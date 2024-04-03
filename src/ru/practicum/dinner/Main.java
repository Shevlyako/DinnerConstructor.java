package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    return;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();
        dc.addDish(dishType, dishName); //После ввода данных переходим к выполнению метода который добавляет блюдо
        // добавьте новое блюдо
    }

    private static void generateDishCombo() {
        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter)." +
                " Для завершения ввода введите пустую строку");
        String nextItem = scanner.nextLine();
        ArrayList<String> typeOfCombos = new ArrayList<>();

        while (!nextItem.isEmpty()) { //заходим в цикл который добавляет тип блюд пока не будет введена пустая строка
            if (dc.dishs.containsKey(nextItem)) { //проверяем есть ли такой тип блюд в нашей HashMap dishs
                typeOfCombos.add(nextItem);
                nextItem = scanner.nextLine(); //снова ждем ввода типа блюда
            } else {
                System.out.println("Вы ввели несуществующий тип блюда, попробуйте ещё раз");
                nextItem = scanner.nextLine(); //если такого типа блюда нет мы об этом сообщаем и ждем нового ввода
            }
        }

        dc.generateOfCombos(numberOfCombos, typeOfCombos);
    }
}
