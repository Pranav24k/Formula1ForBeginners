package com.example.f1beginnerproject.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class F1item(
   @StringRes val titleRes : Int,
    @DrawableRes val imageRes : Int,
    @StringRes val referenceRes : Int,
    @StringRes val contentRes : Int
)
