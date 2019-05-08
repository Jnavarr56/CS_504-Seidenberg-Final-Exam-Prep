import java.util.*;
import java.io.*;
public class MainSortCourses {
    public static void main(String args[]) throws Exception {

        
        Scanner scan = new Scanner(new File("./students.txt"));
        Map<String, ArrayList<String>> organizedRoster = new HashMap<String, ArrayList<String>>();
        while (scan.hasNext()) {
            String[] line = scan.nextLine().split(" ");
            String studentName = line[0];
            String course = line[1];
            if (organizedRoster.containsKey(studentName)) {
                organizedRoster.get(studentName).add(course);
            }
            else {
                ArrayList<String> newCourseList = new ArrayList<String>();
                newCourseList.add(course);
                organizedRoster.put(
                    studentName,
                    newCourseList
                );
            }
        }

        Iterator it = organizedRoster.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, ArrayList<String>> pair = (Map.Entry)it.next();
            System.out.printf("NAME: %s | ENROLLED COURSES: %s\n", pair.getKey(), pair.getValue());
        }
    }
}