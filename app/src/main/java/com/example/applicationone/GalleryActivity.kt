package com.example.applicationone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_gallery.*

class GalleryActivity : AppCompatActivity() {

    val manager = supportFragmentManager
    var isFragmentGridLoaded = false
    var isFragmentSingleLoaded = false
    var galleryActivityViewModel : GalleryActivityViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)

        galleryActivityViewModel = ViewModelProviders.of(this).get(GalleryActivityViewModel::class.java)


        showFragment(galleryActivityViewModel!!.getInitial())

        buttonGridView.setOnClickListener {
            if (isFragmentSingleLoaded) {
                showFragment(galleryActivityViewModel!!.getCurrent())
            }
        }
        buttonSingleView.setOnClickListener {
            if (isFragmentGridLoaded) {
                showFragment(galleryActivityViewModel!!.getCurrent())
            }
        }
    }

    private fun showFragment(checkDigit : Int) {
        if (checkDigit == 0) {
            showGridFragment()
            isFragmentGridLoaded = true
            isFragmentSingleLoaded = false
        } else {
            showSingleFragment()
            isFragmentGridLoaded = false
            isFragmentSingleLoaded = true
        }
    }

    private fun showSingleFragment() {
        val transaction = manager.beginTransaction()
        val fragment = SinglePicture()
        transaction.replace(R.id.fragment, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    private fun showGridFragment() {
        val transaction = manager.beginTransaction()
        val fragment = GridPicture()
        transaction.replace(R.id.fragment, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
