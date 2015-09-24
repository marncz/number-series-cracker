import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String input = "";
        while (!input.equals("END")) {
            System.out.print("Enter series: ");
            input = BIO.getString();
            System.out.println();

            input = input.replaceAll("\\s+", ""); // Removes all spaces
            input = input.replaceAll("\\;+", ","); // Changes ; to commas

            String[] array = input.split(",");
            ArrayList < Double > int_list = new ArrayList < Double > ();

            for (int i = 0; i < array.length; i++) {
                int_list.add(Double.parseDouble(array[i]));
            }

            Cracker serie = new Cracker(int_list);

        }

    }


}
