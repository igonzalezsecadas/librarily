import java.time.LocalDate;

public class Loan {
    private LocalDate loanDate;
    private LocalDate expectedReturnDate;
    private Book book;
    private boolean active;

    public Loan(Book book) {
        this.book = book;
        this.loanDate = LocalDate.now();
        this.expectedReturnDate = loanDate.plusDays(14);
        this.active = true;
    }

    public boolean returnLoan() {
        if (expectedReturnDate.isAfter(LocalDate.now())) {
            boolean returned = this.book.returnBook();
            active = false;
            return returned;
        }
        return false;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDate getExpectedReturnDate() {
        return expectedReturnDate;
    }

    public void setExpectedReturnDate(LocalDate expectedReturnDate) {
        this.expectedReturnDate = expectedReturnDate;
    }
    @Override
    public String toString() {
        return "Loan{" +
                "loanDate=" + loanDate +
                ", expectedReturnDate=" + expectedReturnDate +
                ", book=" + book +
                ", active=" + active +
                '}';
    }
}
