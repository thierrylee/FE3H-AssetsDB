package me.thierrylee.fe3hdb.core.db

import com.squareup.sqldelight.sqlite.driver.JdbcSqliteDriver

class Db{

    fun test(){
        val driver = JdbcSqliteDriver(JdbcSqliteDriver.IN_MEMORY)
    }

}