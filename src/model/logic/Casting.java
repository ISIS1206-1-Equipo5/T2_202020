package model.logic;

public class Casting {
	
	public final static int NOT_AVAILABLE = 0;
	
	public final static int WOMEN = 1;
	
	public final static int MALE = 2;
	
	private int id;
	
	private String producerName;
	
	private int producerNumber;
	
	private String screenplayName;
	
	private String editorName;
	
	private int actorNumber;
	
	private int directorNumber;
	
	private Actor[] actors;
	
	private Director director;
	
	public Casting(String pId, String actor1Name, String actor1Gender, String actor2Name, String actor2Gender, String actor3Name, String actor3Gender, String actor4Name, String actor4Gender,String actor5Name, String actor5Gender,String pActorNumber, String directorName, String directorGender, String pDirectorNumber, String pProducerName, String pProducerNumber, String screenplayName, String editorName)
	{
		id = Integer.parseInt(pId);
		producerName = pProducerName;
		producerNumber = Integer.parseInt(pProducerNumber);
		directorNumber = Integer.parseInt(pDirectorNumber);
		
		actorNumber = Integer.parseInt(pActorNumber);
		if(actorNumber >= 5)
		{
			actors = new Actor[5];
			addActor(actor1Name, Integer.parseInt(actor1Gender), 0);
			addActor(actor2Name, Integer.parseInt(actor2Gender), 1);
			addActor(actor3Name, Integer.parseInt(actor3Gender), 2);
			addActor(actor4Name, Integer.parseInt(actor4Gender), 3);
			addActor(actor5Name, Integer.parseInt(actor5Gender), 4);
		}
		else {
			actors = new Actor[5];
			
			if(!actor1Name.equals("none"))
			{
				addActor(actor1Name, Integer.parseInt(actor1Gender), 0);
			}
			
			if(!actor2Name.equals("none")) {
				addActor(actor2Name, Integer.parseInt(actor2Gender), 1);
			}
			
			if(!actor3Name.equals("none")) {
				addActor(actor3Name, Integer.parseInt(actor3Gender), 2);
			}
			
			if(!actor4Name.equals("none")) {
				addActor(actor4Name, Integer.parseInt(actor4Gender), 3);
			}
			if(!actor5Name.equals("none")) 
			{
				addActor(actor5Name, Integer.parseInt(actor5Gender), 4);
			}
		}
		
		directorNumber = Integer.parseInt(pDirectorNumber);
		
		director = new Director(directorName, Integer.parseInt(directorGender));
		
	}
	
	public void addActor(String pName, int pGender, int i) throws IndexOutOfBoundsException
	{		
		Actor toAdd = new Actor(pName, pGender);
		
		actors[i] = toAdd;
	}
	
	public int getId()
	{
		return id;
	}
	
	public String getProducerName()
	{
		return producerName;
	}
	
	public int getProducerNumber()
	{
		return producerNumber;
	}
	
	public String getScreenPlayName()
	{
		return screenplayName;
	}
	
	public String getEditorName()
	{
		return editorName;
	}
	
	public int getActorNumber()
	{
		return actorNumber;
	}
	
	public Actor[] getActors()
	{
		return actors;
	}
	
	public Director getDirector()
	{
		return director;
	}
	
	public int getDirectorNumber() {
		return directorNumber;
	}

}
