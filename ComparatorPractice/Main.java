import java.util.*;
import java.io.*;
public class Main {
    public static void main(String args[]) throws Exception {
        Scanner scan = new Scanner(new File("./attendence.txt"));
        ArrayList<Email> emails = new ArrayList<Email>();
        while (scan.hasNext()) {
            emails.add(new Email(scan.nextLine()));
        }
        Collections.sort(emails, new Comparator() {
            public int compare(Object email1, Object email2) {
                String companyNameA = ((Email) email1).parseCompanyName();
                String companyNameB = ((Email) email2).parseCompanyName();
                int companyCompare = companyNameA.compareTo(companyNameB);
                if (companyCompare != 0) {
                    return companyCompare;
                }

                String personNameA = ((Email) email1).parseEmailName();
                String personNameB = ((Email) email2).parseEmailName();
                return personNameA.compareTo(personNameB);
            }
        });
        
        for (Email email : emails) {
            System.out.printf("%s %s\n", email.parseCompanyName(), email.parseEmailName());
        }
    }

}