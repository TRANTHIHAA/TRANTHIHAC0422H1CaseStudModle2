package Model.Partner;

public class Partner {
    private String name;
    private String address;
    private double rating;
    private String describe;
    private String id;
    private int status;


    public Partner(String id,String name, String address,double rating,String describe,int status) {
        this.status = status;
        this.id = id;
        this.name = name;
        this.address = address;
        this.rating = rating;
        this.describe = describe;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



    @Override
    public String toString() {
        return "Partner{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", rating=" + rating +
                ", describe='" + describe + '\'' +
                '}';
    }
}
