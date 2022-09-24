package com.example.movieworld.models
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
@Parcelize
data  class Movie (
    @SerializedName("id")
    val  id : String?,

    @SerializedName("overview")
    val  overview : String?,

    @SerializedName("title")
    val title:String?,
    @SerializedName("poster_path")
    val poster :String?,
    @SerializedName("release_date")
    val  release :String?,

    @SerializedName("vote_average")
    val vote:Double?

        ): Parcelable{
            constructor():this( "","","","","",0.0)



        }



