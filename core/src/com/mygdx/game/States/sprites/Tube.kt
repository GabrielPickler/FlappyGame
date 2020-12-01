package com.mygdx.game.States.sprites

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.math.Vector2
import java.util.Random

class Tube(x: Float) {

    companion object {
        val TUBE_WIDTH = 52
        private val FLUTUACAO = 130
        private val TUBO_GAP = 100
        private val MENOR_ABERTURA = 120
    }

    val tuboSuperior: Texture = Texture("assets/toptube.png")
    val tuboInferior: Texture = Texture("assets/bottomtube.png")
    val rand = Random()
    val posicaoTuboTopo = Vector2(x, (rand.nextInt(FLUTUACAO) + TUBO_GAP + MENOR_ABERTURA).toFloat())
    val posicaoTuboEmbaixo = Vector2(x, posicaoTuboTopo.y - TUBO_GAP - tuboInferior.height)
    val areaTopo: Rectangle = Rectangle(posicaoTuboTopo.x, posicaoTuboTopo.y, tuboSuperior.width.toFloat(), tuboSuperior.height.toFloat())
    val areaInferior: Rectangle = Rectangle(posicaoTuboEmbaixo.x, posicaoTuboEmbaixo.y, tuboInferior.width.toFloat(), tuboInferior.height.toFloat())

    fun reposiciona(x: Float) {
        posicaoTuboTopo.set(x, (rand.nextInt(FLUTUACAO) + TUBO_GAP + MENOR_ABERTURA).toFloat())
        posicaoTuboEmbaixo.set(x, posicaoTuboTopo.y - TUBO_GAP - tuboInferior.height)
        areaTopo.setPosition(posicaoTuboTopo.x, posicaoTuboTopo.y)
        areaInferior.setPosition(posicaoTuboEmbaixo.x, posicaoTuboEmbaixo.y)
    }

    fun colide(player: Rectangle): Boolean {
        return player.overlaps(areaTopo) || player.overlaps(areaInferior)
    }

    fun dispose(){
        tuboSuperior.dispose()
        tuboInferior.dispose()
    }
}