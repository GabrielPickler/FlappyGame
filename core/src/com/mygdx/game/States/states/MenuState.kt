package com.mygdx.game.States.states

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.mygdx.game.States.FlappyGame

class MenuState(gsm : GameStateManager) : State(gsm) {

    val background: Texture = Texture("assets/bg.png")
    val playButton: Texture = Texture("assets/playbtn.png")

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
        sb.draw(background, 0F, 0F, FlappyGame().WIDTH, FlappyGame().HEIGHT)
        sb.draw(playButton, (FlappyGame().WIDTH / 2) - (playButton.width / 2), (FlappyGame().HEIGHT / 2))
        sb.end()
    }

    override fun dispose() {
        background.dispose()
        playButton.dispose()
    }
}