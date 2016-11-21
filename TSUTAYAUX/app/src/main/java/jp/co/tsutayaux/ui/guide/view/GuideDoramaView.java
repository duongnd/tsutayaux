
package jp.co.tsutayaux.ui.guide.view;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import jp.co.tsutayaux.R;
import jp.co.tsutayaux.ui.guide.DoramaAdapter;
import jp.co.tsutayaux.ui.guide.DoramaItem;
import jp.co.tsutayaux.ui.guide.SnappingRecyclerView;
import jp.co.tsutayaux.ui.setting.OnSettingItemClickListener;

/**
 * Created by DuongND on 11/15/2016.
 */
public class GuideDoramaView implements OnSettingItemClickListener {
    private View mViewContent;
    private Context mContext;
    private ArrayList<DoramaItem> doramaItems;
    private DoramaAdapter mDoramaAdapter;

    public GuideDoramaView(Context context) {
        mContext = context;
        mViewContent = LayoutInflater.from(context).inflate(R.layout.guide_dorama_view, null);
        SnappingRecyclerView mSnappingRecyclerView = (SnappingRecyclerView) mViewContent.findViewById(android.R.id.list);
        mSnappingRecyclerView.enableViewScaling(true);
        doramaItems = getDataList();
        mDoramaAdapter = new DoramaAdapter(context, doramaItems, this);
        mSnappingRecyclerView.setAdapter(mDoramaAdapter);
    }

    public View getView() {
        return mViewContent;
    }

    private ArrayList<DoramaItem> getDataList() {
        ArrayList<DoramaItem> sampleList = new ArrayList<>();
        final String[] categories = mContext.getResources().getStringArray(R.array.dorama_category);
        DoramaItem doramaItem;
        for (String name : categories) {
            doramaItem = new DoramaItem();
            doramaItem.setName(name);
            sampleList.add(doramaItem);
        }

        return sampleList;
    }

    @Override
    public void onItemClick(String time, int position) {

    }

    @Override
    public void onItemClick(int position) {
        if (doramaItems.get(position).isSelected()) {
            doramaItems.get(position).setIsSelected(false);
        } else {
            doramaItems.get(position).setIsSelected(true);
        }
        mDoramaAdapter.notifyDataSetChanged();
    }
}
