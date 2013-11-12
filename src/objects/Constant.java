package objects;

public class Constant {
	private int id;
	private String text;
	
	public Constant(int id, String text) {
		this.id = id;
		this.text = text;
	}	
	
	public int getId() {
		return id;
	}
	
	public String getText() {
		return text;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Constant other = (Constant) obj;
		if (id != other.id)
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}
	
	 @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		return result;
	}
	 
	 public int compareTo(Object other ) {  
	    int result = 0;
		return result;
	  }  

}
