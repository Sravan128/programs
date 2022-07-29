
import java.io.File;
import java.util.Scanner;
class FilesAscendingOrder {
          public void ascendingorder(String path) {
        	
				File fr=new File(path);
				String listoffiles[]=fr.list();
				if(listoffiles.length==0) {  //When directory is empty
					System.out.println("No files present in the directory");
				}
				// Files are auto arranged in a Ascending order
				//So no need to perform any operation or sorting technique.
				//Displays list of files in ascending order
				else {
				System.out.println("List of files in Directory");
				for(String str :listoffiles) {
					System.out.println(str);
				}
				}
          }
}

 class BusinessRequirements {
       public void createfile(String str) {
		File ff=new File(str+".txt");
		try {
			if(ff.createNewFile()) {       //create a new files and returns the boolean value
				System.out.println("File added successfully");
			}
			else{
				System.out.println("Already file Exists");
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
        public void deletefile(String str) {
		File ff=new File(str+".txt");
		try {
			if(ff.delete()) {   //ff.delete perform the deletion of the specified file and returns the boolean value
				System.out.println("File deleted successfully");
			}
			else{
				System.out.println(" File does not Exists");
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
        public void searchfile(String str) {
		File ff=new File(str+".txt");
		
		try {
			if(ff.exists()) {
				System.out.println(str+" file exists");
			}
			else {
				System.out.println(str+" file does not exists ");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void operations(String path) {
		Scanner sn=new Scanner(System.in);
		System.out.println("----- Business level Operations -------------");
		while(true) {
			//Business operations menu
			System.out.println("1. Add a file \n2. Delete a file  \n3.Search a file \n4.Return to main menu");
			System.out.println("\nEnter your choice : ");
			int choice=sn.nextInt();
			switch(choice) {
			    case 1:System.out.println("Enter file name to add : ");
			       String str=sn.next();
			       BusinessRequirements af=new BusinessRequirements();
			       af.createfile(path+str);
			    	break;
			    case 2:System.out.println("Enter file name to Delete : ");
			       String str1=sn.next();
			        BusinessRequirements df=new  BusinessRequirements();
			       df.deletefile(path+str1);
			    	break;
			    case 3:System.out.println("Enter file name to search : ");
			       String str2=sn.next();
			        BusinessRequirements sf=new  BusinessRequirements();
			       sf.searchfile(path+str2);
			    	break;
			    case 4:
			    	System.out.println("Navigating to main menu.");
			    	return;
			    default:System.out.println("Wrong option Entered! please enter correct option.");
			    break;
			}
		}
	}

}



 class Application{
	public static void details() {
		System.out.println("------------Application Details-------------");
		System.out.println("Project Name :LockedMe.com");
		System.out.println("This application is developed by :");
		System.out.println("ID : 253467");
		System.out.println("Name : Developer1");
		System.out.println("--------------------------------------------");
	}

	public static void main(String[] args) {
		Application.details();//shows the developer details
		Scanner sn=new Scanner(System.in);
		System.out.println("Enter the path or copy the location where to create a directory ");
		String path=sn.next();
		System.out.println("Enter the Directory name where to store files ");
		String dir=sn.next();
		path=path+"/"+dir;
		File f=new File(path);
		if(f.mkdir()) {
			System.out.println("Directory created");
		}
		else {
			System.out.println("Directory already exists");
		}
		while(true){
			// Main menu to perform the operations
			System.out.println("--------------Main menu --------------------");
			System.out.println("1. Display in ascending order \n2. Business level operations  \n3.Close the Application");
			
			System.out.println("Enter Your Choice : ");
			int choice=sn.nextInt();
			switch(choice) {
			      case 1 : FilesAscendingOrder as=new FilesAscendingOrder();
			                  as.ascendingorder(path);
			    	  break;
			      case 2 : BusinessRequirements br=new BusinessRequirements();
			                     br.operations(path+"/");
			    	  break;
			      case 3 :System.out.println("Thank you");
			    	  System.exit(0);
			    default: System.out.println("Wrong option Entered! please enter correct option.");
					    break;
			}
		}
	}

}


     