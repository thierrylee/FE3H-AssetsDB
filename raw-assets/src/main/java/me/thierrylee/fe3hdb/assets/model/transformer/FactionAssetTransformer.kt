package me.thierrylee.fe3hdb.assets.model.transformer

import me.thierrylee.fe3hdb.assets.model.FactionAsset

internal object FactionValue {
    const val NONE = ""
    const val BLACK_EAGLES = "BLACK EAGLES"
    const val BLUE_LIONS = "BLUE LIONS"
    const val GOLDEN_DEERS = "GOLDEN DEERS"
    const val CHURCH_OF_SEIROS = "CHURCH OF SEIROS"
}

internal fun String.toFactionAsset() = when (this.toUpperCase().trim()) {
    FactionValue.NONE -> FactionAsset.NONE
    FactionValue.BLACK_EAGLES -> FactionAsset.BLACK_EAGLES
    FactionValue.BLUE_LIONS -> FactionAsset.BLUE_LIONS
    FactionValue.GOLDEN_DEERS -> FactionAsset.GOLDEN_DEERS
    FactionValue.CHURCH_OF_SEIROS -> FactionAsset.CHURCH_OF_SEIROS
    else -> throw IllegalArgumentException("Invalid faction : $this")
}