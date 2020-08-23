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
	
	public Casting(int pId, String pProducerName, int pProducerNumber, String pScreenPlayName, String pEditorName, int pActorNumber, int pDirectorNumber)
	{
		id = pId;
		producerName = pProducerName;
		producerNumber = pProducerNumber;
		directorNumber = pDirectorNumber;
		actorNumber = pActorNumber;
		directorNumber = pDirectorNumber;
		actors = new Actor[5];
		director = null;
		
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

}
