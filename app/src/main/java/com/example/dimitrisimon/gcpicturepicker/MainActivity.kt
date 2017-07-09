package com.example.dimitrisimon.gcpicturepicker

import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.example.dimitrisimon.gcpicturepicker.fragments.HomeFragment
import com.example.dimitrisimon.gcpicturepicker.fragments.HomeFragment.*
import com.example.dimitrisimon.gcpicturepicker.helper.PermissionHelper



class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //start Homefragment
        startHomeFragment()
    }

    /**
     * Create Homefragment
     */
    private fun  startHomeFragment() {
        val homeFragment = fragmentManager.findFragmentByTag(statics.TAG) ?: HomeFragment()
        supportFragmentManager.beginTransaction()
                .replace(R.id.container, homeFragment as Fragment?, statics.TAG)
                .commit()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {

        when (requestCode) {

            PermissionHelper.statics.MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE
                    -> if (grantResults.isNotEmpty() && grantResults [0] == PackageManager.PERMISSION_GRANTED) {
                            val fragments: MutableList<android.support.v4.app.Fragment>? = supportFragmentManager.fragments
                if (fragments != null) {
                    for (fragment in fragments) {
                        fragment.onRequestPermissionsResult(requestCode, permissions, grantResults)
                    }
                }
            }

            else -> return

        }
    }
}
