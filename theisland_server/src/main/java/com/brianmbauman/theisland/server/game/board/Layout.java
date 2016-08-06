package com.brianmbauman.theisland.server.game.board;

import com.google.gson.*;

import java.io.IOException;
import java.lang.annotation.Inherited;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * A reference for how a {@link com.brianmbauman.theisland.server.game.board.Board} is to be constructed
 * <p>
 * Layouts are immediately parsed from resources/Layouts.json when the application is started.
 * They cannot be created on the fly.
 * <p>
 * A Layout consists of a 2-dimensional array of boolean values, indicating whether a particular cell is land or not.
 * For example:
 * [
 *  [false,false,true,true,false,false],
 *  [false,true,true,true,true,false],
 *  [true,true,true,true,true,true],
 *  [true,true,true,true,true,true],
 *  [false,true,true,true,true,false],
 *  [false,false,true,true,false,false]
 * ]
 */
public final class Layout {
    /**
     * The full map of all Layouts loaded from resources/Layouts.json when the application started.  Each Layout's key is its name.
     */
    public static final Map<String, Layout> layouts = loadLayouts();


    private String name;
    private boolean[][] layout;

    private Layout() {};

    /**
     * Returns the default Layout.
     * @return the Layout named "Default"
     */
    public static Layout getLayout() {
        return getLayout("Default");
    }

    /**
     * Returns the requested Layout.
     * @param string the name of the desired Layout
     * @return the Layout stored under the requested name
     */
    public static Layout getLayout(String string) {
        return layouts.get(string);
    }

    /**
     * Returns a random Layout.
     * @return a random Layout
     */
    public static Layout getRandomLayout(){
        String[] keys = layouts.keySet().toArray(new String[Layout.layouts.size()]);
        int index = new Random().nextInt(layouts.size());
        return layouts.get(keys[index]);
    }

    private static final Map<String, Layout> loadLayouts() {
        Map<String, Layout> layouts = new HashMap<>();

        try {
            //Read JSON file
            String rawJson = new String(
                    Files.readAllBytes(Paths.get("theisland_server/src/main/resources/Layouts.json"))
            );

            //Parse into array of Layouts - custom deserializer to convert int to bool
            GsonBuilder builder = new GsonBuilder();
            builder.registerTypeAdapter(boolean.class, new BooleanTypeAdapter());
            Gson gson = builder.create();
            Layout[] layoutArray = gson.fromJson(rawJson, Layout[].class);

            //Store each Layout in a map by name
            for (Layout layout : layoutArray) {
                layouts.put(layout.name, layout);
            }

            return layouts;

        } catch (IOException e) {
            throw new RuntimeException("Layouts.json could not be loaded.");
        }
    }

    @Override
    public String toString() {
        return "Layout{" +
                "name='" + name + '\'' +
                ", layout=" + Arrays.deepToString(layout) +
                '}';
    }

    private static class BooleanTypeAdapter implements JsonDeserializer<Boolean> {
        public Boolean deserialize(JsonElement json, Type typeOfT,
                                   JsonDeserializationContext context) throws JsonParseException {
            int code = json.getAsInt();
            return code == 0 ? false :
                    code == 1 ? true :
                            null;
        }
    }
}
