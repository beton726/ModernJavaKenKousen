package book;

import org.junit.Test;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ChapterFirst {

    List<String> names = Arrays.asList("Grace Hooper", "Tom Vil", "Billy Pen", "Anna Tik");
    List<Person> personList;

    @Test
    public void testRunnable() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Внутри Runnable 1");
            }
        }).start();
    }

    @Test
    public void testRunnableLambda() {
        new Thread(() -> System.out.println("Лямбда выражение.")).start();
    }

    @Test
    public void testRunnableLambda_1() {
        Runnable r = () -> System.out.println("Еще одна реализация");
        new Thread(r).start();
    }

    @Test
    public void testFileNameFilter() {
        File directory = new File("");

        String[] names = directory.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".java");
            }
        });
        System.out.println(Arrays.asList(names));
//      -------------------------------------------------------
        String[] name_1 = directory.list((dir, name) -> name.endsWith(".java"));
        System.out.println(Arrays.asList(names));
    }

    @Test
    public void testGenerate() {
        Stream.generate(Math::random)
                .limit(10)
                .forEach(System.out::println);
    }

    @Test
    public void testSortList() {
        List<String> list = Arrays.asList("this", "is", "a");
        List<String> sorted = list.stream()
                .sorted(String::compareTo)
                .collect(Collectors.toList());
        System.out.println(sorted);
    }

    @Test
    public void testStreamLength() {
        Stream.of("this", "of")
                .map(String::length)
                .forEach(System.out::println);
    }

    @Test
    public void testPersonVariableConstr() {
        personList = names.stream()
                .map(name -> name.split(" "))
                .map(Person::new)
                .collect(Collectors.toList());


        for (Person pers : personList) {
            System.out.println(pers.toString());
        }


//        System.out.println("Все объекты: " + Arrays.asList(personList));
    }

}