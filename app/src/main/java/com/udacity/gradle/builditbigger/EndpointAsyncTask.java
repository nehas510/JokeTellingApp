package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.example.neha.displayjokeactivity.DisplayJokeActivity;
import com.example.neha.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

/**
 * Created by neha on 3/26/17.
 */

public class EndpointAsyncTask extends AsyncTask<Void, Void, String> {
        private static MyApi myApiService = null;
        private Context context;


    public EndpointAsyncTask(Context context){
        context = context;
    }


    @Override
        protected String doInBackground(Void... params) {
            if(myApiService == null) {  // Only do this once
                MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                        new AndroidJsonFactory(), null)
                        // options for running against local devappserver
                        // - 10.0.2.2 is localhost's IP address in Android emulator
                        // - turn off compression when running against local devappserver
                        .setRootUrl("http://joke-telling-app-162713/_ah/api/");
                    /*   .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                            @Override
                            public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                                abstractGoogleClientRequest.setDisableGZipContent(true);
                            }
                        });*/
                // end options for devappserver

                myApiService = builder.build();
            }



            try {
                return myApiService.getData().execute().getData();
            } catch (IOException e) {
                return e.getMessage();
            }
        }

        @Override
        protected void onPostExecute(String result) {
            Intent intent = new Intent(context, DisplayJokeActivity.class);

            intent.putExtra(DisplayJokeActivity.JOKE_KEY, result);
            context.startActivity(intent);
        }
    }

