package me.thierrylee.fe3hdb.assets.model.transformer

fun String.toId() = replace(Regex("[^A-Za-z0-9]"), "")