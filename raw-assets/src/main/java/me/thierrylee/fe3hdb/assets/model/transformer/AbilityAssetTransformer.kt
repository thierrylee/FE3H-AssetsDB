package me.thierrylee.fe3hdb.assets.model.transformer

import me.thierrylee.fe3hdb.assets.model.AbilityAsset

internal object AbilityAssetTransformer : AbstractAssetTransformer<AbilityAsset>() {

    override fun getAssetFile() = "abilities.tsv"
    override fun getColumnCount() = 2

    override fun internalBuildAsset(rawValues: List<String>) = AbilityAsset(
        id = rawValues[0].toId(),
        description = rawValues[1]
    )

}