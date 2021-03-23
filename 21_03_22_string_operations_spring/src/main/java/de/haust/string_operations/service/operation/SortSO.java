package de.haust.string_operations.service.operation;

import org.springframework.stereotype.Service;

import java.util.Arrays;
@Service
public class SortSO implements IStringOperation {
    @Override
    public String operate(String line) {
        char[] res=line.toCharArray();
        Arrays.sort(res);
        return new String(res);
    }

    @Override
    public String getName() {
        return "sort";
    }
}
