package Model;

import Model.Account.AccountUser;

import java.time.LocalDate;

public class BillHotel extends Bill{
    private int amountOfRoom;

    public BillHotel(LocalDate dateNow, LocalDate checkinDate, LocalDate checkoutDate, String accountUserName, String accountUserPhoneNumber, String partnerName, double prime, int numberOfDays, double amountOfMoney, int amountOfRoom) {
        super(dateNow, checkinDate, checkoutDate, accountUserName, accountUserPhoneNumber, partnerName, prime, numberOfDays, amountOfMoney);
        this.amountOfRoom = amountOfRoom;
    }

    public int getAmountOfRoom() {
        return amountOfRoom;
    }

    public void setAmountOfRoom(int amountOfRoom) {
        this.amountOfRoom = amountOfRoom;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "Ngày đặt phòng: " + super.getDateNow() +
                ", Ngày nhận phòng: " + super.getCheckinDate()+
                ", Ngày trả phòng: " + super.getCheckoutDate() +
                ", Tên người đặt: '" + super.getAccountUserName() + '\'' +
                ", Số điện thoại người đặt: '" + super.getAccountUserPhoneNumber()+ '\'' +
                ", Nơi lưu trú: '" + super.getPartnerName() + '\'' +
                ", Giá cho 1 phòng/ 1 đêm: " + super.getPrime() +
                ", Số ngày ở: " + super.getNumberOfDays() +
                ", Số lượng phòng : " + this.amountOfRoom+
                ", Số tiền phải thanh toán: " + super.getAmountOfMoney()+" Nghìn VND"+
                " }"
                ;
    }

}
