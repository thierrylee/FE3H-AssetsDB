package me.thierrylee.fe3hdb.assets

import me.thierrylee.fe3hdb.assets.model.transformer.AbilityAssetTransformer
import me.thierrylee.fe3hdb.assets.model.transformer.CharacterAssetTransformer
import me.thierrylee.fe3hdb.assets.model.transformer.ClassAssetTransformer
import me.thierrylee.fe3hdb.assets.model.transformer.CrestAssetTransformer

class AssetDatabaseBuilder {

    fun buildAssetDatabase() = AssetDatabase(
        characterAssets = CharacterAssetTransformer.retrieveAssets(),
        crestAssets = CrestAssetTransformer.retrieveAssets(),
        classAssets = ClassAssetTransformer.retrieveAssets(),
        abilityAssets = AbilityAssetTransformer.retrieveAssets()
    )

}