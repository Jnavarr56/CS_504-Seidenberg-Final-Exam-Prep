
public class Email {

    private String emailStr;

    public Email() {  }

    public Email(String emailStr) {
        this.emailStr = emailStr;
    }

    public String parseEmailName() {
        return emailStr.substring(0, emailStr.indexOf('@'));
    }

    public String parseCompanyName() {
        return emailStr.substring(emailStr.indexOf('@') + 1, emailStr.lastIndexOf('.'));
    }

    public String parseExtension() {
        return emailStr.substring(emailStr.lastIndexOf('.') + 1,emailStr.length());
    }

    public String getEmailStr() {
        return emailStr;
    }

}