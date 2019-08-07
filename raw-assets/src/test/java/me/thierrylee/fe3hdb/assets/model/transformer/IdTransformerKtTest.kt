package me.thierrylee.fe3hdb.assets.model.transformer

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class IdTransformerKtTest {

    @Test
    fun `toId - should remove spaces and special characters`() {
        // When
        val id = "Test 'Toto' -!_!-".toId()

        // Then
        assertThat(id).isEqualTo("TestToto")
    }

}

