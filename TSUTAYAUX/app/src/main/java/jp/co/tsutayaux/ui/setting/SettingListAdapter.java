
package jp.co.tsutayaux.ui.setting;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import jp.co.tsutayaux.R;
import jp.co.tsutayaux.util.Constant;

public class SettingListAdapter extends RecyclerView.Adapter<SettingListViewHolder> {

    private ArrayList<ItemSettingModel> mListData;
    private Activity mContext;
    private boolean mSwitchOn;
    private View.OnClickListener mOnSwitchListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            mSwitchOn = !mSwitchOn;
            notifyDataSetChanged();
        }
    };
    private OnSettingItemClickListener mListener;
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            SettingListViewHolder holder = (SettingListViewHolder) view.getTag();
            int position = holder.getPosition();
            mListener.onItemClick(position);
        }
    };

    public SettingListAdapter(Context context,
            ArrayList<ItemSettingModel> itemMenuModelList, OnSettingItemClickListener listener) {
        this.mListData = itemMenuModelList;
        this.mContext = (Activity) context;
        this.mListener = listener;
    }

    @Override
    public SettingListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.setting_item_listview, null);
        return new SettingListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SettingListViewHolder holder, int position) {
        mSwitchOn = Constant.getPrefs(mContext).getBoolean(Constant.SETTING_FLAG, true);
        if (!mListData.get(position).isIsHeader()) {
            holder.mRlItemView.setVisibility(View.VISIBLE);
            holder.mIvItemIcon.setVisibility(View.VISIBLE);

            holder.mRlHeaderView.setVisibility(View.GONE);

            holder.mTvItemTitle.setText(mListData.get(position).getTitle());
            holder.mIvItemIcon.setBackgroundResource(mListData.get(position).getIcon());
            onSwitchView(holder.mSwitchButton, holder.mArrowImage, holder.mIvAppInstall, position);
            holder.mSwitchButton.setOnClickListener(mOnSwitchListener);
            holder.mArrowImage.setOnClickListener(onClickListener);
        } else {
            holder.mRlItemView.setVisibility(View.GONE);

            holder.mRlHeaderView.setVisibility(View.VISIBLE);
            holder.mIvHeaderIcon.setVisibility(View.VISIBLE);

            holder.mTvHeaderTitle.setText(mListData.get(position).getTitle());
            holder.mIvHeaderIcon.setBackgroundResource(mListData.get(position).getIcon());
        }

        if (position == getItemCount()) {
            holder.mDeliverView.setVisibility(View.GONE);
        }

        holder.mRlItemView.setOnClickListener(onClickListener);
        holder.mRlItemView.setTag(holder);
        holder.mTvItemTitle.setTag(holder);
        holder.mTvHeaderTitle.setTag(holder);
        holder.mIvItemIcon.setTag(holder);
        holder.mIvHeaderIcon.setTag(holder);
        holder.mIvAppInstall.setTag(holder);
        holder.mSwitchButton.setTag(holder);
        holder.mArrowImage.setTag(holder);
    }

    private void onSwitchView(Button switchButton, ImageView arrowImage, ImageView ivAppInstall, int position) {
        switchButton.setVisibility(View.GONE);
        ivAppInstall.setVisibility(View.GONE);
        arrowImage.setVisibility(View.VISIBLE);
        switch (position) {
            case 4:
                switchButton.setVisibility(View.VISIBLE);
                arrowImage.setVisibility(View.GONE);
                ivAppInstall.setVisibility(View.GONE);
                switchButton.setBackgroundResource(mSwitchOn ? R.drawable.btn_switch_on
                        : R.drawable.btn_switch_off);
                break;

            case 14:
                switchButton.setVisibility(View.GONE);
                ivAppInstall.setVisibility(View.GONE);

                break;
            default:

                break;
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return mListData != null ? mListData.size() : 0;
    }
}
