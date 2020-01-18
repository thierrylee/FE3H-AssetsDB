package me.thierrylee.fe3hdb.assets.model.transformer

import me.thierrylee.fe3hdb.assets.model.FavoriteTeaAsset

internal object FavoriteTeaAssetTransformer: AbstractAssetTransformer<FavoriteTeaAsset>(){

    override fun getAssetFile() = "favorite_teas"
    override fun getColumnCount() = 2

    override fun internalBuildAsset(rawValues: List<String>) = FavoriteTeaAsset(
        teaName = rawValues[0],
        characterId = rawValues[1].toId()
    )

}