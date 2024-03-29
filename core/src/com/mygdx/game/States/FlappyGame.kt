package com.mygdx.game.States

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.audio.Music
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.mygdx.game.States.states.GameStateManager
import com.mygdx.game.States.states.MenuState
import com.mygdx.game.States.states.State
import java.util.*

class FlappyGame : ApplicationAdapter() {

    val WIDTH: Float = 480F
    val HEIGHT: Float = 800F
    val TITLE = "Run Santa Claus!"

    lateinit var gsm: GameStateManager;
    lateinit var batch: SpriteBatch

    lateinit var music: Music

    override fun create() {
        batch = SpriteBatch()
        gsm = GameStateManager(Stack())
        music = Gdx.audio.newMusic(Gdx.files.internal("files/jinglebell.mp3"))
        music.isLooping
        music.volume = 0.1f
        music.play()
        gsm.push(MenuState(gsm))
    }

    override fun render() {
        Gdx.gl.glClearColor(1f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        gsm.update(Gdx.graphics.deltaTime)
        gsm.render(batch)
    }

    override fun dispose() {
        music.dispose()
    }
}
