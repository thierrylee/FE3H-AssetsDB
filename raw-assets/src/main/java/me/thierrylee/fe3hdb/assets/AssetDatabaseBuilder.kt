package me.thierrylee.fe3hdb.assets

import me.thierrylee.fe3hdb.assets.model.transformer.*

object AssetDatabaseBuilder {

    fun buildAssetDatabase() = AssetDatabase(
        characters = CharacterAssetTransformer.retrieveAssets(),
        crests = CrestAssetTransformer.retrieveAssets(),
        classes = ClassAssetTransformer.retrieveAssets(),
        abilities = AbilityAssetTransformer.retrieveAssets(),
        combatArts = CombatArtAssetTransformer.retrieveAssets(),
        magics = MagicAssetTransformer.retrieveAssets(),
        combatArtRequirements = listOf(
            *CombatArtRequirementAssetTransformer.UniversalLearn.retrieveAssets().toTypedArray(),
            *CombatArtRequirementAssetTransformer.PersonalLearn.retrieveAssets().toTypedArray(),
            *CombatArtRequirementAssetTransformer.BuddingTalent.retrieveAssets().toTypedArray(),
            *CombatArtRequirementAssetTransformer.ClassMastered.retrieveAssets().toTypedArray()
        ),
        abilityRequirements = listOf(
            *AbilityRequirementAssetTransformer.UniversalLearn.retrieveAssets().toTypedArray(),
            *AbilityRequirementAssetTransformer.Personal.retrieveAssets().toTypedArray(),
            *AbilityRequirementAssetTransformer.PersonalLearn.retrieveAssets().toTypedArray(),
            *AbilityRequirementAssetTransformer.BuddingTalent.retrieveAssets().toTypedArray(),
            *AbilityRequirementAssetTransformer.ClassUse.retrieveAssets().toTypedArray(),
            *AbilityRequirementAssetTransformer.ClassMastered.retrieveAssets().toTypedArray()
        ),
        magicRequirements = MagicRequirementAssetTransformer.retrieveAssets(),
        items = listOf(
            *ItemAssetTransformer.Lost.retrieveAssets().toTypedArray(),
            *ItemAssetTransformer.LikedGift.retrieveAssets().toTypedArray(),
            *ItemAssetTransformer.DislikedGift.retrieveAssets().toTypedArray()
        ),
        supports = SupportAssetTransformer.retrieveAssets().filterNot {
            it.characterId1 == "Sothis" ||
            it.characterId2 == "Sothis" ||
            it.characterId1 == "Rhea" ||
            it.characterId2 == "Rhea"
        },
        favoriteTeas = FavoriteTeaAssetTransformer.retrieveAssets(),
        teaTopics = TeaTopicAssetTransformer.retrieveAssets(),
        teaFinalComments = TeaFinalCommentAssetTransformer.retrieveAssets()
    )

}