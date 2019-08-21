package com.example.gertecpinpoc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

public class PedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ped);
        getWindow().setGravity(Gravity.BOTTOM);
        WindowManager.LayoutParams p = getWindow().getAttributes();
        p.width = ViewGroup.LayoutParams.MATCH_PARENT;
        getWindow().setAttributes(p);
        this.setFinishOnTouchOutside(false);
        setTitle("");
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);

        LinearLayout layout = findViewById(R.id.include);

        Button btn0 = layout.findViewById(R.id.btn0);
        Button btn1 = layout.findViewById(R.id.btn1);
        Button btn2 = layout.findViewById(R.id.btn2);
        Button btn3 = layout.findViewById(R.id.btn3);
        Button btn4 = layout.findViewById(R.id.btn4);
        Button btn5 = layout.findViewById(R.id.btn5);
        Button btn6 = layout.findViewById(R.id.btn6);
        Button btn7 = layout.findViewById(R.id.btn7);
        Button btn8 = layout.findViewById(R.id.btn8);
        Button btn9 = layout.findViewById(R.id.btn9);
        Button btnCancel = layout.findViewById(R.id.btnCancel);
        Button btnClear = layout.findViewById(R.id.btnClear);
        Button btnConfirm = layout.findViewById(R.id.btnConfirm);

        GertecPinHelper.getInstance().gertecPinKeyboard = new GertecPinKeyboard(
                btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnCancel,
                btnClear, btnConfirm, this
        );

    }
}
