package sample;

import java.util.Random;
import java.util.Scanner;

public class Student {
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
        //игра

<<<<<<< HEAD
        for (int n = 0; n < attempts; n++) {

=======
        for (int n = 0; n < ATTEMPTS; n++) {
>>>>>>> 18bbfb8d6d56107a195896e8afca0180533c7797
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

        if (end == true) // действие при конце игры с положительным исходом
            System.out.println("Поздравляем! Ты выиграл :З");
        else { //с отрицательным
            System.out.println("игру не выиграл");
        }
    }
}
