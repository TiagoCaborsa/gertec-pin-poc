package br.com.tiagocaborsa.pospinpoc.stone.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import java.util.HashMap;
import java.util.Map;

import br.com.tiagocaborsa.pospinpoc.R;
import br.com.tiagocaborsa.pospinpoc.manufacturer.ManufacturerBcApiImpl;
import br.com.tiagocaborsa.pospinpoc.stone.bc.Constants;
import br.com.tiagocaborsa.pospinpoc.stone.bc.api.BcApi;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();
    private BcApi bcApiImpl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        findViewById(R.id.openPinKBDButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Map<String, Object> properties = new HashMap<>();
                properties.put(Constants.ANDROID_CONTEXT, getApplicationContext());
                properties.put(Constants.PIN_ACTIVIY_CLASS, PinKBDActivity.class);

                try {
                    bcApiImpl = new ManufacturerBcApiImpl(properties);
                    bcApiImpl.goOnChip("F27AHF27AHF72AHF7");
                } catch (Exception e) {
                    Log.e(TAG, "Error on open pinKBD!", e);
                }

            }
        });

//        findViewById(R.id.validateReferencesButton).setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        if (bcApiImpl.validateReferences()) {
//
//                            Toast.makeText(
//                                    MainActivity.this,
//                                    "onClick: Succeeded in getting keyboard references!",
//                                    Toast.LENGTH_SHORT
//                            ).show();
//
//                        } else {
//
//                            Toast.makeText(
//                                    MainActivity.this,
//                                    "onClick: Error in getting keyboard references!",
//                                    Toast.LENGTH_SHORT
//                            ).show();
//
//                        }
//                    }
//                }
//        );
    }
}
