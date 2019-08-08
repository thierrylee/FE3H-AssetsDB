package me.thierrylee.fe3hdb.assets.model.transformer

import me.thierrylee.fe3hdb.assets.model.CombatArtAsset

internal object CombatArtAssetTransformer : AbstractAssetTransformer<CombatArtAsset>() {

    override fun getAssetFile() = "combatarts.tsv"
    override fun getColumnCount() = 8

    override fun internalBuildAsset(rawValues: List<String>) = CombatArtAsset(
        id = rawValues[0].toId(),
        name = rawValues[0],
        useSkill = rawValues[1].toSkillAsset(),
        might = rawValues[2].toIntOrZero(),
        hit = rawValues[3].toIntOrZero(),
        crit = rawValues[4].toIntOrZero(),
        range = rawValues[5],
        cost = rawValues[6].toIntOrZero(),
        description = rawValues[7]
    )
}