package people;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import GUI.Console;
/***************/
/*                */
/*RequirementList*/
/*              */
/***************/

/*=====================*/
public class RequirementList
/*=====================*/
{
	private BufferedReader br;
	private BufferedWriter bw;	
	private ArrayList<Requirement> array;	//create Requirement array to save data;
	private String line; //Calling the methods of a character buffered input stream object to read data
	private String[] strArray;	//Used to split the read string data with split() to get an array of strings
	private static Scanner sc;	
	private String lin;//Store the input data for each row
	private StringBuilder sb;
	
    public void show() throws IOException {
    	
    	fileIO();

        //finish loop then back to main page
        while (true) {
            //finish the write of main page 
            System.out.println("--------Welcome to PTT Management System--------");
            System.out.println("1 Add requirement list");
            System.out.println("2 Change requirement list");
            System.out.println("3 Delete requirement list");
            System.out.println("4 Read requirement list");
            System.out.println("5 Return");
            System.out.println("Please enter your choice£º");

            sc = new Scanner(System.in);
            lin = sc.nextLine();

            bw = new BufferedWriter(new FileWriter("src\\people\\RequirementList.txt"));

            //Iterate the array then get each object
            for(Requirement s : array){

                //change these data to String
                sb = new StringBuilder();
                sb.append(s.getClassName()).append(",").append(s.getLid()).append(",").append(s.getTeaNum()).append(",").append(s.getSkill());
                bw.write(sb.toString());
                bw.newLine();

            }
            
            bw.close();

            //Use the Switch statement to complete the operation
            switch (lin) {
                case"1":
                    addRequirement(array);
                    break;
                case"2":
                    updateRequirement(array);
                    break;
                case"3":
                    deleteRequirement(array);
                    break;
                case"4":
                    findAllRequirement(array);
                    break;
                case"5":
                	Console con = new Console();
        			con.main();
                    sc.close();
            }
        }
    }
    public void fileIO() throws IOException {
    	array = new ArrayList<Requirement>();

        br = new BufferedReader(new FileReader("src\\people\\RequirementList.txt"));
        
        while ((line = br.readLine()) != null){
            
            strArray = line.split(",");

            //Create course object
            Requirement r = new Requirement();

            //Extracts the value of each element of the string array from the corresponding assignment object member variable
            r.setClassName(strArray[0]);
            r.setLid(strArray[1]);           
            r.setTeaNum(strArray[2]);
            r.setSkill(strArray[3]);

            //Adding course objects to array
            array.add(r);
        }
   
        br.close();
    }
    /*
     *  Add requirement information
     */
    public static void addRequirement(ArrayList<Requirement> array) {
    	
    	//input requirements allow the prompt
    	
        sc = new Scanner(System.in);
        System.out.println("Please enter course name£º");
        String className = sc.nextLine();
        System.out.println("Please enter Lab ID£º");
        String lid = sc.nextLine(); 
        System.out.println("Please enter the required teacher number£º");
        String teaNum = sc.nextLine();
        System.out.println("Please enter the required skill£º");
        String skill = sc.nextLine();


        //create requirement object,then give it given data
        Requirement r = new Requirement();
        
        r.setClassName(className);
        r.setLid(lid);
        r.setTeaNum(teaNum);
        r.setSkill(skill);
        //add it into array
        array.add(r);

        System.out.println("add information Successfully!");

    }

    /*
     * read requirements
     */
    public static void findAllRequirement(ArrayList<Requirement> array) {
        //check the array whether is blank or not
        if(array.size() == 0){
            System.out.println("No information£¬please add information at first!");
            return;
        }

        //print the added information
        System.out.println("ClassName\tLab\t\tRequired teacher number\t\tRequired skill");


        for(int i=0; i < array.size(); i++) {
            Requirement r = array.get(i);

            System.out.println(r.getClassName() + "\t\t" + r.getLid() + "\t\t" + r.getTeaNum() + "\t\t\t\t\t\t\t" + r.getSkill());
        }
    }

    /*delete requirement
     * 
     */
    public static void deleteRequirement(ArrayList<Requirement> array){
        sc = new Scanner(System.in);
        System.out.println("Please enter the course name which you want to delete£º");
        String className = sc.nextLine();

        //Determine if the id exists when deleting or modifying requirement information
        //if not existed, remind user enter again
        
        int index = -1;
        for(int i = 0; i < array.size(); i++){
            Requirement r = array.get(i);
            if(r.getClassName().equals(className)){
                index = i;
                break;
            }
        }
        if(index == -1){
            System.out.println("This ID not found, please enter again");
        }else {
            array.remove(index);
            System.out.println("Successfully deleted!");
        }
    }

    /*change requirement
     * 
     */
    public static void updateRequirement(ArrayList<Requirement> array){
 
        sc = new Scanner(System.in);
        System.out.println("Please enter the course name you want to change");
        String className = sc.nextLine();

      //Determine if the id exists when deleting or modifying requirement information
        //if not existed, remind user enter again
        
        int index = -1;
        for(int i = 0; i < array.size(); i++){
            Requirement r = array.get(i);
            if(r.getClassName().equals(className)){
                index = i;
                break;
            }
        }
        if(index == -1){
            System.out.println("This course name not found, please enter again");
        }else {
   
            System.out.println("Please enter the lab ID");
            String lid = sc.nextLine();
            System.out.println("Please enter the new required teacher number");
            String teaNum = sc.nextLine();
            System.out.println("Please enter the new required skill");
            String skill = sc.nextLine();

            //create requirement object
            Requirement r = new Requirement();
            
            r.setClassName(className);
            r.setLid(lid);
            r.setTeaNum(teaNum);
            r.setSkill(skill);

            //if inputed ID is correct, change existed data
            for(int i = 0; i < array.size(); i++){
                Requirement requirement = array.get(i);
                if(requirement.getClassName().equals(className)){
                    array.set(i,r);
                    break;
                }
            }
            System.out.println("Successfully Changed!");
        }

    }

}