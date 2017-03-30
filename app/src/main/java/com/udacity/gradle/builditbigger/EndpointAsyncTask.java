package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;

import com.example.neha.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

/**
 * Created by neha on 3/26/17.
 */

public class EndpointAsyncTask extends AsyncTask<Void, Void, String> {
        private static MyApi myApiService = null;
        private OnTaskCompleted done;


    public EndpointAsyncTask(OnTaskCompleted taskDone){
        this.done = taskDone;
    }


    @Override
        protected String doInBackground(Void... params) {
            if(myApiService == null) {  // Only do this once
                MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                        new AndroidJsonFactory(), null)
                      .setRootUrl("https://udacity-build-it-bigger-162812.appspot.com/_ah/api/");

                myApiService = builder.build();
            }



            try {
                return myApiService.getJoke().execute().getData();
            } catch (IOException e) {
                return e.getMessage();
            }
        }

        @Override
        protected void onPostExecute(String result) {
          done.onTaskCompleted(result);
        }
    }

