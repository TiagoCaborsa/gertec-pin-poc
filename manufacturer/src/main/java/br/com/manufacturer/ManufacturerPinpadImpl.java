package br.com.manufacturer;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Map;

import br.com.bcapi.Pinpad;
import br.com.bcapi.Properties;
import br.com.bcapi.ResultCode;
import br.com.bcapi.RuntimeProperties;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class ManufacturerPinpadImpl extends Pinpad {

    private static final String TAG = ManufacturerPinpadImpl.class.getName();
    private final Context context;

    public ManufacturerPinpadImpl(
            Map<String, Object> properties, Map<String, Object> runtimeProperties
    ) {
        super(properties, runtimeProperties);
        context = (Context) properties.get(Properties.ANDROID_CONTEXT);
    }

    @Override
    public int goOnChip(String tags) {
        Log.i(TAG, "goOnChip: start");
        openPinKBD();
        int resultCode = waitActivityOpen();
        Log.d(TAG, "goOnChip: Send GOC -> " + tags);
        Log.i(TAG, "goOnChip: end");
        return resultCode;
    }

    private void openPinKBD() {
        Log.i(TAG, "openPinKBD: start");
        Intent intent = new Intent(context, PinKBDActivity.class);
        intent.addFlags(FLAG_ACTIVITY_NEW_TASK);

        intent.putExtra(
                RuntimeProperties.PinLayout.PIN_KBD_LAYOUT_ID,
                (int) runtimeProperties.get(RuntimeProperties.PinLayout.PIN_KBD_LAYOUT_ID)
        );

        context.startActivity(intent);
        Log.i(TAG, "openPinKBD: end");
    }

    private int waitActivityOpen() {
        Log.i(TAG, "waitActivityOpen: start");
        int resultCode = ResultCode.PP_NOTOPEN;
        try {

            int timeoutInMillis = 5000;
            long deadlineInMillis = System.currentTimeMillis() + timeoutInMillis;

            while (PinKBDReferencesHelper.INSTANCE().getPinKBDReferences() == null &&
                    System.currentTimeMillis() <= deadlineInMillis) {

                try {
                    Thread.sleep(200);
                    Log.i(TAG, "waitActivityOpen: while in");
                } catch (InterruptedException e) {
                    Log.e(TAG, "waitActivityOpen: InterruptedException", e);
                }

            }

        } catch (NullPointerException e) {
            Log.e(TAG, "waitActivityOpen: NullPointerException", e);
        }

        if (PinKBDReferencesHelper.INSTANCE().getPinKBDReferences() != null) {
            resultCode = ResultCode.PP_OK;
        }

        Log.d(TAG, "waitActivityOpen: pin resuslt code - " + resultCode);
        Log.i(TAG, "waitActivityOpen: end");
        return resultCode;
    }

}
