package me.thierrylee.fe3hdb.assets.model.transformer

import junitparams.JUnitParamsRunner
import junitparams.Parameters
import me.thierrylee.fe3hdb.assets.model.SkillAsset
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(JUnitParamsRunner::class)
class SkillAssetTransformerKtTest {

    fun testCases() = arrayOf(
        SkillAssetValue.SWORD to SkillAsset.SWORD,
        SkillAssetValue.LANCE to SkillAsset.LANCE,
        SkillAssetValue.AXE to SkillAsset.AXE,
        SkillAssetValue.BOW to SkillAsset.BOW,
        SkillAssetValue.BRAWLING to SkillAsset.BRAWLING,
        SkillAssetValue.REASON to SkillAsset.REASON,
        SkillAssetValue.FAITH to SkillAsset.FAITH,
        SkillAssetValue.AUTHORITY to SkillAsset.AUTHORITY,
        SkillAssetValue.ARMOR to SkillAsset.ARMOR,
        SkillAssetValue.RIDING to SkillAsset.RIDING,
        SkillAssetValue.FLYING to SkillAsset.FLYING
    )

    @Test(expected = IllegalArgumentException::class)
    fun `toSkillAsset - when unknown - should throw exception`() {
        // When
        "?".toRankAsset()

        // Then
        // Expect exception
    }

    @Test
    @Parameters(method = "testCases")
    fun `toSkillAsset - should return expected entity`(
        valueToExpected: Pair<String, SkillAsset>
    ) {
        // When
        val skillAsset = valueToExpected.first.toSkillAsset()

        // Then
        assertThat(skillAsset).isEqualTo(valueToExpected.second)
    }

}