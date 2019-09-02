package com.manufacturer;

import android.app.Activity;
import android.widget.Button;

public class PinKBDReferences {

    private Button btn0;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btnCancel;
    private Button btnClear;
    private Button btnConfirm;
    private Activity activity;

    public PinKBDReferences(Button btn0, Button btn1, Button btn2, Button btn3, Button btn4, Button btn5,
                            Button btn6, Button btn7, Button btn8, Button btn9, Button btnCancel,
                            Button btnClear, Button btnConfirm, Activity activity) {
        this.btn0 = btn0;
        this.btn1 = btn1;
        this.btn2 = btn2;
        this.btn3 = btn3;
        this.btn4 = btn4;
        this.btn5 = btn5;
        this.btn6 = btn6;
        this.btn7 = btn7;
        this.btn8 = btn8;
        this.btn9 = btn9;
        this.btnCancel = btnCancel;
        this.btnClear = btnClear;
        this.btnConfirm = btnConfirm;
        this.activity = activity;
    }

    public Button getBtn0() {
        return btn0;
    }

    public Button getBtn1() {
        return btn1;
    }

    public Button getBtn2() {
        return btn2;
    }

    public Button getBtn3() {
        return btn3;
    }

    public Button getBtn4() {
        return btn4;
    }

    public Button getBtn5() {
        return btn5;
    }

    public Button getBtn6() {
        return btn6;
    }

    public Button getBtn7() {
        return btn7;
    }

    public Button getBtn8() {
        return btn8;
    }

    public Button getBtn9() {
        return btn9;
    }

    public Button getBtnCancel() {
        return btnCancel;
    }

    public Button getBtnClear() {
        return btnClear;
    }

    public Button getBtnConfirm() {
        return btnConfirm;
    }

    public Activity getActivity() {
        return activity;
    }

}
