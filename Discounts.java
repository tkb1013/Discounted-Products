import java.util.*;
import java.io.*;

/*
	This program reads a list of discounted products through a text file and sorts the list by any attribute.
*/

public class Discounts 
{
   public static void main(String[] args) throws IOException
   {
      //Open the file
      File file = new File("input5.txt");
      Scanner inputFile = new Scanner(file);
      
      List<Product> rowList = new ArrayList<Product>();
      Discounts productSort = new Discounts();
      
      while(inputFile.hasNextLine())
      {
         String product = inputFile.nextLine();
         String[] array = product.split(",");
         
         String name = array[0];
         String location = array[1];
         double origPrice = Double.parseDouble(array[2]);
         double discPrice = Double.parseDouble(array[3]);
         String availability = array[4];
         String rating = array[5];
         
         Product prod = new Product(name, location, origPrice, discPrice, availability, rating);
         
         rowList.add(prod); 
      }
            
      int attribute, order;
      String input;
      char again;
      Scanner keyboard = new Scanner(System.in);
      
      do
      {
         System.out.println("Select the number for the attribute:");
         System.out.println("1. Product Name");
         System.out.println("2. Locations/Branches where it is available");
         System.out.println("3. Original Price");
         System.out.println("4. Discounted Price");
         System.out.println("5. Sold out or not");
         System.out.println("6. Popularity (0-5 stars)");
         attribute = keyboard.nextInt();
         
         System.out.println("Select the order of the products:");
         System.out.println("1. Ascending");
         System.out.println("2. Descending");
         order = keyboard.nextInt();

         
         if(attribute == 1 && order == 1)
         {
            Collections.sort(rowList, new NameComparator());
            productSort.printProductDetails(rowList);
         } 
         else if(attribute == 2 && order == 1)
         {
            Collections.sort(rowList, new LocationComparator());
            productSort.printProductDetails(rowList);
         }
         else if(attribute == 3 && order == 1)
         {
            Collections.sort(rowList, new OrigPriceComparator());
            productSort.printProductDetails(rowList);
         }
         else if(attribute == 4 && order == 1)
         {
            Collections.sort(rowList, new DiscPriceComparator());
            productSort.printProductDetails(rowList);
         }
         else if(attribute == 5 && order == 1)
         {
            Collections.sort(rowList, new AvailaComparator());
            productSort.printProductDetails(rowList);
         }
         else if(attribute == 6 && order == 1)
         {
            Collections.sort(rowList, new PopComparator());
            productSort.printProductDetails(rowList);
         }
         else if(attribute == 1 && order == 2)
         {
            Collections.sort(rowList, 
                              Collections.reverseOrder(new NameComparator()));
            productSort.printProductDetails(rowList);
         } 
         else if(attribute == 2 && order == 2)
         {
            Collections.sort(rowList, 
                              Collections.reverseOrder(new LocationComparator()));
            productSort.printProductDetails(rowList);
         }
         else if(attribute == 3 && order == 2)
         {
            Collections.sort(rowList, 
                              Collections.reverseOrder(new OrigPriceComparator()));
            productSort.printProductDetails(rowList);
         }
         else if(attribute == 4 && order == 2)
         {
            Collections.sort(rowList, 
                              Collections.reverseOrder(new DiscPriceComparator()));
            productSort.printProductDetails(rowList);
         }
         else if(attribute == 5 && order == 2)
         {
            Collections.sort(rowList, 
                              Collections.reverseOrder(new AvailaComparator()));
            productSort.printProductDetails(rowList);
         }
         else if(attribute == 6 && order == 2)
         {
            Collections.sort(rowList, 
                              Collections.reverseOrder(new PopComparator()));
            productSort.printProductDetails(rowList);
         }
         else
            System.out.println("Invalid input. Please try again.");
         
         System.out.println("");
         System.out.println("Would you like to go again? (Y/N)");
         input = keyboard.next();
         again = input.charAt(0);
      }while(again == 'Y' || again == 'y');
      
      //Close the file
      inputFile.close();
   }
   
   public void printProductDetails(List<Product> rowList)
   {
      for (Product p : rowList) {
         System.out.println(p);
      }
 
   }
}

class NameComparator implements Comparator<Product>
{
   public int compare(Product o1, Product o2) {
      return o1.getName().compareTo(o2.getName());
   }
}

class LocationComparator implements Comparator<Product>
{
   public int compare(Product o1, Product o2) {
      return o1.getLocation().compareTo(o2.getLocation());
   }
}

class OrigPriceComparator implements Comparator<Product>
{
   public int compare(Product o1, Product o2) {
      return Double.compare(o1.getOrigPrice(), o2.getOrigPrice());
   }
}

class DiscPriceComparator implements Comparator<Product>
{
   public int compare(Product o1, Product o2) {
      return Double.compare(o1.getDiscPrice(), o2.getDiscPrice());
   }
}

class AvailaComparator implements Comparator<Product>
{
   public int compare(Product o1, Product o2) {
      return o1.getAvaila().compareTo(o2.getAvaila());
   }
}

class PopComparator implements Comparator<Product>
{
   public int compare(Product o1, Product o2) {
      return o1.getRating().compareTo(o2.getRating());
   }
}
