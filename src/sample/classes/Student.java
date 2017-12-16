package sample.classes;

import sample.controllers.AtmController;

import java.util.Random;
import java.util.Scanner;


public class Student {
    Scanner scanner = new Scanner(System.in);
    Tiredness1 tiredness1 = new Tiredness1();
    Tiredness2 tiredness2 = new Tiredness2();

    static double satiety; //сытость
    static double energy; //энергия
    static double university; // успеваемость и рейтинг в универе ы
    int money; // деньги
    int input; // number entered in ATM when hacking

    boolean cowdigit[] = new boolean[10];

    public boolean[] getCowdigit() {
        return cowdigit;
    }

    public Student(double satiety, double energy, double university, int money) {
        this.satiety = satiety;
        this.energy = energy;
        this.university = university;
        this.money = money;
    }
    public void toSleep() {
        energy = randomPlus(energy,15,10);
        satiety = randomMinus(satiety,10, 5);
        university = randomMinus(university, 5, 5);
        events(15, energy, university, 50, 30);
    }

    public void toStudy() {
        university = randomPlus(university, 15, 10);
        minusMoney(25);


        energy = randomMinus(energy, 10, 5);
        satiety = randomMinus(satiety, 15, 10);;
        events(15, energy, university, 25, 15);

    }

    int restaurant = 0;

    public void toEat() {
        int medicine = 0;
        switch (restaurant) {
            case 1: //добрая
                randomMinusMoney(12, 7);
                energy = randomPlus(energy,1,1);
                satiety = randomPlus(satiety,12, 9);
                events(15, university, energy, medicine,40, 30, 400, 200);
                break;
            case 2: //ханума
                randomMinusMoney(16,9);
                energy = randomPlus(energy, 3, 2);
                satiety = randomPlus(satiety, 17, 10);
                events(15, university, energy, medicine,40, 30, 400, 200);
                break;
            case 3: //дошик
                randomMinusMoney(10, 5);
                energy = randomPlus(energy,3,1);
                satiety = randomPlus(satiety,12, 5);
                events(15, university, energy, medicine,40, 30, 400, 200);
                break;
            case 4: //макдональдс
                randomMinusMoney(15, 12);
                energy = randomPlus(energy,3,1);
                satiety = randomPlus(satiety,15, 10);
                events(15, university, energy, medicine,40, 30, 400, 200);
                break;
            case 5: //мастер пицца
                randomMinusMoney(10, 5);
                energy = randomPlus(energy,1,1);
                satiety = randomPlus(satiety,10, 5);
                events(15, university, energy, medicine,40, 30, 400, 200);
                break;
            case 6: //air
                randomMinusMoney(5, 0);
                energy = randomPlus(energy,0,0);
                satiety = randomPlus(satiety,5, 1);
                events(15, university, energy, medicine,40, 30, 400, 200);
                break;
        }
//        randomMinusMoney(20,5);
//        energy = randomPlus(energy, 3, 1);
//        satiety = randomPlus(satiety, 15, 10);
//        university = randomMinus(university, 5, 5);
//        events(15, university, energy, medicine,40, 30, 400, 200);
    }


    public char[] toHackBulls(int enteredNumber, int[] cardID) {
        char[] output = new char[]{'*','*','*','*'};
        int[] inputID = new int[4];

        int digit = 0;
        for (int i = inputID.length; i < 0; i--) {
            digit = enteredNumber % 10;
            enteredNumber /= 10;
            inputID[i] = digit;
        }
//        for (int i = 0; i <output.length; i++) {
//            output[i] = '*';
//            System.out.print(output[i]); ///////////////////////////////////////////
//        }
        //нахождение коров
        //цифры - коровы

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
        return output;
    }


    public int[] toHackGeneration() {

        int[] cardID = new int[4];
        Random rnd = new Random(System.currentTimeMillis());
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
        return cardID;
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
        if (field == 0) {
            tiredness1.start();
            tiredness2.start();
        }
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
        if (money - fieldPoints < MINIMUM_LEVEL) money = 0;
            else money -= fieldPoints;
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
    public void setRestaurant(int restaurant) {
        this.restaurant = restaurant;
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