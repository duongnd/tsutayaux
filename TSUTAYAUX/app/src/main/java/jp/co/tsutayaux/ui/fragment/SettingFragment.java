
package jp.co.tsutayaux.ui.fragment;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import jp.co.tsutayaux.R;
import jp.co.tsutayaux.ui.setting.ItemSettingModel;
import jp.co.tsutayaux.ui.setting.OnSettingItemClickListener;
import jp.co.tsutayaux.ui.setting.SettingListAdapter;

/**
 * Created by DuongND on 11/15/2016.
 */
public class SettingFragment extends Fragment implements OnSettingItemClickListener {
    private static final int SIZE_LIST = 15;
    private RecyclerView mUlRecycleView;
    private ArrayList<ItemSettingModel> mItemList;
    private SettingListAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewFragmentContent = inflater.inflate(R.layout.setting_fragment,
                null);
        mUlRecycleView = (RecyclerView) viewFragmentContent.findViewById(R.id.lv);
        mUlRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        fetchContent();
        return viewFragmentContent;
    }

    private void fetchContent() {
        mItemList = new ArrayList<ItemSettingModel>();
        ItemSettingModel itemSetting = null;
        for (int i = 1; i < SIZE_LIST; i++) {
            switch (i) {
                case 1:
                    itemSetting = new ItemSettingModel(false, 0, getResources().getString(R.string.setting_text1));
                    break;
                case 2:
                    itemSetting = new ItemSettingModel(false, 0, getResources().getString(R.string.setting_text2));
                    break;
                case 3:
                    itemSetting = new ItemSettingModel(false, 0, getResources().getString(R.string.setting_text3));
                    break;
                case 4:
                    itemSetting = new ItemSettingModel(false, 0, getResources().getString(R.string.setting_text4));
                    break;
                case 5:
                    itemSetting = new ItemSettingModel(false, 0, getResources().getString(R.string.setting_text5));
                    break;
                case 6:
                    itemSetting = new ItemSettingModel(false, 0, getResources().getString(R.string.setting_text6));
                    break;
                case 7:
                    itemSetting = new ItemSettingModel(false, 0, getResources().getString(R.string.setting_text7));
                    break;
                case 8:
                    itemSetting = new ItemSettingModel(false, 0, getResources().getString(R.string.setting_text8));
                    break;
                case 9:
                    itemSetting = new ItemSettingModel(false, 0, getResources().getString(R.string.setting_text9));
                    break;
                case 10:
                    itemSetting = new ItemSettingModel(false, 0, getResources().getString(R.string.setting_text10));
                    break;
                case 11:
                    itemSetting = new ItemSettingModel(false, 0, getResources().getString(R.string.setting_text11));
                    break;
                case 12:
                    itemSetting = new ItemSettingModel(false, 0, getResources().getString(R.string.setting_text12));
                    break;
                case 13:
                    itemSetting = new ItemSettingModel(false, 0, getResources().getString(R.string.setting_text13));
                    break;
                case 14:
                    itemSetting = new ItemSettingModel(false, 0, getResources().getString(R.string.setting_text14));
                    break;
                default:
                    break;

            }
            mItemList.add(itemSetting);
        }
        mAdapter = new SettingListAdapter(getActivity(), mItemList, this);
        mUlRecycleView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(String time, int position) {

    }

    @Override
    public void onItemClick(int position) {

    }
}
