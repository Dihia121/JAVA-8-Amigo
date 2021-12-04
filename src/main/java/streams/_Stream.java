package streams;


import imperative.Main;

import java.util.List;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class _Stream {

    public static void main(String[] args) {
        List<_Stream.Person> people = List.of(
                new _Stream.Person("John", _Stream.Gender.MALE),
                new _Stream.Person("Maria", _Stream.Gender.FEMALE),
                new _Stream.Person("John", _Stream.Gender.MALE),
                new _Stream.Person("Alice", _Stream.Gender.FEMALE)
        );

        people.stream()
                .map(person -> person.name)
                .mapToInt(String::length)//.mapToInt(name -> name.length())
                 //remove duplication collect(Collectors.toSet())
                .forEach(System.out::println);

        Function<Person, String> personStringFunction = person -> person.name;

        ToIntFunction<String> length = String::length;

        IntConsumer println = System.out::println; // x -> System.out.println(x)



//        people.stream()
//                .map(personStringFunction)
//                .mapToInt(length)//.mapToInt(name -> name.length())
//                //remove duplication collect(Collectors.toSet())
//                .forEach(println);

        Predicate<Person> personPredicate =
                person -> person.gender.equals(Gender.FEMALE);

        boolean containsOnlyFemals = people.stream()
                .allMatch(personPredicate); //anyMatch at least 1 female return true nonMatch


    }

    static class Person {
        private final String name;
        private final _Stream.Gender gender;

        public Person(String name, _Stream.Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender {
        MALE, FEMALE
    }
}
