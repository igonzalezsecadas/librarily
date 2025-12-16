import java.util.HashMap;

public class Library {
    public static final double PENALTY_PER_DAY = 0.5;
    public static final int MAXIMUN_LOANS_PER_MEMBER = 3;

    public HashMap<Integer, Loan> loanHistory;
    public HashMap<Integer, Member> members;

    public Library() {
        loanHistory = new HashMap<>();
        members = new HashMap<>();
    }

    public void addMember(Member member) {
        members.put(member.getId(), member);
    }

    public Member searchMember(int memberId) {
        return members.get(memberId);
    }

    public void removeMember(int memberId) {
        members.remove(memberId);
    }

    public void newLoan(Book book, Member member) {
        try {
            Loan newLoan = new Loan(book, member);
            loanHistory.put(newLoan.getId(), newLoan);
            member.addLoan(newLoan);
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        }
    }

    public void setLoanInactive(Loan loan) {
        loan.setLoanInactive();
        loan.getMember().removeActiveLoan(loan);
    }

    public Loan searchLoan(int id) {
        return loanHistory.get(id);
    }

    public HashMap<Integer, Loan> getLoanHistory() {
        return loanHistory;
    }

    public HashMap<Integer, Member> getMembers() {
        return members;
    }
}