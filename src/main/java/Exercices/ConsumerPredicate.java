package Exercices;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public interface ConsumerPredicate {

    static Predicate<Person> p = per -> per.getHeight() >= 140;
    static Predicate<Person> p2 = per -> per.getGender().equals("Female");
    static BiConsumer<String, Person> hobbiesConsumer = (name, hobbies) -> System.out.println(name + " " + hobbies);
    Consumer<Person> personConsumer = per -> {
        if(p.and(p2).test(per)) {
            hobbiesConsumer.accept(per.getGender(), new Person());
        }
    };
    public static void main(String[] args) {

    }

    static class Person {
      String  weight;
      String gender;
      int height = 120;

      public int getHeight() {
          return height;
      }

      public String  getGender() {
          return "Female";
      }
    }
}
