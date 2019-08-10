package me.thierrylee.fe3hdb.assets

import me.thierrylee.fe3hdb.assets.model.transformer.*

object AssetDatabaseBuilder {

    fun buildAssetDatabase() = AssetDatabase(
        characterAssets = CharacterAssetTransformer.retrieveAssets(),
        crestAssets = CrestAssetTransformer.retrieveAssets(),
        classAssets = ClassAssetTransformer.retrieveAssets(),
        abilityAssets = AbilityAssetTransformer.retrieveAssets(),
        combatArtAssets = CombatArtAssetTransformer.retrieveAssets(),
        magicAssets = MagicAssetTransformer.retrieveAssets(),
        combatArtRequirementAssets = listOf(
            *CombatArtRequirementAssetTransformer.UniversalLearn.retrieveAssets().toTypedArray(),
            *CombatArtRequirementAssetTransformer.PersonalLearn.retrieveAssets().toTypedArray(),
            *CombatArtRequirementAssetTransformer.ClassMastered.retrieveAssets().toTypedArray()
        ),
        abilityRequirementAssets = listOf(
            *AbilityRequirementAssetTransformer.UniversalLearn.retrieveAssets().toTypedArray(),
            *AbilityRequirementAssetTransformer.Personal.retrieveAssets().toTypedArray(),
            *AbilityRequirementAssetTransformer.PersonalLearn.retrieveAssets().toTypedArray(),
            *AbilityRequirementAssetTransformer.ClassUse.retrieveAssets().toTypedArray(),
            *AbilityRequirementAssetTransformer.ClassMastered.retrieveAssets().toTypedArray()
        ),
        magicRequirementAssets = MagicRequirementAssetTransformer.retrieveAssets()
    )

}