package mx.edu.utng.json.dummy;

import android.app.Activity;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mx.edu.utng.json.BloqueQuizDos;
import mx.edu.utng.json.R;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent extends Activity{

    /**
     * An array of sample (dummy) items.
     */
    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    private static final int COUNT = 4;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static DummyItem createDummyItem(int position) {
        switch (position) {
            case 1:
                return new DummyItem(String.valueOf(position), .getString(R.string.json, makeDetails(position));

            case 2:
                return new DummyItem(String.valueOf(position), .getString(R.string.sintaxis, makeDetails(position));

            case 3:
                return new DummyItem(String.valueOf(position), .getString(R.string.codificar, makeDetails(position));
            case 4:
                return new DummyItem(String.valueOf(position),.getString(R.string.request, makeDetails(position));
        }

        //return new DummyItem(String.valueOf(position), "Tema " + position, makeDetails(position));
        return null;
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append(.getString(R.string.detalle));

        switch (position) {
            case 1:
                builder.append(.getString(R.string.json) +
                        .getString(R.string.tema_1));
                break;
            case 2:
                builder.append(.getString(R.string.sintaxis)+
                         .getString(R.string.tema_2));
                break;
            case 3:
                builder.append(.getString(R.string.codificar) +
                         .getString(R.string.tema_3));
                break;
            case 4:
                builder.append(.getString(R.string.request) +
                         .getString(R.string.tema_4));
                break;
            default:
                break;
        }
        return builder.toString();
    }


    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public final String id;
        public final String content;
        public final String details;

        public DummyItem(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
