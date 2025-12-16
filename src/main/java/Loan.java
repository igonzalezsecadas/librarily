import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Loan {
    private static int loanCounter;
    private int id;
    private Book book;
    private Member member;
    private LocalDate loanDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private boolean active;
    private double penalty;

    public Loan(Book book, Member member) {
        if (book.lendBook()) {
            this.id = loanCounter++;
            this.member = member;
            this.loanDate = LocalDate.now();
            this.dueDate = loanDate.plusDays(14);
            this.returnDate = null;
            this.active = true;
            this.penalty = 0;
        } else {
            throw new UnsupportedOperationException("No available copies for this book");
        }
    }

    public void setLoanInactive() {
        book.returnBook();
        active = false;
        returnDate = LocalDate.now();
        penalty += computePenalty();
    }

    public boolean isPastReturnDate() {
        return LocalDate.now().isAfter(dueDate);
    }

    public double computePenalty() {
        if(isPastReturnDate()) {
            return ChronoUnit.DAYS.between(dueDate, returnDate) * Library.PENALTY_PER_DAY;
        }
        else return 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public double getPenalty() {
        return penalty;
    }

    public void setPenalty(double penalty) {
        this.penalty = penalty;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", book=" + book +
                ", member=" + member +
                ", loanDate=" + loanDate +
                ", dueDate=" + dueDate +
                ", returnDate=" + returnDate +
                ", active=" + active +
                ", penalty=" + penalty +
                '}';
    }
}
