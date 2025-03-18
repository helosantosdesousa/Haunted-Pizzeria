package com.github.helosantosdesousa.hauntedpizzaria

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.github.helosantosdesousa.hauntedpizzaria.databinding.ActivityGameBinding
import com.github.helosantosdesousa.hauntedpizzaria.databinding.GameOverBinding
import com.github.helosantosdesousa.hauntedpizzaria.databinding.VictoryBinding
import com.github.helosantosdesousa.hauntedpizzaria.entity.Monster
import com.github.helosantosdesousa.hauntedpizzaria.entity.Player
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import kotlin.random.Random

class GameActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGameBinding
    private lateinit var gameOverBinding: GameOverBinding
    private lateinit var victoryBinding: VictoryBinding

    private var inGameHour = 0
    private var inGameMinute = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGameBinding.inflate(layoutInflater)
        gameOverBinding = GameOverBinding.inflate(layoutInflater)
        victoryBinding = VictoryBinding.inflate(layoutInflater)

        setContentView(binding.root)
        val player = Player();
        val monster = Monster();

        val username = intent.getStringExtra("USER_NAME")
        val passcode = intent.getStringExtra("USER_PASSWORD")

        player.username = username
        player.passcode = passcode

        startGame(player, monster)

        val remainingMovesTextView = binding.tvRemainingmoves

        remainingMovesTextView.text = getString(R.string.remaining_moves, player.remainingMoves)

        updateDisplayedHour()

    }

    fun setExit(player: Player){
        val exit = Random.nextInt(9)+1;

        player.setExit(exit);
        println("exit: $exit")
    }

    fun setMonsterRoom(monster: Monster, player: Player){
        var room:Int
        do {
            room = Random.nextInt(9) + 1
        } while (room == player.exit)

        monster.setRoom(room)
        println("Monstro definido para a sala: $room")
    }

    fun selectRoom(player: Player, monster: Monster){
        for (i in 1..9) {
            val resID = resources.getIdentifier("img_room$i", "id", packageName)
            val img = binding.root.findViewById<ImageView>(resID)
            val room = i
            img.setOnClickListener { v: View? ->
                player.room = room
                println("Sala escolhida: $room")
                verifyRoom(player, monster)
                verifyMoves(player, monster)
            }
        }
    }

    fun showToast(player: Player, monster: Monster){
        if (player.room != player.exit && monster.room != player.room) {
            Toast.makeText(this, getString(R.string.toast_try_again), Toast.LENGTH_SHORT).show()
        }
    }

    fun verifyRoom(player: Player, monster: Monster){
        if (monster.room == player.room){
            println("player perdeu pq monstro esta na mesma sala")
            showGameOver()
        } else{
            println("nao estao na mesma sala!")
            if (player.room == player.exit) {
                println("O jogador encontrou a saída e venceu!")
                showVictory()
            }
        }
    }
    fun verifyMoves(player: Player, monster: Monster){
        if (player.remainingMoves<=0){
            println("fim do jogo pois fim dos movimentos")
            showGameOver()
        } else{
            player.remainingMoves--
            binding.tvRemainingmoves.text = getString(R.string.remaining_moves, player.remainingMoves)
            advanceTime()
            println("Movimentos restantes: ${player.remainingMoves}")
            showToast(player, monster)
            setMonsterRoom(monster, player)
            if (player.remainingMoves>0){
                selectRoom(player, monster)
            }
        }
    }

    fun startGame(player: Player, monster: Monster){
        player.remainingMoves = 12
        binding.tvRemainingmoves.text = getString(R.string.remaining_moves, player.remainingMoves)
        binding.tvRemainingmoves.text = getString(R.string.remaining_moves, player.remainingMoves)

        setExit(player)
        setMonsterRoom(monster, player)
        println("Jogo iniciado! O jogador tem ${player.remainingMoves} movimentos.")
        selectRoom(player, monster)

        inGameHour = 0  // Começa com 00:00
        inGameMinute = 0
        updateDisplayedHour()

        println("username: ${player.username}")
        println("passcode: ${player.passcode}")
    }

    fun showGameOver(){
        setContentView(gameOverBinding.root)
        gameOverBinding.retryButton.setOnClickListener{

            //reiniciar
            setContentView(binding.root)
            println("reiniciando o jogo")
            val player = Player()
            val monster = Monster()
            startGame(player, monster)
        }

       gameOverBinding.rankingButton.setOnClickListener{
            println("indo pro ranking")
            setContentView(R.layout.activity_ranking)
        }
    }
    fun showVictory(){
        setContentView(victoryBinding.root)
        victoryBinding.retryButton.setOnClickListener{
            //reiniciar
            setContentView(binding.root)
            println("reiniciando o jogo")
            val player = Player()
            val monster = Monster()
            startGame(player, monster)
        }

        victoryBinding.rankingButton.setOnClickListener{
            println("indo pro ranking")
            setContentView(R.layout.activity_ranking)
        }
    }

    private fun advanceTime() {
        inGameMinute += 30
        if (inGameMinute >= 60) {
            inGameMinute = 0
            inGameHour += 1
            if (inGameHour >= 24) {
                inGameHour = 0
            }
        }
        updateDisplayedHour()
    }

    private fun updateDisplayedHour() {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY, inGameHour)
        calendar.set(Calendar.MINUTE, inGameMinute)

        val format = SimpleDateFormat("hh:mma", Locale.getDefault())
        val hourFormatted = format.format(calendar.time)

        binding.tvGamehour.text = hourFormatted
    }




}
