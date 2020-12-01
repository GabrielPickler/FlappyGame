package com.mygdx.game.States.sprites

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.math.Vector3

class Birds(x: Float, y: Float) {
    companion object {
        val GRAVIDADE = -15
        val MOVIMENTO = 100
    }

    val posicao: Vector3 = Vector3(x.toFloat(), y.toFloat(), 0F)
    val velocidade: Vector3 = Vector3(0F, 0F, 0F)
    val texture: Texture = Texture("assets/santaclaus.png")
    val area : Rectangle = Rectangle(x, y, texture.width.toFloat(), texture.height.toFloat())

    fun update(dt: Float) {
        if(posicao.y > 0F){
            velocidade.add(0F, GRAVIDADE.toFloat(), 0F)
        }
        velocidade.add(0F, GRAVIDADE.toFloat(), 0F)
        velocidade.scl(dt)
        posicao.add(MOVIMENTO * dt, velocidade.y, 0F)
        velocidade.scl(1/dt)
        area.setPosition(posicao.x, posicao.y)
        if(posicao.y < 0) {
            posicao.y = 0F
        }
    }

    fun getPlayerArea() : Rectangle{
        return area
    }

    fun jump(){
        velocidade.y = 250F
    }

    fun dispose(){
        texture.dispose()
    }
}