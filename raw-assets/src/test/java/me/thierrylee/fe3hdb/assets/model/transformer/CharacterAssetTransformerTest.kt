package me.thierrylee.fe3hdb.assets.model.transformer

import me.thierrylee.fe3hdb.assets.RawAssetFileExtractor
import me.thierrylee.fe3hdb.assets.model.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class CharacterAssetTransformerTest {

    @Test
    fun `buildAsset - should return expected character`() {
        // Given
        val rawValues = RawAssetFileExtractor().extractRawValues("dummy_characters.tsv")[1]

        // When
        val characterAsset = CharacterAssetTransformer.buildAsset(rawValues)

        // Then
        assertThat(characterAsset).isEqualTo(
            CharacterAsset(
                id = "BylethM",
                name = "Byleth (M)",
                affiliation = AffiliationAsset.CHURCH_OF_SEIROS,
                gender = GenderAsset.MALE,
                recruitmentRequirements = "From start",
                baseHp = 27,
                baseStr = 13,
                baseMag = 6,
                baseDex = 9,
                baseSpd = 8,
                baseLck = 8,
                baseDef = 6,
                baseRes = 6,
                baseCha = 7,
                growthHp = 45,
                growthStr = 45,
                growthMag = 35,
                growthDex = 45,
                growthSpd = 45,
                growthLck = 45,
                growthDef = 35,
                growthRes = 30,
                growthCha = 45,
                maxHp = 88,
                maxStr = 77,
                maxMag = 55,
                maxDex = 66,
                maxSpd = 66,
                maxLck = 66,
                maxDef = 55,
                maxRes = 55,
                maxCha = 99,
                swordProficiency = ProficiencyAsset.STRONG,
                lanceProficiency = ProficiencyAsset.NEUTRAL,
                axeProficiency = ProficiencyAsset.NEUTRAL,
                bowProficiency = ProficiencyAsset.NEUTRAL,
                brawlingProficiency = ProficiencyAsset.STRONG,
                reasonProficiency = ProficiencyAsset.NEUTRAL,
                faithProficiency = ProficiencyAsset.NEUTRAL,
                authorityProficiency = ProficiencyAsset.STRONG,
                armorProficiency = ProficiencyAsset.NEUTRAL,
                ridingProficiency = ProficiencyAsset.NEUTRAL,
                flyingProficiency = ProficiencyAsset.WEAK,
                baseSwordSkill = RankAsset.S_PLUS,
                baseLanceSkill = RankAsset.S,
                baseAxeSkill = RankAsset.A_PLUS,
                baseBowSkill = RankAsset.A,
                baseBrawlingSkill = RankAsset.B_PLUS,
                baseReasonSkill = RankAsset.B,
                baseFaithSkill = RankAsset.C_PLUS,
                baseAuthoritySkill = RankAsset.C,
                baseArmorSkill = RankAsset.D_PLUS,
                baseRidingSkill = RankAsset.D,
                baseFlyingSkill = RankAsset.E,
                majorCrest = "Flames",
                minorCrest = "",
                isPlayable = true
            )
        )
    }
}