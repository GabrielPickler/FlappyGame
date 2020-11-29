package com.mygdx.game.States.States

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import java.util.Stack

class GameStateManager() {

    lateinit var states: Stack<State>

    fun push(state: State){
        states.push(state)
    }

    fun pop(){
        states.pop()
    }

    fun set(state: State){
        states.pop()
        states.push(state)
    }

    fun update(dt: Float){
        states.peek().update(dt)
    }

    fun render(sb: SpriteBatch){
        states.peek().render(sb)
    }

}