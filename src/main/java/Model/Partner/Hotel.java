package Model.Partner;

import java.util.List;

public class Hotel extends Partner{

   // private List<Room> roomList;
    private int numberOfRoom;
    private double prime;


    public Hotel(String id, String name, String address, double rating, String describe, int status,int numberOfRoom,double prime) {
        super(id, name, address, rating, describe, status);
        this.numberOfRoom = numberOfRoom;
        this.prime = prime;
    }

    public double getPrime() {
        return prime;
    }

    public void setPrime(double prime) {
        this.prime = prime;
    }

    public int getNumberOfRoom() {
        return numberOfRoom;
    }

    public void setNumberOfRoom(int numberOfRoom) {
        this.numberOfRoom = numberOfRoom;
    }

    @Override
    public String toString() {
        return "Hotel "+super.getName()+", Địa chỉ: "+ super.getAddress()+", Điểm đánh giá: "+ super.getRating()+", Mô tả: "+ super.getDescribe()+", Số phòng còn trống: "+this.getNumberOfRoom()+", Giá cho 1 đêm: "+this.getPrime()+" nghìn VND";
    }
}
