
package jp.co.tsutayaux.io.handler;

import java.util.ArrayList;

import jp.co.tsutayaux.ui.top.model.FirmItem;
import jp.co.tsutayaux.ui.top.model.TopDataItem;

/**
 * Created by DuongND on 11/18/2016.
 */
public class MockData {

    public static ArrayList<TopDataItem> getTopMockData() {
        ArrayList<TopDataItem> list = new ArrayList<>();
        TopDataItem topDataItem = new TopDataItem();
        topDataItem.category = "TSUTAYA DISCASサービス利用規約<";
        topDataItem.firmItems = new ArrayList<>();
        FirmItem filmItem;
        for (int i = 0; i < 10; i++) {
            filmItem = new FirmItem();
            filmItem.firmUrl = "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcT-TPgWFR5y8sDR6Ns8nc8BWK_O_cMr0PfgBTnH8HfS75nENLQFlg";
            topDataItem.firmItems.add(filmItem);
        }
        list.add(topDataItem);

        topDataItem = new TopDataItem();
        topDataItem.category = "アプリ内の店舗設定";
        topDataItem.firmItems = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            filmItem = new FirmItem();
            filmItem.firmUrl = "http://media.moddb.com/images/downloads/1/87/86682/bluedemobutton.jpg";
            topDataItem.firmItems.add(filmItem);
        }
        list.add(topDataItem);

        topDataItem = new TopDataItem();
        topDataItem.category = "個人情報の取り扱い";
        topDataItem.firmItems = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            filmItem = new FirmItem();
            filmItem.firmUrl = "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcQ_SjCSHgWMkGMtcxLCg8iUdQugM_2r6qT_gmXrAfknw4Mv7771";
            topDataItem.firmItems.add(filmItem);
        }
        list.add(topDataItem);

        topDataItem = new TopDataItem();
        topDataItem.category = "特定商取引法に基づく表示";
        topDataItem.firmItems = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            filmItem = new FirmItem();
            filmItem.firmUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT-BDYwWZEN3kYuNqTipkZJzL4adhC6nvecqbpyMjgHvmalDfvW8Q";
            topDataItem.firmItems.add(filmItem);
        }
        list.add(topDataItem);
        return list;
    }
}
