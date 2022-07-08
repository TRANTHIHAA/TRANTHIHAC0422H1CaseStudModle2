package Model;

import java.time.LocalDate;

public class BillHomestay extends Bill{
    public BillHomestay(LocalDate dateNow, LocalDate checkinDate, LocalDate checkoutDate, String accountUserName, String accountUserPhoneNumber, String partnerName, double prime, int numberOfDays, double amountOfMoney) {
        super(dateNow, checkinDate, checkoutDate, accountUserName, accountUserPhoneNumber, partnerName, prime, numberOfDays, amountOfMoney);
    }

    @Override
    public String toString() {
        return super.toString()+" }";
    }


}
