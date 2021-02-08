import java.util.List;
import java.util.Random;

public class Worker extends Thread {

    private final String name;
    private final int maxTime;
    private final int minTime;
    private final boolean stable;
    private boolean boost;
    private final int workingPapers;
    Random random = new Random();
    private final long workingTime;
    private final List<Score> finished;

    public Worker(String name, int min, int max, boolean stable, int workingPapers, long workingTime, List<Score> list) {
        this.name = name;
        this.minTime = min;
        this.maxTime = max;
        this.stable = stable;
        this.workingPapers = workingPapers;
        this.workingTime = workingTime;
        this.finished = list;
    }

    @Override
    public void run() {
        if (stable) {
            stableWorker();
        } else {
            unstableWorker();
        }
        finished.add(new Score(name, (int) (System.currentTimeMillis() - workingTime)));
    }

    private void stableWorker() {
        for (int i = 0; i < workingPapers; i++) {
            try {
                Thread.sleep(randomTime(minTime, maxTime));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void unstableWorker() {
        int time;
        int boostCount = 0;
        for (int i = 0; i < workingPapers; i++) {
            if (boost) {
                time = random.nextInt(51) + 50;
                boostCount++;
                if (boostCount == 3) {
                    boost = false;
                    boostCount = 0;
                }
            } else {
                if (random.nextInt(100) < 20) {
                    boost = true;
                    time = random.nextInt(51) + 50;
                    boostCount++;
                } else {
                    time = randomTime(minTime, maxTime);
                }
            }
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    private int randomTime(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

}
