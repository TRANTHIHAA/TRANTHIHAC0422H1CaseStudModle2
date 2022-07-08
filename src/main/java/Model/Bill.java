package Model;

import Model.Account.AccountUser;
import Model.Partner.Partner;

import java.time.LocalDate;

public class Bill {
    private LocalDate dateNow;
    private LocalDate checkinDate;
    private LocalDate checkoutDate;
    private String accountUserName;
    private String accountUserPhoneNumber;
    private String partnerName;
    private  double prime;
    private int numberOfDays;

    private double amountOfMoney;

    public Bill(LocalDate dateNow, LocalDate checkinDate, LocalDate checkoutDate, String accountUserName, String accountUserPhoneNumber, String partnerName, double prime, int numberOfDays, double amountOfMoney) {
        this.dateNow = dateNow;
        this.checkinDate = checkinDate;
        this.checkoutDate = checkoutDate;
        this.accountUserName = accountUserName;
        this.accountUserPhoneNumber = accountUserPhoneNumber;
        this.partnerName = partnerName;
        this.prime = prime;
        this.numberOfDays = numberOfDays;
        this.amountOfMoney = amountOfMoney;
    }

    public String getAccountUserName() {
        return accountUserName;
    }

    public void setAccountUserName(String accountUserName) {
        this.accountUserName = accountUserName;
    }

    public String getAccountUserPhoneNumber() {
        return accountUserPhoneNumber;
    }

    public void setAccountUserPhoneNumber(String accountUserPhoneNumber) {
        this.accountUserPhoneNumber = accountUserPhoneNumber;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public LocalDate getDateNow() {
        return dateNow;
    }

    public void setDateNow(LocalDate dateNow) {
        this.dateNow = dateNow;
    }

    public LocalDate getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(LocalDate checkinDate) {
        this.checkinDate = checkinDate;
    }

    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(LocalDate checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public double getPrime() {
        return prime;
    }

    public void setPrime(double prime) {
        this.prime = prime;
    }

    public double getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(double amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }


    @Override
    public String toString() {
        return "Bill{" +
                "Ngày đặt phòng: " + dateNow +
                ", Ngày nhận phòng: " + checkinDate +
                ", Ngày trả phòng: " + checkoutDate +
                ", Tên người đặt: '" + accountUserName + '\'' +
                ", Số điện thoại người đặt: '" + accountUserPhoneNumber + '\'' +
                ", Nơi lưu trú: '" + partnerName + '\'' +
                ", Giá cho 1 phòng/ 1 đêm: " + prime +
                ", Số ngày ở: " + numberOfDays +
                ", Số tiền phải thanh toán: " + amountOfMoney +" Nghìn VND"
                ;
    }
}
