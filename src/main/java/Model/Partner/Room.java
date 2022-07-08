package Model.Partner;

import Model.Account.AccountUser;

public class Room {
    private AccountUser guest;
    private String typeRoom;
    private double prime;
    private int day;

    public Room(AccountUser customer,String typeRoom, double prime,int day) {
        this.guest = customer;
        this.typeRoom = typeRoom;
        this.prime = prime;
        this.day = day;
    }

    public AccountUser getGuest() {
        return guest;
    }

    public void setGuest(AccountUser guest) {
        this.guest = guest;
    }

    public String getTypeRoom() {
        return typeRoom;
    }

    public void setTypeRoom(String typeRoom) {
        this.typeRoom = typeRoom;
    }

    public double getPrime() {
        return prime;
    }

    public void setPrime(double prime) {
        this.prime = prime;
    }

    @Override
    public String toString() {
        return "Room{" +
                "typeRoom='" + typeRoom + '\'' +
                ", prime=" + prime +
                '}';
    }
}
