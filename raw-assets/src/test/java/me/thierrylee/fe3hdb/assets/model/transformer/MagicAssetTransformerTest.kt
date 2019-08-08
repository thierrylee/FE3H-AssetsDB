package me.thierrylee.fe3hdb.assets.model.transformer

import me.thierrylee.fe3hdb.assets.RawAssetFileExtractor
import me.thierrylee.fe3hdb.assets.model.MagicAsset
import me.thierrylee.fe3hdb.assets.model.RankAsset
import me.thierrylee.fe3hdb.assets.model.SkillAsset
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class MagicAssetTransformerTest {

    @Test
    fun `buildAsset - should return expected combat art`() {
        // Given
        val rawValues = RawAssetFileExtractor().extractRawValues("dummy_magics.tsv")[1]

        // When
        val magicAsset = MagicAssetTransformer.buildAsset(rawValues)

        // Then
        assertThat(magicAsset).isEqualTo(
            MagicAsset(
                id = "Luna",
                name = "Luna Λ",
                useSkill = SkillAsset.REASON,
                type = "Dark Magic",
                might = 1,
                hit = 65,
                crit = 0,
                range = "1~2",
                weight = 7,
                level = RankAsset.C,
                use = 2,
                description = "Ignores enemy’s Resistance; cannot trigger follow-up attacks."
            )
        )
    }

}