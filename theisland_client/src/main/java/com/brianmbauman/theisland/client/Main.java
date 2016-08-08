package com.brianmbauman.theisland.client;

import java.net.Socket;

/**
 * Created by BBauman on 8/8/16.
 */
public class Main {

    public static void main(String[] args) {
        Socket client;

        try {
            client = new Socket("localhost", 48999);
        } catch (java.io.IOException e){
            System.out.println(e);
        }
    }
}
