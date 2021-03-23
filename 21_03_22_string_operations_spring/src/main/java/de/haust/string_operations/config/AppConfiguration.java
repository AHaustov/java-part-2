package de.haust.string_operations.config;

import de.haust.string_operations.OperationContext;
import de.haust.string_operations.service.StringHandler;
import de.haust.string_operations.service.operation.IStringOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;

@Configuration
public class AppConfiguration {

    @Bean
    public PrintWriter printWriter() throws FileNotFoundException {
        return new PrintWriter(new FileOutputStream("output.txt"));
    }

    @Bean
    public OperationContext context( List<IStringOperation> operations) {
        return new OperationContext(operations);
    }

    @Bean
    public StringHandler handler(OperationContext context,
                                 PrintWriter printWriter,
                                 @Value("${SEPARATOR}") String separator,
                                 @Value("${WRONG_OPERATION}") String wrongOperation,
                                 @Value("${WRONG_FORMAT}") String wrongFormat) {
        return new StringHandler(context, printWriter, separator, wrongOperation, wrongFormat);
    }
}
