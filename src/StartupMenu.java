import java.util.Scanner;

public class StartupMenu {

    public static String MenuDisplay() {
        return (
                "Please enter the number to indicate what you would like to do:\n"
                        + "1. Find a book\n"
                        + "2. Add a book\n"
                        + "3. Edit a book entry\n"
                        + "4. Delete a book\n"
                        + "5. Exit\n");
    }

    public static void MenuOptions() {
        Scanner sc = new Scanner(System.in);
        int selection;
        do {
            System.out.println(MenuDisplay());
            selection = sc.nextInt();

            switch (selection) {
                case 1:
                    Option.SearchOption();
                    break;
                case 2:
                    Option.NewEntry();
                    break;
                case 3:
                    Option.editOption();
                    break;
                case 4:
                    Option.deleteOption();
                    break;
                case 5:
                    System.out.println("Closing.");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
            System.out.println("\n");
        } while (selection != 5);
        sc.close();
    }
}