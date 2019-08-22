package br.com.tiagocaborsa.gertecpinpoc;

public class GertecPinHelper {

    private static GertecPinHelper gertecPinHelper;
    public GertecPinKeyboard gertecPinKeyboard;

    private GertecPinHelper() {
    }

    public static GertecPinHelper getInstance() {
        return gertecPinHelper != null ? gertecPinHelper : (gertecPinHelper = new GertecPinHelper());
    }
}
