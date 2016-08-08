package com.brianmbauman.theisland.server.game;

import com.brianmbauman.theisland.server.game.board.Board;
import com.brianmbauman.theisland.server.game.board.Layout;
import com.brianmbauman.theisland.server.game.board.Location;
import com.brianmbauman.theisland.server.game.board.Coordinate;
import java.util.List;

/**
 * A representation of a single island game.
 * <p>
 * The server will spin up a new Game for each active game.
 * Each one runs on its own thread, and maintains the canonical game state.
 * The Games interact heavily with the network package to send and receive messages from clients.
 */
public final class Game implements Runnable{

    private List<Agent> agents;
    private Board board;
    private GameConfig config;

    public Game(){
        this.config = new GameConfig();
        this.board = new Board(this.config.getLayout());
    }

    @Override
    public void run() {

    }
}
