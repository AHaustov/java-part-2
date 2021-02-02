import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        FileOperations fileOperations=new FileOperations();

        List<String> strings = Arrays.asList("Hello","World","friends");
        fileOperations.writeStrings(strings,"strings.txt");
    }

    @Test
    public void testWriteReadStrings() throws IOException{
        List<String> strings = Arrays.asList("Hello","World","friends");

    }
}
