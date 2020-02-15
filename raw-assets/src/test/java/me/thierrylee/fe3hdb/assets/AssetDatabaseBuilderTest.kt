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
        with(database) {
            assertThat(genders).isEqualTo(GenderAsset.values().toList())
            assertThat(skills).isEqualTo(SkillAsset.values().toList())
            assertThat(ranks).isEqualTo(RankAsset.values().toList())
            assertThat(characters).hasSize(37)
            assertThat(crests).hasSize(25)
            assertThat(classes).hasSize(53)
            assertThat(abilities).hasSize(252)
            assertThat(combatArts).hasSize(79)
            assertThat(magics).hasSize(38)
            assertThat(combatArtRequirements.filterIsInstance<CombatArtRequirementAsset.UniversalLearn>()).hasSize(11)
            assertThat(combatArtRequirements.filterIsInstance<CombatArtRequirementAsset.PersonalLearn>()).hasSize(49)
            assertThat(combatArtRequirements.filterIsInstance<CombatArtRequirementAsset.ClassMastered>()).hasSize(17)
            assertThat(combatArtRequirements.filterIsInstance<CombatArtRequirementAsset.BuddingTalent>()).hasSize(5)
            assertThat(abilityRequirements.filterIsInstance<AbilityRequirementAsset.UniversalLearn>()).hasSize(70)
            assertThat(abilityRequirements.filterIsInstance<AbilityRequirementAsset.Personal>()).hasSize(38)
            assertThat(abilityRequirements.filterIsInstance<AbilityRequirementAsset.PersonalLearn>()).hasSize(32)
            assertThat(abilityRequirements.filterIsInstance<AbilityRequirementAsset.ClassUse>()).hasSize(38)
            assertThat(abilityRequirements.filterIsInstance<AbilityRequirementAsset.ClassMastered>()).hasSize(44)
            assertThat(abilityRequirements.filterIsInstance<AbilityRequirementAsset.BuddingTalent>()).hasSize(10)
            assertThat(magicRequirements).hasSize(55)
            assertThat(items).hasSize(106+145+88) // Lost + Liked + Disliked
            assertThat(supports).hasSize(546) // For now, remove Sothis & Rhea supports
            assertThat(favoriteTeas).hasSize(83)
            assertThat(teaTopics).hasSize(1346)
            assertThat(teaFinalComments).hasSize(315)
        }
    }

    @Test
    fun `buildDatabase - should have expected combatArts and remove unrelated requirements`() {
        // Given
        val database = AssetDatabaseBuilder.buildAssetDatabase()
        val character = database.characters.find { it.id == "Hubert" }!!

        // When
        val combatArts = database.getCharacterCombatArts(character)

        // Then
        assertThat(combatArts).isNotEmpty
        assertThat(combatArts.map { it.key.id }).contains("Grounder") // Universal
        assertThat(combatArts.map { it.key.id }).contains("FrozenLance") // BuddingTalent
        assertThat(combatArts.map { it.key.id }).contains("SchismShot") // PersonalLearn

        val requirements = combatArts.getValue(combatArts.keys.first { it.id == "SchismShot" })
        assertThat(requirements).hasSize(1)
        val personalLearn = requirements[0] as CombatArtRequirementAsset.PersonalLearn
        assertThat(personalLearn.rankRequired).isEqualTo(RankAsset.A)
        // Some characters can have SchismShot at C+ rank
    }

    @Test
    fun `buildDatabase - should have expected abilities and remove unrelated requirements`() {
        // Given
        val database = AssetDatabaseBuilder.buildAssetDatabase()
        val character = database.characters.find { it.id == "Ignatz" }!!

        // When
        val abilities = database.getCharacterAbilities(character)

        // Then
        assertThat(abilities).isNotEmpty
        assertThat(abilities.map { it.key.id }).contains("SwordProwessLv1") // Universal
        assertThat(abilities.map { it.key.id }).contains("WatchfulEye") // Personal
        assertThat(abilities.map { it.key.id }).contains("Fistfaire") // ClassUse (Male)
        assertThat(abilities.map { it.key.id }).contains("Lifetaker") // ClassMaster (Male)
        assertThat(abilities.map { it.key.id }).contains("SealStrength") // BuddingTalent
        assertThat(abilities.map { it.key.id }).contains("RallySpeed") // PersonalLearn

        val requirements = abilities.getValue(abilities.keys.first { it.id == "RallySpeed" })
        assertThat(requirements).hasSize(1)
        val personalLearn = requirements[0] as AbilityRequirementAsset.PersonalLearn
        assertThat(personalLearn.rankRequired).isEqualTo(RankAsset.D)
        // Some characters can have RallySpeed at C+ rank
    }

    @Test
    fun `buildDatabase - should have expected magics and remove unrelated requirements`() {
        // Given
        val database = AssetDatabaseBuilder.buildAssetDatabase()
        val character = database.characters.find { it.id == "Dimitri" }!!

        // When
        val magics = database.getCharacterMagics(character)

        // Then
        assertThat(magics).isNotEmpty
        assertThat(magics.map { it.key.id }).contains("Thunder")

        val requirements = magics.getValue(magics.keys.first { it.id == "Thunder" })
        assertThat(requirements).hasSize(1)
        assertThat(requirements[0].requiredRank).isEqualTo(RankAsset.D)
        // Some characters can have Thunder at D+ rank
    }

    @Test
    fun `buildDatabase - should have expected dark magics and remove unrelated requirements`() {
        // Given
        val database = AssetDatabaseBuilder.buildAssetDatabase()
        val character = database.characters.find { it.id == "Lysithea" }!!

        // When
        val magics = database.getCharacterMagics(character)

        // Then
        assertThat(magics).isNotEmpty
        assertThat(magics.map { it.key.id }).contains("Luna")

        val requirements = magics.getValue(magics.keys.first { it.id == "Luna" })
        assertThat(requirements).hasSize(1)
        assertThat(requirements[0].requiredRank).isEqualTo(RankAsset.C)
        // Some characters can have Luna at B rank
    }

}