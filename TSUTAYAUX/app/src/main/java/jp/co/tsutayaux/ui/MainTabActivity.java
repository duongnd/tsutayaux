
package jp.co.tsutayaux.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

import jp.co.tsutayaux.R;
import jp.co.tsutayaux.ui.fragment.CouponFragment;
import jp.co.tsutayaux.ui.fragment.FavouriteFragment;
import jp.co.tsutayaux.ui.fragment.SettingFragment;
import jp.co.tsutayaux.ui.fragment.TopFragment;
import jp.co.tsutayaux.util.ScreenUtils;

/**
 * Created by DuongND on 11/15/2016.
 */
public class MainTabActivity extends FragmentActivity implements TabHost.OnTabChangeListener {
    private static final int TAB_NUMBER = 4;
    private static final float TAB_RATIO = 1.43f;
    private FragmentTabHost mTabHost;
    private int mWidthTabWidget, mHeightTabWidget;

    private String mStrTabTop;
    private String mStrTabCoupon;
    private String mStrTabFavour;
    private String mStrTabSetting;
    private boolean mAttached;
    // private Bundle mSavedInstanceState;
    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;
    private TopFragment mTopFragment = null;
    private CouponFragment mCouponFragment = null;
    private FavouriteFragment mFavourFragment = null;
    private SettingFragment mSettingFragment = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tab);
        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
        mWidthTabWidget = ScreenUtils.getInstance().getScreenWidth(this)
                / TAB_NUMBER;
        mHeightTabWidget = (int) (mWidthTabWidget / TAB_RATIO);
        mTabHost.setOnTabChangedListener(this);
        initialTabWidgets();
    }

    /**
     * initial tabWidgets
     */
    private void initialTabWidgets() {
        addTab(getResources().getString(R.string.tab_top), TopFragment.class);
        addTab(getResources().getString(R.string.tab_coupon),
                CouponFragment.class);
        addTab(getResources().getString(R.string.tab_favourite),
                FavouriteFragment.class);
        addTab(getResources().getString(R.string.tab_setting),
                SettingFragment.class);
    }

    /**
     * addTab : add a new tab to main Tab host
     *
     * @param tabName
     * @param activity
     */
    private void addTab(String tabName, Class<?> activity) {
        FragmentTabHost.TabSpec spec = mTabHost.newTabSpec(tabName).setIndicator(createTabView(this, tabName));
        mTabHost.addTab(spec, activity, null);
    }

    /**
     * createTabView create tab view base on tabName
     *
     * @param context
     * @param str String tab name
     * @return View : tabview
     */
    private View createTabView(final Context context, final String str) {

        View view = LayoutInflater.from(context)
                .inflate(R.layout.tab_layout, null);
        LinearLayout.LayoutParams mainTabLayout = new LinearLayout.LayoutParams(mWidthTabWidget,
                mHeightTabWidget);
        view.setLayoutParams(mainTabLayout);
        ImageView imageView = (ImageView) view.findViewById(R.id.tab_icon);
        TextView textView = (TextView) view.findViewById(R.id.tab_text);
        if (str.equalsIgnoreCase(getResources().getString(R.string.tab_top))) {
            imageView.setBackgroundResource(R.drawable.tab_top_bg_selector);
            textView.setText(getResources().getString(R.string.tab_top));
        } else if (str.equalsIgnoreCase(getResources().getString(
                R.string.tab_coupon))) {
            imageView.setBackgroundResource(R.drawable.tab_coupon_bg_selector);
            textView.setText(getResources().getString(R.string.tab_coupon));
        } else if (str.equalsIgnoreCase(getResources().getString(
                R.string.tab_favourite))) {
            imageView.setBackgroundResource(R.drawable.tab_favour_bg_selector);
            textView.setText(getResources().getString(R.string.tab_favourite));
        } else if (str.equalsIgnoreCase(getResources().getString(
                R.string.tab_setting))) {
            imageView.setBackgroundResource(R.drawable.tab_setting_bg_selector);
            textView.setText(getResources().getString(R.string.tab_setting));
        }
        return view;
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        mAttached = true;
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mAttached = false;
    }

    @Override
    public void onTabChanged(String tabId) {
        Log.e("Maintab", "tabId==" + tabId);
        mStrTabTop = getResources().getString(R.string.tab_top);
        mStrTabCoupon = getResources().getString(R.string.tab_coupon);
        mStrTabFavour = getResources().getString(R.string.tab_favourite);
        mStrTabSetting = getResources().getString(R.string.tab_setting);
        findViewById(R.id.main_search_layout).setVisibility(View.VISIBLE);
        if (tabId.equals(mStrTabSetting)) {
            findViewById(R.id.main_search_layout).setVisibility(View.GONE);
        }
        if (mAttached) {
            mFragmentManager = getSupportFragmentManager();
            mTopFragment = (TopFragment) mFragmentManager.findFragmentByTag(mStrTabTop);
            mCouponFragment = (CouponFragment) mFragmentManager.findFragmentByTag(mStrTabCoupon);
            mFavourFragment = (FavouriteFragment) mFragmentManager.findFragmentByTag(mStrTabFavour);
            mSettingFragment = (SettingFragment) mFragmentManager.findFragmentByTag(mStrTabSetting);
            // FragmentTransaction beginTransaction prior to use, after every
            // use commit
            mFragmentTransaction = mFragmentManager.beginTransaction();
            detachAll();
            toAttach(tabId);
            mFragmentTransaction.commit();
            // mFragmentTransaction.commitAllowingStateLoss();
        }
    }

    // detach the given fragment from the UI
    private void detachAll() {
        if (mTopFragment != null) {
            mFragmentTransaction.detach(mTopFragment);
        }
        if (mCouponFragment != null) {
            mFragmentTransaction.detach(mCouponFragment);
        }
        if (mFavourFragment != null) {
            mFragmentTransaction.detach(mFavourFragment);
        }

        if (mSettingFragment != null) {
            mFragmentTransaction.detach(mSettingFragment);
        }
    }

    // add a fragment to the activity state
    private void toAttach(String tag) {
        if (mStrTabTop.equals(tag)) {
            if (mTopFragment == null) {
                mFragmentTransaction.add(R.id.realtabcontent, new TopFragment(), tag);
                // This creates a Fragment object, and the binding of tag
            } else if (mTopFragment.isDetached()) {
                // re-attach a fragment after it had previously been deatched
                // from the UI with detach
                mFragmentTransaction.attach(mTopFragment);
            }
        } else if (mStrTabCoupon.equals(tag)) {
            if (mCouponFragment == null) {
                mFragmentTransaction.add(R.id.realtabcontent, new CouponFragment(), tag);
            } else if (mCouponFragment.isDetached()) {
                mFragmentTransaction.attach(mCouponFragment);
            }
        } else if (mStrTabFavour.equals(tag)) {
            if (mFavourFragment == null) {
                // mAnalysisFragment = new NewAnalysisFragment();
                mFragmentTransaction.add(R.id.realtabcontent, new FavouriteFragment(), tag);
            } else if (mFavourFragment.isDetached()) {
                mFragmentTransaction.attach(mFavourFragment);
            }
        } else if (mStrTabSetting.equals(tag)) {
            if (mSettingFragment == null) {
                mFragmentTransaction.add(R.id.realtabcontent, new SettingFragment(), tag);
            } else if (mSettingFragment.isDetached()) {
                mFragmentTransaction.attach(mSettingFragment);
            }
        }
    }
}
