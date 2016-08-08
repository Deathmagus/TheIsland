package com.brianmbauman.theisland.server.game.board;

import java.util.Map;

/**
 * Created by BBauman on 8/5/16.
 */
public class Board {
    private Map<Coordinate, Location> island;

    public Board(Layout layout){
        //TODO - Convert layouts to maps.
    }

    public Location getLocation(Coordinate coordinate){
        return island.get(coordinate);
    }
}
