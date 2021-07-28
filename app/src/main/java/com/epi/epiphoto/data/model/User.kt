package com.epi.epiphoto.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val id:String,
    val username:String,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("last_name")
    val lastName:String,
    @SerializedName("profile_image")
    val profileImage : ProfileImage
): Parcelable
