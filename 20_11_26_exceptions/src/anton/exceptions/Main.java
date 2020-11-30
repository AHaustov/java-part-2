package anton.exceptions;

public class Main {

    static boolean toThrow = false;

    public static void main(String[] args) {
        methodA();


        toThrow = true;
        try {
            System.out.println("before method() call");
            methodA();
            System.out.println("after method() call");
        } catch (AUncheckedExceptions e) {
            System.out.println("Under the catch");
        } catch (Exception e) {
            System.out.println("Under second catch");
            //usually here goes logging in the very end.
        }
        try {
            methodB();
        } catch (BCheckedException e) {
            System.out.println("Under BChecked catch");
        } finally {
            System.out.println("Under finally");
        }

        try {
            methodA();
        } finally {
          //  throw new IndexOutOfBoundsException();
            System.out.println("under second finally");
        }
    }

    static void methodA() {
        if (toThrow)
            throw new AUncheckedExceptions();
    }

    /**
     * Here one can look through the description of the method
     *
     * @throws BCheckedException if ....
     */
    static void methodB() throws BCheckedException {
        if (toThrow)
            throw new BCheckedException();
    }
}
