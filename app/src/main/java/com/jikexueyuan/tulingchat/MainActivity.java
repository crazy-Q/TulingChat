package com.jikexueyuan.tulingchat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements HttpCallBackListener {

    private HttpUtil httpUtil;
    private List<ListData> lists;
    /**
     * code : 100000
     * text : 西直门附近没有劳动局啊
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        httpUtil = (HttpUtil) new HttpUtil(
                "http://www.tuling123.com/openapi/api?key=ce7277ee25d24b36a9a9011d4420c7d7&info=从西直门东直门怎么走", this)
                .execute();

    }

    private void initView(){
        lists = new ArrayList<>();
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
            ListData listData = new ListData(jb.getString("text"));
            lists.add(listData);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
