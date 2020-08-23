package model.logic;

public class Actor {

	private String name;
	
	private int gender;
	
	public Actor(String pName, int pGender)
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
