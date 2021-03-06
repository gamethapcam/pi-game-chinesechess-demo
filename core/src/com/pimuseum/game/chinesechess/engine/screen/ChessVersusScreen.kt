package com.pimuseum.game.chinesechess.engine.screen

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.ScreenAdapter
import com.badlogic.gdx.utils.viewport.StretchViewport
import com.pimuseum.game.chinesechess.engine.constant.LogTag
import com.pimuseum.game.chinesechess.engine.game.ChessVersusGame
import com.pimuseum.game.chinesechess.engine.stage.ChessVersusStage


/**
 * Desc : ChessVersusScreen
 * Author : Jiervs
 * Date : 2019/4/12
 */
class ChessVersusScreen(var game : ChessVersusGame) : ScreenAdapter() {

    private var stage : ChessVersusStage
            = ChessVersusStage(game.mode,StretchViewport(game.gameWidth, game.gameHeight))

    init {
        // link input to stage
        Gdx.input.inputProcessor = stage
        Gdx.app.log(LogTag.ChessLog, "World Size: ${game.gameWidth} * ${game.gameHeight}")
    }

    override fun render(delta: Float) {
        super.render(delta)
        stage.act()
        stage.draw()
    }

    override fun dispose() {
        super.dispose()
        stage.dispose()
    }
}