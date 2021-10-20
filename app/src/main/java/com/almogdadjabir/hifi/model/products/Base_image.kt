package com.almogdadjabir.hifi.model.products

import kotlinx.serialization.Serializable

@Serializable
data class Base_image (

	val small_image_url : String?,
	val medium_image_url : String?,
	val large_image_url : String?,
	val original_image_url : String?
)