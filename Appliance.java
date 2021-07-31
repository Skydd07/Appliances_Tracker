/**
 * This class used to used create, mutate, and access 
 * Appliances 
 * 
 * 
 * @author Sanyam Kadd
 *
 */
public class Appliance 
{
	 private String type;
	 private String brand;
	 private double price;
	 private static long serialNumber=1000000;
	 private long sno;
	

	public Appliance()
	{
		this.type="Fridge";
		this.brand="LG";
		this.price=98.6;
		this.sno=serialNumber++;
	}

	public Appliance(String tp, String br, double pr) 
	{   
		this.type=tp;
		this.brand=br;
		this.price=pr;
		this.sno=serialNumber++;
	}
	
	public Appliance(Appliance ap) 
	{
		this.type=ap.type;
		this.brand=ap.brand;
		this.price=ap.price;
		this.sno=serialNumber++;
	}
	
	public void setType(String tp) 
	{
		this.type=tp;
	}
	
	public void setBrand(String br) 
	{
		this.brand=br;
	}
	
	public void setPrice(double pr) 
	{
		this.price=pr;
	}
	
	public String getType()
	{
		return this.type;
	}
	
	public String getBrand()
	{
		return this.brand;
	}
	
	public double getPrice()
	{
		return this.price;
	}
	
	public long getSno() {
		return this.sno;
	}
	
	public static long getSerialNumber()
	{
		return Appliance.serialNumber;
	}
	
	public int findNumberOfCreatedAppliances() 
	{
		return  (int) (serialNumber-1000000);
	}
	
	public boolean equals(Appliance ap)
	{
		return this.type==ap.type&&this.brand==ap.brand&&this.price==ap.price;
	}

	public String toString() 
	{
		return "Appliance [type=" + this.type + ", brand=" + this.brand + ", price=" + this.price + ", sno=" + this.sno + "]";
	}
}
