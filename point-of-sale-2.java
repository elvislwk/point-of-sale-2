import eCart.Product;
import eCart.CartItem;
import eCart.ShoppingCart;
import java.util.*; // used for Scanner and ArrayList

public class pointOfSale2
{
   public static void main(String[] args)
   {
      ArrayList productList = new ArrayList();
      initProductList(productList);
      ShoppingCart cart = new ShoppingCart();
      Scanner input = new Scanner(System.in);
      int option;
      do
      {
         displayMenu();
         System.out.print("Enter your option : ");
         option = input.nextInt();
         switch (option)
         {
            case 1: listAllProductsAndPrices(productList);
               break;
            case 2: addItem(productList, cart);
               break;
            case 3: removeItem(cart);
               break;
            case 4: viewItems(cart);
               break;
            case 5: clearItems(cart);
               break;
            case 6: checkOut(cart);
               break;
            case 0: System.out.println("Exiting programme...");
               break;
            default:System.out.println("Error: Invalid Input");
         }
      }while (option != 0);
   }
   public static void initProductList(ArrayList productList)
   {
      Product p = null;
      p = new Product(1001, "Apple iPhone", 1088.00);
      productList.add(p);
   
      p = new Product(1051, "HTC Sensation", 888.00);
      productList.add(p);
   
      p = new Product(1013, "LG Optimus 2X", 788.00);
      productList.add(p);
   
      p = new Product(1022, "Motorola Atrix", 1958.00);
      productList.add(p);
   
      p = new Product(1027, "Samsung Galaxy", 988.00);
      productList.add(p);
   }
   public static void displayMenu()
   {
      System.out.println("---------------- M E N U -----------------");
      System.out.println("[1] List all products and prices");
      System.out.println("[2] Add item to cart");
      System.out.println("[3] Remove item from cart");
      System.out.println("[4] View cart items");
      System.out.println("[5] Clear cart items");
      System.out.println("[6] Check out");
      System.out.println("[0] Exit");
      System.out.println("------------------------------------------");
   }
   public static void listAllProductsAndPrices(ArrayList productList)
   {
      for (int i=0; i<productList.size(); i++)
      {
         Product p = (Product) productList.get(i);
         System.out.println(p.toString());
      }
   
   }
   public static void addItem(ArrayList productList, ShoppingCart cart)
   {
      listAllProductsAndPrices(productList);
      Scanner input = new Scanner(System.in);
      boolean error = true;
      ArrayList itemList = ShoppingCart.getItemList();
      Product p = null;
      int quantity = 0;
      do
      {
         System.out.print("Enter item code : ");
         int code = input.nextInt();
         for (int i=0; i<productList.size(); i++)
         {
            p = (Product) productList.get(i);
            if (code == p.getCode())
            {
               error = false;
               break;
            }
         }
         if (error == true)
            System.out.println("Error: Invalid Input");
      } while(error == true);
      for (int i=0; i<cart.size(); i++)
      {
         CartItem item = (CartItem) itemList.get(i);
         if (item.getCode() == p.getCode())
         {
            do
            {
               System.out.print("Enter item quantity : ");
               quantity = input.nextInt();
               if (quantity <= 0)
                  System.out.println("Error: Invalid Input");
            }while(quantity <= 0);
            item.setQty(item.getQty()+quantity);
            System.out.println("Item successfully added to cart.");
            return;
         }
      }
      do
      {
         System.out.print("Enter item quantity : ");
         quantity = input.nextInt();
         if (quantity <= 0)
            System.out.println("Error: Invalid Input");
      }while(quantity <= 0);
      CartItem c = new CartItem(p.getCode(), p.getName(), p.getPrice(), quantity);
      cart.addItem(c);
      System.out.println("Item successfully added to cart.");
   }
   public static void removeItem(ShoppingCart cart)
   {
      if (cart.isEmpty() == true)
      {
         System.out.println("Cart is empty.");
         return;
      }
      Scanner input = new Scanner(System.in);
      cart.viewItems();
      int number;
      do
      {
         System.out.print("Enter item number : ");
         number = input.nextInt();
         if (number <= cart.size() && number > 0)
         {
            cart.removeItem(number);
            System.out.println("Item Successfully removed from cart.");
            return;
         }
         else
            System.out.println("Error: Invalid Input");
      } while (number <= 0 || number > cart.size());
   }
   public static void viewItems(ShoppingCart cart)
   {
      if (cart.isEmpty() == true)
      {
         System.out.println("Cart is empty.");
         return;
      }
      cart.viewItems();
   }
   public static void clearItems(ShoppingCart cart)
   {
      cart.clearItems();
      System.out.println("Cart successfully cleared.");
   }
   public static void checkOut(ShoppingCart cart)
   {
      if (cart.isEmpty() == true)
      {
         System.out.println("Cart is empty.");
         return;
      }
      Calendar today = new GregorianCalendar();
      int yr = today.get(Calendar.YEAR);
      int mth = today.get(Calendar.MONTH) + 1;
      int day = today.get(Calendar.DATE);
      String date = day + "/" + mth + "/" + yr;
      int hr  = today.get(Calendar.HOUR);
      int min = today.get(Calendar.MINUTE);
      int sec = today.get(Calendar.SECOND);
      String time = hr + ":" + min + ":" + sec;
      System.out.println("Date : " + date + "\nTime : " + time);
      cart.checkOut();
      System.out.println("Payment processing successful.");
   }
}