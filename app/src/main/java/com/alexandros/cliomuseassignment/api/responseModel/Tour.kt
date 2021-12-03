package com.alexandros.cliomuseassignment.api.responseModel

data class Tour(
    val average_rating: String,
    val duration: String,
    val header_image: String,
    val permalink: String,
    val rating_count: Int,
    val retail_price: String,
    val sales_price: String,
    val sku: String,
    val thumbnail: String,
    val title: String
)