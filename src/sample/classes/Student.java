package sample.classes;

import sample.controllers.AtmController;

import java.util.Random;
import java.util.Scanner;


public class Student {
    Scanner scanner = new Scanner(System.in);

    static double satiety; //сытость
    static double energy; //энергия
    static double university; // успеваемость и рейтинг в универе ы
    int money; // деньги
    int input; // number entered in ATM when hacking

    public Student(double satiety, double energy, double university, int money) {
        this.satiety = satiety;
        this.energy = energy;
        this.university = university;
        this.money = money;
    }
    public void toSleep() {
        energy = randomPlus(energy,70,60);
        satiety = randomMinus(satiety,50, 30);
        university = randomMinus(university, 20, 10);
        events(15, energy, university, 50, 30);
    }

    public void toStudy() {
        university = randomPlus(university, 35, 20);
        minusMoney(25);
        energy = randomMinus(energy, 40, 20);
        satiety = randomMinus(satiety,40,20);
        events(15, energy, university, 25, 15);
    }

    public void toEat() {
        int restaurant = 0;
        int medicine = 0;
//        switch (restaurant) {
//            case 1: //добрая
//                randomMinusMoney(200, 100);
//                energy = randomPlus(energy,5,2);
//                satiety = randomPlus(satiety,30, 15);
//                events(15, university, energy, medicine,40, 30, 400, 200);
//                break;
//            case 2: //ханума
//                randomMinusMoney(250,100);
//                energy = randomPlus(energy, 7, 4);
//                satiety = randomPlus(satiety, 40, 20);
//                events(15, university, energy, medicine,40, 30, 400, 200);
//                break;
//            case 3: //дошик
//                randomMinusMoney(50, 20);
//                energy = randomPlus(energy,3,1);
//                satiety = randomPlus(satiety,15, 5);
//                events(15, university, energy, medicine,40, 30, 400, 200);
//                break;
//            case 4: //макдональдс
//                randomMinusMoney(600, 350);
//                energy = randomPlus(energy,10,5);
//                satiety = randomPlus(satiety,50, 35);
//                events(15, university, energy, medicine,40, 30, 400, 200);
//                break;
//            case 5: //мастер пицца
//                randomMinusMoney(140, 100);
//                energy = randomPlus(energy,5,2);
//                satiety = randomPlus(satiety,30, 20);
//                events(15, university, energy, medicine,40, 30, 400, 200);
//                break;
//        }
        randomMinusMoney(250,100);
        energy = randomPlus(energy, 7, 4);
        satiety = randomPlus(satiety, 40, 20);
        events(15, university, energy, medicine,40, 30, 400, 200);
    }


    public void toHack(int inputID[]) {

        Random rnd = new Random(System.currentTimeMillis());
        final int ATTEMPTS = 4; //кол-во попыток
        boolean end = false; // конец игры (true - игра кончилась с положительным исходом, false - с отрицательным)
        //что будет выводиться

        char output[] = new char[4];

        for (int i = 0; i <output.length; i++) {
            output[i] = '*';
            System.out.print(output[i]); ///////////////////////////////////////////
        }
        System.out.println(" "); //////////////////////////////////////////////////

        int cardID[] = new int[4];
        //генерация рандомного числа
        boolean digits[] = new boolean[10];
        for (int i = 0; i < digits.length; i++)
            digits[i] = true;
        for (int i = 0; i < cardID.length; i++) {
            do {
                cardID[i] = rnd.nextInt(10);
            }
            while (digits[cardID[i]] != true);
            digits[cardID[i]] = false;
        }
        //попытка на который сейчас игрок
        int thisAttempt;
        //игра
        for (thisAttempt = 0; thisAttempt < ATTEMPTS; thisAttempt++) {

            //ввод 4-значного числа
            System.out.println("Введите щисло");
            //input =
            // вводимое число

            // формирование числа в массив цифр
            for (int i = 0; i < inputID.length; i++) {
                inputID[inputID.length - i -1] = input;
            }
//            for (int i = 0; i < inputID.length; i++) {
//                inputID[inputID.length - i -1] = input % 10;
//                input /= 10;
//            }
            //нахождение коров
            //цифры - коровы
            boolean cowdigit[] = new boolean[10];
            for (int i = 0; i < cowdigit.length; i++)
                cowdigit[i] = false;

            for (int i = 0; i < cardID.length; i++)
                for (int j = 0; j < inputID.length; j++) {
                    if (cardID[i] == inputID[j] && i != j ) {
                        cowdigit[cardID[i]] = true;
                    }
                }
            //нахождение быков
            for (int i = 0; i < cardID.length; i++) {
                if (inputID[i] == cardID[i]) {
                    output[i] = Character.forDigit(inputID[i], 10);
                    cowdigit[inputID[i]] = false;
                }
            }

            //высчитывание конца игры(проверка на полное совпадение 2 кодов - рандомного и вводимого)
            end = true;

            for (int i = 0; i < cardID.length; i++) {
                if (output[i] != Character.forDigit(cardID[i], 10))
                    end &= false;
            }
            if (end == true) break;

            //принты
            for (int i = 0; i < output.length; i++) {
                System.out.print(output[i]);
            }
            System.out.println(" ");
            System.out.print("Коровы: ");
            for (int i = 0; i < cowdigit.length; i++){
                if (cowdigit[i] == true)
                    System.out.print(i + " ");
            }
            System.out.println(" ");
            for(int i = 0; i < inputID.length; i++) {
                System.out.println(inputID[i]);
            }
        }

        if (end == true) {// действие при конце игры с положительным исходом
            energy = randomMinus(energy, 50, 40);
            satiety = randomMinus(satiety, 40, 30);
            university = randomMinus(university, 20, 10);
            int moneyPoints = 0;
            switch (thisAttempt){
                case 6:
                    randomPlusMoney(moneyPoints, 150, 100);
                case 5:
                    randomPlusMoney(moneyPoints, 150, 100);
                case 4:
                    randomPlusMoney(moneyPoints, 150, 100);
                case 3:
                    randomPlusMoney(moneyPoints, 150, 100);
                case 2:
                    randomPlusMoney(moneyPoints, 150, 100);
                case 1:
                    randomPlusMoney(moneyPoints, 150, 100);
                case 0:
                    randomPlusMoney(moneyPoints, 150, 100);
            }
            eventsMoneyMinus(15, university, energy, moneyPoints, 30, 15);
            System.out.println(":)");
        }
        else { //с отрицательным
            energy = randomMinus(energy, 50, 40);
            satiety = randomMinus(satiety, 40, 30);
            university = randomMinus(university, 20, 10);
            System.out.println(":(");
        }
    }

