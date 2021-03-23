package de.haust.string_operations;

import de.haust.string_operations.service.operation.IStringOperation;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

public class OperationContext {

    private final Map<String, IStringOperation> operationByName;

    public OperationContext(List<IStringOperation> operations) {
        operationByName = operations.stream()
                .collect(toMap(IStringOperation::getName, operation -> operation));

//        operationByName = new HashMap<>();
//        for (IStringOperation operation : operations) {
//            operationByName.put(operation.getName(), operation);
//        }
    }

    public IStringOperation getOperation(String name) {
        return operationByName.get(name);
    }
}
