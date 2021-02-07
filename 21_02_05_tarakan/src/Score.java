public class Score implements Comparable<Score> {

    String name;
    long score;

    public Score(String name, long score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {

        return name + " " + score + "\n";
    }

    @Override
    public int compareTo(Score o) {
        return (int) (this.score - o.score);
    }
}
