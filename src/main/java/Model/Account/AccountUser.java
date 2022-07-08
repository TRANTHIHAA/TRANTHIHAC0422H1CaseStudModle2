package Model.Account;

public class AccountUser extends Account{

    public AccountUser() {
    }

    public AccountUser(String name, String passWord, String phoneNumber, String email) {
        super(name, passWord, phoneNumber, email);
    }

    @Override
    public String toString() {
        return "Tên: "+super.getName()+","+" Số điện thoại: "+super.getPhoneNumber()+","+" email: "+ super.getEmail();
    }
}
