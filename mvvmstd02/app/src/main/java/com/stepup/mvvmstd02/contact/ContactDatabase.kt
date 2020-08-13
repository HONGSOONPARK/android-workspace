package com.stepup.mvvmstd02.contact

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * 클래스 설명
 *
 * @author 최초작성자: 순홍박맨
 * @date 최초작성일: 2020-08-13 오후 1:43
 *
 */


@Database(entities = [Contact::class], version = 1)
abstract class ContactDatabase: RoomDatabase (){
    abstract fun contactDao(): ContactDao

    companion object {
        private var INSTANCE: ContactDatabase? = null

        fun getInstance(context: Context): ContactDatabase? {
            if (INSTANCE == null) {
                synchronized(ContactDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        ContactDatabase::class.java, "contact")
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE
        }
    }
}