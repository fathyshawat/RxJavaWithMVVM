package com.example.rxjavawithmvvm.model

import com.google.gson.annotations.SerializedName

data class Meta(

	@field:SerializedName("server_time")
	val serverTime: Int? = null,

	@field:SerializedName("server_timezone")
	val serverTimezone: String? = null,

	@field:SerializedName("api_version")
	val apiVersion: Int? = null,

	@field:SerializedName("execution_time")
	val executionTime: String? = null
)