package com.senasoft.consumogetandpost.services;

import android.os.AsyncTask;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class PostServices extends AsyncTask<String,Void,String> {
    OkHttpClient client =  new OkHttpClient();


    public interface AsyncResponse{
        void processFinish (String output);
    }

    public PostServices.AsyncResponse delegate = null;

    public PostServices(AsyncResponse delegate) {
        this.delegate = delegate;
    }


    @Override
    protected String doInBackground(String... params) {

        RequestBody body = new FormBody.Builder()
                .add("name_product",params[1])
                .add("volume_product",params[2])
                .add("value_product",params[3])
                .add("stock_product",params[4])
                .add("url_image_product",params[5])
                .build();

        Request request = new Request.Builder().url(params [0]).post(body).build();
            try {
                Response response = client.newCall(request).execute();

                if (!response.isSuccessful())
                    throw new IOException("LOGG"+response.toString());

                return response.body().string();

            } catch (IOException e) {
                e.printStackTrace();
            }
        return null;
    }

    @Override
    protected void onPostExecute(String result) {
        delegate.processFinish(result);
    }
}
