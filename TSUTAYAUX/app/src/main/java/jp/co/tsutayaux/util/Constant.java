
package jp.co.tsutayaux.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by DuongND on 11/15/2016.
 */
public class Constant {
    private static final String PREFS_NAME = "TSUTAYAUX.prefs";

    public static SharedPreferences getPrefs(Context context) {
        if (context == null) {
            return null;
        }
        return context.getSharedPreferences(PREFS_NAME, 0);
    }

    public static SharedPreferences.Editor getPrefsEditor(Context context) {
        if (context == null) {
            return null;
        }
        return getPrefs(context).edit();
    }

    public static final String FIRST_LAUNCHER = "FIRST_LAUNCHER";

    public static final String SETTING_FLAG = "SETTING_FLAG";

    public static final String YOUTUBE_API_KEY = "AIzaSyB7QfUaP5ALCN5QcLVQgFEk9-yr25Ee8kA";
}
