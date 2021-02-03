package fileChanger.action;

import fileChanger.FileAction;
import fileChanger.FileOperations;

import java.util.ArrayList;
import java.util.List;

public class ReplaceFileAction extends FileAction {
    private final String pattern;
    private final String target;

    protected ReplaceFileAction(FileOperations fileOperations, String pattern, String target) {
        super(fileOperations);
        this.pattern = pattern;
        this.target = target;
    }

    /**
     * Replace all occurences of 'pattern' to 'target'
     *
     * @param text
     * @return
     */

    @Override
    protected List<String> perform(List<String> text) {
        List<String> res = new ArrayList<>();
        for (String string : text) {
            res.add(string.replace(pattern, target));
        }
        return res;
    }
}
