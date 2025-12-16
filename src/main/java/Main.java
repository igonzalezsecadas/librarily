import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Catalogue books = new Catalogue();
        Library libraryRecords = new Library();
        int option = 0;
        do {
            System.out.println("""
                    1 - Member management
                    2 - Books management
                    3 - Loaned books management (return, borrow and list loans)
                    4 - Exit program""");

            option = Integer.parseInt(in.nextLine());

            switch (option) {
                case 1:
                    memberManagement(libraryRecords);
                    break;
                case 2:
                    bookManagement(books);
            }
        } while (option != 4);

        in.close();
    }

    public static void memberManagement(Library libraryRecords) {
        Scanner in = new Scanner(System.in);
        int option = 0;

        do {
            System.out.println("""
                    1 - Add new member
                    2 - Search member
                    3 - Remove member
                    4 - Go back to Main Menu""");

            option = Integer.parseInt(in.nextLine());

            switch (option) {
                case 1:
                    System.out.println("Input the members information (id; name; email; address; telephone):");
                    String memberInfo = in.nextLine();
                    if (memberInfo.matches("^(\\d+);\\s*([^;]+);\\s*([^;]+);\\s*([^;]+);\\s*(\\d{9})$")) {
                        String[] member = memberInfo.split("; ");
                        Member toAdd = new Member(Integer.parseInt(member[0]), member[1], member[2], member[3], Integer.parseInt(member[4]));
                        libraryRecords.addMember(toAdd);
                        System.out.println(toAdd); // Log to see if members are added
                    }
                    break;
                case 2:
                    System.out.println("Input the member's id: ");
                    int memberID = Integer.parseInt(in.nextLine());
                    System.out.println(libraryRecords.searchMember(memberID));
                    break;
                case 3:
                    System.out.println("Input the member you want to remove's id: ");
                    int removeID = Integer.parseInt(in.nextLine());
                    libraryRecords.removeMember(removeID);
                    break;
            }
        } while (option != 4);
    }

    public static void bookManagement(Catalogue cat) {
        Scanner in = new Scanner(System.in);
        int option = 0;

        do {
            System.out.println("""
                    1 - Add new book
                    2 - Search books by ISBN
                    3 - Search books by Title
                    4 - Search books by Author
                    5 - Search books by Publisher
                    6 - Remove book
                    7 - Modify book information""");

            option = Integer.parseInt(in.nextLine());

        } while (option != 8);
    }
}
