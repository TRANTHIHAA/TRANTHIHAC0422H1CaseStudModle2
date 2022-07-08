package Model.Menu;

import Model.Account.AccountManager;
import Model.Partner.Homestay;
import Model.Partner.Hotel;
import Model.ReadAndWriteFile;

import java.util.HashMap;
import java.util.List;

public class MainView {
    ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
    public void displayByAddress(){
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        for (Hotel hotel : ReadAndWriteFile.getHotelList()) {
            if (hotel.getStatus() == 1){
                if (hashMap.containsKey(hotel.getAddress()) ){
                    hashMap.put(hotel.getAddress(), hashMap.get(hotel.getAddress())+hotel.getNumberOfRoom());
                }else {
                    hashMap.put(hotel.getAddress(),hotel.getNumberOfRoom());
                }
            }

        }
        for (Homestay homestay : ReadAndWriteFile.getHomestayList()) {
            if (hashMap.containsKey(homestay.getAddress()) && (homestay.getStatus() == 1)){
                hashMap.put(homestay.getAddress(), hashMap.get(homestay.getAddress())+1);
            }else if (homestay.getStatus() == 1){
                hashMap.put(homestay.getAddress(),1);
            }
        }
        hashMap.forEach((keyInt, valueInt) -> System.out.println(
               "                                                            "+  keyInt + " có: " + valueInt+" chỗ nghỉ"));
    }


}
