package com.brianmbauman.theisland.server.game;

import com.brianmbauman.theisland.server.game.board.Layout;

/**
 * Contains all of the configurable settings for a {@link Game}.
 * <p>
 * Every property should have default values, so that it can be initialized in a usable state and then
 * updated with custom settings.
 * These settings are passed to any new {@link Game}.
 * If no GameConfig object is sent, {@link Game} creates one of its own on the fly, using default values.
 */
public class GameConfig {
    private Layout layout = Layout.getRandomLayout();

    public Layout getLayout() {
        return layout;
    }

    public void setLayout(Layout layout) {
        this.layout = layout;
    }
}
