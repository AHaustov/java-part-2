public class ChaThread implements Runnable{

    final int times;
    final char ch;

    public ChaThread(int times, char ch) {
        this.times = times;
        this.ch = ch;
    }

    @Override
    public void run() {
        System.out.println("This is Runnable Thread");
        for (int i = 0; i < times; i++) {
            System.out.println(ch);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
