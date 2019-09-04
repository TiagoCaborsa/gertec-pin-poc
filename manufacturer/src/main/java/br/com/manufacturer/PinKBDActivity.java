package br.com.manufacturer;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import br.com.bcapi.Constants;
import br.com.bcapi.PinKDBButtonsIds;

public class PinKBDActivity extends Activity {

    private static final String TAG = PinKBDActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate: start");
        super.onCreate(savedInstanceState);
        setFinishOnTouchOutside(false);

        Bundle extras = getIntent().getExtras();

        int pinLayoutId = 0;
        PinKDBButtonsIds pinKDBButtonsIds = null;

        if (extras != null) {
            pinLayoutId = extras.getInt(Constants.PinLayout.PIN_KBD_LAYOUT_ID);
            pinKDBButtonsIds = extras.getParcelable(
                    Constants.PinLayout.PIN_KDB_BUTTONS_IDS
            );
        }

        if (pinLayoutId != 0) {
            setContentView(pinLayoutId);
        }

        if (pinKDBButtonsIds != null) {

            Button btn0 = findViewById(pinKDBButtonsIds.getBtn0Id());
            Button btn1 = findViewById(pinKDBButtonsIds.getBtn1Id());
            Button btn2 = findViewById(pinKDBButtonsIds.getBtn2Id());
            Button btn3 = findViewById(pinKDBButtonsIds.getBtn3Id());
            Button btn4 = findViewById(pinKDBButtonsIds.getBtn4Id());
            Button btn5 = findViewById(pinKDBButtonsIds.getBtn5Id());
            Button btn6 = findViewById(pinKDBButtonsIds.getBtn6Id());
            Button btn7 = findViewById(pinKDBButtonsIds.getBtn7Id());
            Button btn8 = findViewById(pinKDBButtonsIds.getBtn8Id());
            Button btn9 = findViewById(pinKDBButtonsIds.getBtn9Id());
            Button btnCancel = findViewById(pinKDBButtonsIds.getBtnCancelId());
            Button btnClear = findViewById(pinKDBButtonsIds.getBtnClearId());
            Button btnEnter = findViewById(pinKDBButtonsIds.getBtnEnterId());

            // ------ ONLY FOR TEST BUTTONS REFERENCES ---------------------------------------------

            btn0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    toast("BTN0");
                }
            });

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    toast("BTN1");
                }
            });

            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    toast("BTN2");
                }
            });

            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    toast("BTN3");
                }
            });

            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    toast("BTN4");
                }
            });

            btn5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    toast("BTN5");
                }
            });

            btn6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    toast("BTN6");
                }
            });

            btn7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    toast("BTN7");
                }
            });

            btn8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    toast("BTN8");
                }
            });

            btn9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    toast("BTN9");
                }
            });

            btnCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    toast("BTNCANCEL");
                }
            });

            btnClear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    toast("BTNCLEAR");
                }
            });

            btnEnter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    toast("BTNENTER");
                }
            });

            // -------------------------------------------------------------------------------------

            PinKBDReferences pinKBDReferences = new PinKBDReferences(
                    btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnCancel,
                    btnClear, btnEnter, this
            );

            PinKBDReferencesHelper.INSTANCE().setPinKBDReferences(pinKBDReferences);
        }

        Log.i(TAG, "onCreate: end");
    }

    private void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
