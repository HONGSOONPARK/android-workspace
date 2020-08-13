package com.stepup.mvvmstd02.contact

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

/**
 * 클래스 설명
 *
 * @author 최초작성자:
 * @date 최초작성일: 2020-08-13 오후 1:58
 *
 */
class ContactViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = ContactRepository(application)
    private val contacts = repository.getAll()

    fun getAll(): LiveData<List<Contact>> {
        return this.contacts
    }

    fun insert(contact: Contact) {
        repository.insert(contact)
    }

    fun delete(contact: Contact) {
        repository.delete(contact)
    }
}
