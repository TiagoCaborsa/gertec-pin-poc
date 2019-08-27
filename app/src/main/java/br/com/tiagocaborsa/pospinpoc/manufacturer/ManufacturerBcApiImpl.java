package br.com.tiagocaborsa.pospinpoc.manufacturer;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Map;

import br.com.tiagocaborsa.pospinpoc.stone.bc.Constants;
import br.com.tiagocaborsa.pospinpoc.stone.bc.PinKBDReferencesHelper;
import br.com.tiagocaborsa.pospinpoc.stone.bc.api.BcApi;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class ManufacturerBcApiImpl extends BcApi {

    private static final String TAG = ManufacturerBcApiImpl.class.getName();
    private Context context;
    private Class pinActivityClass;
    private PinKBDReferencesHelper pinKBDReferencesHelper = new PinKBDReferencesHelper();

    public ManufacturerBcApiImpl(Map<String, Object> properties) {
        super(properties);
        context = (Context) properties.get(Constants.ANDROID_CONTEXT);
        pinActivityClass =
                (Class) properties.get(Constants.PIN_ACTIVIY_CLASS);
    }

    @Override
    public void goOnChip(String tags) {
        Log.d(TAG, "goOnChip: start");
        openPinKBD();


        final Intent i = new Intent(context, pinActivityClass);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        new Thread(new Runnable() {
            @Override
            public void run() {
                context.startActivity(i);
            }
        });

//        GertecEmv.kbdData = null;
//        coreEmvCallback.showDefaultPinLayout(new PinLayoutConfig(100,
//                670, 32, Color.BLACK, true, 30, false), true);

        while (true) {
            try {
                while (pinKBDReferencesHelper.getPinKBDReferences() == null) {
                    try {
                        Thread.sleep(200);
                        Log.d(TAG, "goOnChip: while in");
                    } catch (InterruptedException e) {

                    }
                }
                break;
            } catch (NullPointerException e) {

            }
        }


//        while (pinKBDReferencesHelper.getPinKBDReferences() == null) {
//            Log.d(TAG, "goOnChip: while in");
//            try {
//                Thread.sleep(200);
//            } catch (InterruptedException e) {
//                Log.e(TAG, "goOnChip: ", e);
//            }
//        }
//        Log.d(TAG, "goOnChip: while out");

//        while (true) {
//            try {
//                while (pinKBDReferencesHelper.getPinKBDReferences().getActivity() == null) {
//                    try {
//                        Thread.sleep(200);
//                        Log.d(TAG, "goOnChip: while in");
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//                Log.d(TAG, "goOnChip: while out in try");
//                break;
//            } catch (NullPointerException e) {
//
//            }
//            Log.d(TAG, "goOnChip: while out");
//        }

        Log.d(TAG, "goOnChip: end - " + tags);
    }

    private void openPinKBD() {
        Log.d(TAG, "openPinKBD: start");
        Intent intent = new Intent(context, pinActivityClass);
        intent.addFlags(FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(Constants.CONFIG_PIN_KBD_REFERENCES_INTENT, pinKBDReferencesHelper);
        context.startActivity(intent);
        Log.d(TAG, "openPinKBD: end");
    }

}
