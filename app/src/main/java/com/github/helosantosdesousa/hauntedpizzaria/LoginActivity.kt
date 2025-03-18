package com.github.helosantosdesousa.hauntedpizzaria

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnCancel = findViewById<Button>(R.id.bt_cancel)
        btnCancel.setOnClickListener {
            finish()
        }

        val btnLogin = findViewById<Button>(R.id.bt_login)
        btnLogin.setOnClickListener {
            val intent = Intent(this, TutorialActivity::class.java)
            startActivity(intent)
        }

        val btnSignup = findViewById<Button>(R.id.bt_acLogin_signup)
        btnSignup.setOnClickListener{
            val intent = Intent(this, CreateAccountActivity::class.java)
            startActivity(intent)
        }


    }
}