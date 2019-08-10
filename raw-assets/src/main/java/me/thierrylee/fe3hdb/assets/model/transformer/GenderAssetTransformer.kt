package me.thierrylee.fe3hdb.assets.model.transformer

import me.thierrylee.fe3hdb.assets.model.GenderAsset

internal object GenderValue {
    const val MALE = "M"
    const val FEMALE = "F"
}

internal fun String.toGenderAsset() = when (this.toUpperCase().trim()) {
    GenderValue.MALE -> GenderAsset.MALE
    GenderValue.FEMALE -> GenderAsset.FEMALE
    else -> throw IllegalArgumentException("Invalid gender : $this")
}