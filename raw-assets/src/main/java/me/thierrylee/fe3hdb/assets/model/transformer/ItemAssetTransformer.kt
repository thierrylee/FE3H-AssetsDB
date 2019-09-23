package me.thierrylee.fe3hdb.assets.model.transformer

import me.thierrylee.fe3hdb.assets.model.ItemAsset
import me.thierrylee.fe3hdb.assets.model.ItemTypeAsset

internal object ItemAssetTransformer {

    internal object Lost : AbstractAssetTransformer<ItemAsset>() {

        override fun getColumnCount() = 2

        override fun getAssetFile() = "lost_items"

        override fun internalBuildAsset(rawValues: List<String>) = ItemAsset(
            name = rawValues[0],
            characterId = rawValues[1].toId(),
            itemType = ItemTypeAsset.LOST
        )
    }

    internal object LikedGift : AbstractAssetTransformer<ItemAsset>() {

        override fun getColumnCount() = 2

        override fun getAssetFile() = "liked_gifts"

        override fun internalBuildAsset(rawValues: List<String>) = ItemAsset(
            name = rawValues[0],
            characterId = rawValues[1].toId(),
            itemType = ItemTypeAsset.LIKED_GIFT
        )
    }

    internal object DislikedGift : AbstractAssetTransformer<ItemAsset>() {

        override fun getColumnCount() = 2

        override fun getAssetFile() = "disliked_gifts"

        override fun internalBuildAsset(rawValues: List<String>) = ItemAsset(
            name = rawValues[0],
            characterId = rawValues[1].toId(),
            itemType = ItemTypeAsset.DISLIKED_GIFT
        )
    }

}