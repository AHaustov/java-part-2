import java.util.List;

public class Tarakan implements Runnable {

    final private String name;
    final private int distance;
    final List<Score> scoreList;
    long startingTime;

    public Tarakan(String name, int distance, List<Score> list) {
        this.name = name;
        this.distance = distance;
        this.scoreList = list;
        this.startingTime = 0;
    }

    @Override
    public void run() {
        int i = 0;
        while (i < distance) {
            long sleepDuration = System.currentTimeMillis();
            i++;
            int temp = (int) Math.random() * 50 + 50;
            try {
                Thread.sleep(temp);
                startingTime += System.currentTimeMillis() - sleepDuration;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        scoreList.add(new Score(this.name, this.startingTime));

    }
}
