package com.jikexueyuan.tulingchat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements HttpCallBackListener {

    private HttpUtil httpUtil;
    /**
     * code : 100000
     * text : 西直门附近没有劳动局啊
     */

    private int code;
    private String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        httpUtil = (HttpUtil) new HttpUtil(
                "http://www.tuling123.com/openapi/api?key=ce7277ee25d24b36a9a9011d4420c7d7&info=从西直门东直门怎么走", this)
                .execute();

    }

    /**
     * 获取解析后的数据
     * @param data
     */
    @Override
    public void getDataUrl(String data) {
//        Log.d("TAG", data + "");
        parseText(data);
    }

    /**
     * 对数据进行解析
     * @param string
     */
    public void parseText(String string) {
        try {
            JSONObject jb = new JSONObject(string);
            Log.d("TAG", jb.getString("code") + "");
            Log.d("TAG", jb.getString("text") + "");
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
