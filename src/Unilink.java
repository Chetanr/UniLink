import java.util.*;
import java.lang.*;

public class Unilink 
{
	static int event_num = 1, sale_num = 1, job_num = 1;
	static String id = null;
	static ArrayList <Post> post = new ArrayList<Post>();

	public static void main (String[] args) 
	{
		
		int ch = 0, validate = 0, option;
		

		while (ch != 2)
		{
			System.out.println ( "**UniLink System**" );
			System.out.println ( "1. Login" );
			System.out.println ( "2. Quit" );
			
			Scanner sc = new Scanner ( System.in );
			ch = sc.nextInt();
			
			switch(ch)
			{ 
				case 1: System.out.println ("Enter the login id: ");
						id = sc.next();
						validate = ValidateLogin (id);
						break;
				case 2: System.out.println("Thank you for using the system.!");
						System.exit(0);
			}
			
			if ( validate == 1 )
			{
				while (ch != 9)
				{
					ch = options();
					
					switch(ch)
					{
						case 1: newEventPost();
								break;
						case 2: newSalePost();
								break;
						case 3: newJobPost();
								break;
						case 4: replyToPost();
								break;
						case 5: displayMyPost();
								break;
						case 6: displayAllMyPost();
								break;
						case 7: closePost();
								break;
						case 8: deletePost();
								break;
						case 9: logout();
								break;
					}
					
				}
				
				
			}
			else
			{
				System.out.println("Bye");
			}

		}
		}
		

	
	//function to validate login 
	public static int ValidateLogin (String id)
	{
		if (id.charAt(0) == 's')
		{
			if(id.charAt (1) >= '0' && id.charAt (1) <= '9')
			{
				return 1;
			}
		}
		
		return 0;
	}
	
	
	//validate options after logging in
	public static int options()
	{
		Scanner sc = new Scanner (System.in);
		int ch = 0;
		
		System.out.println("---------------------");
		System.out.println ( "**UniLink System**" );
		System.out.println ( "1. New Event Post" );
		System.out.println ( "2. New Sale Post" );
		System.out.println ( "3. New Job Post" );
		System.out.println ( "4. Reply to Post" );
		System.out.println ( "5. Display My Posts" );
		System.out.println ( "6. Display All Posts" );
		System.out.println ( "7. Close Post" );
		System.out.println ( "8. Delete Post" );
		System.out.println ( "9. Logout" );
		
		System.out.println("Enter your choice:");
		ch = sc.nextInt();
		
		return ch;
	}
	
	
	//function for New Event Post
	public static void newEventPost()
	{ 
		String name, desc, venue, date, post_id = "EVE";
		int capacity = 0;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("-------------");
		System.out.println("Enter details of the event below:");
		System.out.println("Name:");
		name = sc.next();
		System.out.println("Description:");
		desc = sc.next();
		System.out.println("Venue:");
		venue = sc.next();
		System.out.println("Date:");
		date = sc.next();
		System.out.println("Capacity:");
		capacity = sc.nextInt();
		
		post_id = post_id + event_num;
		event_num++;
		
		
		Event event = new Event(post_id, name, desc, venue, date, capacity, "OPEN", id);
		post.add(event);
		
		System.out.println("Success! Your event has been created with id " + post_id);
		
	}

	
	//function for New Sale Post
	public static void newSalePost()
	{
		String name, desc, post_id = "SAL";
		double asking_price = 0.0, minimum_raise = 0.0;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("-------------");
		System.out.println("Enter details of the item to sale below:");
		System.out.println("Name:");
		name = sc.next();
		System.out.println("Description:");
		desc = sc.next();
		System.out.println("Asking Price:");
		asking_price = sc.nextDouble();
		System.out.println("Minimum Raise:");
		minimum_raise = sc.nextDouble();
		
		post_id = post_id + sale_num;
		
		sale_num++;
		
		Sale sale = new Sale(post_id, name, desc, asking_price, minimum_raise, "OPEN", id);
		post.add(sale);
		
		System.out.println("Success! Your event has been created with id " + post_id);
	}
	
	
	//function for new Job Post
	public static void newJobPost()
	{
		String name, desc, post_id = "JOB";
		int proposed_price = 0;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("-------------");
		System.out.println("Enter details of the job below:");
		System.out.println("Name:");
		name = sc.next();
		System.out.println("Description:");
		desc = sc.next();
		System.out.println("Proposed Price:");
		proposed_price = sc.nextInt();
		
		post_id = post_id + job_num;
		
		job_num++;
		
		Job job = new Job (post_id, name, desc, proposed_price, "OPEN", id);
		post.add(job);
		
		System.out.println("Success! Your event has been created with id " + post_id);
	}
	
	
	//function for reply to Post
	public static int replyToPost()
	{
		String post_id, response;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter post id or 'Q' to quit:");
		post_id = sc.next();
		
		if (post_id.equals('Q'))
		{
			return 0;
		}
		else
		{
			if (post_id.charAt(0) == 'E')
			{
				respondToEventPost(post_id);
				
			}
			else if (post_id.charAt(0) == 'J')
			{
				respondToJobPost(post_id);	
			}
			else if (post_id.charAt(0) == 'S')
			{
				respondToSalePost(post_id);
			}
		}	
		return 1;
	}
	
	
	//respond to job post
	public static int respondToJobPost(String post_id)
	{
		double offerPrice;
		Scanner sc = new Scanner(System.in);
		
		fetchPostDetails(post_id);
		System.out.println("Enter your offer: ");
		offerPrice = sc.nextDouble();
		
		for (Post i : post)
		{
			if (i.getId().equals(post_id))
			{	
				if(offerPrice < ((Job) i).getLowest_offer())
				{
					System.out.println("Offer Accecpted.!");
					return 1;
				}
				else if (offerPrice > ((Job) i).getLowest_offer())
				{
					System.out.println("Offer not accepted.!");
					return 0;
				}	
			}	
		}
		return 0;
	}
	
	
	//respond to sale post
	public static int respondToSalePost(String post_id)
	{
		double offer;
		Scanner sc = new Scanner(System.in);
		
		fetchPostDetails(post_id);
		System.out.println("Enter your offer or 'Q' to quit:");
		offer = sc.nextDouble();
		
		for (Post i : post)
		{
			if(i.getId().equals(post_id));
			{
				if (i.getStatus().equals("OPEN"))
				{
					if (offer < ((Sale) i).getMinimum_raise())
					{
						System.out.println("Offer not accepted.!");
						return 0;
					}
					else if (offer > ((Sale) i).getMinimum_raise())
					{
						System.out.println("Your offer has been submitted.!");
						
						Reply reply = new Reply (post_id, 1, id);
						i.handleReply(reply);
						
						
						if ( (((Sale) i).getHighest_offer() - offer ) < ((Sale) i).getAsking_price())
						{
							if (offer >= ((Sale) i).getAsking_price())
							{
								((Sale) i).setHighest_offer (offer);
								i.setStatus("CLOSED");
								System.out.println("Congratulation.!" + i.getTitle() + " has been sold to you");
								System.out.println("Please contact " + i.getCreator_id() + " for more details");
								return 1;
							}
							else
							{
								((Sale) i).setHighest_offer (offer);
								System.out.println("However, your offer is below the asking price");
								System.out.println("The item is still on sale.!");
								return 1;
							}
							
						}
					}
				}
				else
				{
					System.out.println("Post already closed.! Reply not accepted");
				}
			}
			
			
			
		}
		
		return 0;
	}
	
	
	
	
	//respond to event post
	public static int respondToEventPost(String post_id)
	{
		String response ;
		Scanner sc = new Scanner(System.in);
			
		fetchPostDetails(post_id);
		System.out.println("Enter '1' to join Event or 'Q' to quit");
		response = sc.next();
			
		if(response.equals("1"))
		{
			for (Post i : post)
			{
				if (i.getId().equals(post_id))
				{
					if(i.getStatus().equals("OPEN"))
					{
						if (((Event) i).getCapacity() >= ((Event) i).getAttendee_count())
						{
							((Event) i).setAttendee_count(1);
							System.out.println("Event registration successful.!");
							if (((Event) i).getAttendee_count() == ((Event) i).getCapacity())
							{
								i.setStatus("CLOSED");
							}
							return 1;
						}
					}
					else if (i.getStatus().equals("CLOSED"))
					{
						System.out.println("Sorry.! The Event is closed.");
					}
				}
			}
		}
		else if(response.equals("Q"))
		{
			return 0;
		}
			
		return 0;
	}
	
	
	//fetch the details of the post to reply
	public static String fetchPostDetails(String post_id)
	{
		for (Post i : post)
		{
			if (i.getId().contentEquals(post_id))
			{
				if(i.getCreator_id().equals(id))
				{
					return "Replying to your own post is invalid.!";
				}
				else
				{
					return i.getPostDetails();
				}	
			}
		}
		return "Invalid Post ID! Post not found.";
	}
	
