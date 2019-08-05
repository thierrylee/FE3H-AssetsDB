package me.thierrylee.fe3hdb.core.assets

import me.thierrylee.fe3hdb.core.assets.AssetFileExtractor
import me.thierrylee.fe3hdb.core.assets.AssetFileExtractor.Companion.CHARACTERS_FILE
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class AssetFileExtractorTest {

    private val assetFileExtractor = AssetFileExtractor()

    @Test
    fun `extractRawValues - when unknown file - should return empty list`() {
        // When
        val result = assetFileExtractor.extractRawValues("toto")

        // Then
        assertThat(result).isEmpty()
    }

    @Test
    fun `extractRawValues - when characters - should return not empty list`() {
        // When
        val result = assetFileExtractor.extractRawValues(CHARACTERS_FILE)

        // Then
        assertThat(result).isNotEmpty
    }
}