package me.thierrylee.fe3hdb.assets.model.transformer

import me.thierrylee.fe3hdb.assets.model.UnitTypeAsset

internal object UnitTypeValue {
    const val ARMOR = "ARMOR"
    const val RIDING = "RIDING"
    const val FLYING = "FLYING"
    const val MAGIC = "MAGIC"
}

internal fun String.toUnitTypeAsset() = when (this.toUpperCase().trim()) {
    UnitTypeValue.ARMOR -> UnitTypeAsset.ARMOR
    UnitTypeValue.RIDING -> UnitTypeAsset.RIDING
    UnitTypeValue.FLYING -> UnitTypeAsset.FLYING
    UnitTypeValue.MAGIC -> UnitTypeAsset.MAGIC
    else -> throw IllegalArgumentException("Invalid unit type : $this")
}