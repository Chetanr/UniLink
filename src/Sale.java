
public class Sale extends Post
{
	private int asking_price;
	private int highest_offer;
	private int minimum_raise;

	//constructor for Sale class
	public Sale (String id, String title, String description, String creator_id
			, String status, int minimum_raise, int highest_offer)
	{
		super (id, title, description, creator_id, status);
		this.minimum_raise = minimum_raise;
		this.highest_offer = highest_offer;
	}
	
	//constructor to create a new sale post
	public Sale (String id, String title, String description, int asking_price, int minimum_raise)
	{
		super (id, title, description);
		this.asking_price = asking_price;
		this.minimum_raise = minimum_raise;
	}
	
	
	//to get the details of the post
	@Override
	public String getPostDetails ()
	{
		return this.getId() + this.getTitle() + this.getDescription() + this.getCreator_id() + this.getStatus()
				+ this.getMinimum_raise() + this.getHighest_offer();
	}


	//accessor for asking_price
	public int getAsking_price ()
	{
		return this.asking_price;
	}


	//mutator for asking_price
	public void setAsking_price (int asking_price)
	{
		this.asking_price = asking_price;
	}


	//accessor for highest_offer
	public int getHighest_offer ()
	{
		return this.highest_offer;
	}


	//mutator for highest_offer
	public void setHighest_offer (int highest_offer)
	{
		this.highest_offer = highest_offer;
	}


	//accessor for minimum_raise
	public int getMinimum_raise ()
	{
		return this.minimum_raise;
	}


	//mutator for minimum_raise
	public void setMinimum_raise (int minimum_raise)
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
		// TODO Auto-generated method stub
		return null;
	}
	

}
