package book;

import org.junit.Test;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class ChapterFirst {

    @Test
    public void testRun() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Внутри Runnable 1");
            }
        }).start();
    }

    @Test
    public void testRunLambda() {
        new Thread(() -> System.out.println("Лямбда выражение.")).start();
    }

    @Test
    public void testRunLambda_1() {
        Runnable r = () -> System.out.println("Еще одна реализация");
        new Thread(r).start();
    }

    @Test
    public void fileNameFilter() {
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

}