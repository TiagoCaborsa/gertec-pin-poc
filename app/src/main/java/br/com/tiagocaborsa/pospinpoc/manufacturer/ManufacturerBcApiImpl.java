package br.com.tiagocaborsa.pospinpoc.manufacturer;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Map;

import br.com.tiagocaborsa.pospinpoc.acquirer.bc.Constants;
import br.com.tiagocaborsa.pospinpoc.acquirer.bc.api.BcApi;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class ManufacturerBcApiImpl extends BcApi {

    private static final String TAG = ManufacturerBcApiImpl.class.getName();
    private final Context context;
    private final int PIN_KBD_LAYOUT;
    private final int PIN_KBD_BUTTONS_LAYOUT;

    public ManufacturerBcApiImpl(Map<String, Object> properties) {
        super(properties);
        context = (Context) properties.get(Constants.ANDROID_CONTEXT);
        PIN_KBD_LAYOUT = (int) properties.get(Constants.PIN_KBD_LAYOUT_ID);
        PIN_KBD_BUTTONS_LAYOUT = (int) properties.get(Constants.PIN_KBD_BUTTONS_LAYOUT_ID);
    }

    @Override
    public void goOnChip(String tags) {
        Log.i(TAG, "goOnChip: start");
        openPinKBD();
        waitActivityOpen();
        Log.d(TAG, "goOnChip: Send GOC -> " + tags);
        Log.i(TAG, "goOnChip: end - " + tags);
    }

    private void openPinKBD() {
        Log.i(TAG, "openPinKBD: start");
        Intent intent = new Intent(context, PinKBDActivity.class);
        intent.addFlags(FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(Constants.PIN_KBD_LAYOUT_ID, PIN_KBD_LAYOUT);
        intent.putExtra(Constants.PIN_KBD_BUTTONS_LAYOUT_ID, PIN_KBD_BUTTONS_LAYOUT);
        context.startActivity(intent);
        Log.i(TAG, "openPinKBD: end");
    }

    private void waitActivityOpen() {
        Log.i(TAG, "waitActivityOpen: start");
        try {
            while (PinKBDReferencesHelper.INSTANCE().getPinKBDReferences() == null) {
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
        Log.i(TAG, "waitActivityOpen: end");
    }

}
