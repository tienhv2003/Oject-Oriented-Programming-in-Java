import java.util.Scanner;

public class BooksMenu {
    private static void comparePrices(Book book1, Book book2){
        if(book1 == null || book2 == null){
            System.out.println("One or both books do not exist!");
            return;
        }
        float book1Price = book1.getPrice();
        float book2Price = book2.getPrice();
       
        if(book1Price > book2Price){
            System.out.println("the most expensive of the two is " + book1.getTitle());
        } else{
            System.out.println("the most expensive of the two is " + book2.getTitle());
        }
        
       
    }
    public static void main(String s[]) {
        Scanner scanner = new Scanner(System.in);
        Book[] books = new Book[10];
        int bkIdx = 0;
        while(true) {
            System.out.println("Press 1 to view books, 2 to add books, 3 to compare books of prices any other key to exit");
            String userAction = scanner.nextLine();
            if (userAction.equals("1")) {
                for (int i=0;i<books.length;i++){
                    if(books[i] != null){
                        System.out.println(books[i]);
                    }
                }   
            } else if (userAction.equals("2")){
                if(bkIdx == 10){
                    System.out.println("10 books added already. Cannot add any more books!");
                    continue;   
                }
                System.out.println("Enter book title");
                String tmpTitle = scanner.nextLine();
                System.out.println("Enter book author");
                String tmpAuthor = scanner.nextLine();
                System.out.println("Enter book price");
                float tmpPrice = Float.parseFloat(scanner.nextLine());
                Book bkTmp = new Book();
                bkTmp.setTitle(tmpTitle);
                bkTmp.setAuthor(tmpAuthor);
                bkTmp.setPrice(tmpPrice);
                books[bkIdx++] = bkTmp;

            } else if(userAction.equals("3")) {
                System.out.println("enter index of book1: ");
                int idxBook1 = Integer.parseInt(scanner.nextLine()); 
                System.out.println("enter index of book2: ");
                int idxBook2 = Integer.parseInt(scanner.nextLine()); 
                comparePrices(books[idxBook1], books[idxBook2]);
            }
            
            else{
                break;
            }        
        }

    }
}

