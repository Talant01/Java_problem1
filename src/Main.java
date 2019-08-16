import java.io.File ;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("input.txt"));
        Scanner pattern = new Scanner(new File("pattern.txt"));

        ArrayList<String> b = new ArrayList<>();
        ArrayList<String> c = new ArrayList<>();

        while (input.hasNextLine()) b.add(input.nextLine());

        while (pattern.hasNextLine()) c.add(pattern.nextLine());

        for (String to : b) {
            if (c.contains(to)) {
                System.out.println(to);
                continue;
            }
            if (args.length == 0) continue;
            if (args[0].equals("2")) {
                for (int i = 0; i < to.length(); i++) {
                    if (c.contains(to.substring(0, i + 1))) {
                        System.out.println(to.substring(0, i + 1));
                        break;
                    }
                }
            }
            if (args[0].equals("3")) {
                for (String s : c)
                    if (check(to, s) || check(s, to)) System.out.println(to);
            }
        }
    }

    static boolean check (String a,String b) {
        boolean flag = false;
        for (int i = 0; i < a.length(); i ++) {
            String deleted = a.substring(0,i) + a.substring(i + 1);
            if (b.equals(deleted)) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}
