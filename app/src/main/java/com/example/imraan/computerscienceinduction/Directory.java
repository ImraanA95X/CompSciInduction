package com.example.imraan.computerscienceinduction;

import android.graphics.Bitmap;

/**
 * Created by Imraan on 28/01/2017.
 */

public class Directory {

    private Bitmap mAvatar;
    private String mName;
    private String mPhone;
    private String mEmail;
    private String mLocation;

    public Directory(Bitmap mAvatar, String mName, String mPhone, String mEmail, String mLocation) {
        this.mAvatar = mAvatar;
        this.mName = "Name: " + mName;
        this.mPhone = "Phone Extension: " + mPhone;
        this.mEmail = "Email: " + mEmail;
        this.mLocation = "Location: " + mLocation;
    }

    public Bitmap getmAvatar() {
        return mAvatar;
    }

    public void setmAvatar(Bitmap mAvatar) {
        this.mAvatar = mAvatar;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmPhone() {
        return mPhone;
    }

    public void setmPhone(String mPhone) {
        this.mPhone = mPhone;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public String getmLocation() {
        return mLocation;
    }

    public void setmLocation(String mLocation) {
        this.mLocation = mLocation;
    }


}
