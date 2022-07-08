package Model.Menu;



import Model.Account.AccountManager;
import Model.Account.AccountPartner;
import Model.Account.AccountUser;
import Model.BillHomestay;
import Model.BillHotel;
import Model.Partner.Homestay;
import Model.Partner.Hotel;
import Model.Partner.Partner;
import Model.ReadAndWriteFile;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class AdminView {
    UserView userView = new UserView();
    AccountManager accountManager = new AccountManager();
    ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
//    public int CheckPartnerInformation(Partner partner,Scanner scanner){
//        System.out.println("Addmin oi co doi tac moi");
//        System.out.println();
//        System.out.println("1. Dong y");
//        System.out.println("0.ko dong y");
//        System.out.print("=>");
//        int choice = readAndWriteFile.choice(0,1,scanner);
//        if (choice == 1){
//
//        }
//
//
//    }
    public void RevenueForTheMonth(){
        double turnover = 0;
        int count = 0;
        for (BillHomestay billHomestay : ReadAndWriteFile.getBillHomestayList()) {
            if (billHomestay.getCheckoutDate().getMonth().getValue() == LocalDate.now().getMonth().getValue()){
                turnover += billHomestay.getAmountOfMoney();
                count++;
            }
        }
        for (BillHotel billHotel : ReadAndWriteFile.getBillHotelList()) {
            if (billHotel.getCheckoutDate().getMonth().getValue() == LocalDate.now().getMonth().getValue()){
                turnover += billHotel.getAmountOfMoney();
                count++;
            }
        }
        System.out.println("                                                      "+"Trong tháng có: "+count+" lượt đặt phòng");
        System.out.println("                                                      Với tổng doanh thu trong tháng là: "+turnover);

    }
    public void revenueCalculation(){
        System.out.println("                                                      Số lượt đặt phòng: "+ (ReadAndWriteFile.getBillHotelList().size()+ReadAndWriteFile.getBillHomestayList().size()));
        double turnover = 0;
        if (!ReadAndWriteFile.getBillHomestayList().isEmpty()){
            for (BillHomestay billHomestay : ReadAndWriteFile.getBillHomestayList()) {
                turnover += billHomestay.getAmountOfMoney();
            }
        }
        if (!ReadAndWriteFile.getBillHotelList().isEmpty()){
            for (BillHotel billHotel : ReadAndWriteFile.getBillHotelList()) {
                turnover += billHotel.getAmountOfMoney();
            }
        }
        System.out.println("                                                      Doanh thu tính đến thời điểm hiện tại: " + (turnover*15)/100);

    }
    public void displayUserInformation(){

        for (AccountUser accountUser : ReadAndWriteFile.getAccountUserList()) {
            System.out.println("                                                      "+accountUser);
        }
    }
    public void displayPartnerInformation(){
        for (AccountPartner accountPartner : ReadAndWriteFile.getAccountPartnerList()) {
            System.out.println("                                                     "+ accountPartner);
        }
    }

    public int countNumberOfUser(){
        int count = 0;
        for (int i = 0; i < ReadAndWriteFile.getAccountUserList().size(); i++) {
                count++;
        }
        return count;
    }
    public int countNumberOfPartner(){
        int count = 0;
        for (int i = 0; i < ReadAndWriteFile.getAccountPartnerList().size(); i++) {
            count++;
        }
        return count;
    }
    public void deleteAPartner(Scanner scanner){
        System.out.print("                                                      Nhập tên đối tác muốn xóa");
        String name = scanner.nextLine();
        System.out.print("                                                      Nhập địa chỉ mailđối tác muốn xóa ");
        String mail = scanner.nextLine();
        boolean check = true;
        for (int i = 0; i < ReadAndWriteFile.getAccountPartnerList().size(); i++) {
            if (ReadAndWriteFile.getAccountPartnerList().get(i).getName().equals(name) && ReadAndWriteFile.getAccountPartnerList().get(i).getEmail().equals(mail)){
                check = false;
                System.out.println("                                                      1.Xóa");
                System.out.println("                                                      0.Hủy");
                int choice = readAndWriteFile.choice(0,1,scanner);
                if (choice == 1){
                    switch (ReadAndWriteFile.getAccountPartnerList().get(i).getType()){
                        case "Hotel" :
                            for (Hotel hotel : ReadAndWriteFile.getHotelList()) {
                                if (hotel.getId().equals(mail)){
                                    ReadAndWriteFile.getHotelList().remove(hotel);
                                    readAndWriteFile.writeFileHotelPartner( ReadAndWriteFile.getHotelList());
                                }
                            }
                            break;
                        case "Homestay" :
                            for (Homestay homestay : ReadAndWriteFile.getHomestayList()) {
                                if (homestay.getId().equals(mail)){
                                    ReadAndWriteFile.getHomestayList().remove(homestay);
                                    readAndWriteFile.writeFileHomestayPartner(ReadAndWriteFile.getHomestayList());
                                }
                            }
                            break;
                    }
                    ReadAndWriteFile.getAccountPartnerList().remove(ReadAndWriteFile.getAccountPartnerList().get(i));
                    readAndWriteFile.writeFileAccountPartner(ReadAndWriteFile.getAccountPartnerList());

                }else if (choice == 0){
                    break;
                }
            }
        }
        if (check){
            System.out.println("                                    Không tìm thấy thông tin trên hệ thống!");
        }
    }

   public void runByAdmin(){
       Scanner scanner = new Scanner(System.in);
       int choice =1;
       do {
           System.out.println("                                            ************************ Chao Admin ************************");
           System.out.println("                                            |   1.Hiển thị thông tin người dùng                        |");
           System.out.println("                                            |   2.Hiển thị thông tin đối tác                           |" );
           System.out.println("                                            |   3.Doanh thu trong tháng                                |");
           System.out.println("                                            |   4.Tổng doanh thu tới thời điểm hiện tại                |");
           System.out.println("                                            |   5.Xoa thông tin đối tác khỏi hệ thống                  |");
           System.out.println("                                            |   0.Đăng xuất                                            |");
           System.out.println("                                            *************************************************************");
           System.out.print("                                            ==> Nhập lựa chọn: ");

           choice = readAndWriteFile.choice(0,5,scanner);
           switch (choice){
               case 1:
                   System.out.println();
                   System.out.println();
                   System.out.println("                                                      Tổng số người dùng: "+countNumberOfUser());
                   displayUserInformation();
                   break;
               case 2:
                   System.out.println("                                                      Tổng số đối tác: "+countNumberOfPartner());
                   displayPartnerInformation();
                   break;
               case 3:
                   RevenueForTheMonth();
                   break;
               case 4:
                   revenueCalculation();
                   break;
               case 5:
                   deleteAPartner(scanner);
                   break;

           }



       }while (choice!=0);
   }




}
