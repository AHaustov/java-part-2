package de.haust.string_operations.service.operation;

import org.springframework.stereotype.Service;

@Service
public class LowerCaseSO implements IStringOperation{
    @Override
    public String operate(String line) {
        return line.toLowerCase();
    }

    @Override
    public String getName() {
        return "lower_case";
    }
}
