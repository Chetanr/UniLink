
public class Job extends Post
{
	private int proposed_price;
	private int lowest_offer;
	
	public Job (String id, String title, String description, String creator_id
			, String status, int proposed_price, int lowest_offer)
	{
		super(id, title, description, creator_id, status);
		this.proposed_price = proposed_price;
		this.lowest_offer = lowest_offer;
	}

	
	@Override
	public boolean handleReply(Reply reply) {
		// TODO Auto-generated method stub
		return false;
	}

	
	@Override
	public String getReplyDetails() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	//accessor for proposed_price
	public int getProposed_price() {
		return proposed_price;
	}

	
	//mutator for proposed_price
	public void setProposed_price(int proposed_price) {
		this.proposed_price = proposed_price;
	}

	
	//accessor for plowest_offer
	public int getLowest_offer() {
		return lowest_offer;
	}

	
	
	//mutator for lowest_offer
	public void setLowest_offer(int lowest_offer) {
		this.lowest_offer = lowest_offer;
	}

	@Override
	public String getPostDetails ()
	{
		return this.getId() + this.getTitle() + this.getDescription() + this.getCreator_id() + this.getStatus();
	}

}
