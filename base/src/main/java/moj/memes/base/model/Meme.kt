package moj.memes.base.model

import android.annotation.SuppressLint
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

const val EXTRA_MEME = "extra_meme"

@SuppressLint("ParcelCreator")
@Parcelize
data class Meme(
        val id: Int = -1,
        val name: String = "",
        val imageUrl: String = "",
        val imageWidth: Int = 0,
        val imageHeight: Int = 0
) : Parcelable
