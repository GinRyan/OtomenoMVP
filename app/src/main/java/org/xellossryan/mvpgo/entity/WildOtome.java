package org.xellossryan.mvpgo.entity;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**野生妹子一枚
 * Created by Liang on 2016/3/11.
 */
public class WildOtome {

    /**
     * _id : 56e220ca67765966681b3a23
     * _ns : ganhuo
     * createdAt : 2016-03-11T09:35:06.879Z
     * desc : 3.11--一周年快乐！！！
     * publishedAt : 2016-03-11T12:37:20.4Z
     * source : chrome
     * type : 福利
     * url : http://ww4.sinaimg.cn/large/7a8aed7bjw1f1so7l2u60j20zk1cy7g9.jpg
     * used : true
     * who : 张涵宇
     */

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

    public static WildOtome objectFromData(String str) {

        return new Gson().fromJson(str, WildOtome.class);
    }

    public static WildOtome objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), WildOtome.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

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
