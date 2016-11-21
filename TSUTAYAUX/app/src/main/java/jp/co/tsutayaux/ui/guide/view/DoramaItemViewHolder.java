
package jp.co.tsutayaux.ui.guide.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import jp.co.tsutayaux.R;

/**
 * Created by DuongND on 11/17/2016.
 */
public class DoramaItemViewHolder extends RecyclerView.ViewHolder {

    public RelativeLayout mLinearLayout;
    public TextView mTvItemTitle;
    public ImageView mIvItemIcon;

    public DoramaItemViewHolder(View itemView) {
        super(itemView);
        mLinearLayout = (RelativeLayout) itemView.findViewById(R.id.dorama_item_layout);
        this.mTvItemTitle = (TextView) itemView.findViewById(R.id.dorama_item_name);
        this.mIvItemIcon = (ImageView) itemView.findViewById(R.id.dorama_item_icon);
    }
}
