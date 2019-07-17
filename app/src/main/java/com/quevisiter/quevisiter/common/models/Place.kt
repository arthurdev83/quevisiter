package com.quevisiter.quevisiter.common.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Place (

    @SerializedName("id") val id : Int,
    @SerializedName("title") val title : String,
    @SerializedName("description") val description : String,
    @SerializedName("category") val category : Category

): Parcelable