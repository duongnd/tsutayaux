
package jp.co.tsutayaux.ui.guide;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import jp.co.tsutayaux.R;
import jp.co.tsutayaux.ui.guide.view.DoramaItemViewHolder;
import jp.co.tsutayaux.ui.setting.OnSettingItemClickListener;

public class DoramaAdapter extends RecyclerView.Adapter<DoramaItemViewHolder> {
    private ArrayList<DoramaItem> mListData;
    private Context mContext;
    private OnSettingItemClickListener mListener;

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            DoramaItemViewHolder holder = (DoramaItemViewHolder) view.getTag();
            int position = holder.getPosition();
            mListener.onItemClick(position);
        }
    };

    public DoramaAdapter(Context context, ArrayList<DoramaItem> items, OnSettingItemClickListener listener) {
        mContext = context;
        this.mListData = items;
        mListener = listener;

    }

    @Override
    public DoramaItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.guide_dorama_item_view, null);
        return new DoramaItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DoramaItemViewHolder holder, int position) {
        DoramaItem item = mListData.get(position);
        holder.mTvItemTitle.setText(item.getName());
        if (item.isSelected()) {
            holder.mLinearLayout.setBackgroundColor(Color.GRAY);
            holder.mIvItemIcon.setBackgroundResource(R.drawable.btn_list_close);
        } else {
            holder.mLinearLayout.setBackgroundColor(Color.BLACK);
            holder.mIvItemIcon.setBackgroundResource(R.drawable.btn_list_open);
        }
        holder.mLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(350, 400));
        holder.mLinearLayout.setOnClickListener(onClickListener);
        holder.mLinearLayout.setTag(holder);
        holder.mTvItemTitle.setTag(holder);
    }

    @Override
    public int getItemCount() {
        return mListData.size();
    }

}
