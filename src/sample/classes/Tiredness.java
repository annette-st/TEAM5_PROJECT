package sample.classes;

public class Tiredness extends Thread{
        @Override
        public void run() {
            //этот метод означает, что через определенное кол-во времени человек будет уставать и голодать
            //метод выполняется в background режиме
            while (true) {
                try {
                    sleep(30000);		//Приостанавливает поток на 30 секунд
                } catch (InterruptedException e) {}

                Student.setSatiety(5);
                Student.setEnergy(4);
            }
            //также если у нас будет реализация времени, то можно реализовать ее здесь
        }
    }


