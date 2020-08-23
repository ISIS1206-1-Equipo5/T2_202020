package model.logic;

public class Director {
	
private String name;
	
	private int gender;
	
	public Director(String pName, int pGender)
	{
		name = pName;
		
		gender = pGender;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getGender()
	{
		return gender;
	}	

}
