package Model.Account;

public class AccountPartner extends Account{

    private String type;


    public AccountPartner() {
    }

    public AccountPartner(String type, String name, String passWord, String phoneNumber, String email) {
        super(name, passWord, phoneNumber, email);
        this.type = type;
    }



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return this.type + ": "+ super.getName()+", "+ "Số điện thoại: "+ super.getPhoneNumber()+", email: "+super.getEmail();
    }
}
