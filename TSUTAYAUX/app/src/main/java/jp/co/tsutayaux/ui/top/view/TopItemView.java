
package jp.co.tsutayaux.ui.top.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import jp.co.tsutayaux.R;
import jp.co.tsutayaux.ui.FirmDetailActivity;
import jp.co.tsutayaux.ui.top.FirmTopListAdapter;
import jp.co.tsutayaux.ui.top.model.TopDataItem;

/**
 * Created by DuongND on 11/18/2016.
 */
public class TopItemView {
    private View mViewContent;
    private Context mContext;
    private TopDataItem mTopDataItem;

    public TopItemView(Context context, TopDataItem item, int screenWidth) {
        mContext = context;
        mTopDataItem = item;
        mViewContent = LayoutInflater.from(context).inflate(R.layout.top_item_view, null);
        TextView titleView = (TextView) mViewContent.findViewById(R.id.top_item_category);
        titleView.setText(item.category);
        mViewContent.findViewById(R.id.top_item_category_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, FirmDetailActivity.class);
                mContext.startActivity(intent);
            }
        });

        RecyclerView recyclerView = (RecyclerView) mViewContent.findViewById(R.id.top_recycle_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext,
                LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        FirmTopListAdapter adapter = new FirmTopListAdapter(context, item.firmItems, screenWidth);
        recyclerView.setAdapter(adapter);
    }

    public View getView() {
        return mViewContent;
    }

}
