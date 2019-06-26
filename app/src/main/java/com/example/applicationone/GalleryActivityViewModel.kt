package com.example.applicationone

import androidx.lifecycle.ViewModel

class GalleryActivityViewModel : ViewModel() {
    private var currentVal : Int = 0

    public fun getInitial() : Int{
        return currentVal
    }
    public fun getCurrent() : Int{
        currentVal = 1 - currentVal
        return currentVal
    }
}