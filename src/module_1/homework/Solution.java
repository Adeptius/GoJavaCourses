package module_1.homework;

import module_1.homework.strategies.*;
import module_1.homework.util.ConsoleHelper;
import module_1.homework.util.Util;
import java.util.*;
import java.util.concurrent.TimeUnit;

/*
 Домашнее задание к Модулю 1

 Написать программу для сравнения эффективности коллекций:
 Программа должна сравнивать различные имплементации коллекций по эффективности
 выполнения следующих операций:

 List
 add(index)
 get(index)
 remove(index)
 contains(value)
 populate (наполнение коллекции)
 ListIterator.add()
 ListIterator.remove()

 Set
 add(value)
 remove(value)
 contains(value)
 populate (наполнение коллекции)

 Сравнения должны выполнятся на объемах: 10К (10 000) 100К 1000К элементов.
 Для каждого набора (10К, 100К, 1000К) выполнить не менее 100 измерений и
 вычислить среднее значение.
 Результаты измерений вывести на экран и сохранить в файл в виде таблицы:

               add            get            remove         contains       populate       iterator.add   iterator.remove
ArrayList
LinkedList
HashSet
TreeSet
*/


public class Solution {

    /**
     * В данной программе я ограничил количество циклов для теста, так как на моём компьютере
     * тест проводится слишком долго.
     *
     * Также у меня много вопросов по поводу ньансов работы
     * (Например ArrayList get: куда вставлять элементы? В середину или в конец.. и подобные..)
     * по этому неизвесные моменты я решил по своему усмотрению.
     */

    private Collection<Object> currentCollection;
    private TestingStrategy currentStrategy;
    public static int testTimesForCalculateAverageTime = 20; //Количество тестов для бОльшей точности
    public static int testingFirstCycle = 100;   // Количество операций первого теста
    public static int testingSecondCycle = 500;  // Количество операций второго теста
    public static int testingThirdCycle = 10000; // Количество операций третьего теста

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.testAllCollections();
    }

    public void testAllCollections(){
        ConsoleHelper.drawResult();

        // Testing ArrayList
        ConsoleHelper.append("ArrayList");
        currentCollection = new ArrayList<>();
        testList();

        // Testing LinkedList
        ConsoleHelper.append("LinkedList");
        currentCollection = new LinkedList<>();
        testList();

        //Testing HashSet
        ConsoleHelper.append("HashSet");
        currentCollection = new HashSet<>();
        testSet();

        //Testing HashSet
        ConsoleHelper.append("TreeSet");
        currentCollection = new TreeSet<>((o1, o2) -> o1.hashCode()-o2.hashCode());
        testSet();

        Util.saveResultsToFile("D:\\test result.txt");
    }



    private void testList(){
        currentStrategy = new AddByIndexStrategy();
        runTest();
        currentStrategy = new GetByIndexStrategy();
        runTest();
        currentStrategy = new RemoveByIndexStrategy();
        runTest();
        currentStrategy = new ContainsByValueStrategy();
        runTest();
        currentStrategy = new PopulateStrategy();
        runTest();
        currentStrategy = new AddByIteratorStrategy();
        runTest();
        currentStrategy = new RemoveByIteratorStrategy();
        runTest();
        ConsoleHelper.newCollectionTest();
    }

    private void testSet(){
        currentStrategy = new AddByValueStrategy();
        runTest();
        ConsoleHelper.append("");
        currentStrategy = new RemoveByValueStrategy();
        runTest();
        currentStrategy = new ContainsByValueStrategy();
        runTest();
        currentStrategy = new PopulateStrategy();
        runTest();
        ConsoleHelper.append("");
        ConsoleHelper.append("");
        ConsoleHelper.newCollectionTest();
    }

    private void runTest(){
        int firstTest =  checkAverageTime(testingFirstCycle);
        int secondTest = checkAverageTime(testingSecondCycle);
        int thirdTest =  checkAverageTime(testingThirdCycle);
        ConsoleHelper.append(firstTest + "|" + secondTest + "|" + thirdTest);
    }

    private int checkAverageTime(int cycles){
        int totalTime = 0;
        for (int i = 0; i < testTimesForCalculateAverageTime; i++) {
            totalTime += timeOfSingleTest(cycles);
        }
        return totalTime/testTimesForCalculateAverageTime;
    }

    private int timeOfSingleTest(int cycles){
        currentStrategy.prepare(currentCollection, cycles);
        long t = System.nanoTime();
        currentStrategy.execute(currentCollection, cycles);
        return (int) TimeUnit.NANOSECONDS.toMicros(System.nanoTime()-t);
    }
}
