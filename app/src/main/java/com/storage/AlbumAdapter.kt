package com.storage

import android.content.Context
import android.graphics.BitmapFactory
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

/**
 *
 *
 * @author: FairyHeart.
 * @date  : 2020-05-14.
 */
class AlbumAdapter(
    private val context: Context,
    private val imageList: MutableList<Uri>,
    private val imageSize: Int
) :
    RecyclerView.Adapter<AlbumAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.adapter_album, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.imageView.layoutParams.width = imageSize
        holder.imageView.layoutParams.height = imageSize
        val options = RequestOptions().placeholder(R.drawable.ic_launcher_background)
            .override(imageSize, imageSize)
        val uri = imageList[position]
        Log.i("xxx", uri.toString())
        Glide.with(context).load(uri).apply(options).into(holder.imageView)
    }

}