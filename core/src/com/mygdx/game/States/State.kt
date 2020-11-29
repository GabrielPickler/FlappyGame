package com.mygdx.game.States

import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Vector3

abstract class State {
    private lateinit var cam : OrthographicCamera
    private lateinit var mouse: Vector3
    private lateinit var gsm : GameStateManager

    protected abstract fun handleInput() : Unit
    protected abstract fun update(dt: Float) : Unit
    protected abstract fun render(sb: SpriteBatch): Unit

}