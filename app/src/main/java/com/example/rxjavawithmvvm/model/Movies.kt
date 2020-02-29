package com.example.rxjavawithmvvm.model

import com.google.gson.annotations.SerializedName

data class Movies(

	@field:SerializedName("status_message")
	val statusMessage: String? = null,

	@field:SerializedName("data")
	val data: Data? = null,

	@field:SerializedName("@meta")
	val meta: Meta? = null,

	@field:SerializedName("status")
	val status: String? = null
)