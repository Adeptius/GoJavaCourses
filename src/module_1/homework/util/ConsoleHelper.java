package module_1.homework.util;


import module_1.homework.Solution;

public class ConsoleHelper {

    public static StringBuilder builder = new StringBuilder("");

    static{
        builder.append("TimeUnit is: MICROSECONDS\n");
        builder.append("Test is running for: ").append(Solution.testingFirstCycle);
        builder.append("|").append(Solution.testingSecondCycle);
        builder.append("|").append(Solution.testingThirdCycle).append(" operations\n");
        builder.append("All tests repeated " + Solution.testTimesForCalculateAverageTime);
        builder.append(" times for better precision\n");
        builder.append("                 add              get              remove");
        builder.append("           contains         populate         iterator.add     iterator.remove\n");
    }

    public static void drawResult(){
        System.out.println();
        System.out.println();
        System.out.println();
        for (int i = 0; i < 134; i++) {
            System.out.print("-");
        }
        System.out.println();
        System.out.println(builder.toString());
        for (int i = 0; i < 134; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void append(String s){
        if (s.length()<17){
            int needSpases = 17 - s.length();
            for (int i = 0; i < needSpases; i++) {
                s += " ";
            }
        }
        builder.append(s);
        drawResult();
    }

    public static void newCollectionTest(){
        builder.append("\n");
    }
}
