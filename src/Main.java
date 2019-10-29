import serialization.Object;
import serialization.ObjectKeeper;

import java.util.ArrayList;
import java.util.List;

/*Создайте пакет serialization.
В нём создайте класс Object с двумя полями: int intValue, String name;
Соответственно пропишите геттеры и сеттеры.
В том же пакете создайте класс ObjectKeeper.
У этого класса должен быть нестатический метод saveObjectList,
принимающий на вход лист объектов нашего класса Object.
Метод должен сохранять лист объектов в файл.
Второй метод – readObjectList() должен возвращать сохранённый
ранее лист объектов. Если ранее ничего не сохранено – он должен
возвращать пустой лист. Объекты в возвращаемом листе должны быть
идентичны объектам в сохранённом листе и храниться по тем же индексам.*/
public class Main {
    public static void main(String[] args) {
        ObjectKeeper objectKeeper = new ObjectKeeper();
        List<Object> list = new ArrayList<>();
        list.add(new Object(1,"name1"));
        list.add(new Object(2,"name2"));
        list.add(new Object(3,"name3"));
        list.add(new Object(4,"name4"));
        list.add(new Object(5,"name5"));

        objectKeeper.saveObjectList(list,"list");

        List<Object> list2 = objectKeeper.readObjectList("list");


        for(Object ob : list2)
            System.out.println(ob);
    }
}
