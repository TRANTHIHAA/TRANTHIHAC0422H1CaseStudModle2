package Model.Menu;

import Model.Account.AccountUser;
import Model.Bill;
import Model.BillHomestay;
import Model.BillHotel;
import Model.Partner.Homestay;
import Model.Partner.Hotel;
import Model.Partner.Partner;
import Model.ReadAndWriteFile;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class UserView {


    ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();

    public Bill billCalculationForHomestay(AccountUser accountUser, Homestay homestay,LocalDate localDateCheckin, LocalDate localDateCheckout){
        int days = (int) ChronoUnit.DAYS.between(localDateCheckin, localDateCheckout);
        double amountOfMoney = homestay.getPrime()*days;
        Bill bill = new BillHomestay(LocalDate.now(),localDateCheckin,localDateCheckout,accountUser.getName(), accountUser.getPhoneNumber(), homestay.getName(), homestay.getPrime(),days,amountOfMoney);
        return bill;
    }

    public Bill billCalculationForHotel(AccountUser accountUser, Hotel hotel,LocalDate localDateCheckin, LocalDate localDateCheckout,int amountOfRoom){
        int days = (int) ChronoUnit.DAYS.between(localDateCheckin, localDateCheckout);
        double amountOfMoney = hotel.getPrime()*days*amountOfRoom;
        BillHotel bill = new BillHotel(LocalDate.now(),localDateCheckin,localDateCheckout,accountUser.getName(), accountUser.getPhoneNumber(), hotel.getName(), hotel.getPrime(),days,amountOfMoney,amountOfRoom);
        return bill;
    }

    public void displayHomestayBillOfThisUser(AccountUser accountUser){
        for (BillHomestay bill : ReadAndWriteFile.getBillHomestayList()) {
            if (bill.getAccountUserName().equals(accountUser.getName()) && bill.getAccountUserPhoneNumber().equals(accountUser.getPhoneNumber())){
                System.out.println(bill);
            }

        }
    }

    public void displayHotelBillOfThisUser(AccountUser accountUser){
        for (BillHotel bill : ReadAndWriteFile.getBillHotelList()) {
            if (bill.getAccountUserName().equals(accountUser.getName()) && bill.getAccountUserPhoneNumber().equals(accountUser.getPhoneNumber())) {
                System.out.println(bill);
            }
        }
    }

    public void bookingRoom(AccountUser accountUser,String name, String address) {
        Scanner scanner = new Scanner(System.in);
        for (Hotel hotel : ReadAndWriteFile.getHotelList()) {
            if (hotel.getName().equals(name) && hotel.getAddress().equals(address) && hotel.getStatus()==1){
                System.out.println("                                                      Kh??ch S???n b???n ch???n l??: "+hotel);
                System.out.println("                                      "+hotel);
                System.out.println("                                      Hi???n t???i c??n:  "+hotel.getNumberOfRoom()+"  ph??ng tr???ng tr??n trang c???a ch??ng t??i!");
                System.out.println("                                                      1.?????t ph??ng");
                System.out.println("                                                      2.H???y");
                int choice ;
                do {
                    choice = readAndWriteFile.choice(1,2,scanner);
                    switch (choice){
                        case 1:
                            System.out.println("                                                      B???n mu???n ?????t m???y ph??ng?");
                            int amount = Integer.parseInt(scanner.nextLine());
                            if (hotel.getNumberOfRoom() <amount){
                                System.out.println("                                                      Hi???n Kh??ch S???n "+hotel.getName()+" kh??ng c??n ????? ph??ng, b???n c?? th??? l???a ch???n l???i!");
                                choice = 2;
                            }else {
                                LocalDate localDateNow = LocalDate.now();
                                System.out.print("                                                      Nh???p ng??y nh???n ph??ng: ");
                                String checkinDate = scanner.nextLine();
                                LocalDate localDateCheckin = LocalDate.parse(checkinDate);
                                while (!localDateCheckin.isAfter(localDateNow)){
                                    System.out.println("                                                      Ng??y nh???n ph??ng ph???i sau ng??y h??m nay!");
                                    System.out.print("                                                      Nh???p l???i ng??y nh???n ph??ng: ");
                                    checkinDate = scanner.nextLine();
                                    localDateCheckin = LocalDate.parse(checkinDate);
                                }

                                System.out.print("                                                      Nh???p ng??y tr??? ph??ng: ");
                                String checkoutDate = scanner.nextLine();
                                LocalDate localDateCheckout = LocalDate.parse(checkoutDate);
                                while (!localDateCheckout.isAfter(localDateCheckin)){
                                    System.out.println("                                                      Ng??y tr??? ph??ng ph???i sau ng??y tr??? ph??ng!");
                                    System.out.println("                                                      Nh???p l???i ng??y tr??? ph??ng: ");
                                    checkoutDate = scanner.nextLine();
                                    localDateCheckout = LocalDate.parse(checkoutDate);
                                }
                                System.out.println("                                                      ?????t ph??ng th??nh c??ng! ");
                                System.out.println("                                                      B???n s??? thanh to??n khi nh???n ph??ng!");
                                System.out.println("                                                      ????y l?? h??a ????n c???a b???n, h??y mang theo n?? l??c checkin!");

                                hotel.setNumberOfRoom(hotel.getNumberOfRoom()-amount);
                                if (hotel.getNumberOfRoom() == 0){
                                    hotel.setStatus(0);
                                }
                                readAndWriteFile.writeFileHotelPartner(ReadAndWriteFile.getHotelList());
                                choice = 2;
                                BillHotel bill = (BillHotel) billCalculationForHotel(accountUser,hotel,localDateCheckin,localDateCheckout,amount);
                                ReadAndWriteFile.getBillHotelList().add(bill);
                                readAndWriteFile.writeFileBillHotel(ReadAndWriteFile.getBillHotelList());
                                System.out.println(bill);
                                //displayHotelBillOfThisUser(accountUser);
                            }
                          break;
                    }
                }while (choice !=2);
            }
        }
    }

    public void bookingHomestay(AccountUser accountUser,String name, String address){
        Scanner scanner = new Scanner(System.in);

        for (Homestay homestay : ReadAndWriteFile.getHomestayList()) {
            if (homestay.getName().equals(name) && homestay.getAddress().equals(address) && homestay.getStatus()==1){
                System.out.println("                                                      N??i b???n ch???n l??: ");
                System.out.println("                                "+homestay);
                System.out.println("                                                      1.?????t ch??? ");
                System.out.println("                                                      2.H???y");
                int choice ;
                do {
                    choice = readAndWriteFile.choice(1,2,scanner);
                    switch (choice){
                        case 1:
                            LocalDate localDateNow = LocalDate.now();
                            System.out.print("                                                      Nh???p ng??y nh???n ph??ng: ");
                            String checkinDate = scanner.nextLine();
                            LocalDate localDateCheckin = LocalDate.parse(checkinDate);
                            while (!localDateCheckin.isAfter(localDateNow)){
                                System.out.println("                                                      Ng??y nh???n ph??ng ph???i sau ng??y h??m nay!");
                                System.out.print("                                                      Nh???p l???i ng??y nh???n ph??ng: ");
                                checkinDate = scanner.nextLine();
                                localDateCheckin = LocalDate.parse(checkinDate);
                            }

                            System.out.print("                                                      Nh???p ng??y tr??? ph??ng: ");
                            String checkoutDate = scanner.nextLine();
                            LocalDate localDateCheckout = LocalDate.parse(checkoutDate);
                            while (!localDateCheckout.isAfter(localDateCheckin)){
                                System.out.println("                                                      Ng??y tr??? ph??ng ph???i sau ng??y nh???n ph??ng!");
                                System.out.print("                                                      Nh???p l???i ng??y tr??? ph??ng: ");
                                checkoutDate = scanner.nextLine();
                                localDateCheckout = LocalDate.parse(checkoutDate);
                                }

                            System.out.println("                                                      ?????t ph??ng th??nh c??ng! ");
                            System.out.println("                                                      B???n s??? thanh to??n khi nh???n ph??ng!");
                            System.out.println("                                                      ????y l?? h??a ????n c???a b???n, h??y mang theo khi checkin!");

                            homestay.setStatus(0);
                            readAndWriteFile.writeFileHomestayPartner(ReadAndWriteFile.getHomestayList());
                            choice = 2;
                            BillHomestay bill = (BillHomestay) billCalculationForHomestay(accountUser,homestay,localDateCheckin,localDateCheckout);
                            ReadAndWriteFile.getBillHomestayList().add(bill);
                            readAndWriteFile.writeFileBillHomestay(ReadAndWriteFile.getBillHomestayList());
                           // displayHomestayBillOfThisUser(accountUser);
                            System.out.println(bill);
                            break;
                    }
                }while (choice !=2);

            }
        }

    }





    public void cancelBookingRoom() {


    }

    public void chooseDestination(AccountUser accountUser) {
        int id=0;
        Scanner scanner = new Scanner(System.in);

        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        for (Hotel hotel : ReadAndWriteFile.getHotelList()) {
            if (hashMap.containsKey(hotel.getAddress()) && (hotel.getStatus() == 1)) {
                hashMap.put(hotel.getAddress(), hashMap.get(hotel.getAddress()) + 1);
            } else if (hotel.getStatus() == 1){
                hashMap.put(hotel.getAddress(), 1);
            }
        }
        for (Homestay homestay : ReadAndWriteFile.getHomestayList()) {
            if (hashMap.containsKey(homestay.getAddress()) && (homestay.getStatus() == 1)) {
                hashMap.put(homestay.getAddress(), hashMap.get(homestay.getAddress()) + 1);
            } else if (homestay.getStatus() == 1){
                hashMap.put(homestay.getAddress(), 1);
            }
        }
        Set<String> keySet = hashMap.keySet();
        List<String> AddressList = new ArrayList<String>(keySet);
        HashMap<Integer, String> hashMap1 = new HashMap<Integer, String>();
        for (int i = 0; i < AddressList.size(); i++) {
            id++;
            hashMap1.put(id, AddressList.get(i));
        }
        hashMap1.forEach((keyInt, valueInt) -> System.out.println(
            "                                                      "+    keyInt + ": " + valueInt));
        System.out.print("                                                 Ch???n ??i???m ?????n trong danh s??ch tr??n: ");
        int choice = readAndWriteFile.choice(1,AddressList.size(),scanner);
        System.out.println("                                                      N??i b???n mu???n ?????n l?? " + AddressList.get(choice - 1) + " ? ");
        int choice1 ;
        do {
            System.out.println("                                                      1.T??m theo gi?? (??u ti??n r??? h??n)");
            System.out.println("                                                      2.T??m theo lo???i h??nh c?? tr?? (hotel / homestay)");
            System.out.println("                                                      0.Tho??t");
            System.out.print("                                                          => ");
            choice1  = readAndWriteFile.choice(0,2,scanner);
            switch (choice1) {
                case 1:
                    SearchByPrime(accountUser,AddressList.get(choice - 1));

                    break;
                case 2:
                    SearchByType(accountUser,AddressList.get(choice - 1));
                    break;

            }
        } while (choice1 != 0);


    }
    public void SearchByType(AccountUser accountUser,String address){
        Scanner scanner = new Scanner(System.in);
        int choice ;
        do {
            System.out.println("                                                      1.Hotel");
            System.out.println("                                                      2.Homestay");
            System.out.println("                                                      0.Tho??t");
            System.out.print("                                                          ==> ");
            choice = readAndWriteFile.choice(0,2,scanner);
            switch (choice){
                case 1:{
                    List<Hotel> hotels = new ArrayList<>();
                    for (Hotel hotel : ReadAndWriteFile.getHotelList()) {
                        if (hotel.getAddress().equals(address) && hotel.getStatus() == 1){
                            hotels.add(hotel);
                            System.out.println(hotel);
                        }
                    }
                    if(!hotels.isEmpty()){
                        System.out.print("                                                      Nh???p t??n Kh??ch S???n m?? b???n ch???n: ");
                        String name = scanner.nextLine();
                        if (!name.equals("")){
                            bookingRoom(accountUser,name,address);
                        }else {
                            choice = 0;
                        }
                    }else {
                        System.out.println("                                     Kh??ng c??n Kh??ch S???n n??o c??n ph??ng tr???ng trong h??m nay!");

                    }


                }
                    break;
                case 2:
                    List<Homestay> homestays = new ArrayList<>();
                    for (Homestay homestay : ReadAndWriteFile.getHomestayList()) {
                        if (homestay.getAddress().equals(address) && homestay.getStatus() == 1){
                            homestays.add(homestay);
                            System.out.println(homestay);
                        }
                    }
                    if (!homestays.isEmpty()){
                        System.out.print("                                                      Nh???p t??n Homestay b???n ch???n: ");
                        String name = scanner.nextLine();
                        if (!name.equals("")){
                            bookingHomestay(accountUser,name,address);
                        }else{
                            choice = 0;
                        }

                    }else {
                        System.out.println("                                        Kh??ng c??n Homestay n??o tr???ng trong h??m nay!");
                    }

                    break;
            }

        }while (choice!=0);
    }

   public  void SearchByPrime(AccountUser accountUser,String address){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Hotel> hotels =new ArrayList<>();
        Collections.sort(ReadAndWriteFile.getHotelList(), new Comparator<Hotel>() {
            @Override
            public int compare(Hotel o1, Hotel o2) {
               return (int) (o1.getPrime() - o2.getPrime());
            }
        });
       for (Hotel hotel : ReadAndWriteFile.getHotelList()) {
           if (hotel.getAddress().equals(address) && hotel.getStatus() == 1){
               //System.out.println(hotel);
               hotels.add(hotel);
           }

       }

       Collections.sort(ReadAndWriteFile.getHomestayList(), new Comparator<Homestay>() {
           @Override
           public int compare(Homestay o1, Homestay o2) {
               return (int) (o1.getPrime() - o2.getPrime());
           }
       });
       ArrayList<Homestay> homestays =new ArrayList<>();
       for (Homestay homestay : ReadAndWriteFile.getHomestayList()) {
           if (homestay.getAddress().equals(address) && homestay.getStatus() == 1){
               //System.out.println(hotel);
               homestays.add(homestay);
           }

       }
//       ArrayList<Partner> partners = new ArrayList<>();
//       partners.addAll(ReadAndWriteFile.getHotelList());
//       partners.addAll(ReadAndWriteFile.getHotelList());
//       Collections.sort(ReadAndWriteFile.getHotelList(), new Comparator<Partner>() {
//            @Override
//            public int compare(Partner o1, Partner o2) {
//               return (int) (o1.getPrime() - o2.getPrime());
//            }
//        });

        if (!hotels.isEmpty()){
        for (int i = 0; i < hotels.size(); i++) {
            if (!homestays.isEmpty()){
                for (int j = 0; j < homestays.size(); j++) {
                    if (hotels.get(i).getPrime() < homestays.get(j).getPrime()){
                        System.out.println(hotels.get(i));


                    } else if (hotels.get(i).getPrime() == homestays.get(j).getPrime() ){
                        System.out.println(hotels.get(i));
                        System.out.println(homestays.get(j));

                        homestays.remove(homestays.get(j));


                        i--;

                    }else {
                        System.out.println(homestays.get(j));
                        homestays.remove(homestays.get(j));
                    }
                }
            }
            System.out.println(hotels.get(i));

        }
        }else {
        for (int j = 0; j < homestays.size(); j++){
            System.out.println(homestays.get(j));
        }
        }


       System.out.print("                                                      Nh???p t??n n??i ??? b???n ch???n: ");
       String name = scanner.nextLine();
        bookingRoom(accountUser,name,address);
        bookingHomestay(accountUser,name,address);

   }
    public void favouriteAddress(){

    }
    public void AccountUserManager(AccountUser accountUser){
        Scanner scanner = new Scanner(System.in);
        System.out.println("                                                      Th??ng tin c???a b???n: ");
        System.out.println("                                         T??n: "+accountUser.getName()+"    SDT: "+accountUser.getPhoneNumber()+"     Email: "+accountUser.getEmail());

        int choice;
        do {
            System.out.println("                                                      1.Thay ?????i th??ng tin c?? nh??n");
            System.out.println("                                                      2.Xem th??ng tin ?????t ph??ng ");
            System.out.println("                                                      0.Tho??t");
            System.out.print("                                                          ==> ");

            choice = readAndWriteFile.choice(0,2,scanner);
            switch (choice){
                case 1:

                    String name;
                    String phoneNumber;
                    String email;
                    String password;

                    System.out.print("                                                      C???p nh???t t??n (b???n c?? th??? b??? qua): ");
                    name = scanner.nextLine();
                    if (!name.equals("")){
                        accountUser.setName(name);
                    }
                    System.out.print("                                                      ?????i m???t kh???u (b???n c?? th??? b??? qua): ");
                    password = scanner.nextLine();
                    if (!password.equals("")){
                        accountUser.setPassWord(password);
                    }
                    System.out.print("                                                      C???p nh???t l???i s??? ??i???n tho???i (b???n c?? th??? b??? qua): ");
                    phoneNumber = scanner.nextLine();
                    if (!phoneNumber.equals("")){
                        accountUser.setPhoneNumber(phoneNumber);
                    }
                    System.out.print("                                                      C???p nh???t email (b???n c?? th??? b??? qua): ");
                    email = scanner.nextLine();
                    if (!email.equals("")){
                        accountUser.setEmail(email);
                    }
                    readAndWriteFile.writeFileAccountUser(ReadAndWriteFile.getAccountUserList());
                    break;

                case 2:
                    displayHotelBillOfThisUser(accountUser);
                    displayHomestayBillOfThisUser(accountUser);
                    break;

            }
        }while (choice !=0);
    }
    public void runSystemByUser(AccountUser accountUser){
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("                                                      -----------Ch??o "+accountUser.getName()+" ----------");
            System.out.println("                                                      1.?????t ph??ng cho chuy???n ??i t???i");
            System.out.println("                                                      2.Qu???n l?? t??i kho???n");
            System.out.println("                                                      0.????ng xu???t");
            System.out.print("                                                          ==>   ");
            choice = readAndWriteFile.choice(0,2,scanner);

            switch (choice){
                case 1:
                    System.out.println("                                                     "+accountUser.getName()+" ??i, b???n mu???n ??i t???i ????u?");
                    chooseDestination(accountUser);
                    break;
                case 2:
                    AccountUserManager(accountUser);
                    break;



            }



        }while (choice!=0);
    }


}
