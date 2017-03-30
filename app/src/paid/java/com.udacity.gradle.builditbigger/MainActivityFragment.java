package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.neha.displayjokeactivity.DisplayJokeActivity;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements OnTaskCompleted{
ImageButton tellJoke;
    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        tellJoke = (ImageButton) root.findViewById(R.id.tellJokeButton);

        tellJoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               showJoke();
            }
        });
        return root;
    }


    public void showJoke() {
                EndpointAsyncTask endpointAsyncTask = new EndpointAsyncTask(this);
                endpointAsyncTask.execute();
            }

    @Override
    public void onTaskCompleted(String data) {
        Intent intent = new Intent(getActivity(), DisplayJokeActivity.class);
        intent.putExtra(DisplayJokeActivity.JOKE_KEY, data);
        startActivity(intent);

    }
}
