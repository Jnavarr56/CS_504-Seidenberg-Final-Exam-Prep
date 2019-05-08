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
                int companyNameComparison = companyNameA.compareTo(companyNameB);
                if (companyNameComparison != 0) {
                    return companyNameComparison;
                }

                String personNameA = ((Email) email1).parseEmailName();
                String personNameB = ((Email) email2).parseEmailName();
                int personNameComparison = personNameA.compareTo(personNameB);
                return personNameComparison;
            }
        });

        for (Email email : emails) {
            System.out.printf("%s%s%s\n", 
                email.parseEmailName(), 
                " ".repeat((20 - email.parseEmailName().length())),
                email.parseCompanyName()
            );
        }
    }

}