package Model.Account;



import Model.Menu.AdminView;
import Model.Menu.PartnerView;
import Model.Menu.UserView;
import Model.ReadAndWriteFile;

import java.io.*;
import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class AccountManager {
    PartnerView partnerView = new PartnerView();

    ReadAndWriteFile readAndWriteFile =new ReadAndWriteFile();

    public AccountManager() {
    }


    public void addNewAccount(Scanner scanner){
        Account account = null;
        System.out.println("                                                          Hãy điền vào form dưới đây:");
        System.out.println("                                                         -------------------------------");
        System.out.print("                                                            Họ Tên:        ");
        String name = scanner.next();
        System.out.print("                                                            Password:      ");
        String password = scanner.next();
        if (!readAndWriteFile.isExitAccountUser(name,password) && !readAndWriteFile.isExitAccountPartner(name,password)){
            System.out.print("                                                            Số điện thoại: ");
            String phoneNumber;
            while (true){
                phoneNumber = scanner.nextLine();
                Pattern pattern = Pattern.compile("^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$");
                if (pattern.matcher(phoneNumber).find()) {
                    break;
                } else {
                   // System.out.print("Số điện thoại chưa chính xác!");
                }
            }

            System.out.print("                                                            Email:         ");
            String email ;
            while (true){
                email = scanner.nextLine();
                Pattern pattern = Pattern.compile("^[\\w-\\.]+@([gmail]+\\.)+[\\w-]{2,4}$");
                if (pattern.matcher(email).find()){
                    break;
                } else {
                    System.out.println("                                                        Email chưa chính xác, vui lòng nhập lại!");
                    System.out.print("                                                                          ");
                }
            }
            int choice;
            System.out.println("                                                                      ------");
                System.out.println("                                                         1. Bạn muốn trở thành đối tác của chúng tôi?");
                System.out.println("                                                         2. Bạn muốn đặt phòng?");
                System.out.print("                                                           ==> ");
            choice = readAndWriteFile.choice(1,2,scanner);
                switch (choice){
                    case 1: {
                        String type ="";
                        System.out.println("                                                              Bạn đang kinh doanh loại hình gì?  ");
                        System.out.println("                                                                 1.Hotel");
                        System.out.println("                                                                 2.Homestay");
                        System.out.print("                                                                    ");
                        int choice1 = readAndWriteFile.choice(1,2,scanner);
                        switch (choice1) {
                            case 1:
                                type = "Hotel";
                                System.out.println("                                                                 Cho biết thông tin về Khách Sạn của bạn!");
                                //sửa chô này





                                account = new AccountPartner(type, name, password, phoneNumber, email);
                                partnerView.describeHotel((AccountPartner) account);
                                break;
                            case 2:
                                type = "Homestay";
                                System.out.println("                                                                 Cho biết thông tin về Homestay của bạn!");
                                account = new AccountPartner(type, name, password, phoneNumber, email);
                                partnerView.describeHomestay((AccountPartner) account);
                                break;
                        }
//                        account = new AccountPartner(type, name, password, phoneNumber, email);
                    }
                        break;
                    case 2:
                        account = new AccountUser(name,password,phoneNumber,email);
                        break;
                }
            if (account instanceof AccountUser){
                ReadAndWriteFile.getAccountUserList().add((AccountUser) account);

                readAndWriteFile.writeFileAccountUser(ReadAndWriteFile.getAccountUserList());

                System.out.println("                                                                 Đăng kí thành công!");
            }else {
                ReadAndWriteFile.getAccountPartnerList().add((AccountPartner) account);
                readAndWriteFile.writeFileAccountPartner(ReadAndWriteFile.getAccountPartnerList());
                System.out.println("                                                                 Đăng kí thành công!");

            }

        }else {
            System.out.println("                                                                 Tài khoản đã tồn tại!");
        }

    }










}
