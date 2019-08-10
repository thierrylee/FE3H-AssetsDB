package me.thierrylee.fe3hdb.assets.model.transformer

import me.thierrylee.fe3hdb.assets.RawAssetFileExtractor

internal abstract class AbstractAssetTransformer<E> {

    companion object {
        private const val DELIMITER = ","
        private const val FILE_EXTENSION = ".tsv"
    }

    abstract fun getAssetFile(): String
    abstract fun getColumnCount(): Int
    protected abstract fun internalBuildAsset(rawValues: List<String>): E

    fun retrieveAssets(): List<E> {
        val rawValuesList = RawAssetFileExtractor().extractRawValues("${getAssetFile()}$FILE_EXTENSION")
        return rawValuesList.subList(1, rawValuesList.size).map { buildAsset(it) }
    }

    fun buildAsset(rawValues: List<String>): E {
        if (rawValues.size != getColumnCount()) throw IllegalArgumentException("[${getAssetFile()}] rawValues should have ${getColumnCount()} columns (current ${rawValues.size})\nValues : ${rawValues.map { "\'$it\'" }}")
        return internalBuildAsset(rawValues)
    }

    fun String.toIntOrZero() = toIntOrNull() ?: 0

    fun String.split() = split(DELIMITER).map { it.trim() }.filter { isNotBlank() }
}