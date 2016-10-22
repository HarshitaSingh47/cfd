package com.microsoft.CognitiveServicesExample;

import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.Prediction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Snehil Verma on 10/22/2016.
 */
public class GestureRec extends AppCompatActivity implements GestureOverlayView.OnGesturePerformedListener {

    private GestureLibrary gestureLib;

    public class Pre_data {
        String name;
        double pre_score;

        Pre_data() {
            pre_score = 0;
            name = "null";
        }
    }

    Pre_data pre_data[] = new Pre_data[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        GestureOverlayView gestureOverlayView = new GestureOverlayView(this);
        View inflate = getLayoutInflater().inflate(R.layout.gesture_main, null);
        gestureOverlayView.addView(inflate);
        gestureOverlayView.addOnGesturePerformedListener(this);
        gestureLib = GestureLibraries.fromRawResource(this, R.raw.gesture);
        if (!gestureLib.load()) {
            finish();
        }
        setContentView(gestureOverlayView);

        for (int i = 0; i < 10; i++) {
            pre_data[i] = new Pre_data();
        }


    }

    @Override
    public void onGesturePerformed(GestureOverlayView overlay, Gesture gesture) {
        ArrayList<Prediction> predictions = gestureLib.recognize(gesture);
        int j = 0;
        for (Prediction prediction : predictions) {
            pre_data[j].pre_score = prediction.score;
            pre_data[j].name = prediction.name;
            j++;


        }

        int pos = 0;
        for (int k = 0; k < 10; k++) {
            if (pre_data[k].pre_score > pre_data[pos].pre_score) {
                pos = k;
            }
        }

        Toast.makeText(GestureRec.this, pre_data[pos].name, Toast.LENGTH_SHORT).show();


    }
}
