package me.thierrylee.fe3hdb.assets.model.transformer

import junitparams.JUnitParamsRunner
import junitparams.Parameters
import me.thierrylee.fe3hdb.assets.model.AffiliationAsset
import me.thierrylee.fe3hdb.assets.model.UnitTypeAsset
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(JUnitParamsRunner::class)
class UnitTypeAssetTransformerKtTest {

    fun testCases() = arrayOf(
        UnitTypeValue.ARMOR to UnitTypeAsset.ARMOR,
        UnitTypeValue.RIDING to UnitTypeAsset.RIDING,
        UnitTypeValue.FLYING to UnitTypeAsset.FLYING,
        UnitTypeValue.MAGIC to UnitTypeAsset.MAGIC
    )

    @Test(expected = IllegalArgumentException::class)
    fun `toUnitTypeAsset - when unknown - should throw exception`() {
        // When
        "?".toUnitTypeAsset()

        // Then
        // Expect exception
    }

    @Test
    @Parameters(method = "testCases")
    fun `toUnitTypeAsset - should return expected entity`(
        valueToExpected: Pair<String, UnitTypeAsset>
    ) {
        // When
        val unitTypeAsset = valueToExpected.first.toUnitTypeAsset()

        // Then
        assertThat(unitTypeAsset).isEqualTo(valueToExpected.second)
    }

}