
package jp.co.tsutayaux.ui.guide.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import jp.co.tsutayaux.R;

/**
 * Created by DuongND on 11/15/2016.
 */
public class GuideLocaleView {
    private View mViewContent;

    public GuideLocaleView(Context context) {
        mViewContent = LayoutInflater.from(context).inflate(R.layout.guide_locale_view, null);
    }

    public View getView() {
        return mViewContent;
    }
}
