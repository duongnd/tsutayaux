
package jp.co.tsutayaux.util;

import android.app.Activity;
import android.util.DisplayMetrics;

/**
 * Created by DuongND on 11/15/2016.
 */
public class ScreenUtils {
    private static ScreenUtils sInstance;

    protected ScreenUtils() {

    }

    public static ScreenUtils getInstance() {
        if (sInstance == null) {
            sInstance = new ScreenUtils();
        }
        return sInstance;
    }

    /**
     * getScreenWidth
     *
     * @param activity
     * @return integer screen height
     */
    public int getScreenWidth(Activity activity) {
        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }
}