    public static void setSatiety(double satietyPoints) {
        satiety -= satietyPoints * 0.01;
        //System.out.println(satiety);
    }

    public static void setEnergy(double energyPoints) {
        energy -= energyPoints * 0.01;
        //System.out.println(energy);
    }

    //метод, который добавляет рандомное количесвто единиц к показателю(field) в переделах от min до max
    public double randomPlus(double field, int max, int min) {
        final double MAXIMUM_LEVEL = 1;
        Random rnd = new Random(System.currentTimeMillis());
        double fieldPoints = (min + rnd.nextInt(max-min+1))*0.01;
        if (fieldPoints + field > MAXIMUM_LEVEL) field = MAXIMUM_LEVEL;
            else field += fieldPoints;
        return field;
    }

    //метод, который вычитает рандомное количесвто единиц у показателя(field) в переделах от min до max
    public double randomMinus(double field, int max, int min) {
        final double MINIMUM_LEVEL = 0;
        Random rnd = new Random(System.currentTimeMillis());
        double fieldPoints = (min + rnd.nextInt(max-min+1)) * 0.01;
        if (field - fieldPoints < MINIMUM_LEVEL) field = MINIMUM_LEVEL;
        else field -= fieldPoints;
        return field;
    }

    //метод, который вычитает определенное количесвто единиц(value) от показателя(field) для денег
    public void minusMoney(int value) {
        final int MINIMUM_LEVEL = 0;
        if (money - value < MINIMUM_LEVEL) money = MINIMUM_LEVEL;
        else money -= value;
    }

    //метод, который вычитает рандомное количесвто единиц у показателя(field) в переделах от min до max для денег
    public void randomMinusMoney(int max, int min) {
        final int MINIMUM_LEVEL = 0;
        Random rnd = new Random(System.currentTimeMillis());
        int fieldPoints = min + rnd.nextInt(max-min+1);
        if (money - fieldPoints > MINIMUM_LEVEL) money -= fieldPoints;
            else System.err.println("нищеброд");
    }
    //метод, выдающий рандомное кол-во денег для игрока
    public int randomPlusMoney(int moneyPoints, int min, int max){
        Random rnd = new Random(System.currentTimeMillis());
        moneyPoints = min + rnd.nextInt(max-min+1);
        money -= moneyPoints;
        return moneyPoints;
    }

    //методы ивентов
    public void events(int percent, double field1, double field2, int max, int min) {
        Random rnd = new Random(System.currentTimeMillis());
        int generatedPercent = rnd.nextInt(101);
        if (generatedPercent <= percent) {
            randomMinus(field1, max, min);
            randomMinus(field2, max, min);
        }
    }

    //метод ивентов с деньгами
    public void events(int percent, double field1, double field2, int money, int max, int min, int maxMoney, int minMoney) {
        Random rnd = new Random(System.currentTimeMillis());
        int generatedPercent = rnd.nextInt(101);
        if (generatedPercent <= percent) {
            randomMinus(field1, max, min);
            randomMinus(field2, max, min);
            money = minMoney + rnd.nextInt(maxMoney - minMoney + 1);
            minusMoney(money);
            System.out.println("затрачено" + money);
        }
    }
    //метод ивентов с деньгами с фиксированным значением
    public void eventsMoneyMinus(int percent, double field1, double field2, int money, int max, int min) {
        Random rnd = new Random(System.currentTimeMillis());
        int generatedPercent = rnd.nextInt(101);
        if (generatedPercent <= percent){
            randomMinus(field1, max, min);
            randomMinus(field2, max, min);
            minusMoney(money);
            System.out.println("затрачено" + money);
        }
    }
    public void setInput(int input) {
        this.input = input;
    }

    public static double getSatiety() {
        return satiety;
    }
    public static double getEnergy() {
        return energy;
    }
    public static double getUniversity() {
        return university;
    }
    public int getMoney() {
        return money;
    }
    public int getInput() {
        return input;
    }
}