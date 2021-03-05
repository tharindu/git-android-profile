package com.wordpress.tharindufit.gitprofile.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.wordpress.tharindufit.gitprofile.R;

/**
 * Helper and validation functions for the project may be included here.
 */
public class Utils {

    /**
     * Display AlertDialog box in any context with title, message
     *
     * @param context
     * @param title
     * @param msg
     */
    public static void showAlertDialog(final Context context, String title, String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(msg);
        builder.setTitle(title);
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.setCancelable(false);
        dialog.show();
    }
}
