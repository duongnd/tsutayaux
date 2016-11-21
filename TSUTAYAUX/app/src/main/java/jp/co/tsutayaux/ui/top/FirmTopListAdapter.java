
package jp.co.tsutayaux.ui.top;

import java.util.ArrayList;

import com.bumptech.glide.Glide;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import jp.co.tsutayaux.R;
import jp.co.tsutayaux.ui.top.model.FirmItem;
import jp.co.tsutayaux.ui.top.view.FirmItemViewHolder;

/**
 * Created by DuongND on 11/18/2016.
 */
public class FirmTopListAdapter extends RecyclerView.Adapter<FirmItemViewHolder> {
    private ArrayList<FirmItem> mListData;
    private Context mContext;
    private int mItemWidth, mItemHeigh;

    public FirmTopListAdapter(Context context,
            ArrayList<FirmItem> list, int screenWidth) {
        this.mListData = list;
        this.mContext = context;
        mItemWidth = screenWidth / 3;
        mItemHeigh = screenWidth / 2;
    }

    @Override
    public FirmItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.firm_item_view, null);
        return new FirmItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FirmItemViewHolder holder, int position) {
        holder.mWrapLayout.setLayoutParams(new LinearLayout.LayoutParams(mItemWidth, mItemHeigh));
        FirmItem firmItem = mListData.get(position);
        if (firmItem.firmUrl != null && !firmItem.firmUrl.equalsIgnoreCase("")) {
            Log.e("FirmTopListAdapter", "firmItem==" + firmItem.firmUrl);
            Glide.with(mContext).load(firmItem.firmUrl).into(holder.mImageView);
        }
    }

    @Override
    public int getItemCount() {
        return mListData != null ? mListData.size() : 0;
    }

}
