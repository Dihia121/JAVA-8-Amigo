package functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {

    public static void main(String[] args) {

        // Function takes 1 argument and produces 1 result
        int result = incrementByOne(5);
        System.out.println(result);
        int result1 = incrementByOneFunction.apply(5);
        System.out.println(result1);

        // Compile multiple functions together to acheive a desire
        int multiply = multiplyByTenFunction.apply(result1);
        System.out.println(multiply);

        Function<Integer, Integer> addByOneThenMultiplyByTen =
                incrementByOneFunction.andThen(multiplyByTenFunction);

        System.out.println(addByOneThenMultiplyByTen.apply(5));

        //BiFunction  takes 2 argument and produces 1 result
        System.out.println("BiFunction: " + incrementByOneAndMultiplyFunction.apply(5, 100));
    }


    static Function<Integer, Integer> incrementByOneFunction =
            number -> number + 1;

    static Function<Integer, Integer> multiplyByTenFunction = number -> number * 10;

    static int incrementByOne(int number) {
        return number + 1;
    }

    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyFunction =
            (number, numbToMultiplyBy)
                    -> (number + 1) * numbToMultiplyBy;

    static int incrementByOneAndMultiply(int number, int numbToMultiplyBy) {
        return (number + 1) * numbToMultiplyBy;
    }

}

