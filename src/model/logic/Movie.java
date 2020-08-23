package model.logic;

import com.opencsv.bean.CsvBindByPosition;

public class Movie implements Comparable<Movie> {

	@CsvBindByPosition(position = 0)
	private String id;
	
	
	public Casting casting;
	

	public String getId() {
		return id;
	}

	public Casting getCasting() {
		return casting;
	}

	@Override
	public int compareTo(Movie o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setCasting(Casting pCasting) {
		casting = pCasting;
	}

}
