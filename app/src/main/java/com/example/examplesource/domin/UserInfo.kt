package com.example.examplesource.domin

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserInfo(
    var cardNumber: String ="",
    var cvc: String = "",
    var date: String = ""
): Parcelable


