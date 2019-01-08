package homework.home08012019;

import java.util.Optional;

public class Main {

    private String str = "Hello";
    private String str2 = null;
    private String str3 = new String("Hi");

    public Optional<String> optionalString = Optional.ofNullable(str2);
//    public Optional<String> optionalString2 = Optional.of(str2);

    public static void main(String[] args) {
    Main main = new Main();
//      main.optionalString.ifPresent(System.out::println);
        System.out.println(main.optionalString.orElse("Hi "));

        System.out.println(main.optionalString.orElseGet(()->new String("Hello")));
        System.out.println(main.optionalString.orElseThrow(RuntimeException::new));
    }

}
