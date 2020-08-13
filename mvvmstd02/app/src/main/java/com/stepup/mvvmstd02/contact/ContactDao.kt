package com.stepup.mvvmstd02.contact

import androidx.lifecycle.LiveData
import androidx.room.*

/**
 * 클래스 설명
 *
 * @author 최초작성자:
 * @date 최초작성일: 2020-08-13 오후 1:34
 *
 */

@Dao
interface ContactDao {

    @Query("SELECT * FROM contact ORDER BY name ASC")
    fun getAll(): LiveData<List<Contact>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(contact: Contact)

    @Delete
    fun delete(contact: Contact)

}