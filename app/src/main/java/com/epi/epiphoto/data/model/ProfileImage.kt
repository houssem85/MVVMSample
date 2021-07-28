package com.epi.epiphoto.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProfileImage(
    val small : String,
    val medium : String,
    val large : String
): Parcelable