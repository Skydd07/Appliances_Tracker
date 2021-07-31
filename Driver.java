import java.util.Scanner;
public class Driver {
	 final static String password="c249";
	 static int choice,num;
	 static long srn;
	 static Scanner keyboard=new Scanner(System.in);
	 static String pass;
	 static int max;
	 static int counter;
	 static Appliance[] inventory;
	 
	 /**
	  * Takes a double value of price as input and prints all the appliances
	  * with price less than the input value
	  * 
	  * @param pr the double value
	  */
	 public static void findCheaperThan(double pr) {
		 int ctr=0;
		 for(int i=0,j=0;i<(Appliance.getSerialNumber()-1000000);i++)
		 { if(inventory[i].getPrice()<pr)
		 {	 System.out.println((++j)+". "+inventory[i]);
		 ctr++;
		 }
	 }
		 if(ctr==0)
	    	{System.out.println("No Appliances exist with price less than you entered");
	    	 System.out.println("Main menu will reappear");
	    	}
		 
	 }
	 
	 
	 /**
	  * Takes a String value of brand as input and prints all the appliances
	  * with the input brand value
	  * 
	  * @param br the String value
	  */
	 
    public static void findAppliancesBy(String br) {
    	int ctr=0;
    for(int i=0,j=0;i<(Appliance.getSerialNumber()-1000000);i++) {
    	if(inventory[i].getBrand().equalsIgnoreCase(br))
    	{	System.out.println((++j)+". "+ inventory[i]); 
    	 ctr++;
    	} }
    	if(ctr==0)
    	{System.out.println("No Appliances exists under this brand name");
    	 System.out.println("Main menu will reappear");
    	}
    	
    }
	 /**
	  * Takes a String type value and checks if it equal to types given
	  * 
	  * @param type The input type value to be checked
	  * @return a boolean value indicating the checking
	  */
	public static boolean check_type(String type) 
	{
		if (type.equalsIgnoreCase("Fridge")||type.equalsIgnoreCase("Washer")||type.equalsIgnoreCase("Dryer")||type.equalsIgnoreCase("Air Conditioner")||type.equalsIgnoreCase("Freezer")||type.equalsIgnoreCase("Stove")||type.equalsIgnoreCase("Dishwasher")||type.equalsIgnoreCase("Microwave")||type.equalsIgnoreCase("Water Heaters"))
			return true;
		return false;
	}
	/**
	 * Takes a long value of serialNumber as a input and checks if the appliance
	 * of that serialNumber exists or not
	 * 
	 * @param srn The long value to be checked
	 * @return a boolean value indicating the checking
	 */
	public static boolean check_srnum(long srn)
	{ 
//		System.out.println("max = "+max);
//    	System.out.println(Appliance.serialNumber);
		for(int i=1000000;i<(Appliance.getSerialNumber());i++) 
		{
			if(inventory[i-1000000].getSno()==srn) {
//	     	System.out.println(inventory[i].sno);
				return true;}
			}
		return false;
	
	}
	/**
	 * A static method which provides the user with a menu
	 * 
	 * @return an int indicating the choice output by user
	 */
	  
	public static int  main_menu() 
	{
		   System.out.println("What do you want to do?");
		   System.out.println("   1.  Enter new Appliance(s) (password required)");
		   System.out.println("   2.  Change information of an appliance (password required)");
		   System.out.println("   3.  Display all appliances by a specific brand");
		   System.out.println("   4.  Display all appliances under a specific price");
		   System.out.println("   5.  Quit");
		   System.out.print("Please enter your choice >  ");
		   choice=keyboard.nextInt();
		   if (choice<1||choice>5)
		   { do {
		   System.out.println("Oops!! You entered an invalid choice. Please enter a number between 1-5.");
		   System.out.println("What do you want to do?");
		   System.out.println("   1.  Enter new Appliance(s) (password required)");
		   System.out.println("   2.  Change information of an appliance (password required)");
		   System.out.println("   3.  Display all appliances by a specific brand");
		   System.out.println("   4.  Display all appliances under a specific price");
		   System.out.println("   5.  Quit");
		   System.out.print("Please enter your choice >  ");
		   choice=keyboard.nextInt();
		   } while(choice<1||choice>5); }	  
		   return choice;
	}
	/**
	 * This method asks the user the password and after the entry of correct
	 * password asks the user to input the appliance(s) details and after this stores 
	 * the details in an array
	 * 
	 * 
	 */
	
