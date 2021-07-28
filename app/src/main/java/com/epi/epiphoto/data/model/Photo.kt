package com.epi.epiphoto.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Photo(
    val id : String?,
    @SerializedName("created_at")
    val createdAt:String?,
    @SerializedName("updated_at")
    val updatedAt:String?,
    val description:String?,
    @SerializedName("alt_description")
    val altDescription:String?,
    val user : User,
    var vue : Boolean = false
): Parcelable
