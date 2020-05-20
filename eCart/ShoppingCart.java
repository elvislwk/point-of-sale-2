// ShoppingCart class
package eCart;
import java.util.ArrayList;

public class ShoppingCart 
{
  // attributes
   private static ArrayList itemList = new ArrayList();
  
  // behaviors
  
  // constructors
   public ShoppingCart()	// default constructor
   {
    // attributes will be initialized to their default values
   }
  
  // add and get methods
   public void addItem(CartItem item) { itemList.add(item); }
   public static ArrayList getItemList() { return itemList; }

   public void viewItems() // method to view items
   {
      double total = 0;
      System.out.println("No.\tName\t\tPrice\tQty\tAmount");
      for (int i=0; i<itemList.size(); i++) 
      {
         CartItem item = (CartItem) itemList.get(i);
         System.out.println((i+1) + "\t" + item.getName() + "\t" + item.getPrice() + "\t" + item.getQty() + "\t" + item.calculateTotalAmount());
         total += item.calculateTotalAmount();
      }
      System.out.println("Total Amount : $" + total);
   }
   
   public void removeItem(int i) // method to remove an item in the cart
   {
      itemList.remove(i-1);
   }
   
   public void clearItems()   // method to clear all items in cart 
   {
      itemList.clear();
   }
   
   public void checkOut()  // method to check out
   {
      viewItems();
      clearItems();
   }
   
   public int size() // method to return the size of the cart
   {
      return itemList.size();
   }
   
   public boolean isEmpty()   // method to check if cart is empty
   {
      return itemList.isEmpty();
   }
   
}