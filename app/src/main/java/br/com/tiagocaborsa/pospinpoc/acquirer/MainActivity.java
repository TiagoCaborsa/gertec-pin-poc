package br.com.tiagocaborsa.pospinpoc.acquirer;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.HashMap;
import java.util.Map;

import br.com.bcapi.BcApi;
import br.com.bcapi.Constants;
import br.com.bcapi.PinKDBButtonsIds;
import br.com.manufacturer.ManufacturerBcApiImpl;
import br.com.tiagocaborsa.pospinpoc.R;

public class MainActivity extends Activity {

    private static final String TAG = MainActivity.class.getName();
    private BcApi bcApiImpl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.openPinKBDButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PinKDBButtonsIds pinKDBButtonsIds = new PinKDBButtonsIds(
                        R.id.btn_digit0, R.id.btn_digit1, R.id.btn_digit2, R.id.btn_digit3,
                        R.id.btn_digit4, R.id.btn_digit5, R.id.btn_digit6, R.id.btn_digit7,
                        R.id.btn_digit8, R.id.btn_digit9, R.id.btn_clear, R.id.btn_cancel,
                        R.id.btn_enter
                );

                final Map<String, Object> properties = new HashMap<>();
                properties.put(Constants.ANDROID_CONTEXT, getApplicationContext());
                properties.put(Constants.PinLayout.PIN_KBD_LAYOUT_ID, R.layout.softkeyboard);
                properties.put(Constants.PinLayout.PIN_KDB_BUTTONS_IDS, pinKDBButtonsIds);

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
