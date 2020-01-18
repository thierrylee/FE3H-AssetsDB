package me.thierrylee.fe3hdb.assets.model.transformer

import me.thierrylee.fe3hdb.assets.model.TeaTopicAsset

internal object TeaTopicAssetTransformer: AbstractAssetTransformer<TeaTopicAsset>(){
    override fun getAssetFile() = "tea_topics"

    override fun getColumnCount() = 2

    override fun internalBuildAsset(rawValues: List<String>) = TeaTopicAsset(
        interrestedTopic = rawValues[0],
        characterId = rawValues[1].toId()
    )

}