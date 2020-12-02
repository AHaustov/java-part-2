package introductionMap;

public class ArrayExercise {
    //use map -> collection
    //work with keys
    //count same numbers in array
    // out put that number , where the count is not even


    public static int giveNotEvenCount(int... arr) {
        int output = 0;
        for (int element : arr) {
            output ^= element;
        }
        return output;
    }

}
