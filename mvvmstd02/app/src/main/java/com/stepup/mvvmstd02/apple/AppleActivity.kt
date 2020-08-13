package com.stepup.mvvmstd02.apple

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.stepup.mvvmstd02.AddActivity
import com.stepup.mvvmstd02.R
import com.stepup.mvvmstd02.contact.Contact
import com.stepup.mvvmstd02.contact.ContactAdapter
import com.stepup.mvvmstd02.contact.ContactViewModel
import kotlinx.android.synthetic.main.activity_contact.*


class AppleActivity : AppCompatActivity() {

    private lateinit var contactViewModel: ContactViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apple)

    }




}


