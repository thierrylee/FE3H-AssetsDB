package me.thierrylee.fe3hdb.assets.model.transformer

import me.thierrylee.fe3hdb.assets.RawAssetFileExtractor

internal abstract class AbstractAssetTransformer<E> {

    companion object {
        private const val DELIMITER = ","
    }

    abstract fun getAssetFile(): String
    abstract fun getColumnCount(): Int
    protected abstract fun internalBuildAsset(rawValues: List<String>): E

    fun retrieveAssets(): List<E> {
        val rawValuesList = RawAssetFileExtractor().extractRawValues(getAssetFile())
        return rawValuesList.subList(1, rawValuesList.size).map { buildAsset(it) }
    }

    fun buildAsset(rawValues: List<String>): E {
        if (rawValues.size != getColumnCount()) throw IllegalArgumentException("rawValues should have ${getColumnCount()} columns")
        return internalBuildAsset(rawValues)
    }

    fun String.toIntOrZero() = if (this == "-") 0 else toInt()

    fun String.split() = split(DELIMITER).map { it.trim() }
}