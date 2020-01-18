package me.thierrylee.fe3hdb.assets.model.transformer

import me.thierrylee.fe3hdb.assets.RawAssetFileExtractor
import me.thierrylee.fe3hdb.assets.model.RankAsset
import me.thierrylee.fe3hdb.assets.model.SupportAsset
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class SupportAssetTransformerTest {

    @Test
    fun `buildAssets - should return expected supports and mirror them`() {
        // Given
        val rawValues = RawAssetFileExtractor().extractRawValues("dummy_max_supports.tsv")

        // When
        val supportAssets = SupportAssetTransformer.buildAssets(rawValues)

        // Then
        assertThat(supportAssets).isEqualTo(
            listOf(
                SupportAsset(
                    characterId1 = "BylethM",
                    characterId2 = "Anna",
                    maxSupport = RankAsset.S
                ),
                SupportAsset(
                    characterId1 = "Anna",
                    characterId2 = "BylethM",
                    maxSupport = RankAsset.S
                )
            )
        )
    }

}