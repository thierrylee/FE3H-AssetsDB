package me.thierrylee.fe3hdb.core.entity.transformer

import me.thierrylee.fe3hdb.core.entity.CharacterEntity
import me.thierrylee.fe3hdb.core.entity.ProficiencyEntity
import me.thierrylee.fe3hdb.core.entity.RankEntity
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class CharacterEntityTransformerTest {

    @Test(expected = IllegalArgumentException::class)
    fun `toCharacterEntity - when list is not the correct size - should throw exception`() {
        // When
        CharacterEntityTransformer.toCharacterEntity(emptyList())

        // Then
        // Expect exception
    }

    @Test
    fun `toCharacterEntity - when correct size - should return expected entity`() {
        // Given
        val characterRawValue = listOf(
            "~BylethM _!-!°",
            "",
            "M",
            "",
            "45",
            "45",
            "35",
            "45",
            "45",
            "45",
            "35",
            "30",
            "45",
            "88",
            "77",
            "55",
            "66",
            "66",
            "66",
            "55",
            "55",
            "99",
            "U",
            "-",
            "-",
            "-",
            "U",
            "-",
            "-",
            "U",
            "-",
            "-",
            "D",
            "D+",
            "-",
            "-",
            "-",
            "E+",
            "-",
            "-",
            "D",
            "-",
            "-",
            "-",
            "Flames",
            "",
            ""
        )

        // When
        val characterEntity = CharacterEntityTransformer.toCharacterEntity(characterRawValue)

        // Then
        assertThat(characterEntity).isEqualTo(
            CharacterEntity(
                id = "BylethM",
                name = "~BylethM _!-!°",
                faction = "",
                gender = "M",
                recruitmentRequirements = "",
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
                swordProficiency = ProficiencyEntity.STRONG,
                lanceProficiency = ProficiencyEntity.NEUTRAL,
                axeProficiency = ProficiencyEntity.NEUTRAL,
                bowProficiency = ProficiencyEntity.NEUTRAL,
                brawlingProficiency = ProficiencyEntity.STRONG,
                reasonProficiency = ProficiencyEntity.NEUTRAL,
                faithProficiency = ProficiencyEntity.NEUTRAL,
                authorityProficiency = ProficiencyEntity.STRONG,
                armorProficiency = ProficiencyEntity.NEUTRAL,
                ridingProficiency = ProficiencyEntity.NEUTRAL,
                flyingProficiency = ProficiencyEntity.WEAK,
                baseSwordSkill = RankEntity.D_PLUS,
                baseLanceSkill = RankEntity.E,
                baseAxeSkill = RankEntity.E,
                baseBowSkill = RankEntity.E,
                baseBrawlingSkill = RankEntity.E_PLUS,
                baseReasonSkill = RankEntity.E,
                baseFaithSkill = RankEntity.E,
                baseAuthoritySkill = RankEntity.D,
                baseArmorSkill = RankEntity.E,
                baseRidingSkill = RankEntity.E,
                baseFlyingSkill = RankEntity.E,
                majorCrest = "Flames",
                minorCrest = ""
            )
        )
    }
}