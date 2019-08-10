package me.thierrylee.fe3hdb.assets

import me.thierrylee.fe3hdb.assets.model.transformer.*

class AssetDatabaseBuilder {

    fun buildAssetDatabase() = AssetDatabase(
        characterAssets = CharacterAssetTransformer.retrieveAssets(),
        crestAssets = CrestAssetTransformer.retrieveAssets(),
        classAssets = ClassAssetTransformer.retrieveAssets(),
        abilityAssets = AbilityAssetTransformer.retrieveAssets(),
        combatArtAssets = CombatArtAssetTransformer.retrieveAssets(),
        magicAssets = MagicAssetTransformer.retrieveAssets(),
        combatArtRequirementAssets = listOf(
            *CombatArtRequirementAssetTransformer.UniversalLearn.retrieveAssets().toTypedArray(),
            *CombatArtRequirementAssetTransformer.ClassMastered.retrieveAssets().toTypedArray(),
            *CombatArtRequirementAssetTransformer.PersonalLearn.retrieveAssets().toTypedArray()
        )
    )

}