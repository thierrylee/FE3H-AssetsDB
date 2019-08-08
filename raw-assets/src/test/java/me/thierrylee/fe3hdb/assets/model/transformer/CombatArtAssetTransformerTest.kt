package me.thierrylee.fe3hdb.assets.model.transformer

import me.thierrylee.fe3hdb.assets.RawAssetFileExtractor
import me.thierrylee.fe3hdb.assets.model.CombatArtAsset
import me.thierrylee.fe3hdb.assets.model.SkillAsset
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CombatArtAssetTransformerTest {

    @Test
    fun `buildAsset - should return expected combat art`() {
        // Given
        val rawValues = RawAssetFileExtractor().extractRawValues("dummy_combatarts.tsv")[1]

        // When
        val combatArtAsset = CombatArtAssetTransformer.buildAsset(rawValues)

        // Then
        assertThat(combatArtAsset).isEqualTo(
            CombatArtAsset(
                id = "RupturedHeaven",
                name = "Ruptured Heaven",
                useSkill = SkillAsset.SWORD,
                might = 7,
                hit = 10,
                crit = 10,
                range = "1~2",
                cost = 3,
                description = "Sword of the Creator only; Might increases based on user’s Magic, effective against Dragon foes."
            )
        )
    }
}