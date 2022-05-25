package com.example.nutralysis2.entities

import android.os.Parcel
import android.os.Parcelable

data class WATERX(
    val label: String?,
    val quantity: Double,
    val unit: String?
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readDouble(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(label)
        parcel.writeDouble(quantity)
        parcel.writeString(unit)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<WATERX> {
        override fun createFromParcel(parcel: Parcel): WATERX {
            return WATERX(parcel)
        }

        override fun newArray(size: Int): Array<WATERX?> {
            return arrayOfNulls(size)
        }
    }
}