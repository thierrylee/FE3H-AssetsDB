package me.thierrylee.fe3hdb.core.utils

internal fun String.toId() = replace(Regex("[^A-Za-z0-9]"), "")