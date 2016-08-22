package module_1.homework.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Util {

    public static void fullFillCollection(Collection<Object> collection, int counts){
        collection.clear();
        for (int i = 0; i < counts; i++) {
            collection.add(new Object());
        }
    }

    public static List<String> getTestResult(){
        ArrayList<String> list = new ArrayList<>();
        String res = ConsoleHelper.builder.toString();
        String[] arr = res.split("\n");
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        return list;
    }

    public static void saveResultsToFile(String destination) {
        Path path = Paths.get(destination);

        try {
            Files.write(path, getTestResult(), StandardOpenOption.CREATE);
            System.out.println("Test result is saved to: " + destination);
        } catch (IOException e) {
            System.err.print("Error while saving test result to file: " + e.toString());
        }
    }
}
