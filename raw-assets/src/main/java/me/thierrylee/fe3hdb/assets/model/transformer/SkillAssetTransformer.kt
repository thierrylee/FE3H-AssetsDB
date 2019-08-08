package me.thierrylee.fe3hdb.assets.model.transformer

import me.thierrylee.fe3hdb.assets.model.SkillAsset

internal object SkillAssetValue {
    const val SWORD = "SWORD"
    const val LANCE = "LANCE"
    const val AXE = "AXE"
    const val BOW = "BOW"
    const val BRAWLING = "BRAWLING"
    const val REASON = "REASON"
    const val FAITH = "FAITH"
    const val AUTHORITY = "AUTHORITY"
    const val ARMOR = "ARMOR"
    const val RIDING = "RIDING"
    const val FLYING = "FLYING"
}

internal fun String.toSkillAsset() = when (this.toUpperCase().trim()) {
    SkillAssetValue.SWORD -> SkillAsset.SWORD
    SkillAssetValue.LANCE -> SkillAsset.LANCE
    SkillAssetValue.AXE -> SkillAsset.AXE
    SkillAssetValue.BOW -> SkillAsset.BOW
    SkillAssetValue.BRAWLING -> SkillAsset.BRAWLING
    SkillAssetValue.REASON -> SkillAsset.REASON
    SkillAssetValue.FAITH -> SkillAsset.FAITH
    SkillAssetValue.AUTHORITY -> SkillAsset.AUTHORITY
    SkillAssetValue.ARMOR -> SkillAsset.ARMOR
    SkillAssetValue.RIDING -> SkillAsset.RIDING
    SkillAssetValue.FLYING -> SkillAsset.FLYING
    else -> throw IllegalArgumentException("Invalid skill : $this")
}