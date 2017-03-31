package com.udacity.gradle.builditbigger;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created by neha on 3/31/17.
 */
public class EndpointAsyncTaskTest {


    @Test
    public void doInBackground() throws Exception {

       EndpointAsyncTask testTask = new EndpointAsyncTask(new EndpointAsyncTask.OnTaskCompleted() {
           @Override
           public void onTaskCompleted(String data) {

           }
       });

        testTask.execute();
        String showJoke = testTask.get();
        assertNotNull(showJoke);

    }

    @Test
    public void onPostExecute() throws Exception {

    }

}