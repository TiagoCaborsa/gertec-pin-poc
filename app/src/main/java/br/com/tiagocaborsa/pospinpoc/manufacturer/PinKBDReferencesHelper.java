package br.com.tiagocaborsa.pospinpoc.manufacturer;

import android.util.Log;

public class PinKBDReferencesHelper implements ConfigPinKBDReferences {

    private static final String TAG = PinKBDReferencesHelper.class.getName();
    private static PinKBDReferencesHelper pinKBDReferencesHelper;
    private PinKBDReferences pinKBDReferences;

    private PinKBDReferencesHelper() {
    }

    public static PinKBDReferencesHelper INSTANCE() {
        return pinKBDReferencesHelper != null ?
                pinKBDReferencesHelper :
                (pinKBDReferencesHelper = new PinKBDReferencesHelper());
    }

    @Override
    public void setPinKBDReferences(PinKBDReferences pinKBDReferences) {
        Log.d(TAG, "setPinKBDReferences: " + pinKBDReferences);
        this.pinKBDReferences = pinKBDReferences;
    }

    public PinKBDReferences getPinKBDReferences() {
        return pinKBDReferences;
    }

}
