package com.example.dimitrisimon.gcpicturepicker.fragments


import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dimitrisimon.gcpicturepicker.R
import com.example.dimitrisimon.gcpicturepicker.helper.StorageHelper
import kotlinx.android.synthetic.main.fragment_home.*
import org.jetbrains.anko.alert
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

        //first check if the storage is mounted
        if (StorageHelper.externalStorageMounted())
            toast("Storage ist gemounted")
    }

}
