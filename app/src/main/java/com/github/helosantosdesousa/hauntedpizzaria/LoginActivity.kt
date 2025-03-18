package com.github.helosantosdesousa.hauntedpizzaria

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.github.helosantosdesousa.hauntedpizzaria.entity.Player

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val etName = findViewById<EditText>(R.id.etName)
        val etPassword = findViewById<EditText>(R.id.etPassword)

        val player = Player()

        val btnCancel = findViewById<Button>(R.id.bt_cancel)
        btnCancel.setOnClickListener {
            finish()
        }

        val btnLogin = findViewById<Button>(R.id.bt_login)
        btnLogin.setOnClickListener {
            val username = etName.text.toString()
            val passcode = etPassword.text.toString()

            player.username = username
            player.passcode = passcode

            val intent = Intent(this, GameActivity::class.java).apply {
                putExtra("USER_NAME", username)
                putExtra("USER_PASSWORD", passcode)
            }
            startActivity(intent)
        }

        val btnSignup = findViewById<Button>(R.id.bt_acLogin_signup)
        btnSignup.setOnClickListener {
            val intent = Intent(this, CreateAccountActivity::class.java)
            startActivity(intent)
        }
    }

}
