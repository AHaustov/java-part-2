package operations;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OperationContext {

    Map<String, IStringOperation> operationByName;

    {
  /*      IStringOperation upperCase = new UpperCaseSO();
        IStringOperation lowerCase = new LowerCaseSO();
        IStringOperation reverse = new ReverseSO();
        IStringOperation random= new RandomSO();
        IStringOperation sort=new SortSO();

        operationByName = new HashMap<>();
        operationByName.put(upperCase.getName(), upperCase);
        operationByName.put(lowerCase.getName(), lowerCase);
        operationByName.put(reverse.getName(), reverse);
        operationByName.put(random.getName(), random);
        operationByName.put(sort.getName(), sort);*/
    }

    public OperationContext(List<String> operationPaths) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        operationByName = new HashMap<>();
        for (String op : operationPaths) {
            IStringOperation temp = (IStringOperation) Class.forName(op).
                    getConstructor().newInstance();
            operationByName.put(temp.getName(), temp);
        }
    }

    public IStringOperation getOperation(String name) {
        return operationByName.get(name);
    }
}
