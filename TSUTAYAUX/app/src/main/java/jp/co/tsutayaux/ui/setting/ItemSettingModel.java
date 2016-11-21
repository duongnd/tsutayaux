
package jp.co.tsutayaux.ui.setting;

public class ItemSettingModel {

    private boolean mIsHeader;
    private int mIcon;
    private String mTitle;

    public ItemSettingModel(boolean isHeader, int icon, String title) {
        this.mIsHeader = isHeader;
        this.mIcon = icon;
        this.mTitle = title;
    }

    public boolean isIsHeader() {
        return mIsHeader;
    }

    public void setIsHeader(boolean mIsHeader) {
        this.mIsHeader = mIsHeader;
    }

    public int getIcon() {
        return mIcon;
    }

    public void setIcon(int mIcon) {
        this.mIcon = mIcon;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }
}
