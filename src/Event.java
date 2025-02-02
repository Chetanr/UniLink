
public class Event extends Post
{
	private String venue;
	private String date;
	private int capacity;
	private int attendee_count;
	
	//constructor for Event class
	public Event (String id, String title, String description, String creator_id,
			String status, String replies, String venue, String date, int capacity)
	{
		super (id, title, description, creator_id, replies);
		this.venue = venue;
		this.date = date;
		this.capacity = capacity;
	}

	//constructor to create a new event post
	public Event (String id, String title, String description ,
			 String venue, String date, int capacity, String status, String creator_id)
	{
		super (id, title, description, status, creator_id);
		this.venue = venue;
		this.date = date;
		this.capacity = capacity;
	}
	

	//handle replies to a post
	@Override
	public boolean handleReply (Reply reply) 
	{
		if (reply.getValue() == 1)
		{
			
			return true;
		}
		else
			return false;
	}
	

	//get the details for the replies to a post
	@Override
	public String getReplyDetails () 
	{
		return null;
	}
	
	//return information about a post
	@Override
	public String getPostDetails ()
	{
		return "\nPost Id: " + this.getId() + "\nTitle: " + this.getTitle() + "\nDescription: " + this.getDescription() 
		+"\nCreator Id: " + this.getCreator_id() + "\nStatus: " + this.getStatus()+ "\nVenue: " + this.getVenue() 
		+ "\nDate: " + this.getDate() + "\nCapacity: " + this.getCapacity() + "\nAttendee Count: " + this.getAttendee_count();
	}

	public String getVenue() 
	{
		return this.venue;
	}

	public void setVenue(String venue) 
	{
		this.venue = venue;
	}

	public String getDate() 
	{
		return this.date;
	}

	public void setDate(String date) 
	{
		this.date = date;
	}

	public int getCapacity() 
	{
		return this.capacity;
	}

	public void setCapacity(int capacity) 
	{
		this.capacity = capacity;
	}

	public int getAttendee_count() 
	{
		return this.attendee_count;
	}

	public void setAttendee_count(int attendee_count) 
	{
		this.attendee_count = this.attendee_count + attendee_count;
	}
	

}
