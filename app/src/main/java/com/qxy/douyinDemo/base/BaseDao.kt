package com.qxy.douyinDemo.base

import android.util.Log
import androidx.room.*
import androidx.sqlite.db.SimpleSQLiteQuery
import androidx.sqlite.db.SupportSQLiteQuery
import java.lang.reflect.ParameterizedType

/**
 * A base Data Access Object(DAO) class for all in the project, implemented some basic
 * CRUD operation with Room
 * @param T Data class
 * @property tableName table name
 * @author louis-ui
 */
abstract class BaseDao<T> {
    val tableName: String
        get() {
            val clazz = (javaClass.superclass.genericSuperclass as ParameterizedType)
                .actualTypeArguments[0] as Class<*>
            val tableName = clazz.simpleName
            Log.d("ez", "getTableName: -->$tableName")
            return tableName
        }
    /**
     * Add one object into table. If it has a same id(primary key) in the database then
     * it will replace that data for particular id
     * @param obj the object want to be added
     * @return Object's id
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(obj: T): Long

    /**
     * Add more than one object into table. If it has a same id(primary key) in the
     * database then it will replace that data for particular id
     * @param obj objects want to add
     * @return Objects' id
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(vararg obj: T): LongArray?

    /**
     * 添加对象集合
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(personList: List<T>): List<Long>

    /**
     * Delete one object based on id(primary key)
     * @param obj the object want to be deleted
     */
    @Delete
    abstract fun delete(obj: T)

    /**
     * Update object based on id(primary key)
     * @param obj objects want to add
     */
    @Update
    abstract fun update(vararg obj: T): Int

    /**
     * Delete all object in table
     * @return Number of impact lines
     */
    fun deleteAll(): Int {
        val query = SimpleSQLiteQuery(
            "delete from $tableName"
        )
        return doDeleteAll(query)
    }

    /**
     * Fina all object in table
     * @return All object in table
     */
    fun findAll(): List<T>? {
        val query = SimpleSQLiteQuery(
            "select * from $tableName"
        )
        return doFindAll(query)
    }

    /**
     * Find object by id(primary key)
     * @return The object
     */
    fun find(id: Long): T? {
        val query = SimpleSQLiteQuery(
            "select * from $tableName where id = ?", arrayOf<Any>(id)
        )
        return doFind(query)
    }

    /**
     * Delete object by condition
     * @param params column name
     * @param value value in the column
     */
    fun deleteByParams(params: String, value: String): Int {
        val query = SimpleSQLiteQuery("delete from $tableName where $params='${value}'")
//        Log.d("Dao", "deleteByParams: ${"delete from $tableName where $params='${value}'"}")
        return doDeleteByParams(query)
    }

    /**
     * Paging query, support multiple fields, but must be passed in order(like 'key = value，
     * key = value', you can use StringBuilder to construct).
     * @param string Query condition
     * @param limit Limit condition in query
     * @param offset Offset condition in query
     * @return object list
     */
    fun doQueryByLimit(vararg string: String, limit: Int = 10, offset: Int = 0): List<T>? {
        val query =
            SimpleSQLiteQuery("SELECT * FROM $tableName WHERE ${string[0]} = '${string[1]}' limit $limit offset $offset")
        return doQueryByLimit(query)
    }

    /**
     * Descending paging query, support multiple fields, but must be passed in order(like 'key = value，
     * key = value', you can use StringBuilder to construct).
     * @param string Query condition
     * @param limit Limit condition in query
     * @param offset Offset condition in query
     * @return object list
     */
    fun doQueryByOrder(vararg string: String, limit: Int = 10, offset: Int = 10): List<T>? {
        val query =
            SimpleSQLiteQuery("SELECT * FROM $tableName ORDER BY ${string[0]} desc limit '${limit}' offset '${offset}'")
        return doQueryByLimit(query)
    }

    // Function below is RawQuery method, you have no need to override or implement it.

    @RawQuery
    protected abstract fun doFindAll(query: SupportSQLiteQuery): List<T>?

    @RawQuery
    protected abstract fun doFind(query: SupportSQLiteQuery): T

    @RawQuery
    protected abstract fun doDeleteAll(query: SupportSQLiteQuery): Int

    @RawQuery
    protected abstract fun doDeleteByParams(query: SupportSQLiteQuery): Int

    @RawQuery
    protected abstract fun doQueryByLimit(query: SupportSQLiteQuery): List<T>?

    @RawQuery
    protected abstract fun doQueryByOrder(query: SupportSQLiteQuery): List<T>?
}