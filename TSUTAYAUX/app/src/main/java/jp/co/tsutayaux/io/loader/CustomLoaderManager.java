
package jp.co.tsutayaux.io.loader;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

public class CustomLoaderManager<T> extends AsyncTaskLoader<T> {
    public static final String TAG = CustomLoaderManager.class.getSimpleName();
    private T mResult;
    private ICommonLoaderManager<T> mICommonLoaderManager;

    public CustomLoaderManager(Context aContext) {
        super(aContext);
    }

    public void setICommonLoaderManager(ICommonLoaderManager obj) {
        mICommonLoaderManager = obj;
    }

    @Override
    public T loadInBackground() {
        return mICommonLoaderManager.handlerTaskInBackground();
    }

    /**
     * Called when there is new data to deliver to the client. The super class
     * will take care of delivering it; the implementation here just adds a
     * little more logic.
     */
    @Override
    public void deliverResult(T data) {
        // An async query came in while the loader is stopped. We
        // don't need the result.
        if (isReset() && data != null) {
            onReleaseResources(data);
        }
        T oldData = data;
        mResult = data;
        if (isStarted()) {
            // If the Loader is currently started, we can immediately
            // deliver its results.
            super.deliverResult(data);
        }
        // At this point we can release the resources associated with
        // 'oldApps' if needed; now that the new result is delivered we
        // know that it is no longer in use.
        if (oldData != null) {
            onReleaseResources(oldData);
        }
    }

    /**
     * Handles a request to start the Loader.
     */
    @Override
    protected void onStartLoading() {
        if (mResult != null) {
            deliverResult(mResult);
        }
        // Start watching for changes in the app data.
        if (takeContentChanged() || mResult == null) {
            // If the data has changed since the last time it was loaded
            // or is not currently available, start a load.
            forceLoad();
        }
    }

    /**
     * Handles a request to stop the Loader.
     */
    @Override
    protected void onStopLoading() {
        // Attempt to cancel the current load task if possible.
        cancelLoad();
    }

    /**
     * Handles a request to cancel a load.
     */
    @Override
    public void onCanceled(T data) {
        super.onCanceled(data);
        // At this point we can release the resources associated with 'apps'
        // if needed.
        onReleaseResources(data);
    }

    /**
     * Handles a request to completely reset the Loader.
     */
    @Override
    protected void onReset() {
        super.onReset();
        // Ensure the loader is stopped
        onStopLoading();
        // At this point we can release the resources associated with 'apps'
        // if needed.
        if (mResult != null) {
            onReleaseResources(mResult);
            mResult = null;
        }
        // Stop monitoring for changes.
    }

    protected void onReleaseResources(T data) {
        // For a simple List<> there is nothing to do. For something
        // like a Cursor, we would close it here.
        mResult = data;
    }
}
