
package jp.co.tsutayaux.util;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import jp.co.tsutayaux.ui.top.model.FirmItem;
import jp.co.tsutayaux.ui.top.model.TopDataItem;

/**
 * Created by DuongND on 11/18/2016.
 */
public class TopUtils {
    private static TopUtils sInstance;

    protected TopUtils() {

    }

    public static TopUtils getInstance() {
        if (sInstance == null) {
            sInstance = new TopUtils();
        }
        return sInstance;
    }

    public ArrayList<TopDataItem> getTopData(JSONArray jsonArray) {
        ArrayList<TopDataItem> list = new ArrayList<>();
        JSONArray jsons = null;
        try {
            jsons = jsonArray.getJSONArray(0);
            TopDataItem item;
            ArrayList<FirmItem> firmItems;
            for (int i = 0; i < jsons.length(); i++) {
                JSONObject jsonRslt = jsons.getJSONObject(i);
                JSONObject category = jsonRslt.getJSONObject("Category");
                item = new TopDataItem();
                item.category = category.getString("categoryName");
                item.categoryId = category.getString("categoryId");
                JSONArray jsonFilmList = category.getJSONArray("Film");
                firmItems = new ArrayList<>();
                FirmItem filmItem;
                for (int j = 0; j < jsonFilmList.length(); j++) {
                    JSONObject filmJson = jsonFilmList.getJSONObject(j);
                    filmItem = new FirmItem();
                    filmItem.firmCategory = filmJson.getString("filmName");
                    filmItem.firmId = filmJson.getString("filmId");
                    filmItem.firmUrl = filmJson.getString("url");
                    firmItems.add(filmItem);
                }
                item.firmItems = firmItems;
                list.add(item);
            }
        } catch (JSONException e) {
            return null;
        }
        return list;
    }
}
