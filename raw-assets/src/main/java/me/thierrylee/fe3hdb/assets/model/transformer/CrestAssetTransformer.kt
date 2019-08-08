package me.thierrylee.fe3hdb.assets.model.transformer

import me.thierrylee.fe3hdb.assets.model.CrestAsset

internal object CrestAssetTransformer : AbstractAssetTransformer<CrestAsset>() {

    override fun getAssetFile() = "crests"
    override fun getColumnCount() = 2

    override fun internalBuildAsset(rawValues: List<String>) = CrestAsset(
        id = rawValues[0].toId(),
        description = rawValues[1]
    )

}