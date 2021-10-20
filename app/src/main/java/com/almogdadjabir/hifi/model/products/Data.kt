package com.almogdadjabir.hifi.model.products

import kotlinx.serialization.Serializable

@Serializable
data class Data (

	val id : Int?,
	val sku : Int?,
	val type : String?,
	val name : String?,
	val url_key : String?,
	val price : Double?,
	val formated_price : String?,
	val short_description : String?,
	val description : String?,
	val images : List<Images>?,
	val videos : List<String>?,
	val base_image : Base_image?,
	val created_at : String?,
	val updated_at : String?,
	val reviews : Reviews?,
	val in_stock : Boolean?,
	val is_wishlisted : Boolean?,
	val is_item_in_cart : Boolean?,
	val show_quantity_changer : Boolean?
)