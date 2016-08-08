package com.brianmbauman.theisland.server;

import com.brianmbauman.theisland.server.game.Game;
import com.brianmbauman.theisland.server.game.board.Layout;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by BBauman on 8/4/16.
 */
public class Main {

    public static void main(String[] args){
        ServerSocket server;
        Socket clientConnection = null;

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
