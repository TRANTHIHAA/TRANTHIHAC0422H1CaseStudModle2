package Model;
import Model.Account.AccountManager;
import Model.Account.Account;
import Model.Account.AccountPartner;
import Model.Account.AccountUser;
import Model.Menu.AdminView;
import Model.Menu.PartnerView;
import Model.Menu.UserView;
import java.util.List;
import java.util.Scanner;

public class Login {
    ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();

    AdminView adminView = new AdminView();
    UserView userView = new UserView();
    PartnerView partnerView = new PartnerView();




    public void login(Scanner scanner){
//        Account account;
        System.out.println("                                                 ----------------Form Đăng Nhập----------------                                ");
        System.out.print("                                                      Nhập tên: ");
        String name = scanner.next();
        System.out.print("                                                      Nhập password: ");
        String password = scanner.next();
        if (name.equals("HA") && password.equals("12345")){
            adminView.runByAdmin();
        }else if (readAndWriteFile.isExitAccountUser(name,password)){
            for (int i = 0; i < ReadAndWriteFile.getAccountUserList().size(); i++) {
                if (ReadAndWriteFile.getAccountUserList().get(i).getName().equals(name)&& ReadAndWriteFile.getAccountUserList().get(i).getPassWord().equals(password)){
                    userView.runSystemByUser(ReadAndWriteFile.getAccountUserList().get(i));
                }
            }
        }else if (readAndWriteFile.isExitAccountPartner(name,password)){

            for (int i = 0; i < ReadAndWriteFile.getAccountPartnerList().size(); i++) {
                if (ReadAndWriteFile.getAccountPartnerList().get(i).getName().equals(name)&& ReadAndWriteFile.getAccountPartnerList().get(i).getPassWord().equals(password)){
                    partnerView.runSystemByPartner(ReadAndWriteFile.getAccountPartnerList().get(i));
                }
            }
        } else {
            System.out.println("                                                      Tài khoản chưa được đăng kí!");
        }
    }
}
