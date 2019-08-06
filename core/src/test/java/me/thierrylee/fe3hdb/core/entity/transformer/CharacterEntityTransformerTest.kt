package me.thierrylee.fe3hdb.core.entity.transformer

import me.thierrylee.fe3hdb.core.assets.AssetFileExtractor
import me.thierrylee.fe3hdb.core.entity.CharacterEntity
import me.thierrylee.fe3hdb.core.entity.GenderEntity
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
        val characterRawValue = AssetFileExtractor().extractRawValues("dummy_characters.tsv")[1]

        // When
        val characterEntity = CharacterEntityTransformer.toCharacterEntity(characterRawValue)

        // Then
        assertThat(characterEntity).isEqualTo(
            CharacterEntity(
                id = "BylethM",
                name = "~BylethM _!-!°",
                faction = "",
                gender = GenderEntity.MALE,
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
                baseSwordSkill = RankEntity.S_PLUS,
                baseLanceSkill = RankEntity.S,
                baseAxeSkill = RankEntity.A_PLUS,
                baseBowSkill = RankEntity.A,
                baseBrawlingSkill = RankEntity.B_PLUS,
                baseReasonSkill = RankEntity.B,
                baseFaithSkill = RankEntity.C_PLUS,
                baseAuthoritySkill = RankEntity.C,
                baseArmorSkill = RankEntity.D_PLUS,
                baseRidingSkill = RankEntity.D,
                baseFlyingSkill = RankEntity.E,
                majorCrest = "Flames",
                minorCrest = ""
            )
        )
    }
}