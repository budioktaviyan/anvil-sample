package id.android.anvil.detail.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DetailEntity(
  val title: String,
  val content: String,
  val background: String,
  val rating: Double
) : Parcelable