import java.util.ArrayList;
import java.util.List;

public class Lab06 {

    public int evalRPN(List<String> tokens) {
        // Your implementation here
        return 0;
    }


    public ArrayList<String> getList(int example) throws Exception {
        if (example < 0 || example > 2)
            throw new Exception("Three examples only!");
        ArrayList<String> list = new ArrayList<String>();
        if (example == 0)
            list.addAll(List.of(new String[]{"2", "1", "+", "3", "*"}));
        else if (example == 2)
            list.addAll(List.of(new String[] {""}));
        else
            list.addAll(List.of(new String[] {""}));
        return list;
    }


    public static void main (String [] args) {
        Lab06 lab = new Lab06();
        ArrayList<String> tokens = new ArrayList<String>();
        try {
            for (int example = 0; example < 3; example++)
                System.out.println("Example " + example + " evaludates to " + lab.evalRPN(lab.getList(example)));
        } catch (Exception e) {
            System.out.println("Something went wrong!");
            e.printStackTrace();
        }
    }
}
