package me.thierrylee.fe3hdb.assets.model.transformer

import me.thierrylee.fe3hdb.assets.model.CharacterAsset

internal object CharacterAssetTransformer : AbstractAssetTransformer<CharacterAsset>() {

    override fun getAssetFile() = "characters"
    override fun getColumnCount() = 56

    override fun internalBuildAsset(rawValues: List<String>) = CharacterAsset(
        id = rawValues[0].toId(),
        name = rawValues[0],
        affiliation = rawValues[1].toAffiliationAsset(),
        gender = rawValues[2].toGenderAsset(),
        recruitmentRequirements = rawValues[3],
        baseHp = rawValues[4].toInt(),
        baseStr = rawValues[5].toInt(),
        baseMag = rawValues[6].toInt(),
        baseDex = rawValues[7].toInt(),
        baseSpd = rawValues[8].toInt(),
        baseLck = rawValues[9].toInt(),
        baseDef = rawValues[10].toInt(),
        baseRes = rawValues[11].toInt(),
        baseCha = rawValues[12].toInt(),
        growthHp = rawValues[13].toInt(),
        growthStr = rawValues[14].toInt(),
        growthMag = rawValues[15].toInt(),
        growthDex = rawValues[16].toInt(),
        growthSpd = rawValues[17].toInt(),
        growthLck = rawValues[18].toInt(),
        growthDef = rawValues[19].toInt(),
        growthRes = rawValues[20].toInt(),
        growthCha = rawValues[21].toInt(),
        maxHp = rawValues[22].toInt(),
        maxStr = rawValues[23].toInt(),
        maxMag = rawValues[24].toInt(),
        maxDex = rawValues[25].toInt(),
        maxSpd = rawValues[26].toInt(),
        maxLck = rawValues[27].toInt(),
        maxDef = rawValues[28].toInt(),
        maxRes = rawValues[29].toInt(),
        maxCha = rawValues[30].toInt(),
        swordProficiency = rawValues[31].toProficiencyAsset(),
        lanceProficiency = rawValues[32].toProficiencyAsset(),
        axeProficiency = rawValues[33].toProficiencyAsset(),
        bowProficiency = rawValues[34].toProficiencyAsset(),
        brawlingProficiency = rawValues[35].toProficiencyAsset(),
        reasonProficiency = rawValues[36].toProficiencyAsset(),
        faithProficiency = rawValues[37].toProficiencyAsset(),
        authorityProficiency = rawValues[38].toProficiencyAsset(),
        armorProficiency = rawValues[39].toProficiencyAsset(),
        ridingProficiency = rawValues[40].toProficiencyAsset(),
        flyingProficiency = rawValues[41].toProficiencyAsset(),
        baseSwordSkill = rawValues[42].toRankAsset(),
        baseLanceSkill = rawValues[43].toRankAsset(),
        baseAxeSkill = rawValues[44].toRankAsset(),
        baseBowSkill = rawValues[45].toRankAsset(),
        baseBrawlingSkill = rawValues[46].toRankAsset(),
        baseReasonSkill = rawValues[47].toRankAsset(),
        baseFaithSkill = rawValues[48].toRankAsset(),
        baseAuthoritySkill = rawValues[49].toRankAsset(),
        baseArmorSkill = rawValues[50].toRankAsset(),
        baseRidingSkill = rawValues[51].toRankAsset(),
        baseFlyingSkill = rawValues[52].toRankAsset(),
        majorCrest = rawValues[53].toId(),
        minorCrest = rawValues[54].toId(),
        isPlayable = (rawValues[55] == "Y")
    )
}