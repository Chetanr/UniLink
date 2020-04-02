public abstract class Post 
{
	private String id;
	private String title;
	private String description;
	private String creator_id;
	private String status;
	private String replies;
	
	
	//Constructor for post class
//	public Post (String id, String title, String description,
//			String creator_id, String replies)
//	{
//		this.id = id;
//		this.title = title;
//		this.description = description;
//		this.creator_id = creator_id;
//		this.status = "OPEN";
//		this.replies = replies;
//	}
	
	//constructor to create a new post
	public Post (String id, String title, String description, String status, String creator_id)
	{
		this.id = id;
		this.title = title;
		this.description = description;
		this.status = status;
		this.creator_id = creator_id;
	}
	

	
	
	//return information about a post
	public String getPostDetails ()
	{
		return "\nPost ID: \n" + this.getId() + "\nTitle: " + this.getTitle() + "\nDescription: " + this.getDescription() 
		+ "\nCreator ID: " + this.getCreator_id() + "\nStatus: " + this.getStatus();
	}
	
	//abstract class to handle reply
	public abstract boolean handleReply (Reply reply);
	
	
	//abstract class to get reply details
	public abstract String getReplyDetails ();
	
	
	//accessor for title
	public String getTitle () {
		return this.title;
	}

	//mutator for title
	public void setTitle (String title) {
		this.title = title;
	}

	//accessor for description
	public String getDescription () {
		return this.description;
	}

	
	//mutator for description
	public void setDescription (String description) {
		this.description = description;
	}


	//accessor for creator_id
	public String getCreator_id () {
		return this.creator_id;
	}


	//mutator for creator_id
	public void setCreator_id (String creator_id) {
		this.creator_id = creator_id;
	}


	//accessor for status
	public String getStatus () {
		return this.status;
	}


	//mutator for status
	public void setStatus (String status) {
		this.status = status;
	}


	//accessor for replies
	public String getReplies () {
		return this.replies;
	}


	//mutator for replies
	public void setReplies (String replies) {
		this.replies = replies;
	}


	//accessor for id
	public String getId () {
		return this.id;
	}


	//mutator for id
	public void setId (String id) {
		this.id = id;
	}


    //abstract method to set the attendee_count variable from Event class
//	protected abstract void setAttendee_count(int i);
//
//
//    //abstract method to get the capacity of an event from Event class
//	protected abstract int getCapacity();
//
//
//	//abstract method to get the attendee count of an event from Event class
//	protected abstract int getAttendee_count();
	


}
