package me.thierrylee.fe3hdb.assets.model.transformer

import me.thierrylee.fe3hdb.assets.model.TeaFinalCommentAsset

internal object TeaFinalCommentAssetTransformer: AbstractAssetTransformer<TeaFinalCommentAsset>(){

    override fun getAssetFile() = "tea_final_comments"
    override fun getColumnCount() = 3

    override fun internalBuildAsset(rawValues: List<String>) = TeaFinalCommentAsset (
        finalComment = rawValues[0],
        validAnswers = rawValues[1].split(),
        characterId = rawValues[2].toId()
    )

}