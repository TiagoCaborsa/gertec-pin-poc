package br.com.tiagocaborsa.pospinpoc.acquirer;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.HashMap;
import java.util.Map;

import br.com.bcapi.Pinpad;
import br.com.bcapi.Properties;
import br.com.bcapi.RuntimeProperties;
import br.com.manufacturer.ManufacturerPinpadImpl;
import br.com.tiagocaborsa.pospinpoc.R;

public class MainActivity extends Activity {

    private static final String TAG = MainActivity.class.getName();
    private Pinpad pinpadImpl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.openPinKBDButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Map<String, Object> properties = new HashMap<>();
                final Map<String, Object> runtimeProperties = new HashMap<>();

                properties.put(Properties.ANDROID_CONTEXT, getApplicationContext());

                runtimeProperties.put(
                        RuntimeProperties.PinLayout.PIN_KBD_LAYOUT_ID, R.layout.softkeyboard
                );

                final int[] resultCode = new int[1];

                try {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            pinpadImpl = new ManufacturerPinpadImpl(properties, runtimeProperties);
                            resultCode[0] = pinpadImpl.goOnChip("F27AHF27AHF72AHF7");
                            Log.i(TAG, "run: " + resultCode[0]);
                        }
                    }).start();

                } catch (Exception e) {
                    Log.e(TAG, "Error on open pinKBD!", e);
                }

            }
        });

    }
}
