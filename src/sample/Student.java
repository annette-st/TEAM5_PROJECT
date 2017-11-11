package sample;

import java.util.Random;

public class Student {
    int satiety;
    int energy;
    int univer;
    int money;

    public Student(int satiety, int energy, int univer, int money) {
        this.satiety = satiety;
        this.energy = energy;
        this.univer = univer;
        this.money = money;
    }

    public void toHack() {
        int cardID[] = new int[4];
        Random rnd = new Random(System.currentTimeMillis());
        boolean digits[] = new boolean[10];
        for (int i = 0; i < digits.length; i++)
            digits[i] = true;
        for(int i = 0; i < cardID.length; i++) {
            do {
                cardID[i] = rnd.nextInt(10);
            }
            while (digits[cardID[i]] != true);
            digits[cardID[i]] = false;
        }

       // int inputID[] = new int[4];



    }
}
