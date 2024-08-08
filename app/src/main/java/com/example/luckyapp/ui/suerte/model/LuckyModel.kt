package com.example.luckyapp.ui.suerte.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

//modelo va en la capa de UI porque el DrawableRes y StringRes son de la capa de UI
data class LuckyModel (
    //@DrawableRes hace que sí o sí el dato sea una referencia de drawable como R.drawable.algo
    @DrawableRes val image:Int,
    //@StringRes hace que sí o sí el dato sea una referencia de string como R.string.algo
    @StringRes val text:Int
)