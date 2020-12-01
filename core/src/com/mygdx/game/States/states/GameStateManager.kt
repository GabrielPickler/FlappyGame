package com.mygdx.game.States.states

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import java.util.Stack

class GameStateManager(var states: Stack<State>) {

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
        states.peek().atualiza(dt)
    }

    fun render(sb: SpriteBatch){
        states.peek().render(sb)
    }

}