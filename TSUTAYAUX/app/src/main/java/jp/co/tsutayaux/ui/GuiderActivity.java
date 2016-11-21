
package jp.co.tsutayaux.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import jp.co.tsutayaux.R;
import jp.co.tsutayaux.ui.guide.CustomViewPager;
import jp.co.tsutayaux.ui.guide.view.GuideDoramaView;
import jp.co.tsutayaux.ui.guide.view.GuideLocaleView;
import jp.co.tsutayaux.ui.guide.view.GuideMainView;

/**
 * Created by DuongND on 11/15/2016.
 */
public class GuiderActivity extends FragmentActivity {
    private static final int PAGE_COUNT = 3;

    private CustomViewPager mViewPager;
    private ImageButton mButtonPrevious;
    private Button mButtonNext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        mViewPager = (CustomViewPager) findViewById(R.id.launch_view_pager);
        mViewPager.setAdapter(new GuideAdapter());
        mViewPager.setPagingEnabled(false);
        mViewPager.setOnPageChangeListener(mOnPageViewPager);
        mViewPager.setCurrentItem(0);
        mButtonPrevious = (ImageButton) findViewById(R.id.launch_previous);
        mButtonPrevious.setVisibility(View.GONE);
        mButtonPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(mViewPager.getCurrentItem() - 1);
            }
        });
        mButtonNext = (Button) findViewById(R.id.launch_next);
        mButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mViewPager.getCurrentItem() == 2) {
                    startActivity(new Intent(GuiderActivity.this, MainTabActivity.class));
                    finish();
                } else {
                    mViewPager.setCurrentItem(mViewPager.getCurrentItem() + 1);
                }
            }
        });
    }

    private void initView() {

    }

    private ViewPager.OnPageChangeListener mOnPageViewPager = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
            switch (position) {
                case 0:
                    mButtonPrevious.setVisibility(View.GONE);
                    break;
                case 1:
                    mButtonPrevious.setVisibility(View.VISIBLE);
                    break;
                case 2:
                    mButtonPrevious.setVisibility(View.VISIBLE);
                    break;
                default:
                    break;
            }
        }

        @Override
        public void onPageScrolled(int position, float positionOffset,
                int positionOffsetPixels) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    };

    private class GuideAdapter extends PagerAdapter {
        public GuideAdapter() {

        }

        @Override
        public int getCount() {
            return PAGE_COUNT;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == ((View) object);
        }

        @Override
        public void destroyItem(View collection, int position, Object view) {
            ((ViewPager) collection).removeView((View) view);
        }

        @Override
        public Object instantiateItem(View collection, int position) {
            View view = new GuideMainView(GuiderActivity.this).getView();
            ;
            switch (position) {
                case 0:
                    ((ViewPager) collection).addView(view);
                    return view;
                case 1:
                    view = new GuideDoramaView(GuiderActivity.this).getView();
                    ((ViewPager) collection).addView(view);
                    return view;
                case 2:
                    view = new GuideLocaleView(GuiderActivity.this).getView();
                    ((ViewPager) collection).addView(view);
                    return view;
                default:
                    return view;
            }
        }

    }

}
