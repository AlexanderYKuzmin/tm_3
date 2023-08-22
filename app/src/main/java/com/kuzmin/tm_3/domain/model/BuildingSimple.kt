package com.kuzmin.tm_3.domain.model

import android.os.Parcel
import android.os.Parcelable
import java.util.Date

data class BuildingSimple(
  val id: Long,
  val name: String,
  val address: String,
  val date: Date,
  val employee: String,
  val completed: Boolean,
  val approved: Boolean,
  val firstPhotoId: Long?,
  val firstPhotoUrl: String?
) : Parcelable {
  constructor(parcel: Parcel) : this(
    parcel.readLong(),
    parcel.readString()!!,
    parcel.readString()!!,
    Date(parcel.readLong()),
    parcel.readString()!!,
    parcel.readByte() != 0.toByte(),
    parcel.readByte() != 0.toByte(),
    parcel.readLong(),
    parcel.readString()
  ) {
  }

  override fun writeToParcel(parcel: Parcel, flags: Int) {
    parcel.writeLong(id)
    parcel.writeString(name)
    parcel.writeString(address)
    parcel.writeLong(date.time)
    parcel.writeString(employee)
    parcel.writeByte(if (completed) 1 else 0)
    parcel.writeByte(if (approved) 1 else 0)
    parcel.writeLong(firstPhotoId ?: -1L)
    parcel.writeString(firstPhotoUrl)
  }

  override fun describeContents(): Int {
    return 0
  }

  companion object CREATOR : Parcelable.Creator<BuildingSimple> {
    override fun createFromParcel(parcel: Parcel): BuildingSimple {
      return BuildingSimple(parcel)
    }

    override fun newArray(size: Int): Array<BuildingSimple?> {
      return arrayOfNulls(size)
    }
  }
}