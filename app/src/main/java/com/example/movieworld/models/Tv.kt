package com.example.movieworld.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Tv(
    @SerializedName("id")
    val id: String?,
    @SerializedName("original_name")
    val title: String?,
    @SerializedName("poster_path")
    val poster: String?,
    @SerializedName("first_air_date")
    val release: String?,

    @SerializedName("overview")
    val overview: String?,

    @SerializedName("vote_average")
    val vote: Double?

) : Parcelable {
    constructor() : this("", "", "", "", "", 0.0)


}

