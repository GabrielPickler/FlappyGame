package com.mygdx.game.States.states

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.mygdx.game.States.FlappyGame
import com.mygdx.game.States.sprites.Birds
import com.mygdx.game.States.sprites.Tube
import com.badlogic.gdx.utils.Array;


class PlayState(gsm: GameStateManager) : State(gsm) {

    companion object{
        val ESPACO_TUBOS = 125
        val CONTA_TUBO = 4
    }

    val bird = Birds(50F, 300F)
    val bg = Texture("assets/bg.png")
    var tubos : Array<Tube>

    init {
        cam.setToOrtho(false, FlappyGame().WIDTH / 2, FlappyGame().HEIGHT / 2)
        tubos = Array()
        for(i in CONTA_TUBO downTo 1 step 1){
            tubos.add(Tube(i * (ESPACO_TUBOS + Tube.TUBE_WIDTH).toFloat()))
        }

    }

    override fun handleInput() {
        if(Gdx.input.justTouched()){
            bird.jump()
        }
    }

    override fun atualiza(dt: Float) {
        handleInput()
        bird.update(dt)
        cam.position.x = bird.posicao.x + 80
        for(tubo : Tube in tubos){
            if(cam.position.x - (cam.viewportWidth / 2) > tubo.posicaoTuboTopo.x + tubo.tuboSuperior.width){
                tubo.reposiciona(tubo.posicaoTuboTopo.x + ((Tube.TUBE_WIDTH + ESPACO_TUBOS) * CONTA_TUBO))
            }
            if(tubo.colide(bird.getPlayerArea())){
                gsm.set(PlayState(gsm))
            }
        }



        cam.update()
    }

    override fun render(sb: SpriteBatch) {
        sb.projectionMatrix = cam.combined
        sb.begin()
        sb.draw(bg, cam.position.x - (cam.viewportWidth / 2), 0F)
        sb.draw(bird.texture, bird.posicao.x, bird.posicao.y)
        for(tubo : Tube in tubos) {
            sb.draw(tubo.tuboSuperior, tubo.posicaoTuboTopo.x, tubo.posicaoTuboTopo.y)
            sb.draw(tubo.tuboInferior, tubo.posicaoTuboEmbaixo.x, tubo.posicaoTuboEmbaixo.y)
        }
        sb.end()
    }

    override fun dispose() {
        TODO("Not yet implemented")
    }
}