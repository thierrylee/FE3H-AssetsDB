package me.thierrylee.fe3hdb.core.entity.transformer

import me.thierrylee.fe3hdb.core.entity.GenderEntity

internal object GenderEntityValue {
    const val MALE = "M"
    const val FEMALE = "F"
}

internal fun String.toGenderEntity() = when (this) {
    GenderEntityValue.MALE -> GenderEntity.MALE
    GenderEntityValue.FEMALE -> GenderEntity.FEMALE
    else -> throw IllegalArgumentException("Invalid gender : $this")
}