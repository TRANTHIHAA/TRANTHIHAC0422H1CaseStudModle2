import Model.Account.AccountManager;
import Model.Login;
import Model.Menu.MainView;
import Model.ReadAndWriteFile;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AccountManager accountManager = new AccountManager();
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        Login login = new Login();
        MainView mainView = new MainView();
        Scanner scanner =new Scanner(System.in);
        int choice;
        do {
            System.out.println("                                      ---------------------------BOOKINGFAKE.COM-----------------------------");
            System.out.println("                                        ---------------------------Giới thiệu-------------------------");

            mainView.displayByAddress();
            System.out.println("                                        1.Đăng kí ");
            System.out.println("                                        2.Đăng nhập");
            System.out.print("                                        => ");
            choice = readAndWriteFile.choice(1,2,scanner);
            switch (choice){
                case 1:
                    accountManager.addNewAccount(scanner);
                    break;
                case 2:
                    login.login(scanner);
                    break;

            }
        }while (choice !=0);



    }
}
