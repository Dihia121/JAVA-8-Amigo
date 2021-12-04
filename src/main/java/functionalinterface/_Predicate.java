package functionalinterface;

import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {

        System.out.println("WITHOUT Predicate");
        System.out.println(isPhoneNumberValid("07000000000"));
        System.out.println(isPhoneNumberValid("09 000000000"));

        System.out.println("WITH Predicate");
        System.out.println(isPhoneNumberValidPredicate.test("09 000000000"));

        System.out.println("isPhoneNumberValid and contains number 3 = "
                + isPhoneNumberValidPredicate.and(containsNumber3).test("07000000003"));

        System.out.println("isPhoneNumberValid and contains number 3 = "
                + isPhoneNumberValidPredicate.or(containsNumber3).test("07000000004"));
    }




    static boolean isPhoneNumberValid (String phoneNumber) {
        return phoneNumber.startsWith("07") && phoneNumber.length() == 11;
    }

    static Predicate<String> isPhoneNumberValidPredicate =
            phoneNumber -> phoneNumber.startsWith("07") && phoneNumber.length() == 11;

    static Predicate<String> containsNumber3 = phoneNumber ->
        phoneNumber.contains("3");
}
