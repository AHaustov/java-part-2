import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Score> championship = new ArrayList<>();
        Tarakan red = new Tarakan("red", 100, championship);
        Tarakan blue = new Tarakan("blue", 100, championship);
        Tarakan yellow = new Tarakan("yellow", 100, championship);
        Tarakan pink = new Tarakan("pink", 100, championship);
        Tarakan brown = new Tarakan("brown", 100, championship);

        Thread redTh = new Thread(red);
        Thread blueTh = new Thread(blue);
        Thread yellowTh = new Thread(yellow);
        Thread pinkTh = new Thread(pink);
        Thread brownTh = new Thread(brown);

        redTh.start();
        blueTh.start();
        yellowTh.start();
        pinkTh.start();
        brownTh.start();

        redTh.run();
        blueTh.run();
        yellowTh.run();
        pinkTh.run();
        brownTh.run();


        while (redTh.isAlive() || blueTh.isAlive() || yellowTh.isAlive() || pinkTh.isAlive() || brownTh.isAlive())
            Thread.currentThread().join();
        Collections.sort(championship);
        System.out.println(championship);


    }
}
