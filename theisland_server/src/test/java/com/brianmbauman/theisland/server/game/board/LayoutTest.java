package com.brianmbauman.theisland.server.game.board;

import junit.framework.TestCase;

/**
 * Created by Magus on 2016-08-06.
 */
public class LayoutTest extends TestCase {

    //Demo test
    public void testGetLayout(){
        String defaultLayoutString = "Layout{name='Default', layout=[[false, false, true, true, false, false], " +
                "[false, true, true, true, true, false], [true, true, true, true, true, true], " +
                "[true, true, true, true, true, true], [false, true, true, true, true, false], " +
                "[false, false, true, true, false, false]]}";
        Layout layout = Layout.getLayout();
        assertEquals(defaultLayoutString, layout.toString());
    }
}
