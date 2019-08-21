package com.example.gertecpinpoc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button openPedButton = findViewById(R.id.openPedButton);
        openPedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Map<String, Object> properties = new HashMap<>();
                properties.put(Constants.ANDROID_CONTEXT, getApplicationContext());
                properties.put(Constants.GERTEC_PIN_ACTIVIY_CLASS, PedActivity.class);
                properties.put(Constants.GERTEC_PIN_HELPER, GertecPinHelper.getInstance());

                try {
                    final GertecLayer gertecLayer = new GertecLayer(properties);
                    gertecLayer.openPed();

                    if (gertecLayer.validateReferences()) {
                        Log.d(
                                MainActivity.class.getName(),
                                "onClick: Succeeded in getting keyboard references!"
                        );
                    } else {
                        Log.e(
                                MainActivity.class.getName(),
                                "onClick: Error in getting keyboard references!"
                        );
                    }
                } catch (Exception e) {
                    Log.e(MainActivity.class.getName(), "Error on open ped!", e);
                }

            }
        });
    }
}
