package ustory.com.mvvm.services;

import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;

import ustory.com.mvvm.core.AbsModule;
import ustory.com.mvvm.utils.HttpUtil;

/**
 * Created by qiyue on 2016/4/6.
 */
public class IPModule extends AbsModule {
    private static final String IP_URL = "http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=json&ip=";

    public IPModule(Context context) {
        super(context);
    }

    /**
     * 获取IP信息
     */
    public void getIpInfo() {
        HttpUtil util = HttpUtil.getInstance(getContext());
        util.get(IP_URL, new HttpUtil.AbsResponse() {
            @Override
            public void onResponse(String data) {
                super.onResponse(data);
                try {
                    JSONObject obj = new JSONObject(data);
                    String country = obj.getString("country");
                    String province = obj.getString("province");
                    String city = obj.getString("city");
                    //进行数据回调
                    callback(1, "你的IP地址是：" + country + " " + province + " " + city);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Object error) {
                super.onError(error);
            }
        });
    }
}
