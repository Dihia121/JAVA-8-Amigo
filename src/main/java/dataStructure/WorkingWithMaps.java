package dataStructure;

import java.util.HashMap;
import java.util.Map;

public class WorkingWithMaps {
    public static void main(String[] args) {
        Map<Integer, Person> map = new HashMap<>();
        map.put(1, new Person("SAIDANI DIHIA"));
        map.put(2, new Person("SAIDANI maria"));
        map.put(3, new Person("SAIDANI nydia"));
        map.remove(3);
        System.out.println(map);
        System.out.println(map.size());
        System.out.println(map.get(1));
        System.out.println(map.containsKey(4));
        System.out.println(map.entrySet());
        System.out.println(map.keySet());
        //Loop through map
        map.entrySet().
                forEach((x) ->
                        System.out.println(x.getKey() + " " + x.getValue()));

        // Another manner
        map.forEach((key, person) -> {
            System.out.println(key + " - " + person);
        });

    }

    static class Person {
        String name;

        public Person(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

}
