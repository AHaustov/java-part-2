package fileChanger;

import fileChanger.action.CapitalLettersFileAction;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        CapitalLettersFileAction test=new CapitalLettersFileAction(new FileOperations());

        test.handleFile("test.txt");
    }
}
