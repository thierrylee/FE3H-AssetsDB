package me.thierrylee.fe3hdb.assets.model.transformer

import me.thierrylee.fe3hdb.assets.model.CharacterAsset

internal object CharacterAssetTransformer : AbstractAssetTransformer<CharacterAsset>() {

    override fun getAssetFile() = "characters"
    override fun getColumnCount() = 47

    override fun internalBuildAsset(rawValues: List<String>) = CharacterAsset(
        id = rawValues[0].toId(),
        name = rawValues[0],
        affiliation = rawValues[1].toAffiliationAsset(),
        gender = rawValues[2].toGenderAsset(),
        recruitmentRequirements = rawValues[3],
        growthHp = rawValues[4].toInt(),
        growthStr = rawValues[5].toInt(),
        growthMag = rawValues[6].toInt(),
        growthDex = rawValues[7].toInt(),
        growthSpd = rawValues[8].toInt(),
        growthLck = rawValues[9].toInt(),
        growthDef = rawValues[10].toInt(),
        growthRes = rawValues[11].toInt(),
        growthCha = rawValues[12].toInt(),
        maxHp = rawValues[13].toInt(),
        maxStr = rawValues[14].toInt(),
        maxMag = rawValues[15].toInt(),
        maxDex = rawValues[16].toInt(),
        maxSpd = rawValues[17].toInt(),
        maxLck = rawValues[18].toInt(),
        maxDef = rawValues[19].toInt(),
        maxRes = rawValues[20].toInt(),
        maxCha = rawValues[21].toInt(),
        swordProficiency = rawValues[22].toProficiencyAsset(),
        lanceProficiency = rawValues[23].toProficiencyAsset(),
        axeProficiency = rawValues[24].toProficiencyAsset(),
        bowProficiency = rawValues[25].toProficiencyAsset(),
        brawlingProficiency = rawValues[26].toProficiencyAsset(),
        reasonProficiency = rawValues[27].toProficiencyAsset(),
        faithProficiency = rawValues[28].toProficiencyAsset(),
        authorityProficiency = rawValues[29].toProficiencyAsset(),
        armorProficiency = rawValues[30].toProficiencyAsset(),
        ridingProficiency = rawValues[31].toProficiencyAsset(),
        flyingProficiency = rawValues[32].toProficiencyAsset(),
        baseSwordSkill = rawValues[33].toRankAsset(),
        baseLanceSkill = rawValues[34].toRankAsset(),
        baseAxeSkill = rawValues[35].toRankAsset(),
        baseBowSkill = rawValues[36].toRankAsset(),
        baseBrawlingSkill = rawValues[37].toRankAsset(),
        baseReasonSkill = rawValues[38].toRankAsset(),
        baseFaithSkill = rawValues[39].toRankAsset(),
        baseAuthoritySkill = rawValues[40].toRankAsset(),
        baseArmorSkill = rawValues[41].toRankAsset(),
        baseRidingSkill = rawValues[42].toRankAsset(),
        baseFlyingSkill = rawValues[43].toRankAsset(),
        majorCrest = rawValues[44].toId(),
        minorCrest = rawValues[45].toId()
    )
}