package com.github.helosantosdesousa.hauntedpizzaria

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import android.util.Log
import android.widget.Toast

class RankingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ranking)

        val btnPlay = findViewById<Button>(R.id.bt_backToGame)
        btnPlay.setOnClickListener {
            Log.d("RankingActivity", "chamou bt") // Usa Log.d para depuração
            val intent = Intent(this, TutorialActivity::class.java)
            startActivity(intent)
            finish() // Finaliza a Activity atual para não voltar para ela depois
        }
        btnPlay.setOnClickListener {
            Toast.makeText(this, "Botão clicado", Toast.LENGTH_SHORT).show()
        }


    }
}
