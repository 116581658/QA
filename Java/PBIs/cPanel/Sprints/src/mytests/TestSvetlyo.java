package mytests;

import java.util.HashMap;
import java.util.Map;

public class TestSvetlyo {


    public static void main(String[] args) {

        Map<String, Svetlyo> myMap = new HashMap<>();

        Svetlyo object1 = new Svetlyo();

        object1.setField1("na object1 field1 stojnostta");
        object1.setField2("na object1 field2 stojnostta");
        object1.setField3("na object1 field3 stojnostta");


        myMap.put("key1", object1);

        myMap.get("key1");
        myMap.get("key2");

    }
}
