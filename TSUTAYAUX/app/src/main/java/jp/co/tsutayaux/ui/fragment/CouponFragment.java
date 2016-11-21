
package jp.co.tsutayaux.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import jp.co.tsutayaux.R;

/**
 * Created by DuongND on 11/15/2016.
 */
public class CouponFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewFragmentContent = inflater.inflate(R.layout.coupon_fragment,
                container, false);
        return viewFragmentContent;
    }
}
