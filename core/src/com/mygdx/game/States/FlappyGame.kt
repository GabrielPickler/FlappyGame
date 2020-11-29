package com.mygdx.game.States

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.mygdx.game.States.States.GameStateManager
import com.mygdx.game.States.States.MenuState

class FlappyGame : ApplicationAdapter() {

    val WIDTH = 480
    val HEIGHT = 800
    val TITLE = "Flappy"

    lateinit var gsm: GameStateManager;
    lateinit var batch: SpriteBatch
    lateinit var img: Texture

    override fun create() {
        batch = SpriteBatch()
        gsm = GameStateManager()
        img = Texture("badlogic.jpg")
        gsm.push(MenuState(gsm))
    }

    override fun render() {
        Gdx.gl.glClearColor(1f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        gsm.update(Gdx.graphics.deltaTime)
        gsm.render(batch)
    }
}
