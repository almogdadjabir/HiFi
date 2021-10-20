package com.almogdadjabir.hifi.model.products

import kotlinx.serialization.Serializable

@Serializable
data class Links (

	val first : String?,
	val last : String?,
	val prev : String?,
	val next : String?
)