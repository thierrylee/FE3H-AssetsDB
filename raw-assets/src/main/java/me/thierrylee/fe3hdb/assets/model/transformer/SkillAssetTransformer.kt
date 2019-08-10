package me.thierrylee.fe3hdb.assets.model.transformer

import me.thierrylee.fe3hdb.assets.model.SkillAsset

internal object SkillValue {
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
    const val NONE = "NONE"
}

internal fun String.toSkillAsset() = when (this.toUpperCase().trim()) {
    SkillValue.SWORD -> SkillAsset.SWORD
    SkillValue.LANCE -> SkillAsset.LANCE
    SkillValue.AXE -> SkillAsset.AXE
    SkillValue.BOW -> SkillAsset.BOW
    SkillValue.BRAWLING -> SkillAsset.BRAWLING
    SkillValue.REASON -> SkillAsset.REASON
    SkillValue.FAITH -> SkillAsset.FAITH
    SkillValue.AUTHORITY -> SkillAsset.AUTHORITY
    SkillValue.ARMOR -> SkillAsset.ARMOR
    SkillValue.RIDING -> SkillAsset.RIDING
    SkillValue.FLYING -> SkillAsset.FLYING
    SkillValue.NONE -> SkillAsset.NONE
    else -> throw IllegalArgumentException("Invalid skill : $this")
}