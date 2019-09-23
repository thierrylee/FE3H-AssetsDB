package me.thierrylee.fe3hdb.assets.model.transformer

import me.thierrylee.fe3hdb.assets.model.GiftAsset

internal object GiftAssetTransformer {

    internal object Liked : AbstractAssetTransformer<GiftAsset>() {

        override fun getColumnCount() = 2

        override fun getAssetFile() = "liked_gifts"

        override fun internalBuildAsset(rawValues: List<String>) = GiftAsset(
            name = rawValues[0],
            characterId = rawValues[1].toId(),
            isLiked = true
        )
    }

    internal object Disliked : AbstractAssetTransformer<GiftAsset>() {

        override fun getColumnCount() = 2

        override fun getAssetFile() = "disliked_gifts"

        override fun internalBuildAsset(rawValues: List<String>) = GiftAsset(
            name = rawValues[0],
            characterId = rawValues[1].toId(),
            isLiked = false
        )
    }

}