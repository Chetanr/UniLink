import java.util.*;
import java.lang.*;

public class Unilink 
{
	static int event_num = 1, sale_num = 1, job_num = 1;
	static String id = null;
	static ArrayList <Post> post = new ArrayList<Post>();

	public static void main (String[] args) 
	{
		
		int ch, validate = 0, option;
		
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
			case 2: System.exit(0);
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
					case 9: break;
				}
				
			}
			
			
		}
		else
		{
			System.out.println("Bye");
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
		
		
		Event event = new Event(id, name, desc, venue, date, capacity, "OPEN", id);
		post.add(event);
		
		System.out.println("Success! Your event has been created with id " + id);
		
	}

	
	//function for New Sale Post
	public static void newSalePost()
	{
		String name, desc, post_id = "SAL";
		double asking_price = 0.0, minimum_raise = 0.0;
		
		Scanner sc = new Scanner(System.in);
		
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
	}
	
	
	//function for new Job Post
	public static void newJobPost()
	{
		String name, desc, post_id = "JOB";
		int proposed_price = 0;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter details of the item to sale below:");
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
	}
	
	
	//function for reply to Post
	public static int replyToPost()
	{
		String post_id;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter post id or 'Q' to quit:");
		post_id = sc.next();
		
		if (post_id.equals('Q'))
		{
			return 0;
		}
		else
		{
			
		}
		
		return 1;
	}
	
	
	//function for display my Posts
	public static void displayMyPost()
	{
		for (Post i : post)
		{
			System.out.println(i.getPostDetails());
		}
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
			
	}
	
	
	//function for delete Post
	public static void deletePost()
	{
			
	}
}
