package com.storage

import android.app.Application
import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.Registry
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.load.engine.cache.DiskCache
import com.bumptech.glide.load.engine.cache.ExternalPreferredCacheDiskCacheFactory
import com.bumptech.glide.module.AppGlideModule

/**
 *
 *
 * @author: FairyHeart.
 * @date  : 2020-05-14.
 */
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

//        var builder = GlideBuilder().setDiskCache(
//            ExternalPreferredCacheDiskCacheFactory(
//                this, "image_manager_d",
//                DiskCache.Factory.DEFAULT_DISK_CACHE_SIZE.toLong()
//            )
//        )
//        Glide.init(this, builder)
    }
//    @GlideModule
//    public final class MyAppGlideModule : AppGlideModule() {
//        override fun registerComponents(context: Context, glide: Glide, registry: Registry) {
//            super.registerComponents(context, glide, registry)
//        }
//
//        override fun applyOptions(context: Context, builder: GlideBuilder) {
//            builder.setDiskCache(
//                ExternalPreferredCacheDiskCacheFactory(
//                    context, "image_manager_d",
//                    DiskCache.Factory.DEFAULT_DISK_CACHE_SIZE.toLong()
//                )
//            )
//        }
//    }
}