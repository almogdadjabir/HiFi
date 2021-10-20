package com.almogdadjabir.hifi.model.products

import kotlinx.serialization.Serializable

@Serializable
data class ProductAPIDATA (

	val data : List<Data>?,
	val links : Links?,
	val meta : Meta?
)