import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Program {

    public static void main(String[] args) {
        try {

            File f = new File("input.txt");
            Scanner s = new Scanner(f);
            boolean readingStacks = true;
            ArrayList<Stack<Character>> stacks = new ArrayList<>();

            while(s.hasNextLine()) {
                String line = s.nextLine();
                System.out.println(line);

                if (line.charAt(0) == '#') {
                    readingStacks = false;
                    continue;
                }

                if (readingStacks) {
                    if (stacks.size() == 0) {
                        for (int i = 0; i< line.length(); i++) {
                            stacks.add(new Stack());
                        }
                    }

                    for (int i = 0; i< line.length(); i++) {
                        if (line.charAt(i) != ' ') {
                            stacks.get(i).push(line.charAt(i));
                        }
                    }

                } else {
                    String[] move = line.split("-");
                    int[] parsedmove = {Integer.parseInt(move[0]), Integer.parseInt(move[1]), Integer.parseInt(move[2])};

                    Stack<Character> crates = new Stack();
                    for ( int i = 0; i < parsedmove[0]; i++) {
                        char crate = stacks.get(parsedmove[1]-1).pop();
                        // part 1
                        //stacks.get(parsedmove[2]-1).push(crate);
                        crates.push(crate);
                    }

                    for ( int i = 0; i < parsedmove[0]; i++) {
                        stacks.get(parsedmove[2]-1).push(crates.pop());
                    }
                }

            }

            for (Stack stack: stacks) {
                System.out.println(stack.peek());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
