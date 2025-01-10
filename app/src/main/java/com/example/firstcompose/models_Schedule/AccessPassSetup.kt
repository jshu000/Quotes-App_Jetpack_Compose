package com.example.firstcompose.models_Schedule

data class AccessPassSetup(
    val available_passes: Int,
    val fortress_passes_sold: Any,
    val no_threshold: Boolean,
    val non_stm_cost: Int,
    val stm_cost: Int,
    val total_passes_allowed: Int
)