package me.thierrylee.fe3hdb.assets.model.transformer

import me.thierrylee.fe3hdb.assets.RawAssetFileExtractor
import me.thierrylee.fe3hdb.assets.model.SupportAsset

internal object SupportAssetTransformer {

    private const val ASSET_FILE = "max_supports"
    private const val ASSET_FILE_EXTENSION = ".tsv"

    fun retrieveAssets(): List<SupportAsset> {
        val rawValuesList =
            RawAssetFileExtractor().extractRawValues("$ASSET_FILE$ASSET_FILE_EXTENSION")

        return buildAssets(rawValuesList)
    }

    fun buildAssets(rawValues: List<List<String>>): List<SupportAsset> {
        val secondCharacterSupportIdIndexMap = rawValues
            .first()
            .mapIndexed { index, characterId -> (index - 1 to characterId.toId()) }
            .toMap()

        return rawValues.subList(1, rawValues.size).flatMap { lineContent ->
            val characterId = lineContent.first().toId()
            lineContent.subList(1, lineContent.size).mapIndexed { index, rawSupportRank ->
                buildSupport(
                    characterId = characterId,
                    secondCharacterSupportIdIndexMap = secondCharacterSupportIdIndexMap,
                    index = index,
                    rawSupportRank = rawSupportRank
                )
            }.filterNotNull().flatten()
        }
    }

    private fun buildSupport(
        characterId: String,
        secondCharacterSupportIdIndexMap: Map<Int, String>,
        index: Int,
        rawSupportRank: String
    ) = if (rawSupportRank.isNotEmpty()) {
        val secondCharacterSupportId = secondCharacterSupportIdIndexMap[index]
            ?: throw IllegalStateException("Character index $index not found")
        val maxSupport = rawSupportRank.toRankAsset()
        listOf(
            SupportAsset(
                characterId1 = characterId,
                characterId2 = secondCharacterSupportId,
                maxSupport = maxSupport
            ),
            SupportAsset(
                characterId1 = secondCharacterSupportId,
                characterId2 = characterId,
                maxSupport = maxSupport
            )
        )
    } else null


}