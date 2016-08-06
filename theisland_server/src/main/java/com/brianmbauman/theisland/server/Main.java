package com.brianmbauman.theisland.server;

import com.brianmbauman.theisland.server.game.board.Layout;

/**
 * Created by BBauman on 8/4/16.
 */
public class Main {

    public static void main(String[] args){
        //Quick test of resource reading
        System.out.print(Layout.getRandomLayout().toString());
    }
}
