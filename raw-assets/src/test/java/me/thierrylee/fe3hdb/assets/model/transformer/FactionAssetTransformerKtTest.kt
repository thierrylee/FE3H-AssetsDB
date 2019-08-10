package me.thierrylee.fe3hdb.assets.model.transformer

import junitparams.JUnitParamsRunner
import junitparams.Parameters
import me.thierrylee.fe3hdb.assets.model.FactionAsset
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(JUnitParamsRunner::class)
class FactionAssetTransformerKtTest {

    fun testCases() = arrayOf(
        FactionValue.NONE to FactionAsset.NONE,
        FactionValue.BLACK_EAGLES to FactionAsset.BLACK_EAGLES,
        FactionValue.BLUE_LIONS to FactionAsset.BLUE_LIONS,
        FactionValue.GOLDEN_DEERS to FactionAsset.GOLDEN_DEERS,
        FactionValue.CHURCH_OF_SEIROS to FactionAsset.CHURCH_OF_SEIROS
    )

    @Test(expected = IllegalArgumentException::class)
    fun `toFactionAsset - when unknown - should throw exception`() {
        // When
        "?".toRankAsset()

        // Then
        // Expect exception
    }

    @Test
    @Parameters(method = "testCases")
    fun `toFactionAsset - should return expected entity`(
        valueToExpected: Pair<String, FactionAsset>
    ) {
        // When
        val factionAsset = valueToExpected.first.toFactionAsset()

        // Then
        assertThat(factionAsset).isEqualTo(valueToExpected.second)
    }

}