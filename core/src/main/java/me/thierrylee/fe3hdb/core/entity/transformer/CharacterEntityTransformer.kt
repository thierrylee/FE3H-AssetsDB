package me.thierrylee.fe3hdb.core.entity.transformer

import me.thierrylee.fe3hdb.core.entity.CharacterEntity
import me.thierrylee.fe3hdb.core.utils.toId

internal object CharacterEntityTransformer{

    private const val COLUMN_COUNT = 46

    fun toCharacterEntity(rawValues : List<String>): CharacterEntity{
        if (rawValues.size != COLUMN_COUNT) throw IllegalArgumentException("rawValues should have $COLUMN_COUNT columns")
        return CharacterEntity(
            id = rawValues[0].toId(),
            name = rawValues[0],
            faction = rawValues[1],
            gender = rawValues[2],
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
            swordProficiency = rawValues[22].toProficiencyEntity(),
            lanceProficiency = rawValues[23].toProficiencyEntity(),
            axeProficiency = rawValues[24].toProficiencyEntity(),
            bowProficiency = rawValues[25].toProficiencyEntity(),
            brawlingProficiency = rawValues[26].toProficiencyEntity(),
            reasonProficiency = rawValues[27].toProficiencyEntity(),
            faithProficiency = rawValues[28].toProficiencyEntity(),
            authorityProficiency = rawValues[29].toProficiencyEntity(),
            armorProficiency = rawValues[30].toProficiencyEntity(),
            ridingProficiency = rawValues[31].toProficiencyEntity(),
            flyingProficiency = rawValues[32].toProficiencyEntity(),
            baseSwordSkill = rawValues[33].toRankEntity(),
            baseLanceSkill = rawValues[34].toRankEntity(),
            baseAxeSkill = rawValues[35].toRankEntity(),
            baseBowSkill = rawValues[36].toRankEntity(),
            baseBrawlingSkill = rawValues[37].toRankEntity(),
            baseReasonSkill = rawValues[38].toRankEntity(),
            baseFaithSkill = rawValues[39].toRankEntity(),
            baseAuthoritySkill = rawValues[40].toRankEntity(),
            baseArmorSkill = rawValues[41].toRankEntity(),
            baseRidingSkill = rawValues[42].toRankEntity(),
            baseFlyingSkill = rawValues[43].toRankEntity(),
            majorCrest = rawValues[44].toId(),
            minorCrest = rawValues[45].toId()
        )
    }
}