package functionalinterface;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer   {

    // Takes one single argument and returns no result
    public static void main(String[] args) {
        Customer maei = new Customer("Maei", "99999");
        greetCustomer(maei);

        // Using functional interface Consumer
        greetCustomerConsumer.accept(maei);
        greetCustomerConsumerV2.accept(maei, false);

        System.out.println("Ici l'enchainement des méthodes");
        mixGreetAndCustomerConsumer();

        System.out.println("Print With Condition");
        printWithCondition();

    }

    static BiConsumer<Customer, Boolean> greetCustomerConsumerV2 = (customer,showPhoneNumber)  ->
            System.out.println("Hello " + customer.customerName
                    + ", thanks for registering phone number "
                    + (showPhoneNumber ? customer.customerPhoneNumber : "**********"));

    static Consumer<Customer> greetCustomerConsumer = customer ->
            System.out.println("Hello " + customer.customerName
            + ", thanks for registering phone number "
            + customer.customerPhoneNumber);

    static Consumer<Customer> customerConsumer = customer ->
            System.out.println("Hello " + customer.customerName);

    static void mixGreetAndCustomerConsumer (){
        List<Customer> customerList = List.of(
                new Customer("Dihia", "07920000003"),
                new Customer("Nydia", "07921110003"),
                new Customer("Soraya", "07000000003"),
                new Customer("Nacer", "07001100003")
        );
        customerList.forEach(customerConsumer.andThen(greetCustomerConsumer));
    }

    static void printWithCondition() {
        List<Customer> customerList = List.of(
                new Customer("Dihia", "07920000003"),
                new Customer("Nydia", "07921110003"),
                new Customer("Soraya", "07000000003"),
                new Customer("Nacer", "07001100003")
        );
        customerList.forEach(p -> {
            if(p.customerName.contains("a")){
                customerConsumer.andThen(greetCustomerConsumer).accept(p);
            }
        });
    }



    static  void greetCustomer(Customer customer) {
        System.out.println("Hello " + customer.customerName
                + ", thanks for registering phone number "
                + customer.customerPhoneNumber);
    }
    static class Customer {
        private final String customerName;
        private final String customerPhoneNumber;

        public Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }
    }

}
