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
    public PrintWriter printWriter(@Value("${de.haust.string_operation.output.file.path}") String output) throws FileNotFoundException {
        return new PrintWriter(new FileOutputStream(output));
    }

    @Bean
    public OperationContext context(List<IStringOperation> operations) {
        return new OperationContext(operations);
    }


}
