package me.thierrylee.fe3hdb.assets

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class RawAssetFileExtractorTest {

    private val assetFileExtractor = RawAssetFileExtractor()

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
        val result = assetFileExtractor.extractRawValues("characters.tsv")

        // Then
        assertThat(result).isNotEmpty
    }
}