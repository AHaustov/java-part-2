package fileChanger;

import java.io.IOException;
import java.util.List;

public abstract class FileAction {

    final FileOperations fileOperations;

    protected FileAction(FileOperations fileOperations) {
        this.fileOperations = fileOperations;
    }

    protected abstract List<String> perform(List<String> text);

    /**
     * The method receives a filename and must read read the file into a List<String>,calls the perform
     * method, then writes the result back to the file.
     *
     * @param filename name of the file to handle.
     */
    public void handleFile(String filename) throws IOException {
        List<String> text = fileOperations.readList(filename);
        perform(text);
        fileOperations.writeList(text, filename);
    }
}
