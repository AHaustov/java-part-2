import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Tanja 100-200
        //Peter 200-300
        //Tom 200-300 , bei 20% fur 3 Runden 50-100

        List<Score> breakTime = new ArrayList<>();

        Worker tanja = new Worker("Tanja", 100, 200, true,
                20, System.currentTimeMillis(), breakTime);
        Worker peter = new Worker("Peter", 200, 300, true,
                20, System.currentTimeMillis(), breakTime);
        Worker tom = new Worker("Tom", 200, 300, false,
                20, System.currentTimeMillis(), breakTime);

        Worker[] bank = {tanja, peter, tom};

        for (int i = 0; i < bank.length; i++) {
            bank[i].start();
        }
        for (int i = 0; i < bank.length; i++) {
            bank[i].join();
        }

        for (int i = 0; i < bank.length; i++) {
            System.out.println((i + 1) + ". " + breakTime.get(i).name + " " + breakTime.get(i).workTime);
        }
    }
}
