import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.lang.Character;

public class Program {

    public static boolean isOneContained(int[] s1, int[] s2) {
        boolean firstContained = s1[0] >= s2[0] && s1[0] <= s2[1] && s1[1] <= s2[1] && s1[1] >= s2[0];
        boolean secondContained = s2[0] >= s1[0] && s2[0] <= s1[1] && s2[1] <= s1[1] && s2[1] >= s1[0];
        return firstContained || secondContained;
    }

    public static boolean isOverlapped(int[] s1, int[] s2) {
        boolean overlap1 = s1[0] >= s2[0] && s1[0] <= s2[1];
        boolean overlap2 = s1[1] <= s2[1] && s1[1] >= s2[0];
        boolean overlap3 = s2[0] >= s1[0] && s2[0] <= s1[1];
        boolean overlap4 =  s2[1] <= s1[1] && s2[1] >= s1[0];
        return overlap1 || overlap2 || overlap3 || overlap4;
    }

    public static int[] convertToRange(String input) {
        String[] nums = input.split("-");
        int start = Integer.parseInt(nums[0]);
        int end = Integer.parseInt(nums[1]);
        int[] result = {start, end};
        return result;
    }

    public static void main(String[] args) {

        try {
            File f = new File("input.txt");
            Scanner s = new Scanner(f);
            int numContained = 0;
            while (s.hasNextLine()) {
                String line = s.nextLine();
                System.out.println(line);
                String[] split = line.split(",");
                System.out.println(split[0]);
                System.out.println(split[1]);
                //System.out.println( isOneContained(convertToRange(split[0]), convertToRange(split[1])));
                // Part 1
                //if (isOneContained(convertToRange(split[0]), convertToRange(split[1]))) numContained++;
                //Part 2
                System.out.println( isOverlapped(convertToRange(split[0]), convertToRange(split[1])));
                if (isOverlapped(convertToRange(split[0]), convertToRange(split[1]))) numContained++;
            }
            System.out.println(numContained);

        } catch (Exception e) {
            System.out.println("Exception detected");
            e.printStackTrace();
        }
    }
}
