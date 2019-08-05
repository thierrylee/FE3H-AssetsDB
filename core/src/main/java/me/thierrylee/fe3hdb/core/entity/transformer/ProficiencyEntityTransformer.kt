package me.thierrylee.fe3hdb.core.entity.transformer

import me.thierrylee.fe3hdb.core.entity.ProficiencyEntity

internal object ProficiencyValue {
    const val STRONG = "U"
    const val NEUTRAL = "-"
    const val WEAK = "D"
}

internal fun String.toProficiencyEntity() = when (this) {
    ProficiencyValue.STRONG -> ProficiencyEntity.STRONG
    ProficiencyValue.NEUTRAL -> ProficiencyEntity.NEUTRAL
    ProficiencyValue.WEAK -> ProficiencyEntity.WEAK
    else -> throw IllegalArgumentException("Invalid proficiency : $this")
}