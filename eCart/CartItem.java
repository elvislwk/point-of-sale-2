// CartItem class derived from Product class
package eCart;

public class CartItem extends Product
{
  	// Attributes
  	private int qty;
  
  	// Behaviors
  
  	// constructors
  	public CartItem() 	// default constructor
  	{ 
		super();
	  	qty = 0;
  	}
	 
  	public CartItem( int c, String n, double p, int q) // parameterized constructor
  	{ 
     	super(c,n,p); 
	  	qty = q;
  	}
  
  	// set and get methods
  	public void setQty(int q) { qty = q; }
  	public int  getQty() { return qty; }
  	
  	public double calculateTotalAmount() { return qty * price; }

	// toString() method
  	public String toString() { return super.toString() + "\tQty:" + qty; }
 }