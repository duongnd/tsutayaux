
package jp.co.tsutayaux.ui.fragment;

import java.util.ArrayList;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import jp.co.tsutayaux.R;
import jp.co.tsutayaux.io.handler.MockData;
import jp.co.tsutayaux.io.loader.CustomLoaderManager;
import jp.co.tsutayaux.io.loader.ICommonLoaderManager;
import jp.co.tsutayaux.ui.top.model.TopDataItem;
import jp.co.tsutayaux.ui.top.view.TopItemView;
import jp.co.tsutayaux.util.Constant;
import jp.co.tsutayaux.util.ScreenUtils;

/**
 * Created by DuongND on 11/15/2016.
 */
public class TopFragment extends Fragment implements LoaderManager.LoaderCallbacks<ArrayList<TopDataItem>>, ICommonLoaderManager<ArrayList<TopDataItem>> {
    private static final int TOP_LOADER = 1;
    private LinearLayout mDataLayout;
    private int mScreenWidth;

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = layoutInflater.inflate(R.layout.top_fragment, null);
        mDataLayout = (LinearLayout) view.findViewById(R.id.top_list_layout);
        mScreenWidth = ScreenUtils.getInstance().getScreenWidth(getActivity());
        YouTubePlayerSupportFragment youTubeView = (YouTubePlayerSupportFragment) getChildFragmentManager().findFragmentById(R.id.youtube_fragment);
        if (youTubeView == null) {
            Log.e("TopFragment", "Failure===youTubeView");
            return view;
        }
        youTubeView.initialize(Constant.YOUTUBE_API_KEY, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                if (!b) {
                    youTubePlayer.setShowFullscreenButton(false);
                    youTubePlayer.loadVideo("km7Nfy20OUc");
                    youTubePlayer.play();
                }
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Log.e("TopFragment", "Failure===" + youTubeInitializationResult.toString());
            }
        });
        onGetData();
        return view;
    }

    private void onGetData() {
        Log.e("TopFragment", "onGetData ==");
        getLoaderManager().destroyLoader(TOP_LOADER);
        getLoaderManager().initLoader(TOP_LOADER, null, this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        YouTubePlayerSupportFragment youTubeView = (YouTubePlayerSupportFragment) getChildFragmentManager().findFragmentById(R.id.youtube_fragment);
        if (youTubeView != null) {
            getFragmentManager().beginTransaction().remove(youTubeView).commit();
        }

    }

    @Override
    public ArrayList<TopDataItem> handlerTaskInBackground() {
        return MockData.getTopMockData();
    }

    @Override
    public Loader<ArrayList<TopDataItem>> onCreateLoader(int id, Bundle args) {
        if (id == TOP_LOADER) {
            CustomLoaderManager<ArrayList<TopDataItem>> aLoaderManager = new CustomLoaderManager<ArrayList<TopDataItem>>(getActivity());
            aLoaderManager.setICommonLoaderManager(TopFragment.this);
            return aLoaderManager;
        }
        return null;
    }

    @Override
    public void onLoadFinished(Loader<ArrayList<TopDataItem>> loader, ArrayList<TopDataItem> data) {
        Log.e("TopFragment", "onLoadFinished ==");
        setData(data);
    }

    @Override
    public void onLoaderReset(Loader<ArrayList<TopDataItem>> loader) {

    }

    private void setData(ArrayList<TopDataItem> data) {
        if (data == null || data.size() == 0) {
            return;
        }
        Log.e("TopFragment", "data.size() ==" + data.size());
        // TODO
        TopItemView topItemView;
        for (TopDataItem item : data) {
            topItemView = new TopItemView(getActivity(), item, mScreenWidth);
            mDataLayout.addView(topItemView.getView());
        }
    }
}
