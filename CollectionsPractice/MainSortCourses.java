import java.util.*;
import java.io.*;
public class MainSortCourses {
    public static void main(String args[]) throws Exception {

        Scanner scan = new Scanner(new File("./students.txt"));
        Map<String, ArrayList<String>> roster = new TreeMap<String, ArrayList<String>>();
        while (scan.hasNext()) {
            String[] line = scan.nextLine().split(" ");
            String name = line[0];
            String course = line[1];
            if (roster.containsKey(name)) {
                roster.get(name).add(course);
            }
            else {
                ArrayList<String> courseList = new ArrayList<String>();
                courseList.add(course);
                roster.put(name, courseList);
            }
        }
        Iterator it = roster.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, ArrayList<String>> pair = (Map.Entry)it.next();
            System.out.printf("%s %s\n", pair.getKey(), pair.getValue());
        }

        for (Map.Entry pair : roster.entrySet()) {
            System.out.printf("%s %s\n", pair.getKey(), pair.getValue());
        }

        int[] testArr = {1, 3, 3, 4, 5, 6, 6, 7, 8, 3, 5, 6, 6, 6, 6, 4};
        Map<String, Integer> intCounts = new TreeMap<String, Integer>();
        for (int num: testArr) {
            if (intCounts.containsKey(Integer.toString(num))) {
                intCounts.put(
                    Integer.toString(num),
                    new Integer(Integer.valueOf(intCounts.get(Integer.toString(num))) + 1)
                );
            }
            else {
                intCounts.put(
                    Integer.toString(num),
                    new Integer(1)
                );
            }
        }

        System.out.println(intCounts);
    }
}