package me.thierrylee.fe3hdb.assets

import me.thierrylee.fe3hdb.assets.model.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class AssetDatabaseBuilderTest {

    @Test
    fun buildDatabase() {
        // When
        val assetDatabase = AssetDatabaseBuilder.buildAssetDatabase()

        // Then
        assertThat(assetDatabase.genderAssets).isEqualTo(GenderAsset.values().toList())
        assertThat(assetDatabase.skillAssets).isEqualTo(SkillAsset.values().toList())
        assertThat(assetDatabase.rankAssets).isEqualTo(RankAsset.values().toList())
        assertThat(assetDatabase.characterAssets).hasSize(35)
        assertThat(assetDatabase.crestAssets).hasSize(25)
        assertThat(assetDatabase.classAssets).hasSize(47)
        assertThat(assetDatabase.abilityAssets).hasSize(239)
        assertThat(assetDatabase.combatArtAssets).hasSize(77)
        assertThat(assetDatabase.magicAssets).hasSize(38)
        assertThat(assetDatabase.combatArtRequirementAssets.filterIsInstance<CombatArtRequirementAsset.UniversalLearn>()).hasSize(11)
        assertThat(assetDatabase.combatArtRequirementAssets.filterIsInstance<CombatArtRequirementAsset.PersonalLearn>()).hasSize(48)
        assertThat(assetDatabase.combatArtRequirementAssets.filterIsInstance<CombatArtRequirementAsset.ClassMastered>()).hasSize(13)
        assertThat(assetDatabase.abilityRequirementAssets.filterIsInstance<AbilityRequirementAsset.UniversalLearn>()).hasSize(70)
        assertThat(assetDatabase.abilityRequirementAssets.filterIsInstance<AbilityRequirementAsset.Personal>()).hasSize(37)
        assertThat(assetDatabase.abilityRequirementAssets.filterIsInstance<AbilityRequirementAsset.PersonalLearn>()).hasSize(30)
        assertThat(assetDatabase.abilityRequirementAssets.filterIsInstance<AbilityRequirementAsset.ClassUse>()).hasSize(35)
        assertThat(assetDatabase.abilityRequirementAssets.filterIsInstance<AbilityRequirementAsset.ClassMastered>()).hasSize(36)
    }

}