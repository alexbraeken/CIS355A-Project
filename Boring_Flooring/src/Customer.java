
public class Customer {

	private String name, address, fType, zip;
	private double area, cost;
	
	public Customer()
	{
		
	}
	
	public void setName(String inName)
	{
		name = inName;
	}
	
	public void setAddress(String inAddress)
	{
		address = inAddress;
	}
	
	public void setFloorType(String inFType)
	{
		fType = inFType;
	}
	
	public void setZip(String inZip)
	{
		zip = inZip;
	}
	
	public void setArea(double inArea)
	{
		area = inArea;
	}
	
	public void setCost(double inCost)
	{
		cost = inCost;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getAddress( )
	{
		return address;
	}
	
	public String getFloorType( )
	{
		return fType;
	}
	
	public String getZip( )
	{
		return zip;
	}
	
	public double getArea( )
	{
		return area;
	}
	
	public double getCost( )
	{
		return cost;
	}
	
}
