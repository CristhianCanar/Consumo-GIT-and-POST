package com.senasoft.consumogetandpost.services;

import android.os.AsyncTask;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class GetServices extends AsyncTask<String,Void,String> {
    OkHttpClient client = new OkHttpClient();

    public interface AsyncResponse{
        void processFinish(String output);
    }

    public GetServices.AsyncResponse delegate = null;

    public GetServices(AsyncResponse delegate) {
        this.delegate = delegate;
    }

    @Override
    protected String doInBackground(String... params) {

        Request request = new Request.Builder().url(params[0]).get().build();

        /*try {
            Response response =client.

        }*/

        return null;
    }

    @Override
    protected void onPostExecute(String result) {

    }
}
