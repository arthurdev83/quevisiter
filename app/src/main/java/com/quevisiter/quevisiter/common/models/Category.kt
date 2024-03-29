package com.quevisiter.quevisiter.common.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Category (

    @SerializedName("id") val id : Int,
    @SerializedName("name") val name : String

): Parcelable