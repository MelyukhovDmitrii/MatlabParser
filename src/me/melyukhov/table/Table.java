package me.melyukhov.table;

import java.util.HashMap;

public class Table extends HashMap<String, HashMap<Integer, Integer>> {

	public Table(){
		initializeTable();
	}
	
	private void initializeTable() {
		this.put("=", new HashMap<Integer, Integer>() {{
			put(2,3); 
			put(8,9);
		}});
		
		this.put("function", new HashMap<Integer, Integer>(){{
			put(1,16);
		}});
		
		this.put("name", new HashMap<Integer, Integer>(){{
			put(3,4);
			put(5,6);
			put(7,8);
			put(9,10);
			put(13,14);
			put(17,18);
		}});
		
		this.put("(", new HashMap<Integer, Integer>(){{
			put(4,5);
			put(12,13);
		}});
		
		this.put(")", new HashMap<Integer, Integer>(){{
			put(5,7);
			put(6,7);
			put(14,15);
		}});
		
		this.put(",", new HashMap<Integer, Integer>(){{
			put(6,5);
			put(14,13);
			put(18,17);
		}});
		
		this.put("+", new HashMap<Integer, Integer>(){{
			put(10,9);
		}});
		
		this.put("/", new HashMap<Integer, Integer>(){{
			put(10,9);
		}});
		
		this.put("-", new HashMap<Integer, Integer>(){{
			put(10,9);
		}});
		 
		this.put("*", new HashMap<Integer, Integer>(){{
			put(10,9);
		}});
		
		this.put(";", new HashMap<Integer, Integer>(){{
			put(8,7);
			put(10,7);
			put(15,7);
		}});
		
		this.put("number", new HashMap<Integer, Integer>(){{
			put(9,10);
		}});
		
		this.put("disp", new HashMap<Integer, Integer>(){{
			put(7,12);
		}});
		
		this.put("END", new HashMap<Integer, Integer>(){{
			put(7,18);
		}});
		
		this.put("[", new HashMap<Integer, Integer>(){{
			put(16,17);
		}});
		
		this.put("]", new HashMap<Integer, Integer>(){{
			put(17,2);
			put(18,2);
		}});
	}
	
}
