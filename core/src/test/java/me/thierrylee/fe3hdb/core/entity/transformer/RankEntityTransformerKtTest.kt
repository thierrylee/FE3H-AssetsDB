package me.thierrylee.fe3hdb.core.entity.transformer

import junitparams.JUnitParamsRunner
import junitparams.Parameters
import me.thierrylee.fe3hdb.core.entity.RankEntity
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(JUnitParamsRunner::class)
internal class RankEntityTransformerKtTest {

    fun testCases() = arrayOf(
        "E" to RankEntity.E,
        "-" to RankEntity.E,
        "E+" to RankEntity.E_PLUS,
        "D" to RankEntity.D,
        "D+" to RankEntity.D_PLUS,
        "C" to RankEntity.C,
        "C+" to RankEntity.C_PLUS,
        "B" to RankEntity.B,
        "B+" to RankEntity.B_PLUS,
        "A" to RankEntity.A,
        "A+" to RankEntity.A_PLUS,
        "S" to RankEntity.S,
        "S+" to RankEntity.S_PLUS
    )

    @Test(expected = IllegalArgumentException::class)
    fun `toRankEntity - when unknown - should throw exception`() {
        // When
        "?".toRankEntity()

        // Then
        // Expect exception
    }

    @Test
    @Parameters(method = "testCases")
    fun `toRankEntity - should return expected entity`(
        valueToExpected: Pair<String, RankEntity>
    ) {
        // When
        val rankEntity = valueToExpected.first.toRankEntity()

        // Then
        assertThat(rankEntity).isEqualTo(valueToExpected.second)
    }

}