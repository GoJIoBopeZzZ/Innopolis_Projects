package testWeakHashMap;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * Created by _red_ on 08.06.17.
 */
public class MyWeakHashMap {
    public static void testWeakHashMap() {
        Map map = new WeakHashMap();
        Object obj = new Object(); // создаём объект
        map.put(obj, "object"); // кладём его в мапу
        System.out.println(map.size()); // в мапе один элемент
        obj = null; // чистим ссылку
        System.gc(); // играемся со сборщиком мусора
        System.runFinalization();
        System.out.println(map.size()); // мапа должна стать пустой
    }
}
