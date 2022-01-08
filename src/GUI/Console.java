package GUI;

import java.io.IOException;
import java.util.Scanner;

import people.RequirementList;
import people.TeacherList;
/***************/
/*             */
/*  ConsoleIn  */
/*             */
/***************/

/*======================*/
public class Console {
/*======================*/
	
	public Console() {	
}
	public void main() {
		System.err.println("Please INPUT 1/2 to view teacher list or teaching requirement list:"
				+ "\n1 for teacher list"
				+ "\n2 for teaching requirement list"
				+ "\n3 quit system");
		Scanner scan = new Scanner(System.in);
	    //String i = sc.nextLine();
		 switch (scan.nextLine()) {
	     	case"1":
			try {
				TeacherList LoT = new TeacherList();
				LoT.show();
				scan.close();
			} catch (IOException e1) {e1.printStackTrace();}
		
			case"2":
			try {
				RequirementList LoR = new RequirementList();
				LoR.show();
				scan.close();
			} catch (IOException e1) {e1.printStackTrace();}
			case"3":
				scan.close();
				System.err.println("Thanks for using PTT system!");
				System.exit(0);
	}
}
}
