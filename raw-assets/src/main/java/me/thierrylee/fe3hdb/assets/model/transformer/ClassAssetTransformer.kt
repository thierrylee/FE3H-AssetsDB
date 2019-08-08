package me.thierrylee.fe3hdb.assets.model.transformer

import me.thierrylee.fe3hdb.assets.model.ClassAsset

internal object ClassAssetTransformer : AbstractAssetTransformer<ClassAsset>() {

    override fun getAssetFile() = "classes.tsv"
    override fun getColumnCount() = 28

    override fun internalBuildAsset(rawValues: List<String>): ClassAsset {
        return ClassAsset(
            id = rawValues[0].toId(),
            name = rawValues[0],
            requiredLevel = rawValues[1].toIntOrZero(),
            requiredSkillLevels = extractRequiredSkills(rawValues).zip(extractRequiredRanks(rawValues)),
            isOneRequirementOnly = rawValues[4] == "Y",
            availableGenders = rawValues[5].split().map { it.toGenderAsset() },
            characterExclusive = rawValues[7].split(),
            swordProficiency = rawValues[8].toIntOrZero(),
            lanceProficiency = rawValues[9].toIntOrZero(),
            axeProficiency = rawValues[10].toIntOrZero(),
            bowProficiency = rawValues[11].toIntOrZero(),
            brawlingProficiency = rawValues[12].toIntOrZero(),
            reasonProficiency = rawValues[13].toIntOrZero(),
            faithProficiency = rawValues[14].toIntOrZero(),
            authorityProficiency = rawValues[15].toIntOrZero(),
            armorProficiency = rawValues[16].toIntOrZero(),
            ridingProficiency = rawValues[17].toIntOrZero(),
            flyingProficiency = rawValues[18].toIntOrZero(),
            growthHp = rawValues[19].toIntOrZero(),
            growthStr = rawValues[20].toIntOrZero(),
            growthMag = rawValues[21].toIntOrZero(),
            growthDex = rawValues[22].toIntOrZero(),
            growthSpd = rawValues[23].toIntOrZero(),
            growthLck = rawValues[24].toIntOrZero(),
            growthDef = rawValues[25].toIntOrZero(),
            growthRes = rawValues[26].toIntOrZero(),
            growthCha = rawValues[27].toIntOrZero()
        )
    }

    private fun extractRequiredSkills(rawValues: List<String>) = rawValues[2].split().map { it.toSkillAsset() }

    private fun extractRequiredRanks(rawValues: List<String>) = rawValues[3].split().map { it.toRankAsset() }
}