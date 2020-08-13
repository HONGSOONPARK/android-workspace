package com.stepup.mvvmstd02.contact

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.stepup.mvvmstd02.AddActivity
import com.stepup.mvvmstd02.R
import kotlinx.android.synthetic.main.activity_contact.*


class ContactActivity : AppCompatActivity() {

    private lateinit var contactViewModel: ContactViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

        // Set contactItemClick & contactItemLongClick lambda
        val adapter = ContactAdapter({ contact ->
            // put extras of contact info & start AddActivity
        }, { contact ->
            deleteDialog(contact)
        })

        val lm = LinearLayoutManager(this)
        main_recycleview.adapter = adapter
        main_recycleview.layoutManager = lm
        main_recycleview.setHasFixedSize(true)

        contactViewModel = ViewModelProviders.of(this).get(ContactViewModel::class.java)
        contactViewModel.getAll().observe(this, Observer<List<Contact>> { contacts ->
            // Update UI
            adapter.setContacts(contacts!!)
        })


        main_button.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            startActivity(intent)
        }
    }


    private fun deleteDialog(contact: Contact) {
        val builder = AlertDialog.Builder(this)
        builder.setMessage("Delete selected contact?")
            .setNegativeButton("NO") { _, _ -> }
            .setPositiveButton("YES") { _, _ ->
                contactViewModel.delete(contact)
            }
        builder.show()
    }

}


