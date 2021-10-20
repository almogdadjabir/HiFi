package com.almogdadjabir.hifi.model.products

import kotlinx.serialization.Serializable

@Serializable
data class Images (

	val id : Int?,
	val path : String?,
	val url : String?,
	val original_image_url : String?,
	val small_image_url : String?,
	val medium_image_url : String?,
	val large_image_url : String?
)