package com.almogdadjabir.hifi.model.products

import kotlinx.serialization.Serializable

@Serializable
data class Reviews (

	val total : Int?,
	val total_rating : Int?,
	val average_rating : Int?,
	val percentage : List<String>?
)