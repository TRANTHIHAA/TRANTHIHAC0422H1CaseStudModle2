package Model.Partner;

import Model.Account.AccountUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HotelManager {
    static int count = 0;
    List<Room> roomList ;
    public HotelManager() {
        roomList =new ArrayList<>();
    }


    public  void AddNewCustomer(AccountUser accountUser) {
        Scanner scanner = new Scanner(System.in);
            int chon;
            int check =1;
            double prime =0;
            String roomType = "";
            do {
                System.out.println("nhap loai phong :  ");
                System.out.println("1.Phong loai A gia 500$ / ngay");
                System.out.println("2.Hủy dặt phòng");
                chon = Integer.parseInt(scanner.next());
                switch (chon ) {
                    case 1: {
                        if (count < 2) {
                            System.out.println("Ban da chon phong loai A");
                            roomType = "A";
                            prime = 500;
                            count++;
                            check = -1;
                        } else {
                            System.out.println("Rat xin loi da het phong!");
                        }
                        break;
                    }
                    case 2:
                        break;
                    default:
                        System.out.println("Ban chua chon phong");

                }
            }while (chon !=2 && check == 1);
            if (!roomType.equals("")){
                System.out.print("Nhap so ngay o: ");
                int soNgay = scanner.nextInt();
                 Room room = new Room(accountUser,roomType,prime,soNgay);
                roomList.add(room);
                System.out.println("Đặt phòng thành công!");
            }else {
                System.out.println("Đã hủy đặt phòng!");
            }



    }
}
