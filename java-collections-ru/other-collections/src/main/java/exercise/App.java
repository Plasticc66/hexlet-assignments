package exercise;

import java.util.*;

// BEGIN
public class App {
    public static LinkedHashMap<String, String> genDiff(Map<String, Object> data1, Map<String, Object> data2) {
        //tree for autoSort
        TreeMap<String, String> resultTree = new TreeMap<>();
        //add data1 keys
        for (String k : data1.keySet()) {
            resultTree.put(k, "added");
        }
        //add data2 keys
        for (String k : data2.keySet()) {
            resultTree.put(k, "added");
        }
        //logic values
        for (String k : data1.keySet()
        ) {
            if (data2.containsKey(k)) {
                if (data2.get(k).equals(data1.get(k))) {
                    resultTree.put(k, "unchanged");
                } else {
                    resultTree.put(k, "changed");
                }
            } else {
                resultTree.put(k, "deleted");
            }
        }
        //tree ---> linked
        LinkedHashMap<String, String> result = new LinkedHashMap<>();
        for (Map.Entry<String, String> treeM : resultTree.entrySet()) {
            result.put(treeM.getKey(), treeM.getValue());
        }
        return result;
    }
}
//END
