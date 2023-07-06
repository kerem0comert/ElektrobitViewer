package com.keremcomert.elektrobitviewer.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Site(
    val id: Int,
    val name: String,
    val address: String,
    @SerializedName("photo_url") val photoUrl: String,
): Parcelable