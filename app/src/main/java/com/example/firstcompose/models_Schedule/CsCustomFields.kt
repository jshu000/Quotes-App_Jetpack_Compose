package com.example.firstcompose.models_Schedule

data class CsCustomFields(
    val family_night: String,
    val hide_tune_in: Boolean,
    val sponsor: Sponsor,
    val tune_in: List<Any>,
    val utility_menu: List<Any>
)