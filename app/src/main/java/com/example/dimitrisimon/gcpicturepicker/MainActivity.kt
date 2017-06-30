package com.example.dimitrisimon.gcpicturepicker


import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.dimitrisimon.gcpicturepicker.fragments.HomeFragment
import com.example.dimitrisimon.gcpicturepicker.fragments.HomeFragment.*


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
        fragmentManager.beginTransaction()
                .replace(R.id.container, homeFragment, statics.TAG)
                .commit()
    }

}
