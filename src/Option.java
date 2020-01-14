import java.sql.*;
import java.util.Scanner;

public class Option {

    public static void executeModifyOption(String option){
        try {
            Connection connn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eBookstore?useSSL=false" , "root" ,"@shaylanB2");
            Statement stmt = connn.createStatement();
            int Querycount = stmt.executeUpdate(option);

        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public static void executeSearchOption(String option)
    {
        try
        {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eBookstore?useSSL=false" , "root" ,"@shaylanB2");
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery(option);
            String results = "";

            while (rset.next()) {
                results += String.format("%d. %s, %s, %d, %d",
                        rset.getInt("id"),
                        rset.getString("title"),
                        rset.getString("author"),
                        rset.getInt("qty"),
                        rset.getInt("price"));
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public static void SearchOption()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your search parameter:");
        String searchColumns = sc.nextLine();
        System.out.println("Enter " + searchColumns + " you are looking for:");
        String searchParameter = sc.nextLine();

        String sqlSearch = String.format("SELECT * from books WHERE %s = '%s'", searchColumns, searchParameter);
        System.out.println("Your query is: " + sqlSearch);
        executeSearchOption(sqlSearch);
    }

    public static void NewEntry() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter new book ID");
        String newID = sc.nextLine();
        System.out.println("Enter the book title:");
        String newTitle = sc.nextLine();
        System.out.println("Enter book author:");
        String newAuthor = sc.nextLine();
        System.out.println("Enter whether the book is softback or hardback");
        String newBack = sc.nextLine();
        System.out.println("Enter the number of books available:");
        String newQty = sc.nextLine();
        System.out.println("Enter the price of the book:");


        String bookAdd = String.format("INSERT INTO BOOKS VALUES (%s, %s, %s, %s, %s, %s)", newID, newTitle, newAuthor, newBack, newQty);
        System.out.println("SQL Query is as follows:\n" + bookAdd);
        executeModifyOption(bookAdd);

    }

    public static void editOption()
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter the column you would like to enter:");
        String selectColumn = sc.nextLine();
        System.out.println("Please enter the " + selectColumn + "you would like to edit:");
        String editChoice = sc.nextLine();
        System.out.println("Please enter the new column you would like to select:");
        String editColumn = sc.nextLine();
        System.out.println("Please enter what you would like to change " + editChoice + " to:");
        String editOutput = sc.nextLine();

        String setValue = String.format("UPDATE BOOKS SET %s = '%s' WHERE %s = '%s'", selectColumn, editChoice, editColumn, editOutput);
        System.out.println("SQL Query is as follows: " + setValue);

        executeModifyOption(setValue);
    }

    public static void deleteOption()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the field you want to search by:");
        String delColumn = sc.nextLine();
        System.out.println("Please enter the" + delColumn + " of the book you would like to delete:");
        String delBook = sc.nextLine();

        String strDelete = String.format("DELETE FROM BOOKS WHERE '%s' = '%s'", delColumn, delBook);
        System.out.println("SQL Query is as follows: " + strDelete);

        executeModifyOption(strDelete);
    }
}
