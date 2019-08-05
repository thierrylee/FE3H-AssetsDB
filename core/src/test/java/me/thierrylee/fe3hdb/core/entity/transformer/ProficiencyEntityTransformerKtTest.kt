package me.thierrylee.fe3hdb.core.entity.transformer

import junitparams.JUnitParamsRunner
import junitparams.Parameters
import me.thierrylee.fe3hdb.core.entity.ProficiencyEntity
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(JUnitParamsRunner::class)
internal class ProficiencyEntityTransformerKtTest {

    fun testCases() = arrayOf(
        "U" to ProficiencyEntity.STRONG,
        "-" to ProficiencyEntity.NEUTRAL,
        "D" to ProficiencyEntity.WEAK
    )

    @Test(expected = IllegalArgumentException::class)
    fun `toProficiencyEntity - when unknown - should throw exception`() {
        // When
        val proficiencyEntity = "?".toProficiencyEntity()

        // Then
        // Expect exception
    }

    @Test
    @Parameters(method = "testCases")
    fun `toProficiencyEntity - should return expected entity`(
        valueToExpected: Pair<String, ProficiencyEntity>
    ) {
        // When
        val proficiencyEntity = valueToExpected.first.toProficiencyEntity()

        // Then
        assertThat(proficiencyEntity).isEqualTo(valueToExpected.second)
    }

}