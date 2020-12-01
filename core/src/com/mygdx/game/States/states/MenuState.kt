package com.mygdx.game.States.states

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.mygdx.game.States.FlappyGame

class MenuState(gsm : GameStateManager) : State(gsm) {

    val background: Texture = Texture("files/bg.png")
    val playButton: Texture = Texture("files/playbtn.png")

    init {
        cam.setToOrtho(false, FlappyGame().WIDTH / 2, FlappyGame().HEIGHT / 2)
    }

    override fun handleInput() {
        if(Gdx.input.justTouched()){
            gsm.set(PlayState(gsm))
        }
    }

    override fun atualiza(dt: Float) {
        handleInput()
    }

    override fun render(sb: SpriteBatch) {
        sb.begin()
        sb.projectionMatrix = cam.combined
        sb.draw(background, 0F, 0F)
        sb.draw(playButton,  cam.position.x - playButton.width / 2, cam.position.y)
        sb.end()
    }

    override fun dispose() {
        background.dispose()
        playButton.dispose()
    }
}