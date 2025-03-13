package com.github.helosantosdesousa.hauntedpizzaria

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.gridlayout.widget.GridLayout
import com.github.helosantosdesousa.hauntedpizzaria.databinding.ActivityGameBinding

class GameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        println("chamou game activity")
    }

    /*private lateinit var binding: ActivityGameBinding // Declaração do binding

    // Defina o estado do jogo: 0 - Nenhuma ação, 1 - Encontrou a saída, 2 - Foi pego pelo monstro
    private var gameState = 0
    private val roomStates = IntArray(9) // 0 - Sala não visitada, 1 - Sala com saída, 2 - Sala com monstro

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializa o binding
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inicialize o estado das salas (exemplo)
        roomStates[0] = 1  // Sala 1 com saída
        roomStates[4] = 2  // Sala 5 com monstro

        // Configura as imagens para as salas e os ouvintes de clique
        setupGrid()
    }

    private fun setupGrid() {
        // Acesse o GridLayout corretamente com a referência do binding
        val grid: GridLayout = binding.grid_rooms

        for (i in 0 until grid.childCount) {
            val roomImage = grid.getChildAt(i) as ImageView
            // Adiciona ouvinte de clique para cada imagem de sala
            roomImage.setOnClickListener {
                handleRoomClick(i)
            }
        }
    }

    private fun handleRoomClick(roomIndex: Int) {
        // Verifica o estado da sala
        when (roomStates[roomIndex]) {
            0 -> {
                // Sala não visitada ainda
                Toast.makeText(this, "Você ainda não entrou nesta sala.", Toast.LENGTH_SHORT).show()
            }
            1 -> {
                // Encontrou a saída
                gameState = 1
                Toast.makeText(this, "Você encontrou a saída!", Toast.LENGTH_LONG).show()
                updateGameState()
            }
            2 -> {
                // Foi pego pelo monstro
                gameState = 2
                Toast.makeText(this, "Você foi pego pelo monstro!", Toast.LENGTH_LONG).show()
                updateGameState()
            }
        }
    }

    private fun updateGameState() {
        // Atualize a tela dependendo do estado do jogo
        when (gameState) {
            1 -> {
                binding.containerRooms.setBackgroundColor(resources.getColor(R.color.success)) // cor para vitória
            }
            2 -> {
                binding.containerRooms.setBackgroundColor(resources.getColor(R.color.warning)) // cor para derrota
            }
            else -> {
                binding.containerRooms.setBackgroundColor(resources.getColor(R.color.bg_main_color)) // cor padrão
            }
        }
    }*/
}
