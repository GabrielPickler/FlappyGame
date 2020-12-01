package com.mygdx.game.desktop

import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration
import com.mygdx.game.States.FlappyGame

object DesktopLauncher {
    @JvmStatic
    fun main(arg: Array<String>) {
        val config = LwjglApplicationConfiguration()
        config.width = FlappyGame().WIDTH.toInt()
        config.height = FlappyGame().HEIGHT.toInt()
        config.title = FlappyGame().TITLE
        LwjglApplication(FlappyGame(), config)
    }
}