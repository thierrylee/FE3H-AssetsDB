package me.thierrylee.fe3hdb.assets

import java.io.BufferedReader
import java.io.InputStreamReader

class RawAssetFileExtractor {

    companion object {
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

