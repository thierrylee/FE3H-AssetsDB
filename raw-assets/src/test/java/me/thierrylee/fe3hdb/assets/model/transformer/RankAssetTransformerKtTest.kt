package me.thierrylee.fe3hdb.assets.model.transformer

import junitparams.JUnitParamsRunner
import junitparams.Parameters
import me.thierrylee.fe3hdb.assets.model.RankAsset
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(JUnitParamsRunner::class)
class RankAssetTransformerKtTest {

    fun testCases() = arrayOf(
        "E" to RankAsset.E,
        "-" to RankAsset.E,
        "E+" to RankAsset.E_PLUS,
        "D" to RankAsset.D,
        "D+" to RankAsset.D_PLUS,
        "C" to RankAsset.C,
        "C+" to RankAsset.C_PLUS,
        "B" to RankAsset.B,
        "B+" to RankAsset.B_PLUS,
        "A" to RankAsset.A,
        "A+" to RankAsset.A_PLUS,
        "S" to RankAsset.S,
        "S+" to RankAsset.S_PLUS
    )

    @Test(expected = IllegalArgumentException::class)
    fun `toRankAsset - when unknown - should throw exception`() {
        // When
        "?".toRankAsset()

        // Then
        // Expect exception
    }

    @Test
    @Parameters(method = "testCases")
    fun `toRankAsset - should return expected entity`(
        valueToExpected: Pair<String, RankAsset>
    ) {
        // When
        val rankEntity = valueToExpected.first.toRankAsset()

        // Then
        assertThat(rankEntity).isEqualTo(valueToExpected.second)
    }

}