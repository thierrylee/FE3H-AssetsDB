package me.thierrylee.fe3hdb.assets.model.transformer

import me.thierrylee.fe3hdb.assets.model.MagicRequirementAsset

internal object MagicRequirementAssetTransformer : AbstractAssetTransformer<MagicRequirementAsset>() {

    override fun getAssetFile() = "magic_req_personallearn"
    override fun getColumnCount() = 4

    override fun internalBuildAsset(rawValues: List<String>) = MagicRequirementAsset(
        magicId = rawValues[0],
        requiredSkill = rawValues[1].toSkillAsset(),
        requiredRank = rawValues[2].toRankAsset(),
        characterIds = rawValues[3].split().map { it.toId() }
    )

}