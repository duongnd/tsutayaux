
package jp.co.tsutayaux.ui.setting;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import jp.co.tsutayaux.R;

public class SettingListViewHolder extends RecyclerView.ViewHolder {
    public TextView mTvItemTitle;
    public TextView mTvHeaderTitle;
    public ImageView mIvItemIcon;
    public ImageView mIvHeaderIcon;
    public ImageView mIvAppInstall;
    public Button mSwitchButton;
    public RelativeLayout mRlItemView;
    public RelativeLayout mRlHeaderView;
    public View mDeliverView;
    public ImageView mArrowImage;

    public SettingListViewHolder(View itemView) {
        super(itemView);
        this.mTvItemTitle = (TextView) itemView.findViewById(R.id.menu_item_tv_title);
        this.mTvHeaderTitle = (TextView) itemView.findViewById(R.id.menu_item_header_tv_title);
        this.mIvItemIcon = (ImageView) itemView.findViewById(R.id.menu_item_iv_icon);
        this.mIvHeaderIcon = (ImageView) itemView.findViewById(R.id.menu_item_header_iv_icon);
        this.mIvAppInstall = (ImageView) itemView.findViewById(R.id.menu_item_iv_apps);
        mArrowImage = (ImageView) itemView.findViewById(R.id.menu_item_arrow);
        this.mSwitchButton = (Button) itemView.findViewById(R.id.menu_item_bt_on_off);
        this.mRlItemView = (RelativeLayout) itemView.findViewById(R.id.menu_item_rl_rootview);
        this.mRlHeaderView = (RelativeLayout) itemView.findViewById(R.id.menu_item_header_rl_rootview);
        this.mDeliverView = (View) itemView.findViewById(R.id.menu_item_deliver);
    }
}
