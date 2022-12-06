import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.lang.Character;

public class Program {

    public static char findRepeatedChar(CharSequence seq1, CharSequence seq2) {
        for (int i = 0; i < seq1.length(); i++) {
            for (int j=0; j < seq2.length(); j++) {
                if (seq1.charAt(i) == seq2.charAt(j)) return seq2.charAt(j);
            }
        }
        return '$';
    }

    public static char findCommonChar(String s1, String s2, String s3) {
        for (int i = 0; i < s1.length(); i++) {
            for (int j=0; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    for (int k=0; k<s3.length(); k++) {
                        if (s2.charAt(j) == s3.charAt(k)) return s3.charAt(k);
                    }
                }
            }
        }
        return '$';
    }

    public static int calcPriority(List<Character> chars) {
        int total = 0;
        for (Character c: chars) {
            //System.out.println(c);
            int value = c;
            value -= c.isLowerCase(c) ? 96 : 38;
            //System.out.println(value);
            total += value;
        }
        return total;
    }

    public static void main(String[] args) {

        try {
            File f = new File("input.txt");
            Scanner s = new Scanner(f);
            List<Character> repeated = new ArrayList<>();
            List<String> group = new ArrayList<>();
            while (s.hasNextLine()) {
                String line = s.nextLine();
                int size = line.length();
                group.add(line);
                // Part 1
                // CharSequence start = line.subSequence(0, size/2);
                // CharSequence end = line.subSequence(size/2, size);
                // System.out.println(line);
                // System.out.println(start);
                // System.out.println(end);

                // repeated.add(findRepeatedChar(start, end));
                
                // Part 2
                if (group.size() == 3) {
                    System.out.println(group);
                    System.out.println(findCommonChar(group.get(0), group.get(1), group.get(2)));
                    repeated.add(findCommonChar(group.get(0), group.get(1), group.get(2)));
                    group = new ArrayList<>();
                }
            }
            System.out.println(repeated);
            System.out.println(calcPriority(repeated));

        } catch (Exception e) {
            System.out.println("Exception detected");
            e.printStackTrace();
        }
    }
}
