package com.brianmbauman.theisland.server.game.board;

/**
 * Created by BBauman on 8/4/16.
 */
public class Coordinate {
    private final int x;
    private final int y;

    public Coordinate(int x, int y) throws IndexOutOfBoundsException {

        if(x < 1 || y < 1){
            throw new IndexOutOfBoundsException();
        }
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals (final Object o) {
        if (!(o instanceof Coordinate)) return false;
        if (((Coordinate) o).x != x) return false;
        if (((Coordinate) o).y != y) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return (x << 16) + y;
    }
}
