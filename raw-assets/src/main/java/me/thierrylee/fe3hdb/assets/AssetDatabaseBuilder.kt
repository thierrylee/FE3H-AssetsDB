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
        lostItems = LostItemAssetTransformer.retrieveAssets(),
        gifts = listOf(
            *GiftAssetTransformer.Liked.retrieveAssets().toTypedArray(),
            *GiftAssetTransformer.Disliked.retrieveAssets().toTypedArray()
        )
    )

}