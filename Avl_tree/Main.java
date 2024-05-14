package Avl_tree;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        AVL_Tree avlTree = new AVL_Tree();
        Random random = new Random();
        int[] array = new int[10000];

        // генерация случайной последовательности из 10000 чисел
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt();
        }

//        System.out.println(Arrays.toString(array)); вывод массива
        // добавление элементов в дерево с замером времени и количества операций
        long startTime = System.nanoTime();
        int operationsCount = 0;
        for (int i = 0; i < array.length; i++) {
            avlTree.insert(array[i]);
            operationsCount += avlTree.getSize(); // увеличение счетчика операций на размер дерева после каждой вставки
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        // вывод результатов
        System.out.println("Добавление элементов в дерево:");
        System.out.println("Время выполнения: " + duration + " нс");
        System.out.println("Количество операций: " + operationsCount);
        System.out.println();

        // поиск случайных 100 элементов в дереве с замером времени и количества операций
        int[] searchArray = new int[100];
        for (int i = 0; i < searchArray.length; i++) {
            searchArray[i] = array[random.nextInt(array.length)];
        }
        startTime = System.nanoTime();
        operationsCount = 0;
        for (int i = 0; i < searchArray.length; i++) {
            avlTree.contains(searchArray[i]);
            operationsCount += avlTree.getSize(); // увеличение счетчика операций на размер дерева после каждого поиска
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;

        // вывод результатов
        System.out.println("Поиск элементов в дереве:");
        System.out.println("Время выполнения: " + duration + " нс");
        System.out.println("Количество операций: " + operationsCount);
        System.out.println();

        // удаление случайных 1000 элементов из дерева с замером времени и количества операций
        int[] removeArray = new int[1000];
        for (int i = 0; i < removeArray.length; i++) {
            removeArray[i] = array[random.nextInt(array.length)];
        }
        startTime = System.nanoTime();
        operationsCount = 0;
        for (int i = 0; i < removeArray.length; i++) {
            avlTree.remove(removeArray[i]);
            operationsCount += avlTree.getSize(); // увеличение счетчика операций на размер дерева после каждого удаления
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;

        // вывод результатов
        System.out.println("Удаление элементов из дерева:");
        System.out.println("Время выполнения: " + duration + " нс");
        System.out.println("Количество операций: " + operationsCount);
    }
}
