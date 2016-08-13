package com.jikexueyuan.tulingchat;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by QQQ on 2016/8/13.
 */
public class HttpUtil extends AsyncTask<String, Void, String> {

    private HttpURLConnection connection;
    private HttpCallBackListener listener;
    private String address;

    public HttpUtil(String address, HttpCallBackListener listener) {
        this.address = address;
        this.listener = listener;
    }

    @Override
    protected String doInBackground(String... strings) {
        try {
            URL url = new URL(address);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(8000);
            connection.setReadTimeout(8000);
            InputStream in = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            return response.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        listener.getDataUrl(s);
        super.onPostExecute(s);
    }
}
