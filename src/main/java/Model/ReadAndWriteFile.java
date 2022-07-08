package Model;

import Model.Account.Account;
import Model.Account.AccountPartner;
import Model.Account.AccountUser;
import Model.Partner.Homestay;
import Model.Partner.Hotel;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadAndWriteFile {
    static List<Hotel> hotelList = readFileHotelPartner();
    static List<Homestay> homestayList = readFileHomestayPartner();
    static List<AccountUser> accountUserList = readFileAccountUser();
    static List<AccountPartner> accountPartnerList = readFileAccountPartner();
    static List<BillHotel> billHotelList = readFileBillHotel();
    static List<BillHomestay> billHomestayList = readFileBillHomestay();

//    static List<Hotel> hotelListTemp = readFileHotelPartnerTemp();
//    static List<Homestay> homestayListTemp = readFileHomestayPartnerTemp();
//    static List<AccountPartner> accountPartnerListTemp = readFileAccountPartnerTemp();

//    public static List<Hotel> getHotelListTemp() {
//        return hotelListTemp;
//    }
//
//
//
//    public static List<Homestay> getHomestayListTemp() {
//        return homestayListTemp;
//    }
//
//
//
//    public static List<AccountPartner> getAccountPartnerListTemp() {
//        return accountPartnerListTemp;
//    }



    public static List<BillHotel> getBillHotelList() {
        return billHotelList;
    }

    public static void setBillHotelList(List<BillHotel> billHotelList) {
        ReadAndWriteFile.billHotelList = billHotelList;
    }

    public static List<BillHomestay> getBillHomestayList() {
        return billHomestayList;
    }

    public static void setBillHomestayList(List<BillHomestay> billHomestayList) {
        ReadAndWriteFile.billHomestayList = billHomestayList;
    }

    public static List<Hotel> getHotelList() {
        return hotelList;
    }

    public static void setHotelList(List<Hotel> hotelList) {
        ReadAndWriteFile.hotelList = hotelList;
    }

    public static List<Homestay> getHomestayList() {
        return homestayList;
    }

    public static void setHomestayList(List<Homestay> homestayList) {
        ReadAndWriteFile.homestayList = homestayList;
    }

    public static List<AccountUser> getAccountUserList() {
        return accountUserList;
    }

    public static void setAccountUserList(List<AccountUser> accountUserList) {
        ReadAndWriteFile.accountUserList = accountUserList;
    }

    public static List<AccountPartner> getAccountPartnerList() {
        return accountPartnerList;
    }

    public static void setAccountPartnerList(List<AccountPartner> accountPartnerList) {
        ReadAndWriteFile.accountPartnerList = accountPartnerList;
    }

    public void writeFileAccountPartner(List<AccountPartner> accountPartners) {
        try {
            File file = new File("AccountPartnerList.csv");
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            // AccountPartner accountTitle = new AccountPartner("C1","C2","C3","C4","C5");
            // accountPartnerList.add(0,accountTitle);
            for (AccountPartner account : accountPartners) {
                bufferedWriter.write(account.getType() + "," + account.getName() + "," + account.getPassWord() + "," + account.getPhoneNumber() + "," + account.getEmail() + "\n");
            }
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("loi2");
        }
    }

    public void writeFileAccountUser(List<AccountUser> accountUsers) {
        try {
            File file = new File("AccountUserList.csv");
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
//            AccountUser accountTitle = new AccountUser("C1","C2","C3","C4");
//            accountUserList.add(0, accountTitle);
            for (AccountUser account : accountUsers) {
                bufferedWriter.write(account.getName() + "," + account.getPassWord() + "," + account.getPhoneNumber() + "," + account.getEmail() + "\n");
            }
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("loi1");
        }
    }

    public static List<AccountUser> readFileAccountUser() {
        ArrayList<AccountUser> accounts = new ArrayList<>();
        try {
            File file = new File("AccountUserList.csv");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String value;
            while ((value = bufferedReader.readLine()) != null) {
                String[] strings = value.split(",");
                AccountUser account = new AccountUser(strings[0], strings[1], strings[2], strings[3]);
                accounts.add(account);
            }
//            if (!accounts.isEmpty()) {
//                accounts.remove(0);
//            }
            bufferedReader.close();

        } catch (IOException e) {
            System.out.println("loi3");
        }
        return accounts;
    }

    public static List<AccountPartner> readFileAccountPartner() {
        ArrayList<AccountPartner> accounts = new ArrayList<>();
        try {
            File file = new File("AccountPartnerList.csv");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String value;
            while ((value = bufferedReader.readLine()) != null) {
                String[] strings = value.split(",");
                AccountPartner account = new AccountPartner(strings[0], strings[1], strings[2], strings[3], strings[4]);
                accounts.add(account);
            }
//            if (!accounts.isEmpty()) {
//                accounts.remove(0);
//            }
            bufferedReader.close();

        } catch (IOException e) {
            System.out.println("loi4");
        }
        return accounts;
    }

    public boolean isExitAccountUser(String name, String password) {
        List<AccountUser> accountUserList = readFileAccountUser();
        for (Account account : accountUserList) {
            if (account.getName().equals(name) && account.getPassWord().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public boolean isExitAccountPartner(String name, String password) {
        List<AccountPartner> accountPartnerList = readFileAccountPartner();
        for (AccountPartner account : accountPartnerList) {
            if (account.getName().equals(name) && account.getPassWord().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static List<Homestay> readFileHomestayPartner() {
        ArrayList<Homestay> homestays = new ArrayList<>();
        try {
            File file = new File("describeHomestay.csv");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String value;
            while ((value = bufferedReader.readLine()) != null) {
                String[] strings = value.split(",");
                Homestay homestay = new Homestay(strings[0], strings[1], strings[2], Double.parseDouble(strings[3]), strings[4], Integer.parseInt(strings[5]), Integer.parseInt(strings[6]), Double.parseDouble(strings[7]));
                homestays.add(homestay);
            }
//            if (!accounts.isEmpty()) {
//                accounts.remove(0);
//            }
            bufferedReader.close();

        } catch (IOException e) {
            System.out.println("loi4");
        }
        return homestays;
    }

    public static List<Hotel> readFileHotelPartner() {
        ArrayList<Hotel> hotels = new ArrayList<>();
        try {
            File file = new File("describeHotel.csv");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String value;
            while ((value = bufferedReader.readLine()) != null) {
                String[] strings = value.split(",");
                Hotel hotel = new Hotel(strings[0], strings[1], strings[2], Double.parseDouble(strings[3]), strings[4], Integer.parseInt(strings[5]), Integer.parseInt(strings[6]), Double.parseDouble(strings[7]));
                hotels.add(hotel);
            }
//            if (!accounts.isEmpty()) {
//                accounts.remove(0);
//            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("loi4");
        }
        return hotels;
    }

    public void writeFileHomestayPartner(List<Homestay> homestays) {
        try {
            File file = new File("describeHomestay.csv");
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            // AccountPartner accountTitle = new AccountPartner("C1","C2","C3","C4","C5");
            // accountPartnerList.add(0,accountTitle);
            for (Homestay homestay : homestays) {
                bufferedWriter.write(homestay.getId() + "," + homestay.getName() + "," + homestay.getAddress() + "," + homestay.getRating() + "," + homestay.getDescribe() + "," + homestay.getStatus() + "," + homestay.getNumberOfRoom() + "," + homestay.getPrime() + "\n");
            }
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("loi2");
        }
    }

    public void writeFileHotelPartner(List<Hotel> hotels) {
        try {
            File file = new File("describeHotel.csv");
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            // AccountPartner accountTitle = new AccountPartner("C1","C2","C3","C4","C5");
            // accountPartnerList.add(0,accountTitle);
            for (Hotel hotel : hotels) {
                bufferedWriter.write(hotel.getId() + "," + hotel.getName() + "," + hotel.getAddress() + "," + hotel.getRating() + "," + hotel.getDescribe() + "," + hotel.getStatus() + "," + hotel.getNumberOfRoom() + "," + hotel.getPrime() + "\n");
            }
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("loi2");
        }
    }
    public void writeFileBillHotel(List<BillHotel> billHotelList) {
        try {
            File file = new File("FileBillHotelList.csv");
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            // AccountPartner accountTitle = new AccountPartner("C1","C2","C3","C4","C5");
            // accountPartnerList.add(0,accountTitle);
            for (BillHotel bill : billHotelList) {
                bufferedWriter.write(bill.getDateNow() + "," + bill.getCheckinDate() + "," + bill.getCheckoutDate() + "," + bill.getAccountUserName() + "," + bill.getAccountUserPhoneNumber() + "," + bill.getPartnerName() + "," + bill.getPrime()+"," +bill.getNumberOfDays()+","+bill.getAmountOfMoney()+","+bill.getAmountOfRoom()+"\n");
            }
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("loi5");
        }
    }

    public static ArrayList<BillHotel> readFileBillHotel() {
        ArrayList<BillHotel> bills = new ArrayList<>();
        try {
            File file = new File("FileBillHotelList.csv");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String value;
            while ((value = bufferedReader.readLine()) != null) {
                String[] strings = value.split(",");
                BillHotel bill = new BillHotel(LocalDate.parse(strings[0]), LocalDate.parse(strings[1]), LocalDate.parse(strings[2]), strings[3], strings[4], strings[5], Double.parseDouble(strings[6]),Integer.parseInt(strings[7]),Double.parseDouble(strings[8]),Integer.parseInt(strings[9]));
                bills.add(bill);
            }
//            if (!accounts.isEmpty()) {
//                accounts.remove(0);
//            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("loi4");
        }
        return bills;
    }

    public void writeFileBillHomestay(List<BillHomestay> billHomestayList) {
        try {
            File file = new File("FileBillHomestayList.csv");
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            // AccountPartner accountTitle = new AccountPartner("C1","C2","C3","C4","C5");
            // accountPartnerList.add(0,accountTitle);
            for (BillHomestay bill : billHomestayList) {
                bufferedWriter.write(bill.getDateNow() + "," + bill.getCheckinDate() + "," + bill.getCheckoutDate() + "," + bill.getAccountUserName() + "," + bill.getAccountUserPhoneNumber() + "," + bill.getPartnerName() + "," + bill.getPrime()+"," +bill.getNumberOfDays()+","+bill.getAmountOfMoney()+"\n");
            }
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("loi5");
        }
    }



    public static ArrayList<BillHomestay> readFileBillHomestay() {
        ArrayList<BillHomestay> bills = new ArrayList<>();
        try {
            File file = new File("FileBillHomestayList.csv");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String value;
            while ((value = bufferedReader.readLine()) != null) {
                String[] strings = value.split(",");
                BillHomestay bill = new BillHomestay(LocalDate.parse(strings[0]), LocalDate.parse(strings[1]), LocalDate.parse(strings[2]), strings[3], strings[4], strings[5], Double.parseDouble(strings[6]),Integer.parseInt(strings[7]),Double.parseDouble(strings[8]));
                bills.add(bill);
            }
//            if (!accounts.isEmpty()) {
//                accounts.remove(0);
//            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("loi4");
        }
        return bills;
    }

    public int choice(int min, int max, Scanner scanner) {
        int choice = 1;
        boolean flag = false;
        while (!flag) {
            try {
                flag = true;
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < min || choice > max) {
                    flag = false;
                    System.out.println("                                                                 Nhap so tu " + min + " - " + max + "!");
                }

            } catch (Exception e) {
               // System.out.println("                                                                 Nhap so tu " + min + " - " + max + "!");
                flag = false;
            }

        }
        return choice;
    }


    public void writeFileHotelPartnerTemp(List<Hotel> hotels) {
        try {
            File file = new File("describeHotelTemp.csv");
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            // AccountPartner accountTitle = new AccountPartner("C1","C2","C3","C4","C5");
            // accountPartnerList.add(0,accountTitle);
            for (Hotel hotel : hotels) {
                bufferedWriter.write(hotel.getId() + "," + hotel.getName() + "," + hotel.getAddress() + "," + hotel.getRating() + "," + hotel.getDescribe() + "," + hotel.getStatus() + "," + hotel.getNumberOfRoom() + "," + hotel.getPrime() + "\n");
            }
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("loi2");
        }
    }

    public void writeFileHomestayPartnerTemp(List<Homestay> homestays) {
        try {
            File file = new File("describeHomestayTemp.csv");
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            // AccountPartner accountTitle = new AccountPartner("C1","C2","C3","C4","C5");
            // accountPartnerList.add(0,accountTitle);
            for (Homestay homestay : homestays) {
                bufferedWriter.write(homestay.getId() + "," + homestay.getName() + "," + homestay.getAddress() + "," + homestay.getRating() + "," + homestay.getDescribe() + "," + homestay.getStatus() + "," + homestay.getNumberOfRoom() + "," + homestay.getPrime() + "\n");
            }
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("loi2");
        }
    }

    public static List<AccountPartner> readFileAccountPartnerTemp() {
        ArrayList<AccountPartner> accounts = new ArrayList<>();
        try {
            File file = new File("AccountPartnerListTemp.csv");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String value;
            while ((value = bufferedReader.readLine()) != null) {
                String[] strings = value.split(",");
                AccountPartner account = new AccountPartner(strings[0], strings[1], strings[2], strings[3], strings[4]);
                accounts.add(account);
            }
//            if (!accounts.isEmpty()) {
//                accounts.remove(0);
//            }
            bufferedReader.close();

        } catch (IOException e) {
            System.out.println("loi4");
        }
        return accounts;
    }
    public void writeFileAccountPartnerTemp(List<AccountPartner> accountPartners) {
        try {
            File file = new File("AccountPartnerListTemp.csv");
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            // AccountPartner accountTitle = new AccountPartner("C1","C2","C3","C4","C5");
            // accountPartnerList.add(0,accountTitle);
            for (AccountPartner account : accountPartners) {
                bufferedWriter.write(account.getType() + "," + account.getName() + "," + account.getPassWord() + "," + account.getPhoneNumber() + "," + account.getEmail() + "\n");
            }
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("loi2");
        }
    }

    public static List<Homestay> readFileHomestayPartnerTemp() {
        ArrayList<Homestay> homestays = new ArrayList<>();
        try {
            File file = new File("describeHomestayTemp.csv");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String value;
            while ((value = bufferedReader.readLine()) != null) {
                String[] strings = value.split(",");
                Homestay homestay = new Homestay(strings[0], strings[1], strings[2], Double.parseDouble(strings[3]), strings[4], Integer.parseInt(strings[5]), Integer.parseInt(strings[6]), Double.parseDouble(strings[7]));
                homestays.add(homestay);
            }
//            if (!accounts.isEmpty()) {
//                accounts.remove(0);
//            }
            bufferedReader.close();

        } catch (IOException e) {
            System.out.println("loi4");
        }
        return homestays;
    }

    public static List<Hotel> readFileHotelPartnerTemp() {
        ArrayList<Hotel> hotels = new ArrayList<>();
        try {
            File file = new File("describeHotelTemp.csv");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String value;
            while ((value = bufferedReader.readLine()) != null) {
                String[] strings = value.split(",");
                Hotel hotel = new Hotel(strings[0], strings[1], strings[2], Double.parseDouble(strings[3]), strings[4], Integer.parseInt(strings[5]), Integer.parseInt(strings[6]), Double.parseDouble(strings[7]));
                hotels.add(hotel);
            }
//            if (!accounts.isEmpty()) {
//                accounts.remove(0);
//            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("loi4");
        }
        return hotels;
    }


}
