package com.example.dimitrisimon.gcpicturepicker.helper

import android.os.Environment

/**
 * (c) Dimitri Simon on 29.06.17
 */

class StorageHelper {

    var storagePath: String = Environment.getExternalStorageState()

    /**
     * Check if external storage is mounted
     */
    fun externalStorageMounted (): Boolean {
        return Environment.MEDIA_MOUNTED.equals(storagePath)
    }
}