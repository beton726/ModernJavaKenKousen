package book;

import org.junit.Test;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
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
    }

    @Test
    public void workReturnSql() {
        int count = 0;

        List<String[]> listArr = new ArrayList<>();

        listArr.add(new String[]{"TableName_1", "1"});
        listArr.add(new String[]{"TableName_2", "2"});
        listArr.add(new String[]{"TableName_3", "3"});
        listArr.add(new String[]{"TableName_4", "3"});
        listArr.add(new String[]{"TableName_5", "3"});

        // e_1 в данном выбирает по очереди значения из списка. (.get(0))
        //

        listArr.stream()
                .forEach(e_1 -> Arrays.stream(e_1).skip(1).mapToInt((s) -> Integer.parseInt(s)).toArray());


        List<Integer> arr = listArr.stream()
                .map(e_1 -> Integer.parseInt(e_1[1]))
                .collect(Collectors.toList());



        int sum = listArr.stream()
                .map(e_1 -> Integer.parseInt(e_1[1]))
                .reduce(Integer::sum).orElse(0);

        System.out.println(sum);


        //        for (int i = 0; i < listArr.size(); i++) {
//            String arr = listArr.get(i)[1];
//        }
    }

}