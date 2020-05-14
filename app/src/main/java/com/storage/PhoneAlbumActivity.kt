package com.storage

import android.content.ContentUris
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.ViewTreeObserver
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_phone_album.*
import kotlin.concurrent.thread

class PhoneAlbumActivity : AppCompatActivity() {

    val imageList = mutableListOf<Uri>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_album)

        recycler_view.viewTreeObserver.addOnPreDrawListener(object :
            ViewTreeObserver.OnPreDrawListener {
            override fun onPreDraw(): Boolean {
                recycler_view.viewTreeObserver.removeOnPreDrawListener(this)
                val columns = 3
                val imageSize = recycler_view.width / columns
                val adapter = AlbumAdapter(this@PhoneAlbumActivity, imageList, imageSize)
                recycler_view.layoutManager = GridLayoutManager(this@PhoneAlbumActivity, columns)
                recycler_view.adapter = adapter
                loadImages(adapter)
                return false
            }
        })
    }

    private fun loadImages(adapter: AlbumAdapter) {
        thread {
            val cursor = contentResolver.query(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                null,
                null,
                null,
                "${MediaStore.MediaColumns.DATE_ADDED} desc"
            )
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    val id =
                        cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.MediaColumns._ID))
                    val uri =
                        ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, id)
                    imageList.add(uri)
                }
                cursor.close()
            }
            runOnUiThread {
                adapter.notifyDataSetChanged()
            }
        }
    }
}
