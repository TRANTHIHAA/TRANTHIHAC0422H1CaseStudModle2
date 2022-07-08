package Model.Account;

public class Account {
    private String name;
    private String passWord;
    private String phoneNumber;
    private String email;

    public Account() {
    }

    public Account(String name, String passWord, String phoneNumber, String email) {
        this.name = name;
        this.passWord = passWord;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

}
