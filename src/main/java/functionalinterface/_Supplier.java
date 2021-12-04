package functionalinterface;

import java.util.List;
import java.util.function.Supplier;

public class _Supplier {
    // Represents a supplier of results
    public static void main(String[] args) {
        System.out.println(getDBConnectionUrl());
        System.out.println(getDBConnectionUrlSupplier.get());
    }

    static Supplier<List<String>> getDBConnectionUrlSupplier =
            () -> List.of("jdbs://localhost:53 1/users");

    //return a value
    static String getDBConnectionUrl() {
        return "jdbs://localhost:531/users";
    }
}
