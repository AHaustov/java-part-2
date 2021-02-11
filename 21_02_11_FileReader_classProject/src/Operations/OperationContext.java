package Operations;

import java.util.HashMap;
import java.util.Map;

public class OperationContext {

    Map<String, IStringOperation> operationByName;

    {
        IStringOperation upperCase = new UpperCaseSO();
        IStringOperation lowerCase = new LowerCaseSO();
        IStringOperation reverse = new ReverseSO();
        IStringOperation random= new RandomSO();
        IStringOperation sort=new SortSO();

        operationByName = new HashMap<>();
        operationByName.put(upperCase.getName(), upperCase);
        operationByName.put(lowerCase.getName(), lowerCase);
        operationByName.put(reverse.getName(), reverse);
        operationByName.put(random.getName(), random);
        operationByName.put(sort.getName(), sort);
    }

    public IStringOperation getOperation(String name) {
        return operationByName.get(name);
    }
}
