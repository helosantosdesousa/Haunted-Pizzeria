package com.github.helosantosdesousa.hauntedpizzaria

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CreateAccountActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        val btnCancel = findViewById<Button>(R.id.bt_cancel)
        btnCancel.setOnClickListener {
            finish()
        }

        val btnSignup = findViewById<Button>(R.id.bt_signup)
        btnSignup.setOnClickListener {
            val intent = Intent(this, TutorialActivity::class.java)
            startActivity(intent)
        }

        val btnLogin = findViewById<Button>(R.id.bt_createAc_login)
        btnLogin.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}