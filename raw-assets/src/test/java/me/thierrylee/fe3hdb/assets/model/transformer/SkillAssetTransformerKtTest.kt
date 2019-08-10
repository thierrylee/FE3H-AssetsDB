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
        SkillValue.SWORD to SkillAsset.SWORD,
        SkillValue.LANCE to SkillAsset.LANCE,
        SkillValue.AXE to SkillAsset.AXE,
        SkillValue.BOW to SkillAsset.BOW,
        SkillValue.BRAWLING to SkillAsset.BRAWLING,
        SkillValue.REASON to SkillAsset.REASON,
        SkillValue.FAITH to SkillAsset.FAITH,
        SkillValue.AUTHORITY to SkillAsset.AUTHORITY,
        SkillValue.ARMOR to SkillAsset.ARMOR,
        SkillValue.RIDING to SkillAsset.RIDING,
        SkillValue.FLYING to SkillAsset.FLYING,
        SkillValue.NONE to SkillAsset.NONE
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