	public static void choice_one()
	{
		String ty=null,br=null;
		double pr=0;
		int x=0;
//	    Appliance[] inventory=new Appliance[max];
		   do {
		   System.out.print("Please enter password  ");
		   pass=keyboard.next();
		   if(!(pass.equals(password)))
		   { System.out.println("Oops you entered an invalid password.");
			   counter++;}
		   if(counter==3||counter==6||counter==9)
		   {  do {main_menu();
			   if(choice==1)
			   {    continue; }
			   else if(choice==2)
			   {    choice_two(); }
			   else if(choice==3)
				   choice_three();
			     else if(choice==4)
			     {  choice_four(); }
			   }while(choice!=5);
			   System.out.println("Program will terminate immediately");
			      System.exit(0);}
			        
			   
		   else if(counter==12)
		   { System.out.println("Program detected suspicious activities and will terminate immediately!");
			   System.exit(0);} 
		   } while(!(pass.equals(password)));
		  
//		   System.out.println("max="+max);
		   counter=0;
		   do {
		   System.out.print("How many appliances do you want to enter? ");
		   num=keyboard.nextInt();
		  if(num>max)
			   System.out.println("Not enough space in the inventory to add these many appliances. You can only add a maximum of "+max+" appliances. Enter again");
		    }while(num>max);
		   for(int i=0;i<num;i++)
		   {x=0;
			   System.out.println("Enter the type of Appliance "+((Appliance.getSerialNumber()-1000000)+1)); 
			do {
//		    System.out.println();
//			System.out.println("Enter the type of Appliance "+((Appliance.getSerialNumber()-1000000)+1));      
			ty=keyboard.nextLine();
//			ty1=keyboard.next();
//	        System.out.println(ty);
//	        System.out.println(ty1);
//	        System.out.println(ty+" "+ty1);
            if(check_type(ty));
	        else
	        {  if(x==0)
	        	{
	        	System.out.println("Type can only be one of the following: Fridge, Air Conditioner, Washer, Dryer, Freezer, Stove, Dishwasher, Water Heaters, and Microwave");
	        	x++;
	        	} 
	            else  
	            {
	        	System.out.println("You have entered an invalid type. Again, type can only be one of the above.");
	        	}
	        }
			}while(!check_type(ty));
			
			System.out.println("Enter the brand of Appliance "+((Appliance.getSerialNumber()-1000000)+1));
			br=keyboard.next();
			
			do {
				System.out.println("Enter the price of Appliance "+((Appliance.getSerialNumber()-1000000)+1));
				pr=keyboard.nextDouble();
				if(pr>=1.00);
				else
					System.out.println("Price cannot be less than 1 $");
			}while(pr<1.00);	
//			System.out.println(Appliance.getSerialNumber());
           inventory[(int) (Appliance.getSerialNumber()-1000000)]=new Appliance(ty, br, pr);
//         System.out.println(Appliance.getSerialNumber());
//         System.out.println(inventory[(int) (Appliance.getSerialNumber()-1000001)].toString());
	     }
//		   System.out.println(max);
             max=max-num;
//	         System.out.println(max);
	         System.out.println(num+" Appliance(s) added");
//		   System.out.println("max="+max);
	}
	/**
	 * In this method after the entry of correct password, it asks
	 * the user the serialNumber of the appliance of which he wishes to 
	 * update or change any information of and changes that information in 
	 * the array
	 */
	public static void choice_two()
	{
		int x1=0;
//		System.out.println(Appliance.getSerialNumber());
		if((Appliance.getSerialNumber()-1000000)==0) {
			System.out.println("You have not added any appliances yet in the inventory.");
			System.out.println("Main menu will reappear");
		}
		else
			{
			int schoice, tchoice;
	  String t,b;
//	  Appliance[] inventory=new Appliance[max];
	  double p;
//	  System.out.println("max="+max);
//		  System.out.println(inventory[0].toString());
//		  System.out.println(inventory[1].toString());
//		  System.out.println(inventory[2].toString());
	  
	  
		 do {
			   System.out.print("Please enter password  ");
			   pass=keyboard.next();
			   if(!(pass.equals(password)))
			   { System.out.println("Oops you entered an invalid password.");
				   counter++;}
			   if(counter%3==0&&counter!=0)
			   {  do {main_menu();
				   if(choice==1)
				   {    choice_one(); }
				   else if(choice==2)
				   {    continue; }
				   else if(choice==3)
					   choice_three();
				     else if(choice==4)
				     {  choice_four(); }
				   }while(choice!=5);
				   System.out.println("Program will terminate immediately");
				      System.exit(0);}
			   } while(!(pass.equals(password)));
		 do {
		 System.out.print("Enter the serial number of the appliance you wish to update ");
		  srn=keyboard.nextLong();
		  if(check_srnum(srn)==true) {
//		   System.out.println(inventory.length);
//			 System.out.println((inventory[(int)(srn-1000000)]).toString());
			  break;}
		  else
		  { System.out.println("The serial number you entered is invalid");
		      System.out.println("Please enter 1 if you want to re-enter the serial number and 2 if u want to go back to the main menu");
		      schoice=keyboard.nextInt();
		      if(schoice==1);
		      else if(schoice==2) 
		      {
		    	  do {main_menu();
		      if(choice==1)
		      {    choice_one(); }
		      else if(choice==2)
		      {    choice_two(); }
		      else if(choice==3)
		   	   choice_three();
		        else if(choice==4)
		        {  choice_four(); }
		      }while(choice!=5);
		      System.out.println("Program will terminate immediately");
		         System.exit(0);
		    	  }
		      }
//		  System.out.println(inventory.length);
//			 System.out.println((inventory[(int)(srn-1000000)]).toString());
		 }while(check_srnum(srn)==false);
//		 System.out.println("max ="+max);
//		 System.out.println("srn ="+srn);
//		 System.out.println(inventory.length);
//		 System.out.println((inventory[(int)(srn-1000000)]).toString());
		 do {
		 System.out.println("");
		 System.out.println("Appliance Serial # "+srn);
		 System.out.println("Brand : "+inventory[(int) (srn-1000000)].getBrand());
		 System.out.println("Type : "+inventory[(int)(srn-1000000)].getType());
		 System.out.println("Price : "+inventory[(int)(srn-1000000)].getPrice());
		 System.out.println("");
		 System.out.println("Which information would you like to change?");
		 System.out.println("   1. Brand");
		 System.out.println("   2. Type");
		 System.out.println("   3. Price");
		 System.out.println("   4. Quit");
		 do {
		 System.out.print("Enter your choice >");
		 tchoice=keyboard.nextInt();
		 if(tchoice<1||tchoice>4)
			 System.out.println("Please enter a valid number i.e. from 1 to 4");
		 }while(tchoice<1||tchoice>4);
		 if(tchoice==1) { 
			 System.out.println("Enter the updated brand");
			 b=keyboard.next();
			 inventory[(int)(srn-1000000)].setBrand(b);}
		 else if(tchoice==2) {
			 System.out.println("Enter the updated type");
			do { 
			 t=keyboard.nextLine();
			 if(check_type(t)==true);
			 else {
				if(x1==0) {
				 System.out.println("Type can only be one of the following: Fridge, Air Conditioner, Washer, Dryer, Freezer, Stove, Dishwasher, Water Heaters, and Microwave");
				x1=0;
				}
				else {
					System.out.println("You have entered an invalid type. Again, type can only be one of the following");
					x1++;
				}
				}
			 }while (check_type(t)==false);
			inventory[(int) (srn-1000000)].setType(t);
		 }
		 else if(tchoice==3) {
			 do {
			 System.out.println("Enter the updated price");
			 p=keyboard.nextDouble();
			 if(p>=1.00);
			 else
				 System.out.println("Price can never be less than 1$");
			 }while(p<1.00);
			 inventory[(int)(srn-1000000)].setPrice(p);
		 }
		 }while(tchoice!=4);}
     }
	
