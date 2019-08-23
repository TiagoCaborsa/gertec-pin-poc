package br.com.tiagocaborsa.gertecpinpoc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();
    private GertecLayer gertecLayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        findViewById(R.id.openPedButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Map<String, Object> properties = new HashMap<>();
                properties.put(Constants.ANDROID_CONTEXT, getApplicationContext());
                properties.put(Constants.GERTEC_PIN_ACTIVIY_CLASS, PedActivity.class);
                properties.put(Constants.GERTEC_PIN_HELPER, GertecPinHelper.getInstance());

                try {
                    gertecLayer = new GertecLayer(properties);
                    gertecLayer.openPed();
                } catch (Exception e) {
                    Log.e(TAG, "Error on open ped!", e);
                }

            }
        });

        findViewById(R.id.validateReferencesButton).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (gertecLayer.validateReferences()) {

                            Toast.makeText(
                                    MainActivity.this,
                                    "onClick: Succeeded in getting keyboard references!",
                                    Toast.LENGTH_SHORT
                            ).show();

                        } else {

                            Toast.makeText(
                                    MainActivity.this,
                                    "onClick: Error in getting keyboard references!",
                                    Toast.LENGTH_SHORT
                            ).show();

                        }
                    }
                }
        );
    }
}
