package br.com.ricardobadan.jogodedados

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v4.content.ContextCompat
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_game.*
import java.util.*

class GameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        btJogar.setOnClickListener(){
            realizarJogada()
        }
    }

    fun realizarJogada() {
        val jogador = gerarNumero()
        val adversario = gerarNumero()

        configuraImagemDoDado(jogador, ivJogador)
        configuraImagemDoDado(adversario, ivAdversario)

        verificaVencedor(jogador, adversario)
    }

    fun exibeMensagem(mensagem:String){
        Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show()
    }

    fun verificaVencedor(numeroJogador:Int, numeroAdversario:Int){
        if(numeroJogador < numeroAdversario){
            exibeMensagem(mensagem = "Perdeu")
        }
        else if(numeroJogador > numeroAdversario){
            exibeMensagem(mensagem = "Ganhou")
        }
        else{
            exibeMensagem(mensagem = "Empatou")
        }

        Handler().postDelayed({
            btJogar.isEnabled = true
        }, 3000)
    }

    fun configuraImagemDoDado(numeroDado: Int, imageView: ImageView) {
        when(numeroDado) {
            1-> {setImagem(imageView, R.drawable.dice1)}
            2-> {setImagem(imageView, R.drawable.dice2)}
            3-> {setImagem(imageView, R.drawable.dice3)}
            4-> {setImagem(imageView, R.drawable.dice4)}
            5-> {setImagem(imageView, R.drawable.dice5)}
            else -> {setImagem(imageView, R.drawable.dice6)}
        }
    }

    private fun setImagem(imageView: ImageView, idImagem: Int) {
        imageView.setImageDrawable(ContextCompat.getDrawable(this, idImagem))
    }

    fun gerarNumero() : Int{
        return Random().nextInt(5) + 1
    }


}