	/**
	 * This method displays all the appliances with brand input by
	 * the user
	 */
	public static void choice_three() {
		if(	(Appliance.getSerialNumber()-1000000)==0) {
			System.out.println("You have not added any appliances yet in the inventory.");
			System.out.println("Main menu will reappear");
			
			
		}
		else {
		String br;
		System.out.print("Enter brand name ");
		br=keyboard.next();
		findAppliancesBy(br);
		System.out.println("");
	}}
	/**
	 * This method displays all the appliances with price less than 
	 * that input by the user
	 */
	public static void choice_four() {
		if((Appliance.getSerialNumber()-1000000)==0) {
			System.out.println("You have not added any appliances yet in the inventory.");
			System.out.println("Main menu will reappear");
		}
		else {
		double pr;
		System.out.print("Enter price ");
		pr=keyboard.nextDouble();
		findCheaperThan(pr);
		
	}}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
   System.out.println("Welcome to the software that will help you in acquiring and keeping track of all the appliances at your store.");
   do{System.out.print("What is the maximum number of appliances that you would like to contain in your store?  ");
    max=keyboard.nextInt();
    if(max==0)
    {System.out.println("You have entered an invalid number");
    	System.out.println("Enter again");}
    }while(max<1);
    inventory=new Appliance[max];
   do {main_menu();
   if(choice==1)
   {    choice_one(); }
   else if(choice==2)
   {    choice_two(); }
   else if(choice==3)
	   choice_three();
     else if(choice==4)
     {  choice_four(); }
   }while(choice!=5);
   System.out.println("Program will terminate immediately");
      System.exit(0);
   
   }
   }





















