package me.thierrylee.fe3hdb.assets.model.transformer

import me.thierrylee.fe3hdb.assets.model.LostItemAsset

internal object LostItemAssetTransformer : AbstractAssetTransformer<LostItemAsset>() {

    override fun getColumnCount() = 2

    override fun getAssetFile() = "lost_items"

    override fun internalBuildAsset(rawValues: List<String>) = LostItemAsset(
        name = rawValues[0],
        characterId = rawValues[1].toId()
    )

}
