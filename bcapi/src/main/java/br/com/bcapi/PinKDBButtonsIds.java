package br.com.bcapi;

import android.os.Parcel;
import android.os.Parcelable;

public class PinKDBButtonsIds implements Parcelable {

    private int btn0Id;
    private int btn1Id;
    private int btn2Id;
    private int btn3Id;
    private int btn4Id;
    private int btn5Id;
    private int btn6Id;
    private int btn7Id;
    private int btn8Id;
    private int btn9Id;
    private int btnClearId;
    private int btnCancelId;
    private int btnEnterId;

    public PinKDBButtonsIds(int btn0Id, int btn1Id, int btn2Id, int btn3Id, int btn4Id, int btn5Id,
                            int btn6Id, int btn7Id, int btn8Id, int btn9Id, int btnClearId,
                            int btnCancelId, int btnEnterId) {
        this.btn0Id = btn0Id;
        this.btn1Id = btn1Id;
        this.btn2Id = btn2Id;
        this.btn3Id = btn3Id;
        this.btn4Id = btn4Id;
        this.btn5Id = btn5Id;
        this.btn6Id = btn6Id;
        this.btn7Id = btn7Id;
        this.btn8Id = btn8Id;
        this.btn9Id = btn9Id;
        this.btnClearId = btnClearId;
        this.btnCancelId = btnCancelId;
        this.btnEnterId = btnEnterId;
    }

    protected PinKDBButtonsIds(Parcel in) {
        btn0Id = in.readInt();
        btn1Id = in.readInt();
        btn2Id = in.readInt();
        btn3Id = in.readInt();
        btn4Id = in.readInt();
        btn5Id = in.readInt();
        btn6Id = in.readInt();
        btn7Id = in.readInt();
        btn8Id = in.readInt();
        btn9Id = in.readInt();
        btnClearId = in.readInt();
        btnCancelId = in.readInt();
        btnEnterId = in.readInt();
    }

    public static final Creator<PinKDBButtonsIds> CREATOR = new Creator<PinKDBButtonsIds>() {
        @Override
        public PinKDBButtonsIds createFromParcel(Parcel in) {
            return new PinKDBButtonsIds(in);
        }

        @Override
        public PinKDBButtonsIds[] newArray(int size) {
            return new PinKDBButtonsIds[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(btn0Id);
        dest.writeInt(btn1Id);
        dest.writeInt(btn2Id);
        dest.writeInt(btn3Id);
        dest.writeInt(btn4Id);
        dest.writeInt(btn5Id);
        dest.writeInt(btn6Id);
        dest.writeInt(btn7Id);
        dest.writeInt(btn8Id);
        dest.writeInt(btn9Id);
        dest.writeInt(btnClearId);
        dest.writeInt(btnCancelId);
        dest.writeInt(btnEnterId);
    }

    public int getBtn0Id() {
        return btn0Id;
    }

    public int getBtn1Id() {
        return btn1Id;
    }

    public int getBtn2Id() {
        return btn2Id;
    }

    public int getBtn3Id() {
        return btn3Id;
    }

    public int getBtn4Id() {
        return btn4Id;
    }

    public int getBtn5Id() {
        return btn5Id;
    }

    public int getBtn6Id() {
        return btn6Id;
    }

    public int getBtn7Id() {
        return btn7Id;
    }

    public int getBtn8Id() {
        return btn8Id;
    }

    public int getBtn9Id() {
        return btn9Id;
    }

    public int getBtnClearId() {
        return btnClearId;
    }

    public int getBtnCancelId() {
        return btnCancelId;
    }

    public int getBtnEnterId() {
        return btnEnterId;
    }

}
