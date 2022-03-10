package book;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Person {

    private String name;

    public Person(String... name) {
        this.name = Arrays.stream(name)
                .collect(Collectors.joining(" "));
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}