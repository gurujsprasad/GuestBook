package GuestBookSrc;

public class GuestBookEntries {
	
	String name;
	String comment;
	int id;
	
	public GuestBookEntries(String name , String comment, int id)
	{
		this.name = name;
		this.comment = comment;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}	

}
