package com.jikexueyuan.tulingchat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements HttpCallBackListener {

    private HttpUtil httpUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        httpUtil = (HttpUtil) new HttpUtil(
                "http://www.tuling123.com/openapi/api?key=ce7277ee25d24b36a9a9011d4420c7d7&info=从西直门东直门怎么走", this)
                .execute();

    }

    @Override
    public void getDataUrl(String data) {
        Log.d("TAG", data + "");
    }
}
