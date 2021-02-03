package fileChanger.action;

import fileChanger.FileAction;
import fileChanger.FileOperations;

import java.util.ArrayList;
import java.util.List;

public class CapitalLettersFileAction extends FileAction {

    protected CapitalLettersFileAction(FileOperations fileOperations) {
        super(fileOperations);
    }

    @Override
    protected List<String> perform(List<String> text) {
        List<String> res = new ArrayList<>();
        for (String string : text) {
            res.add(string.toUpperCase());
        }
        return res;
    }
}
