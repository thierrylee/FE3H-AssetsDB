package me.thierrylee.fe3hdb.assets.model.transformer

import me.thierrylee.fe3hdb.assets.model.TeaAnswerAsset

internal object TeaAnswerAssetTransformer: AbstractAssetTransformer<TeaAnswerAsset>(){

    override fun getAssetFile() = "tea_answers"
    override fun getColumnCount() = 3

    override fun internalBuildAsset(rawValues: List<String>) = TeaAnswerAsset (
        finalComment = rawValues[0],
        validAnswers = rawValues[1].split(),
        characterId = rawValues[2].toId()
    )

}