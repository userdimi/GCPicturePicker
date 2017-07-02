package com.example.dimitrisimon.gcpicturepicker.fragments

import android.app.Fragment
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dimitrisimon.gcpicturepicker.R
import com.example.dimitrisimon.gcpicturepicker.fragments.HomeFragment.statics.TAG
import com.example.dimitrisimon.gcpicturepicker.helper.PermissionHelper
import com.example.dimitrisimon.gcpicturepicker.helper.StorageHelper
import kotlinx.android.synthetic.main.fragment_home.*
import org.jetbrains.anko.toast

/**
 * (c) Dimitri Simon on 24.06.17
 */

class HomeFragment : Fragment() {

    /**
     * Static vars
     */
    object statics {
        //Fragment Tag
        const val TAG = "Homefragment"
    }



    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_home, container, false)

    }

    /**
     * OnClick load picture to the server.
     */
    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {

        btn_picture_upload.setOnClickListener { uploadPicture() }

        super.onViewCreated(view, savedInstanceState)
    }

    fun uploadPicture() {
        selectPictures(StorageHelper())
    }

    fun selectPictures(StorageHelper: StorageHelper) {

        Log.i(TAG, "Show upload button pressed. Checking permission.")

        //first check if the storage is mounted
        if (!StorageHelper.externalStorageMounted()) {
            return
        }
        //than check the VersionNumber of the Device
        //if the VersionNumber is higher then 23 we need to request the permissions on runtime
        if (Build.VERSION.SDK_INT > 23) {

            // now check if the read external storage permission is already available.
            if (PermissionHelper().permissionToReadStorageNotGranded(activity)) {

                // if not, request permissions and open gallery
                PermissionHelper().requestReadExternStoragePermission(activity)

            } else {
                //permissions, available, open gallery
                openGallery()
            }
        }
    }

    private fun openGallery() {
        toast("Open Gallery")
    }
}
