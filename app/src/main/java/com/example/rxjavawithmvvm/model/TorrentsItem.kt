package com.example.rxjavawithmvvm.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class TorrentsItem : Serializable {

    @field:SerializedName("size_bytes")
    val sizeBytes: Long? = null

    @field:SerializedName("size")
    val size: String? = null

    @field:SerializedName("seeds")
    val seeds: Int? = null

    @field:SerializedName("date_uploaded")
    val dateUploaded: String? = null

    @field:SerializedName("peers")
    val peers: Int? = null

    @field:SerializedName("date_uploaded_unix")
    val dateUploadedUnix: Int? = null

    @field:SerializedName("type")
    val type: String? = null

    @field:SerializedName("url")
    val url: String? = null

    @field:SerializedName("hash")
    val hash: String? = null

    @field:SerializedName("quality")
    val quality: String? = null
}