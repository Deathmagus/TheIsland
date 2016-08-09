package com.brianmbauman.theisland.server;

import com.brianmbauman.theisland.server.game.Game;
import com.brianmbauman.theisland.server.game.board.Layout;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

/**
 * Created by BBauman on 8/4/16.
 */
public class Main {
    public static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args){
        ServerSocket server;
        Socket clientConnection = null;

        LOGGER.info("Starting server");
        Game game = new Game();

        try{
            server = new ServerSocket(48999);
        } catch (IOException e){
            System.out.println(e);
            throw new RuntimeException("Couldn't open server.", e);
        }

        while(true){
            try{
                clientConnection = server.accept();
            } catch (IOException e){
                System.out.println(e);
            }
        }
    }
}
