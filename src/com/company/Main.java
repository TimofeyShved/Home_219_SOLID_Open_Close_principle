package com.company;

// каждый модуль должен быть открыт для расшерения и закрыт для модификации
// вот пример кода, котороый будет полным говно-кодом (так делать нельзя!)
// Всё потому что придётся каждый раз переписывать код и добовлять классу новые требования от заказчика
// соответсвенно увеличивается класс Toyota и метод с проверкой workInTaxi

/*
public class Main {

    public static void main(String[] args) {
        Toyota toyota = new Toyota();
        workInTaxi(toyota);
        Celica celica = new Celica();
        workInTaxi(celica);
    }

    // а тут мы проверем спортивная она или нет
    static void workInTaxi(Toyota toyota){
        // пренадлежит спротивноуму классу?
        if (toyota instanceof Celica){
            toyota.getPassanger();
        }else {
            toyota.getPassangers();
        }
    }
}

// например есть класс Toyota, у которой есть в линейке 2 модели,
// на 2 и 4 двери и они по разному работают
class Toyota{
    void getPassangers(){
        System.out.println("get passangers");
    }
    void getPassanger(){
        System.out.println("get passanger");
    }
}

// есть класс Celica, это вид марки Toyota
class Celica extends Toyota{
    void getCelica(){
        System.out.println("sport car");
    }
}

 */

// а как же сделать его расшеряемым? А всё просто:

public class Main {

    public static void main(String[] args) {
        Toyota toyota = new Toyota();
        workInTaxi(toyota);
        Celica celica = new Celica();
        workInTaxi(celica);
    }

    static void workInTaxi(Toyota toyota){
        toyota.workInTaxi();
    }
}

interface Car{
    void workInTaxi();
}

// например есть класс Toyota
class Toyota implements Car{
    @Override
    public void workInTaxi() {
        getPassangers();
    }

    void getPassangers(){
        System.out.println("get passangers");
    }
}

// есть класс Celica, это вид марки Toyota
class Celica extends Toyota{
    void getCelica(){
        System.out.println("sport car");
    }

    @Override
    public void workInTaxi() {
        getPassanger();
    }

    void getPassanger(){
        System.out.println("get passanger");
    }
}

// теперь если появяться новые требования,
// нужно будет только в новом классе, прописывать новый код (＃￣ω￣)