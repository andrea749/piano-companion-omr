package com.andrea.pianocompanionomr.imagescanner

import android.content.Context
import android.graphics.Bitmap


// change to DI class
object ImageScanner {
    private val TAG = ImageScanner::class.java.simpleName

    init {
        System.loadLibrary("stlport_shared")
        System.loadLibrary("ReadScoreLib")
    }

    fun scanBitmap(bitmap: Bitmap, context: Context) {}
}