package com.example.dimitrisimon.gcpicturepicker.helper

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat


/**
 * (c) Dimitri Simon on 29.06.17
 *
 */
class PermissionHelper (context: Context){

    val MY_PERMISSIONS_REQUEST_READ_CONTACTS: Int = 1

    var permissionCheck: Int = ContextCompat.checkSelfPermission(context,
            Manifest.permission.READ_EXTERNAL_STORAGE)

    var readExternalStorage: String = Manifest.permission.READ_EXTERNAL_STORAGE

    fun requestReadExternStoragePermission (context: Context) {

        if (ContextCompat.checkSelfPermission(context, readExternalStorage)
                != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(context as Activity,
                    readExternalStorage)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.


            }

        } else {

            //// No explanation needed, we can request the permission.
            ActivityCompat.requestPermissions(context as Activity, arrayOf(readExternalStorage),
                    MY_PERMISSIONS_REQUEST_READ_CONTACTS)
        }
    }
}
