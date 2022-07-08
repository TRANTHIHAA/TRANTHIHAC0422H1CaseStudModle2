package Model.Menu;

import Model.Account.AccountManager;
import Model.Account.AccountPartner;
import Model.BillHomestay;
import Model.BillHotel;
import Model.Partner.Homestay;
import Model.Partner.Hotel;
import Model.ReadAndWriteFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PartnerView {
    Scanner scanner = new Scanner(System.in);
   ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();

    public void describeHotel(AccountPartner accountPartner){
        List<Hotel>hotelList = ReadAndWriteFile.getHotelList();
        System.out.print("                                                                 Tên Khách San: ");
        String name = scanner.nextLine();
        System.out.print("                                                                 Điểm đánh giá hiện tại: ");
        double rating = Double.parseDouble(scanner.nextLine());
        System.out.print("                                                                 Địa chỉ: ");
        String address = scanner.nextLine();
        System.out.print("                                                                 Mô tả: ");
        String describe = scanner.nextLine();
        System.out.print("                                                                 Số lượng phòng: ");
        int numberOfRoom = Integer.parseInt(scanner.nextLine());
        System.out.print("                                                                 Giá 1 phòng / 1 ngày: ");
        double prime = Double.parseDouble(scanner.nextLine());
        Hotel hotel = new Hotel(accountPartner.getEmail(),name,address,rating,describe,1,numberOfRoom,prime);
        hotelList.add(hotel);
        readAndWriteFile.writeFileHotelPartner(hotelList);

    }
    public void describeHomestay(AccountPartner accountPartner){
       List<Homestay> homestayList = ReadAndWriteFile.getHomestayList();

        System.out.print("                                                                 Tên Homestay: ");
        String name = scanner.nextLine();
        System.out.print("                                                                 Điểm đánh giá: ");
        double rating = Double.parseDouble(scanner.nextLine());
        System.out.print("                                                                 Địa chỉ: ");
        String address = scanner.nextLine();
        System.out.print("                                                                 Mô tả: ");
        String describe = scanner.nextLine();
        System.out.print("                                                                 Số lượng phòng ngủ: ");
        int amount = Integer.parseInt(scanner.nextLine());
        System.out.print("                                                                 Giá thuê 1 ngày: ");
        double prime = Double.parseDouble(scanner.nextLine());
        Homestay homestay = new Homestay(accountPartner.getEmail(),name,address,rating,describe,1,amount,prime);
        homestayList.add(homestay);
        readAndWriteFile.writeFileHomestayPartner(homestayList);
    }

    public void addANewHotel(AccountPartner accountPartner,Scanner scanner){
//        System.out.print("                                                      Nhập tên Khách Sạn: ");
//        String name = scanner.nextLine();
        System.out.print("                                                      Nhập địa chỉ: ");
        String address = scanner.nextLine();
        System.out.print("                                                      Nhập mô tả: ");
        String describe = scanner.nextLine();
        System.out.print("                                                      Nhập điểm đánh giá hiện tại: ");
        double rating = Double.parseDouble(scanner.nextLine());
        System.out.print("                                                      Nhập số lượng phòng: ");
        int numberOfRoom = Integer.parseInt(scanner.nextLine());
        System.out.print("                                                      Nhập giá 1 phòng / 1 ngày: ");
        double prime = Double.parseDouble(scanner.nextLine());
       String name = "";
        for (int i = 0; i < ReadAndWriteFile.getHotelList().size(); i++) {
            if (ReadAndWriteFile.getHotelList().get(i).getId().equals(accountPartner.getEmail())){
                name = ReadAndWriteFile.getHotelList().get(i).getName();
            }
        }

        Hotel hotel = new Hotel(accountPartner.getEmail(),name,address,rating,describe,1,numberOfRoom,prime);
        ReadAndWriteFile.getHotelList().add(hotel);
        readAndWriteFile.writeFileHotelPartner(ReadAndWriteFile.getHotelList());
    }

    public void addANewHomestay(AccountPartner accountPartner, Scanner scanner){
//        System.out.print("                                                      Nhập tên của Homestay: ");
//        String name = scanner.nextLine();
        System.out.print("                                                      Nhập địa chỉ: ");
        String address = scanner.nextLine();
        System.out.print("                                                      Nhập điểm đánh giá hiện tại: ");
        double rating = Double.parseDouble(scanner.nextLine());
        System.out.print("                                                      Nhập mô tả: ");
        String describe = scanner.nextLine();
        System.out.print("                                                      Nhập số lượng phòng: ");
        int numberOfRoom = Integer.parseInt(scanner.nextLine());
//        System.out.print("                                                      Nhập giá: ");
//        double prime = Double.parseDouble(scanner.nextLine());
        String name = "";
        double prime= 0;
        for (int i = 0; i < ReadAndWriteFile.getHomestayList().size(); i++) {
            if (ReadAndWriteFile.getHomestayList().get(i).getId().equals(accountPartner.getEmail())){
                name = ReadAndWriteFile.getHomestayList().get(i).getName();
                prime = ReadAndWriteFile.getHomestayList().get(i).getPrime();
                break;
            }
        }
        Homestay homestay = new Homestay(accountPartner.getEmail(), name, address,rating,describe,1,numberOfRoom,prime);
        ReadAndWriteFile.getHomestayList().add(homestay);
        readAndWriteFile.writeFileHomestayPartner(ReadAndWriteFile.getHomestayList());
    }
    public void AccountPartnerManager(AccountPartner accountPartner){
        int choice;
        do {
            System.out.println("                                                 -------------------------------------------------");
            System.out.println("                                                      1.Thay đổi thông tin cá nhân               ");
            System.out.println("                                                      2.Thay đổi thông tin "+accountPartner.getType()+" của bạn        ");
            System.out.println("                                                      3.Thêm "+accountPartner.getType());
            System.out.println("                                                      4.Xem doanh thu qua hệ thống               ");
            System.out.println("                                                      5.Thoát                                    ");
            System.out.println("                                                 --------------------------------------------------");
            System.out.print("                                                      ");
            choice = readAndWriteFile.choice(1,5,scanner);
            switch (choice){
                case 1:
                    int choiceOfThisMenu ;
                    System.out.println("                                                      ");
                    System.out.println("                                                      1.Thay đổi tài khoản");
                    System.out.println("                                                      2.Thay đổi địa chỉ mail");
                    System.out.println("                                                      3.Thay đổi số điện thoại");
                    System.out.print("                                                      => ");
                    choiceOfThisMenu = readAndWriteFile.choice(1,3,scanner);
                    switch (choiceOfThisMenu){
                        case 1:
                            System.out.print("                                                      Nhập lại tên mới: ");
                            String name = scanner.nextLine();
                            System.out.print("                                                      Nhập lại mật khẩu mới: ");
                            String password = scanner.nextLine();

                            if (readAndWriteFile.isExitAccountUser(name,password) && readAndWriteFile.isExitAccountPartner(name,password)){
                                System.out.println("Tài khoản đã tồn tại");
                                choice = 5;
                                break;
                            } else if (!name.equals("") ){
                                accountPartner.setName(name);
                                if (!password.equals("") ){
                                    accountPartner.setPassWord(password);
                                }
                            }



                            //newAccountPartner = new AccountPartner(accountPartner.getType(),name,password,accountPartner.getPhoneNumber(),accountPartner.getEmail());
                            break;
                        case 2:
                            System.out.print("                                                      Nhập lại địa chỉ mail mới: ");
                            String mail = scanner.nextLine();

                            switch (accountPartner.getType()){
                                case "Hotel":
                                    for (int i = 0; i < ReadAndWriteFile.getHotelList().size(); i++) {
                                        if (ReadAndWriteFile.getHotelList().get(i).getId().equals(accountPartner.getEmail())){
                                            ReadAndWriteFile.getHotelList().get(i).setId(mail);
                                            readAndWriteFile.writeFileHotelPartner(ReadAndWriteFile.getHotelList());
                                        }
                                    }
                                    break;
                                case "Homestay":
                                    for (int i = 0; i < ReadAndWriteFile.getHomestayList().size(); i++) {
                                        if (ReadAndWriteFile.getHomestayList().get(i).getId().equals(accountPartner.getEmail())){
                                            ReadAndWriteFile.getHomestayList().get(i).setId(mail);
                                            readAndWriteFile.writeFileHomestayPartner(ReadAndWriteFile.getHomestayList());
                                        }
                                    }
                                    break;
                            }
                            accountPartner.setEmail(mail);

                            break;
                        case 3:
                            System.out.print("                                                      Nhập lại số điện thoại:  ");
                            String phoneNumber = scanner.nextLine();
                            accountPartner.setPhoneNumber(phoneNumber);
                            //newAccountPartner = new AccountPartner(accountPartner.getType(),accountPartner.getName(),accountPartner.getPassWord(),phoneNumber,accountPartner.getEmail());
                            break;
                    }

                   readAndWriteFile.writeFileAccountPartner(ReadAndWriteFile.getAccountPartnerList());
                    break;

                case 2:
                    String name;
                    String address;
                    String describe;
                    double prime;

                    switch (accountPartner.getType()){
                        case "Hotel":
                            Hotel hotel = null;
                                for (int i = 0; i < ReadAndWriteFile.getHotelList().size(); i++) {
                                    if (ReadAndWriteFile.getHotelList().get(i).getId().equals(accountPartner.getEmail())){
                                         hotel = ReadAndWriteFile.getHotelList().get(i);
                                         ReadAndWriteFile.getHotelList().remove(ReadAndWriteFile.getHotelList().get(i));
                                    }
                                }
                            System.out.print("                                                      Cập nhật tên mới: ");
                             name = scanner.nextLine();
                            if (!name.equals("")){
                                hotel.setName(name);
                            }
                            System.out.print("                                                      Cập nhật địa chỉ: ");
                             address = scanner.nextLine();
                            if (!address.equals("")){
                                hotel.setAddress(address);
                            }
                            System.out.print("                                                      Cập nhật mô tả: ");
                             describe = scanner.nextLine();
                            if (!describe.equals("")){
                                hotel.setDescribe(describe);
                            }
                            System.out.print("                                                      Cập nhật giá: ");
                            prime = Double.parseDouble(scanner.nextLine());
                            if (prime != hotel.getPrime()){
                                hotel.setPrime(prime);
                            }
                            ReadAndWriteFile.getHotelList().add(hotel);
                            readAndWriteFile.writeFileHotelPartner(ReadAndWriteFile.getHotelList());
                            break;

                        case "Homestay":
                            Homestay homestay = null;
                            for (int i = 0; i < ReadAndWriteFile.getHomestayList().size(); i++) {
                                if (ReadAndWriteFile.getHomestayList().get(i).getId().equals(accountPartner.getEmail())){
                                    homestay = ReadAndWriteFile.getHomestayList().get(i);
                                    ReadAndWriteFile.getHomestayList().remove(ReadAndWriteFile.getHomestayList().get(i));
                                }
                            }
                            System.out.print("                                                      Cập nhật tên mới: ");
                             name = scanner.nextLine();
                            if (!name.equals("")){
                               homestay.setName(name);
                            }
                            System.out.print("                                                      Cập nhật địa chỉ mới: ");
                            address = scanner.nextLine();
                            if (!address.equals("")){
                                homestay.setAddress(address);
                            }
                            System.out.print("                                                      Cập nhật mô tả: ");
                            describe = scanner.nextLine();
                            if (!describe.equals("")){
                                homestay.setDescribe(describe);
                            }
                            System.out.print("                                                      Cập nhật số lượng phòng: ");
                            int numberOfRoom = Integer.parseInt(scanner.nextLine());
                            if (numberOfRoom != homestay.getNumberOfRoom()){
                                homestay.setNumberOfRoom(numberOfRoom);
                            }
                            System.out.print("                                                      Cập nhật giá: ");
                             prime = Double.parseDouble(scanner.nextLine());
                            if (prime != homestay.getPrime()){
                                homestay.setPrime(prime);
                            }
                            ReadAndWriteFile.getHomestayList().add(homestay);
                            readAndWriteFile.writeFileHomestayPartner(ReadAndWriteFile.getHomestayList());
                            break;
                    }
                    break;
                case 3:
                    switch (accountPartner.getType()){
                        case "Hotel":
                            addANewHotel(accountPartner,scanner);
                            break;
                        case "Homestay":
                            addANewHomestay(accountPartner,scanner);
                            break;
                    }
                    break;
                case 4:
                    double businessturnover = 0;
                    switch (accountPartner.getType()){
                        case "Hotel" :
                            for (BillHotel billHotel : ReadAndWriteFile.getBillHotelList()) {
                                if (billHotel.getPartnerName().equals(accountPartner.getName())){
                                      businessturnover += billHotel.getAmountOfMoney();
                                }
                            }
                            System.out.println(businessturnover);
                            break;
                        case "Homestay" :
                            for (BillHomestay billHomestay : ReadAndWriteFile.getBillHomestayList()) {
                                if (billHomestay.getPartnerName().equals(accountPartner.getName())){
                                    businessturnover += billHomestay.getAmountOfMoney();
                                }
                            }
                            System.out.println(businessturnover);
                            break;
                    }

            }
        }while (choice !=5);

    }
    public void runSystemByPartner(AccountPartner accountPartner){
        System.out.println();
        System.out.println("                                                      ---------Chào "+accountPartner.getName()+"---------");
        System.out.println("                                                      Đây là thông tin về " +accountPartner.getType()+" của bạn trên hệ thống:");
        int choice;

        switch (accountPartner.getType()){
            case "Hotel":{
                for (Hotel hotel: ReadAndWriteFile.getHotelList()) {
                    if (accountPartner.getEmail().equals(hotel.getId())){
                        System.out.println("                           "+hotel);
                    }
                }
                break;
            }
            case "Homestay" :{
                for (Homestay homestay : ReadAndWriteFile.getHomestayList()) {
                    if (accountPartner.getEmail().equals(homestay.getId())){
                        System.out.println("                           "+homestay);
                    }
                }
            }
        }
        do {
            System.out.println("                                                      1.Quản lí tài khoản");
            System.out.println("                                                      2.Đăng xuất");
            System.out.print("                                                      ==>chọn: ");
            choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1){
                AccountPartnerManager(accountPartner);
            }
        }while (choice !=2);



    }


}
