import java.util.ArrayList;
import java.util.List;

public class Member {
    private int id;
    private String name;
    private String email;
    private String address;
    private int telephone;
    private double penalties;
    public List<Loan> activeLoans;

    public Member(int id, String name, String email, String address, int telephone) {
        this.id = id;
        this.name = name;
        this.email =  email;
        this.address = address;
        this.telephone = telephone;
        this.penalties = 0;
        activeLoans = new ArrayList<Loan>();
    }

    public void addLoan(Loan loan) {
        if((activeLoans.size() < Library.MAXIMUN_LOANS_PER_MEMBER) && penalties == 0.0) {
            activeLoans.add(loan);
        }
    }

    public void removeActiveLoan(Loan loan) {
        activeLoans.remove(loan);
        penalties += loan.computePenalty();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public double getPenalties() {
        return penalties;
    }

    public void setPenalties(double penalties) {
        this.penalties = penalties;
    }

    public List<Loan> getActiveLoans() {
        return activeLoans;
    }

    public void setActiveLoans(List<Loan> activeLoans) {
        this.activeLoans = activeLoans;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", telephone=" + telephone +
                ", penalties=" + penalties +
                ", activeLoans=" + activeLoans +
                '}';
    }
}
