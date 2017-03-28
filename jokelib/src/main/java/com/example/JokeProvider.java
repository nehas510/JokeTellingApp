package com.example;

import java.util.Random;

public class JokeProvider {

    private static final String[] jokes = {
            "Today a man knocked on my door and asked for a small donation towards the local swimming pool. I gave him a glass of water",
            "My wife and I were happy for twenty years. Then we met.",
            "A recent study has found that women who carry a little extra weight live longer than the men who mention it.",
            "For Sale: Parachute. Only used once, never opened.",
            "Born free, taxed to death.",
            "As long as there are tests, there will be prayer in schools.",
            "I say no to alcohol, it just doesn’t listen.",
            "Whenever I find the key to success, someone changes the lock."
    };

    public static String getJoke(){
        int size = jokes.length;

        Random r = new Random();
        int index = r.nextInt(size);

        return jokes[index];
    }
}
