import java.util.Scanner;
import java.lang.*;

public class Unilink {

	public static void main (String[] args) 
	{
		
		int ch, validate = 0;
		String id = null;
		
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
			ch = options();
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

}
