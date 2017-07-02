package com.example.dimitrisimon.gcpicturepicker.helper

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.support.v4.app.ActivityCompat
import android.util.Log
import com.example.dimitrisimon.gcpicturepicker.R
import com.example.dimitrisimon.gcpicturepicker.fragments.HomeFragment
import com.example.dimitrisimon.gcpicturepicker.helper.PermissionHelper.statics.MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE
import com.example.dimitrisimon.gcpicturepicker.helper.PermissionHelper.statics.PERMISSIONS_READ_EXTERNAL_STORAGE
import org.jetbrains.anko.alert


/**
 * (c) Dimitri Simon on 29.06.17
 *
 */
class PermissionHelper {


    object statics {
        /**
         * Id to identify
         */
        const val MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE: Int = 1

        /**
         * Permissions required to read external storage. Used by the {@link HomeFragment}.
         */
        const val PERMISSIONS_READ_EXTERNAL_STORAGE: String = Manifest.permission.READ_EXTERNAL_STORAGE
    }

    /**
     * Check if permission to read external storage is already available.
     */
    fun permissionToReadStorageNotGranded(context: Context): Boolean {
        return ActivityCompat.checkSelfPermission(context,
                Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
    }


    /**
     * Requests the Read External Storage permission.
     * If the permission has been denied previously, a SnackBar will prompt the user to grant the
     * permission, otherwise it is requested directly.
    */
    fun requestReadExternStoragePermission (context: Context) {

        Log.i(HomeFragment.statics.TAG,
                "Read external storage permission has NOT been granted. Requesting permission.")

            // BEGIN_INCLUDE(externalStorage_permission_request)
            if (ActivityCompat.shouldShowRequestPermissionRationale(context as Activity,
                    PERMISSIONS_READ_EXTERNAL_STORAGE)) {

                //show explanation for the request
                showPermissionExplanation(context, context.resources.getString(R.string.alert_externalStorage_Permission_title),
                        context.resources.getString(R.string.alert_externalStorage_Permission_message))

        } else {
            //// No explanation needed, we can request the permission.
            ActivityCompat.requestPermissions(context, arrayOf(PERMISSIONS_READ_EXTERNAL_STORAGE),
                    MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE)
        }
    }

    /**
     * Show an explanation for the request to the user
     */
    fun showPermissionExplanation (context: Context, title: String, message: String) {
        context.alert(message = message,
                title = title) {
            positiveButton (context.resources.getString(R.string.btn_pos_alert_externalStorage))
            { ActivityCompat.requestPermissions(context as Activity,
                    arrayOf(PERMISSIONS_READ_EXTERNAL_STORAGE),
                    MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE)}
            negativeButton(context.resources.getString(R.string.btn_neg_alert_externalStorage))
            { return@negativeButton }
        }.show()
    }
}
