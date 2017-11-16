package sample.classes;

import java.util.Random;
import java.util.Scanner;


public class Student {
    Random rnd = new Random(System.currentTimeMillis());
    Scanner scanner = new Scanner(System.in);
    int satiety;
    int energy;
    int university;
    int money;

    public Student(int satiety, int energy, int university, int money) {
        this.satiety = satiety;
        this.energy = energy;
        this.university = university;
        this.money = money;
    }

    public void tiredness() throws InterruptedException {
        //этот метод означает, что через определенное кол-во времени человек будет уставать и голодать
        //метод выполняется в background режиме
        while (true) {
            Thread.sleep(3000);
            satiety -= 5;
            energy -= 4;
        }
    }

    public void toSleep() {
        int energyPoints = 60 + rnd.nextInt(70-60+1); //кол-во энергии за один сон
        if (energyPoints + energy > 100) energy = 100;
            else energy +=energyPoints;
    }

    public void toStudy() {
        int universityPoints = 20 + rnd.nextInt(35-20+1);
        if (universityPoints + university > 100) university = 100;
            else university +=universityPoints;
    }

    public void toEat() {
        int restaurant = 0;
        int eatingPoints; //кол-во сытости за один поход в кафешку
        int energyPoints = 3 + rnd.nextInt(10-3+1); //кол-во энергии за один поход в кафешку
        switch (restaurant) {
            case 1: //добрая
                eatingPoints = 15 + rnd.nextInt(30-15+1);
                money -= 100 + rnd.nextInt(200-100+1);
                if (eatingPoints + satiety > 100) satiety = 100;
                    else satiety += eatingPoints;
                if (energyPoints + energy > 100) energy = 100;
                else energy +=energyPoints;
                break;
            case 2: //ханума
                eatingPoints = 20 + rnd.nextInt(40-20+1);
                money -= 100 + rnd.nextInt(250-100+1);
                if (eatingPoints + satiety > 100) satiety = 100;
                    else satiety += eatingPoints;
                if (energyPoints + energy > 100) energy = 100;
                else energy +=energyPoints;
                break;
            case 3: //дошик
                eatingPoints = 5 + rnd.nextInt(15-5+1);
                money -= 20 + rnd.nextInt(50-20+1);
                if (eatingPoints + satiety > 100) satiety = 100;
                else satiety += eatingPoints;
                if (energyPoints + energy > 100) energy = 100;
                else energy +=energyPoints;
                break;
            case 4: //макдональдс
                eatingPoints = 35 + rnd.nextInt(50-35+1);
                money -= 350 + rnd.nextInt(600-350+1);
                if (eatingPoints + satiety > 100) satiety = 100;
                else satiety += eatingPoints;
                if (energyPoints + energy > 100) energy = 100;
                else energy +=energyPoints;
                break;
            case 5: //мастер пицца
                eatingPoints = 20 + rnd.nextInt(30-20+1);
                money -= 100 + rnd.nextInt(140-100+1);
                if (eatingPoints + satiety > 100) satiety = 100;
                else satiety += eatingPoints;
                if (energyPoints + energy > 100) energy = 100;
                else energy +=energyPoints;
                break;
        }
    }

    public void toHack() {

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
            int input = scanner.nextInt();                      // вводимое число
            int inputID[] = new int[4];

            // формирование числа в массив цифр
            for (int i = 0; i < inputID.length; i++) {
                inputID[inputID.length - i -1] = input % 10;
                input /= 10;
            }
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
            if (inputID[0] == cardID[0]) {
                output[0] = Character.forDigit(inputID[0], 10);
                cowdigit[inputID[0]] = false;
            }
            if (inputID[1] == cardID[1]) {
                output[1] = Character.forDigit(inputID[1], 10);
                cowdigit[inputID[1]] = false;
            }
            if (inputID[2] == cardID[2]) {
                output[2] = Character.forDigit(inputID[2], 10);
                cowdigit[inputID[2]] = false;
            }
            if (inputID[3] == cardID[3]) {
                output[3] = Character.forDigit(inputID[3], 10);
                cowdigit[inputID[3]] = false;
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
        }

        if (end == true) {// действие при конце игры с положительным исходом
            System.out.println("затащил");
            this.money += 500 + rnd.nextInt(1000-500+1);
        }
        else { //с отрицательным
            System.out.println("игру не выиграл");
        }
    }
}
