
package jp.co.tsutayaux.ui.top.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import jp.co.tsutayaux.R;

/**
 * Created by DuongND on 11/18/2016.
 */
public class FirmItemViewHolder extends RecyclerView.ViewHolder {

    public ImageView mImageView;
    public LinearLayout mWrapLayout;

    public FirmItemViewHolder(View itemView) {
        super(itemView);
        this.mImageView = (ImageView) itemView.findViewById(R.id.firm_item_image);
        mWrapLayout = (LinearLayout) itemView.findViewById(R.id.film_item_wrap);
    }
}
