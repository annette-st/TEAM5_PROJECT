package sample.classes;

public class Tiredness1 extends Thread{
    @Override
        public void run() {
            //этот метод означает, что через определенное кол-во времени человек будет уставать и голодать
            //метод выполняется в background режиме
            while (true) {
                try {
                    		//Приостанавливает поток на 30 секунд
                   sleep(1); //Приостанавливает поток на 20 секунд


                } catch (InterruptedException e) {}


            }
            //также если у нас будет реализация времени, то можно реализовать ее здесь
        }
}


