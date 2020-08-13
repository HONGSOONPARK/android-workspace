package com.stepup.mvvmstd02.contact

import android.app.Application
import androidx.lifecycle.LiveData

/**
 * 클래스 설명
 *
 * @author 최초작성자: 순홍박맨
 * @date 최초작성일: 2020-08-13 오후 1:43
 *
 */

class ContactRepository (application: Application){
    private val contactDatabase = ContactDatabase.getInstance(application)!!
    private val contactDao: ContactDao = contactDatabase.contactDao()
    private val contacts: LiveData<List<Contact>> = contactDao.getAll()

    fun getAll(): LiveData<List<Contact>> {
        return contacts
    }

    fun insert(contact: Contact) {
        try {
            val thread = Thread(Runnable {
                contactDao.insert(contact) })
            thread.start()
        } catch (e: Exception) { }
    }

    fun delete(contact: Contact) {
        try {
            val thread = Thread(Runnable {
                contactDao.delete(contact)
            })
            thread.start()
        } catch (e: Exception) { }
    }

}