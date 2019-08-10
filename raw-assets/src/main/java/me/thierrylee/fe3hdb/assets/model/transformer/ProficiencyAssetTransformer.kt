package me.thierrylee.fe3hdb.assets.model.transformer

import me.thierrylee.fe3hdb.assets.model.ProficiencyAsset

internal object ProficiencyValue {
    const val STRONG = "U"
    const val NEUTRAL = "-"
    const val NEUTRAL_ALT = ""
    const val WEAK = "D"
}

internal fun String.toProficiencyAsset() = when (this.toUpperCase().trim()) {
    ProficiencyValue.STRONG -> ProficiencyAsset.STRONG
    ProficiencyValue.NEUTRAL, ProficiencyValue.NEUTRAL_ALT -> ProficiencyAsset.NEUTRAL
    ProficiencyValue.WEAK -> ProficiencyAsset.WEAK
    else -> throw IllegalArgumentException("Invalid proficiency : $this")
}