package me.thierrylee.fe3hdb.assets

import me.thierrylee.fe3hdb.assets.model.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class AssetDatabaseBuilderTest {

    @Test
    fun buildDatabase() {
        // When
        val database = AssetDatabaseBuilder.buildAssetDatabase()

        // Then
        assertThat(database.genderAssets).isEqualTo(GenderAsset.values().toList())
        assertThat(database.skillAssets).isEqualTo(SkillAsset.values().toList())
        assertThat(database.rankAssets).isEqualTo(RankAsset.values().toList())
        assertThat(database.characterAssets).hasSize(35)
        assertThat(database.crestAssets).hasSize(25)
        assertThat(database.classAssets).hasSize(47)
        assertThat(database.abilityAssets).hasSize(239)
        assertThat(database.combatArtAssets).hasSize(77)
        assertThat(database.magicAssets).hasSize(38)
        assertThat(database.combatArtRequirementAssets.filterIsInstance<CombatArtRequirementAsset.UniversalLearn>()).hasSize(11)
        assertThat(database.combatArtRequirementAssets.filterIsInstance<CombatArtRequirementAsset.PersonalLearn>()).hasSize(48)
        assertThat(database.combatArtRequirementAssets.filterIsInstance<CombatArtRequirementAsset.ClassMastered>()).hasSize(13)
        assertThat(database.abilityRequirementAssets.filterIsInstance<AbilityRequirementAsset.UniversalLearn>()).hasSize(70)
        assertThat(database.abilityRequirementAssets.filterIsInstance<AbilityRequirementAsset.Personal>()).hasSize(37)
        assertThat(database.abilityRequirementAssets.filterIsInstance<AbilityRequirementAsset.PersonalLearn>()).hasSize(30)
        assertThat(database.abilityRequirementAssets.filterIsInstance<AbilityRequirementAsset.ClassUse>()).hasSize(35)
        assertThat(database.abilityRequirementAssets.filterIsInstance<AbilityRequirementAsset.ClassMastered>()).hasSize(36)
        assertThat(database.magicRequirementAssets).hasSize(54)
    }

    @Test
    fun `buildDatabase - Byleth should have expected combatArts, abilities and magics`() {
        // Given
        val database = AssetDatabaseBuilder.buildAssetDatabase()
        val character = database.characterAssets.find { it.id == "BylethM" }!!

        // When
        val combatArts = database.getCharacterCombatArts(character)
        val abilities = database.getCharacterAbilities(character)
        val magics = database.getCharacterMagics(character)

        // Then
        assertThat(combatArts).isNotEmpty
        assertThat(abilities).isNotEmpty
        assertThat(magics).isNotEmpty
        assertThat(combatArts.map { it.key.id }).contains("Grounder") // Universal
        assertThat(combatArts.map { it.key.id }).contains("Windsweep") // PersonalLearn
//        assertThat(combatArts.map { it.key.id }).contains("Windsweep") // BuddingTalent TODO
        assertThat(abilities.map { it.key.id }).contains("SwordProwessLv1") // Universal
        assertThat(abilities.map { it.key.id }).contains("ProfessorsGuidance") // Personal
        assertThat(abilities.map { it.key.id }).contains("ModelLeader") // PersonalLearn
        assertThat(abilities.map { it.key.id }).contains("Fistfaire") // ClassUse (Male)
        assertThat(abilities.map { it.key.id }).contains("Lifetaker") // ClassMaster (Male)
//        assertThat(abilities.map { it.key.id }).contains("Lifetaker") // BuddingTalent TODO
        assertThat(magics.map { it.key.id }).contains("Thunder")
    }

}