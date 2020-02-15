package me.thierrylee.fe3hdb.assets.model.transformer

import me.thierrylee.fe3hdb.assets.model.AffiliationAsset

internal object AffiliationValue {
    const val BLACK_EAGLES = "BLACK EAGLES"
    const val BLUE_LIONS = "BLUE LIONS"
    const val GOLDEN_DEERS = "GOLDEN DEERS"
    const val CHURCH_OF_SEIROS = "CHURCH OF SEIROS"
    const val ASHEN_WOLVES = "ASHEN WOLVES"
}

internal fun String.toAffiliationAsset() = when (this.toUpperCase().trim()) {
    AffiliationValue.BLACK_EAGLES -> AffiliationAsset.BLACK_EAGLES
    AffiliationValue.BLUE_LIONS -> AffiliationAsset.BLUE_LIONS
    AffiliationValue.GOLDEN_DEERS -> AffiliationAsset.GOLDEN_DEERS
    AffiliationValue.CHURCH_OF_SEIROS -> AffiliationAsset.CHURCH_OF_SEIROS
    AffiliationValue.ASHEN_WOLVES -> AffiliationAsset.ASHEN_WOLVES
    else -> throw IllegalArgumentException("Invalid affiliation : $this")
}