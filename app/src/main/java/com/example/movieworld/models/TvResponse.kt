package com.example.movieworld.models
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TvResponse(
    @SerializedName("results")
    val movies :List<Tv>
) : Parcelable {
    constructor() : this(mutableListOf())
}

