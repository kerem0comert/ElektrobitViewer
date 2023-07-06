package com.keremcomert.elektrobitviewer.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Country(
    val id: Int,
    val name: String,
    @SerializedName("photo_url") val photoUrl: String,
    val sites: List<Site>
): Parcelable