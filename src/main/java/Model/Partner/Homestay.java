package Model.Partner;

public class Homestay extends Partner {
    private int numberOfRoom;
    private double prime;

    public Homestay(String id, String name, String address, double rating, String describe, int status, int numberOfRoom, double prime) {
        super(id, name, address, rating, describe, status);
        this.numberOfRoom = numberOfRoom;
        this.prime = prime;
    }

    public int getNumberOfRoom() {
        return numberOfRoom;
    }

    public void setNumberOfRoom(int numberOfRoom) {
        this.numberOfRoom = numberOfRoom;
    }

    public double getPrime() {
        return prime;
    }

    public void setPrime(double prime) {
        this.prime = prime;
    }

    @Override
    public String toString() {
        return "Homestay " +super.getName()+", Địa chỉ "+super.getAddress()+", Điểm đánh giá: "+ super.getRating()+
                ", Số lượng phòng ngủ: " + numberOfRoom+", Mô tả: "+super.getDescribe()+", Giá cho 1 ngày thuê: " + this.getPrime()+" nghìn VND";
    }
}
