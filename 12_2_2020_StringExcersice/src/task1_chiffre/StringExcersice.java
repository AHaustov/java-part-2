package task1_chiffre;

public class StringExcersice {
    // line of latin small letters
    // if there are same symbols repeating, change to like "aaaabbcddd"->"a4b2cd2"
    // minimum 3 tests


    static String shortLength(String str) {
        if (str.length() == 0) return str;
        char[] temp = new char[str.length()];
        temp[0] = str.charAt(0);
        int count = 1;
        int position = 0;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == temp[position])
                count++;
            else if (count > 1) {
                temp[++position] = (char) (count + 48);
                count = 1;
                temp[++position] = str.charAt(i);
            } else
                temp[++position] = str.charAt(i);
        }
        if (count > 1)
            temp[++position] = (char) (count + 48);
        char[] result = new char[position + 1];
        for (int i = 0; i <= position; i++) {
            result[i] = temp[i];
        }
        return new String(result);
    }


    /*  public static String shortLength(String str) {
        if (str.length() == 0) return str;
        ArrayList<Symbol> list = new ArrayList<Symbol>();
        list.add(new Symbol(str.charAt(0)));
        for (int i = 1; i < str.length(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).getSymbol() == str.charAt(i)) {
                    list.get(j).plus();
                    break;
                }
                if (j == list.size() - 1) {
                    list.add(new Symbol(str.charAt(i)));
                    break;
                }
            }
        }
        char[] result = new char[list.size() * 2];
        int position = 0;
        for (int i = 0; i < list.size(); i++) {
            result[position++] = list.get(i).getSymbol();
            if (list.get(i).getNumber() > 1 && list.get(i).getNumber() < 10) {
                result[position++] = (char) (list.get(i).getNumber() + 48);
            }
        }
        return new String(result);
    }*/
}
