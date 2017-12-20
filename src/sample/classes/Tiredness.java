package sample.classes;

import com.sun.org.apache.xpath.internal.SourceTree;

public class Tiredness extends Thread{
        @Override
        public void run() {
            //этот метод означает, что через определенное кол-во времени человек будет уставать и голодать
            //метод выполняется в background режиме
            while (true) {
                try {
                    sleep(30000);		//Приостанавливает поток на 30 секунд
                    sleep(1000);		//Приостанавливает поток на 20 секунд
                } catch (InterruptedException e) {}

                Student.setSatiety(5);
                Student.setEnergy(4);

                System.out.println(Student.getEnergy());
                System.out.println(Student.getSatiety());
                System.out.println(Student.getUniversity());
            }
            //также если у нас будет реализация времени, то можно реализовать ее здесь
        }
    }


