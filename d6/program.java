import java.io.File;
import java.util.Scanner;
import java.util.HashSet;

public class program {

    public static void main(String[] args) {
        try {
            File f = new File("input.txt");
            Scanner s = new Scanner(f);
            String line = s.nextLine();
            HashSet<Character> buffer = new HashSet<>();
            for (int i=0; i< line.length(); i++) {
                char c = line.charAt(i);
                if (buffer.contains(c)) buffer.clear();
                buffer.add(c);

                // Part 1
                // if (buffer.size() == 4) {
                //     System.out.println(i+1);
                //     break;
                // }

                // Part 2
                if (buffer.size() == 14) {
                    // Part 1
                    System.out.println(i+1);

                    // Part 2 (should be i+1 but the answer was bugged i think, because we start counting at 0)
                    // System.out.println(i);
                    break;
                }

            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
