package me.thierrylee.fe3hdb.assets.model.transformer

import me.thierrylee.fe3hdb.assets.model.MagicAsset

internal object MagicAssetTransformer : AbstractAssetTransformer<MagicAsset>() {

    override fun getAssetFile() = "magics.tsv"
    override fun getColumnCount() = 11

    override fun internalBuildAsset(rawValues: List<String>) = MagicAsset(
        id = rawValues[0].toId(),
        name = rawValues[0],
        useSkill = rawValues[1].toSkillAsset(),
        type = rawValues[2],
        might = rawValues[3].toIntOrZero(),
        hit = rawValues[4].toIntOrZero(),
        crit = rawValues[5].toIntOrZero(),
        range = rawValues[6],
        weight = rawValues[7].toIntOrZero(),
        level = rawValues[8].toRankAsset(),
        use = rawValues[9].toIntOrZero(),
        description = rawValues[10]
    )
}