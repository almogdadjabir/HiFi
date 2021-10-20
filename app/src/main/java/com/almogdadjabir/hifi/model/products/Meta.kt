package com.almogdadjabir.hifi.model.products

import kotlinx.serialization.Serializable

@Serializable
data class Meta (

	val current_page : Int?,
	val from : Int?,
	val last_page : Int?,
	val path : String?,
	val per_page : Int?,
	val to : Int?,
	val total : Int?
)