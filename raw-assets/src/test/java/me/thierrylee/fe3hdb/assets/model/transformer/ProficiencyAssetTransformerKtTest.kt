package me.thierrylee.fe3hdb.assets.model.transformer

import junitparams.JUnitParamsRunner
import junitparams.Parameters
import me.thierrylee.fe3hdb.assets.model.ProficiencyAsset
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(JUnitParamsRunner::class)
class ProficiencyAssetTransformerKtTest {

    fun testCases() = arrayOf(
        "U" to ProficiencyAsset.STRONG,
        "-" to ProficiencyAsset.NEUTRAL,
        "D" to ProficiencyAsset.WEAK
    )

    @Test(expected = IllegalArgumentException::class)
    fun `toProficiencyAsset - when unknown - should throw exception`() {
        // When
        "?".toProficiencyAsset()

        // Then
        // Expect exception
    }

    @Test
    @Parameters(method = "testCases")
    fun `toProficiencyAsset - should return expected entity`(
        valueToExpected: Pair<String, ProficiencyAsset>
    ) {
        // When
        val proficiencyEntity = valueToExpected.first.toProficiencyAsset()

        // Then
        assertThat(proficiencyEntity).isEqualTo(valueToExpected.second)
    }

}