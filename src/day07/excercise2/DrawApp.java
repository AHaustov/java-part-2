package day07.excercise2;

public class DrawApp {
    public static void main(String[] args) {
        Shape line1=new Line('*',5);
        Shape ra1= new Rectangle('#',3,3);
        Shape pic1= new Picture('!',line1,ra1);

        pic1.draw();
    }
}
