package com.github.helosantosdesousa.hauntedpizzaria

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        val btnCancel = findViewById<Button>(R.id.bt_cancel)
        btnCancel.setOnClickListener {
            finish()
        }

        val btnSignup = findViewById<Button>(R.id.bt_signup)
        btnSignup.setOnClickListener {
            val intent = Intent(this, TutorialActivity::class.java)
            startActivity(intent)
        }


    }
}