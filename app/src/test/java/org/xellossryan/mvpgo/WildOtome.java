package org.xellossryan.mvpgo;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * 野生妹子一枚
 * Created by Liang on 2016/3/11.
 */
public class WildOtome {
    @SerializedName("_id")
    public String id;
    @SerializedName("_ns")
    public String ns;
    @SerializedName("createdAt")
    public String createdAt;
    @SerializedName("desc")
    public String desc;
    @SerializedName("publishedAt")
    public String publishedAt;
    @SerializedName("source")
    public String source;
    @SerializedName("type")
    public String type;
    @SerializedName("url")
    public String url;
    @SerializedName("used")
    public boolean used;
    @SerializedName("who")
    public String who;

    @SerializedName("otome")
    public WildOtome otome;

    /**
     * 数据到单个对象
     *
     * @param str
     * @return
     */
    public static WildOtome objectFromData(String str) {
        return new Gson().fromJson(str, WildOtome.class);
    }

    /**
     * 单个对象到数据
     *
     * @param wo
     * @return
     */
    public static String jsonFromObject(WildOtome wo) {
        return new Gson().toJson(wo);
    }

    /**
     * 取出key的数据到对象
     * @param str
     * @param key
     * @return
     */
    public static WildOtome objectFromData(String str, String key) {
        try {
            JSONObject jsonObject = new JSONObject(str);
            return new Gson().fromJson(jsonObject.getString(str), WildOtome.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 数据到对象的ArrayList
     * @param str
     * @return
     */
    public static List<WildOtome> arrayWildOtomeFromData(String str) {
        Type listType = new TypeToken<ArrayList<WildOtome>>() {
        }.getType();
        return new Gson().fromJson(str, listType);
    }

    public static List<WildOtome> arrayWildOtomeFromData(String str, String key) {
        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<WildOtome>>() {
            }.getType();
            return new Gson().fromJson(jsonObject.getString(str), listType);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return new ArrayList();
    }
}
