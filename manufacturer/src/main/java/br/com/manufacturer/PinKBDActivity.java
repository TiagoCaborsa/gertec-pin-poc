package br.com.manufacturer;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import br.com.bcapi.R;
import br.com.bcapi.RuntimeProperties;

public class PinKBDActivity extends Activity {

    private static final String TAG = PinKBDActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate: start");
        super.onCreate(savedInstanceState);
        setFinishOnTouchOutside(false);

        final int pinLayoutId = getIntent().
                getIntExtra(RuntimeProperties.PinLayout.PIN_KBD_LAYOUT_ID, 0);

        if (pinLayoutId != 0) {
            setContentView(pinLayoutId);

            final View rootView = getWindow().getDecorView().getRootView();

            Button btn0 = rootView.findViewWithTag(getString(R.string.btn0Tag));
            Button btn1 = rootView.findViewWithTag(getString(R.string.btn1Tag));
            Button btn2 = rootView.findViewWithTag(getString(R.string.btn2Tag));
            Button btn3 = rootView.findViewWithTag(getString(R.string.btn3Tag));
            Button btn4 = rootView.findViewWithTag(getString(R.string.btn4Tag));
            Button btn5 = rootView.findViewWithTag(getString(R.string.btn5Tag));
            Button btn6 = rootView.findViewWithTag(getString(R.string.btn6Tag));
            Button btn7 = rootView.findViewWithTag(getString(R.string.btn7Tag));
            Button btn8 = rootView.findViewWithTag(getString(R.string.btn8Tag));
            Button btn9 = rootView.findViewWithTag(getString(R.string.btn9Tag));
            Button btnClear = rootView.findViewWithTag(getString(R.string.btnClearTag));
            Button btnCancel = rootView.findViewWithTag(getString(R.string.btnCancelTag));
            Button btnEnter = rootView.findViewWithTag(getString(R.string.btnEnterTag));

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
