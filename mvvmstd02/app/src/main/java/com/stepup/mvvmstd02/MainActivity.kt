package com.stepup.mvvmstd02

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.stepup.mvvmstd02.apple.AppleActivity
import com.stepup.mvvmstd02.contact.ContactActivity
import com.stepup.mvvmstd02.contact.ContactViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var contactViewModel: ContactViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)



            contact_button.setOnClickListener {
                val intent = Intent(this, ContactActivity::class.java)
                startActivity(intent)
            }

            apple_button.setOnClickListener {
                val intent = Intent(this, AppleActivity::class.java)
                startActivity(intent)
            }



    }




}


