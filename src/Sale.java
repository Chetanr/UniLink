
public class Sale extends Post
{
	private double asking_price;
	private double highest_offer;
	private double minimum_raise;

	//constructor for Sale class
	public Sale (String id, String title, String description, String creator_id
			, String status, double minimum_raise, double highest_offer)
	{
		super (id, title, description, creator_id, status);
		this.minimum_raise = minimum_raise;
		this.highest_offer = highest_offer;
	}
	
	//constructor to create a new sale post
	public Sale (String id, String title, String description, double asking_price, double minimum_raise, String status, String creator_id)
	{
		super (id, title, description, status, creator_id);
		this.asking_price = asking_price;
		this.minimum_raise = minimum_raise;
	}
	
	
	//to get the details of the post
	@Override
	public String getPostDetails ()
	{
		return "\nPost ID: " + this.getId() + "\nTitle: " + this.getTitle() + "\nDescription: " + this.getDescription() + 
				"\nCreator Id: " + this.getCreator_id() + "\nStatus: " + this.getStatus();
				//+ this.getMinimum_raise() + this.getHighest_offer();
	}


	//accessor for asking_price
	public double getAsking_price ()
	{
		return this.asking_price;
	}


	//mutator for asking_price
	public void setAsking_price (double asking_price)
	{
		this.asking_price = asking_price;
	}


	//accessor for highest_offer
	public double getHighest_offer ()
	{
		return this.highest_offer;
	}


	//mutator for highest_offer
	public void setHighest_offer (double highest_offer)
	{
		this.highest_offer = highest_offer;
	}


	//accessor for minimum_raise
	public double getMinimum_raise ()
	{
		return this.minimum_raise;
	}


	//mutator for minimum_raise
	public void setMinimum_raise (double minimum_raise)
	{
		this.minimum_raise = minimum_raise;
	}


	@Override
	public boolean handleReply (Reply reply)
	{
		
		return false;
	}


	@Override
	public String getReplyDetails ()
	{
		return "";
	}
	

}
