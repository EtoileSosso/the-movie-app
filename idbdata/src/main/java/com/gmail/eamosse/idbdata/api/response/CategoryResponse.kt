package com.gmail.eamosse.idbdata.api.response

import com.gmail.eamosse.idbdata.data.Category
import com.google.gson.annotations.SerializedName

internal data class CategoryResponse(
    @SerializedName("genres")
    val genres: List<Genre>
) {
    data class Genre(
        val id: Int,
        val name: String
    )
}

internal fun CategoryResponse.Genre.toCategory() = Category(
    id = id,
    name = name
)