	//function for display my Posts
		public static void displayMyPost()
		{
			for (Post i : post)
			{
				if (i.getCreator_id().equals(id))
				{
					System.out.println(i.getPostDetails());
					System.out.println("-----------------");
					return ;
				}
			}
			System.out.println("There are no posts created by you.!");
		}
		
	
	
	//function for display all my Posts
	public static void displayAllMyPost()
	{
		for (Post i : post)
		{
			System.out.println(i.getPostDetails());
		}
	}
	
	
	//function for close Post
	public static void closePost()
	{
		Scanner sc = new Scanner (System.in);
		String post_id;
		
		System.out.println("Enter the id or 'Q' to quit: ");
		post_id = sc.next();
		
		if(post_id != "Q")
		{
			return;
		}
		else if (post_id.equals("Q"))
		{
			
			for (Post i : post)
			{
				if (i.getId().equals(post_id))
				{
					if (i.getCreator_id().equals(id))
					{
						i.setStatus("CLOSED");
						System.out.println("Post has ben successfully closed.!");
						return;
					}
					else
					{
						System.out.println("Access Denied! You are not the owner of the post.");
					}
				}
			}
			System.out.println("Post not found.!");
		}
		
	}
	
	
	//function for delete Post
	public static void deletePost()
	{
		Scanner sc = new Scanner (System.in);
		String post_id;
		
		System.out.println("Enter the id or 'Q' to quit: ");
		post_id = sc.next();
		
		
		if (post_id != "Q")
		{
			for (Post i : post)
			{
				if (i.getId().equals(post_id))
				{
					if(i.getCreator_id().equals(id))
					{
						post.remove(i);
						System.out.println("Post has been successfuly deleted.");
						return;
					}	
					else
					{
						System.out.println("Access Denied! You are not the owner of the post.");
					}
				}
			}
			System.out.println("Post not found.!");
		}
		else
		{
			return ;
		}
		
		return ; 
		
	}
	
	//logout of the system
	public static void logout()
	{
		System.out.println("You have successfully logged out!");
	}
	
	
	
}
