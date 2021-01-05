import java.util.Comparator;

public class Human {

    boolean isMedicalPersonal;
    int age;

    public Human(boolean isMedicalPersonal, int age) {
        this.isMedicalPersonal = isMedicalPersonal;
        this.age = age;
    }
}

class CoronaComparator implements Comparator<Human> {

    @Override
    public int compare(Human h1, Human h2) {

        if (h1.isMedicalPersonal && h2.isMedicalPersonal ||
                !h1.isMedicalPersonal && h2.isMedicalPersonal)
            return h1.age - h2.age;

        if (h1.isMedicalPersonal)
            return 1;
        else
            return -1;
    }
}