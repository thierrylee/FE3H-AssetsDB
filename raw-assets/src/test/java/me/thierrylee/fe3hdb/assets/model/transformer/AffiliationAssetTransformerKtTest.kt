package me.thierrylee.fe3hdb.assets.model.transformer

import junitparams.JUnitParamsRunner
import junitparams.Parameters
import me.thierrylee.fe3hdb.assets.model.AffiliationAsset
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(JUnitParamsRunner::class)
class AffiliationAssetTransformerKtTest {

    fun testCases() = arrayOf(
        AffiliationValue.NONE to AffiliationAsset.NONE,
        AffiliationValue.BLACK_EAGLES to AffiliationAsset.BLACK_EAGLES,
        AffiliationValue.BLUE_LIONS to AffiliationAsset.BLUE_LIONS,
        AffiliationValue.GOLDEN_DEERS to AffiliationAsset.GOLDEN_DEERS,
        AffiliationValue.CHURCH_OF_SEIROS to AffiliationAsset.CHURCH_OF_SEIROS
    )

    @Test(expected = IllegalArgumentException::class)
    fun `toAffiliationAsset - when unknown - should throw exception`() {
        // When
        "?".toAffiliationAsset()

        // Then
        // Expect exception
    }

    @Test
    @Parameters(method = "testCases")
    fun `toAffiliationAsset - should return expected entity`(
        valueToExpected: Pair<String, AffiliationAsset>
    ) {
        // When
        val affiliationAsset = valueToExpected.first.toAffiliationAsset()

        // Then
        assertThat(affiliationAsset).isEqualTo(valueToExpected.second)
    }

}