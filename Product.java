import java.util.*;
import java.text.DecimalFormat;
import java.io.*;

public class Product
{
   private String name, location, availability, rating;
   private double origPrice, discPrice;
   
   DecimalFormat df = new DecimalFormat("#0.00");
   
   public Product(String n, String l, double op, double dp, String a, String r)
   {
      name = n;
      location = l;
      origPrice = op;
      discPrice = dp;
      availability = a;
      rating = r;
   }
   
   public String getName()
   {
      return name;
   }
   
   public String getLocation()
   {
      return location;
   }
   
   public double getOrigPrice()
   {
      return origPrice;
   }
   
   public double getDiscPrice()
   {
      return discPrice;
   }
   
   public String getAvaila()
   {
      return availability; 
   }
   
   public String getRating()
   {
      return rating;
   }
   
   public String toString()
   {
      String str = name + "," + location + ", " + df.format(origPrice) + ", " + df.format(discPrice)
                   + "," + availability + "," + rating;
                   
      return str;
   }
   
   /*public static void main(String[] args) throws IOException
   {
      //Open the file
      File file = new File("input5.txt");
      Scanner inputFile = new Scanner(file);
      
      List<Product> rowList = new ArrayList<Product>();
      
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
      
      for (Product p : rowList) 
      {
         System.out.println(p);
      }
      
      //Close the file
      inputFile.close();

   }*/
}
