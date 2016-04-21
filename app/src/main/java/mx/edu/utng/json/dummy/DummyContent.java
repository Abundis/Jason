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
                return new DummyItem(String.valueOf(position), "¿Que es JSON?", makeDetails(position));

            case 2:
                return new DummyItem(String.valueOf(position), "Sintaxis", makeDetails(position));

            case 3:
                return new DummyItem(String.valueOf(position), "Codificar y Decodificar JSON", makeDetails(position));
            case 4:
                return new DummyItem(String.valueOf(position),"Request.JSON", makeDetails(position));
        }

        //return new DummyItem(String.valueOf(position), "Tema " + position, makeDetails(position));
        return null;
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Detalles del Tema: ");
        /*for (int i = 0; i < position; i++) {
            builder.append("\nMás informacion aquí.");
        }
        */
        //builder.append("\nMas información aquí.");

        switch (position) {
            case 1:
                builder.append("\n¿Que es JSON?\n" +
                        "\nUn formato de intercambio de datos es un formato de texto que se utiliza" +
                        " para el intercambio de datos entre plataformas.Otro formato de intercambio" +
                        " de datos que ya han oído hablar de es XML. El mundo necesita formatos de" +
                        " intercambio de datos, como XML y JSON, para el intercambio de datos entre" +
                        " sistemas muy diferentes. Imagine por un momento un mundo compuesto por" +
                        " cientos de islas pequeñas, aisladas entre un vasto océano. Cada isla tiene" +
                        " su propio idioma y las costumbres únicas. Las islas tienen todos los" +
                        " comerciantes marineros que viajan largas distancias entre las islas. el" +
                        " comercio exterior es una parte integral de todas las economías de las islas" +
                        " y contribuye a un alto nivel de vida de los isleños. Si no fuera por las" +
                        " gaviotas de soporte altamente capacitadas, esto no sería posible.");
                break;
            case 2:
                builder.append("\nSintaxis\n"+
                         "\nLa sintaxis de JSON realmente no es nada más que la mezcla de literales de objeto y" +
                         " matrices para almacenar datos. ¿JSON representa solamente datos? No incluye el" +
                         " concepto de variables, asignaciones o igualdades." +
                         "\nSi transmitimos esta información a través de HTTP a un navegador, será bastante\n" +
                         " rápido, dado el reducido número de caracteres.\n" +
                         " Suponga que recupera esta información utilizando y la almacena en una\n" +
                         " variable llamada sJSON. Ahora, dispondrá de una cadena de información, no de un\n" +
                         " objeto. Para transformarla en un objeto, simplemente utilizaremos la función eval():");
                break;
            case 3:
                builder.append("\nCcodificar y Decodificar JSON\n" +
                         " ¿Podíamos decodíficar JSON utilizando la función eval ()?. Hay un problema\n" +
                         " inherente en la utilización de eval(), que evalúa cualquier código JavaScript" +
                         " que se pasa a la función y esto es un gran riesgo de seguridad." +
                         " MOOTOOLS: Json\n" +
                         " Json nos facilita la tarea de pasar de un string Json a un Objeto Javascript y viceversa.\n" +
                         " Nota: Todo lo referente a JSON respecto a la versión anterior (1.11) ha cambiado\n" +
                         " bastante, haciendose completamente incompatibles. Por ejemplo, antes se escribía\n" +
                         " Json. Ahora es JSON.\n" +
                         " JSON.encode(objeto)\n" +
                         " Nos permite pasar un Objeto Javascript a un simple String." +
                         " JSON.decode(string, secure)\n" +
                         " Nos permite pasar de un String Json a un Objeto Javascript.");
                break;
            case 4:
                builder.append("\nRequest.JSON\n" +
                         " Nos permite enviar y recibir objetos JSON mediante AJAX de manera muy simple.\n" +
                         " Hereda todos los métodos y propiedades de la clase Request (para trabajo con AJAX)." +
                         " Supongamos que tenemos una base de datos de productos y queremos, mediante\n" +
                         " ASP y AJAX, mostrar todos esos productos. Con Request.JSON enviaríamos la\n" +
                         " petición a ASP, éste buscaría todos los productos y los devolvería en formato JSON.\n" +
                         " Una vez que tenemos los datos en dicho formato, solo debemos mostrarlos con\n" +
                         " javascript");
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
