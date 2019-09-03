package br.com.tiagocaborsa.pospinpoc.acquirer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.manufacturer.ManufacturerBcApiImpl;

import java.util.HashMap;
import java.util.Map;

import br.com.bcapi.BcApi;
import br.com.bcapi.Constants;
import br.com.tiagocaborsa.pospinpoc.R;

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
                properties.put(Constants.PinLayout.PIN_KBD_LAYOUT_ID, R.layout.activity_pin_kbd);
                properties.put(Constants.PinLayout.PIN_KBD_BUTTONS_LAYOUT_ID, R.id.include);

                final int[] resultCode = new int[1];

                try {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            bcApiImpl = new ManufacturerBcApiImpl(properties);
                            resultCode[0] = bcApiImpl.goOnChip("F27AHF27AHF72AHF7");
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
