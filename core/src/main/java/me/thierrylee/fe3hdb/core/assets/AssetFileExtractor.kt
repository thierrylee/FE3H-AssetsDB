package me.thierrylee.fe3hdb.core.assets

import java.io.BufferedReader
import java.io.InputStreamReader

internal class AssetFileExtractor {

    companion object {
        const val CHARACTERS_FILE = "characters.tsv"
        const val CRESTS_FILE = "crests.tsv"
    }

    fun extractRawValues(fileName: String): List<List<String>> {
        val rawValueFile = mutableListOf<List<String>>()

        javaClass.classLoader.getResourceAsStream(fileName)?.use { inputStream ->
            BufferedReader(InputStreamReader(inputStream)).use { reader ->
                reader.forEachLine { line ->
                    rawValueFile.add(line.split("\t"))
                }
            }
        }

        return rawValueFile
    }
}

