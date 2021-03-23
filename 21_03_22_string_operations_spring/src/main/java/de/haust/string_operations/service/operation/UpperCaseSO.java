package de.haust.string_operations.service.operation;

import org.springframework.stereotype.Service;

@Service
public class UpperCaseSO implements IStringOperation{
    @Override
    public String operate(String line) {
        return line.toUpperCase();
    }

    @Override
    public String getName() {
        return "upper_case";
    }
}
