package com.cos.myapplication3;

import android.util.Log;

public class CountProvider {

    private static final String TAG = "CountProvider";

    public int download() {

        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.d(TAG, "download: "+i+"초");
        } // for

        return 5;
    }

}
