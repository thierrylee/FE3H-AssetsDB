package me.thierrylee.fe3hdb.assets.model.transformer

internal fun String.toId() = replace("+", "p").replace(Regex("[^A-Za-z0-9]"), "")