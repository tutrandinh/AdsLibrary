package com.sapp.ads.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import com.sapp.ads.R;

public class ResumeLoadingDialog extends Dialog {

    public ResumeLoadingDialog(Context context) {
        super(context, R.style.AppTheme);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_resume_loading);
    }
}
