import java.util.HashSet;
import java.util.Set;

public class Member {
    private String name;
    private String address;
    private String id;
    private int telephone;
    private String email;
    private Set<Loan> memberActiveLoans;


    public Member(String name, String id, String address, int telephone, String email) {
        this.name = name;
        this.address = address;
        this.id = id;
        this.telephone = telephone;
        this.email = email;
        memberActiveLoans = new HashSet<>();
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void newLoan(Book book) {
        memberActiveLoans.add(new Loan(book));
    }

    public void listActiveLoans() {
        
    }
     @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", id='" + id + '\'' +
                ", telephone=" + telephone +
                ", email='" + email + '\'' +
                '}';
    }
}
