package com.almogdadjabir.hifi.repository

import com.almogdadjabir.hifi.model.products.ProductAPIDATA
import com.almogdadjabir.hifi.other.Constants.URL_allProducts
import io.ktor.client.*
import io.ktor.client.request.*
import javax.inject.Inject

class Repository @Inject constructor(private val client: HttpClient) {

    suspend fun getAllProducts(): ProductAPIDATA {
        return client.get(urlString = URL_allProducts) as ProductAPIDATA
    }
}