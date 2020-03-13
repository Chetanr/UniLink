
public class Reply 
{
	private String post_id;
	private int value;
	private String responder_id;
	
	
	//constructor for reply class
	public Reply (String post_id, int value, String responder_id)
	{
		this.post_id = post_id;
		this.value = value;
		this.responder_id = responder_id;
	}


	//accessor for post_id
	public String getPost_id ()
	{
		return this.post_id;
	}


	//mutator for post_id
	public void setPost_id (String post_id)
	{
		this.post_id = post_id;
	}


	//accessor for value
	public int getValue ()
	{
		return this.value;
	}


	//mutator for value
	public void setValue (int value)
	{
		this.value = value;
	}


	//accessor for responder_id
	public String getResponder_id ()
	{
		return this.responder_id;
	}


	//mutator for responder_id
	public void setResponder_id (String responder_id) 
	{
		this.responder_id = responder_id;
	}
	
	
}
