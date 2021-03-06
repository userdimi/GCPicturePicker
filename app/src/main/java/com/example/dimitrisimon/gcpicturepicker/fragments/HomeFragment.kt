package com.example.dimitrisimon.gcpicturepicker.fragments

import android.content.Intent
import android.content.pm.PackageManager
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


/**
 * (c) Dimitri Simon on 24.06.17
 */

class HomeFragment : android.support.v4.app.Fragment() {

    /**
     * Static vars
     */
    object statics {
        //Fragment Tag
        const val TAG = "Homefragment"
    }

    val SELECT_PICTURE_REQUEST: Int = 1;



    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_home, container, false)

    }

    /**
     * OnClick load picture to the server.
     */
    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {

        btn_picture_upload.setOnClickListener { PrepareUploadPictures() }

        super.onViewCreated(view, savedInstanceState)
    }

    fun PrepareUploadPictures() {
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
            if (PermissionHelper().permissionToReadStorageNotGranded(context)) {

                // if not, request permissions and open gallery
                PermissionHelper().requestReadExternStoragePermission(context)

            } else {
                //permissions, available, open gallery
                openGallery()
            }
        }
    }

    /**
     * If Permissions are granted, open the the gallery. Otherwise go back to the Homescreen
     */
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when (requestCode) {
            PermissionHelper.statics.MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE
            -> if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED ) {

                openGallery()
            }

            else -> return
        }
    }

    /**
     * Open Android Gallery App to choose a picture for upload
     */
    fun openGallery() {
        var intent: Intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(intent, SELECT_PICTURE_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)


    }

    /**
    fun uploadPictures (fileUri: Uri) {

        var pictureFile: RequestBody = RequestBody.create(
            MediaType.parse(context.contentResolver.getType(fileUri)), FileUtils.getFile(this, fileUri))

        //create Retrofit instance
        RetrofitHelper().buildRetrofit()

    }
    */


}


