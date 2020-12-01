package com.mygdx.game.States.sprites

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.math.Vector2
import java.util.Random

class Tube(x: Float) {

    companion object {
        val TUBE_WIDTH = 52
        private val FLUTUACAO = 130
        private val TUBO_GAP = 100
        private val MENOR_ABERTURA = 120
    }

    val topTube: Texture = Texture("assets/toptube.png")
    val bottomTube: Texture = Texture("assets/bottomtube.png")
    val rand = Random()
    val posicaoTuboTopo = Vector2(x, (rand.nextInt(FLUTUACAO) + TUBO_GAP + MENOR_ABERTURA).toFloat())
    val posicaoTuboEmbaixo = Vector2(x, posicaoTuboTopo.y - TUBO_GAP - bottomTube.height)

    fun reposiciona(x: Float){
        posicaoTuboTopo.set(x, (rand.nextInt(FLUTUACAO) + TUBO_GAP + MENOR_ABERTURA).toFloat())
        posicaoTuboEmbaixo.set(x, posicaoTuboTopo.y - TUBO_GAP - bottomTube.height)
    }
}