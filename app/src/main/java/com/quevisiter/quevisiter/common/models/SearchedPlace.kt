package com.quevisiter.quevisiter.common.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SearchedPlace (
    @SerializedName("category") val category : Category,
    @SerializedName("places") val places: ArrayList<Place>
): Parcelable