package model.logic;

import com.opencsv.bean.CsvBindByPosition;

public class Casting {

	@CsvBindByPosition(position = 0)
	public String id;
	
	public String getId() {
		return id;
	}

}
