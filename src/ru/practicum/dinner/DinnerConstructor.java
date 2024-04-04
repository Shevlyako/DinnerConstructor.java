package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> dishs = new HashMap<>();

    void addDish(String dishType, String dishName){
        if(dishs.containsKey(dishType)){ // проверяем наличие типа в списке и добавляем наименование блюда
            dishs.get(dishType).add(dishName);
        } else { // в случае отсутствия типа блюда в списке добавляем тип и сразу добавляем блюдо
            ArrayList<String> dishsName = new ArrayList<>();
            dishsName.add(dishName);
            dishs.put(dishType, dishsName);
        }
    }

    void generateOfCombos(int numberOfCombos, ArrayList<String> typeOfCombos) {
        Random random = new Random();
        for(int i = 1; i <= numberOfCombos; i++){ //цикл чтобы создать нужное колличество комбо обедов
            System.out.println("Комбо " + i);
            ArrayList<String> combo = new ArrayList<>();
            for(String type : typeOfCombos){ //здесь проходимся по списку типов блюд которые нужны в комбо обеде
                combo.add(dishs.get(type).get(random.nextInt(dishs.get(type).size())));
                /*здесь вызываем список нужного типа и у него вызываем элемент с рандомным индексом
                 рандом от 0 до размера списка этого типа блюд. и присваиваем это значение в список combo*/
            }
            System.out.println(combo);
        }
    }
}

