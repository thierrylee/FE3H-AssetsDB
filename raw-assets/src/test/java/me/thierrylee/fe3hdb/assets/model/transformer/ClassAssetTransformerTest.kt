package me.thierrylee.fe3hdb.assets.model.transformer

import me.thierrylee.fe3hdb.assets.RawAssetFileExtractor
import me.thierrylee.fe3hdb.assets.model.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class ClassAssetTransformerTest {

    @Test
    fun `buildAsset - should return expected class`() {
        // Given
        val rawValues = RawAssetFileExtractor().extractRawValues("dummy_classes.tsv")[1]

        // When
        val classAsset = ClassAssetTransformer.buildAsset(rawValues)

        // Then
        assertThat(classAsset).isEqualTo(
            ClassAsset(
                id = "Lord",
                name = "Lord",
                requiredLevel = 10,
                requiredSkillRanks = listOf(
                    SkillAsset.SWORD to RankAsset.D_PLUS,
                    SkillAsset.AUTHORITY to RankAsset.C
                ),
                isOneRequirementOnly = false,
                availableGenders = listOf(GenderAsset.MALE, GenderAsset.FEMALE),
                characterExclusive = listOf("Edelgard", "Dimitri", "Claude"),
                unitTypes = listOf(UnitTypeAsset.MAGIC),
                swordProficiency = 2,
                lanceProficiency = 1,
                axeProficiency = 0,
                bowProficiency = 0,
                brawlingProficiency = 0,
                reasonProficiency = 0,
                faithProficiency = 0,
                authorityProficiency = 2,
                armorProficiency = 0,
                ridingProficiency = 0,
                flyingProficiency = 0,
                growthHp = 20,
                growthStr = 0,
                growthMag = 0,
                growthDex = 10,
                growthSpd = 0,
                growthLck = 0,
                growthDef = 0,
                growthRes = 0,
                growthCha = 10,
                movement = 5,
                isDlc = false
            )
        )
    }
}