package people;

import GUI.Console;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
/***************/
/*             */
/* TeacherList */
/*             */
/***************/
/*=====================*/
public class TeacherList
/*=====================*/
{
	private ArrayList<Teacher> array;	//create Teacher array to save data;
	private BufferedReader br;	
	private BufferedWriter bw;
	private String line;//Calling the methods of a character buffered input stream object to read data
	private String[] strArray;//Used to split the read string data with split() to get an array of strings
	private Scanner sc;
	private String lin;//Store the input data for each row
    private String sid;
	
    public void show() throws IOException{
        
        array = new ArrayList<Teacher>();

        br = new BufferedReader(new FileReader("src\\people\\TeacherList.txt"));

        
        while ((line = br.readLine()) != null){
            strArray = line.split(",");

            //create teacher object
            Teacher t = new Teacher();

            //Extracts the value of each element of the string array from the corresponding assignment object member variable
            t.setSid(strArray[0]);
            t.setName(strArray[1]);
            t.setSkill(strArray[2]);

            //add teacher object to array
            array.add(t);
        }

        br.close();

        //finish loop then back to main page
        while (true) {
        	//finish the write of main page 
            System.out.println("--------Welcome to PTT Management System --------");
            System.out.println("1 Add teacher information");
            System.out.println("2 Change teacher information");
            System.out.println("3 Delete teacher information");
            System.out.println("4 Read teacher information");
            System.out.println("5 return");
            System.out.println("Please enter your choice:");

           
            Scanner sc = new Scanner(System.in);
            lin = sc.nextLine();

            bw = new BufferedWriter(new FileWriter("src\\people\\TeacherList.txt"));

          //Iterate the array then get each object
            for(Teacher s : array){

            	//change these data to String
                StringBuilder sb = new StringBuilder();
                sb.append(s.getSid()).append(",").append(s.getName()).append(",").append(s.getSkill());
                bw.write(sb.toString());
                bw.newLine();
                bw.flush();

            }
            
            bw.close();

          //Use the Switch statement to complete the operation
            switch (lin) {
                case"1":
                    addTeacher(array);
                    break;
                case"2":
                    updateTeacher(array);
                    break;
                case"3":
                    deleteTeacher(array);
                    break;
                case"4":
                    findAllTeacher(array);
                    break;
                case"5":
                	Console con = new Console();
        			con.main();
                    sc.close();

            }
        }
    }

    /*
     *  Add requirement information
     */
    public  void addTeacher(ArrayList<Teacher> array) {
    	//input information of teacher allow the prompt
        sc = new Scanner(System.in);
        

        while(true) {
            System.out.println("Please enter teacher ID£º");
            sid = sc.nextLine();

            boolean flag = isUsed(array, sid);
            if (flag) {
                System.out.println("The ID has been used, please enter again!");
            } else {
                break;
            }
        }
        System.out.println("Please enter teacher's name£º");
        String name = sc.nextLine();
        System.out.println("Please enter teacher's skill£º");
        String skill = sc.nextLine();

      //create teacher object,then give it given data
        Teacher t = new Teacher();
        t.setSid(sid);
        t.setName(name);
        t.setSkill(skill);

        //add teacher object into array
        array.add(t);


        System.out.println("Successfully added!");

    }

    //Check the id is duplicate or not
    public boolean isUsed(ArrayList<Teacher> array, String sid){
        boolean flag = false;
        for(int i = 0; i < array.size(); i++){
            Teacher t = array.get(i);
            if(t.getSid().equals(sid)){
                flag = true;
                break;
            }
        }
        return flag;
    }

    //read the teacher information
    public void findAllTeacher(ArrayList<Teacher> array) {
        ///check the array whether is blank or not
        if(array.size() == 0){
            System.out.println("No information£¬please add information at first!");
            return;
        }

        //print the added information
        System.out.println("ID\t\tName\t\tSkill");

        for(int i=0; i < array.size(); i++) {
            Teacher t = array.get(i);
            System.out.println(t.getSid() + "\t\t" + t.getName() + "\t\t" + t.getSkill());
        }
    }

    //delete teacher information
    public void deleteTeacher(ArrayList<Teacher> array){
        sc = new Scanner(System.in);
        System.out.println("Please enter the ID which you want to delete£º");
        sid = sc.nextLine();

        //Determine if the id exists when deleting or modifying teacher information
        //if not existed, remind user enter again
        int index = -1;
        for(int i = 0; i < array.size(); i++){
            Teacher t = array.get(i);
            if(t.getSid().equals(sid)){
                index = i;
                break;
            }
        }
        if(index == -1){
            System.out.println("his ID not found, please enter again");
        }else {
            array.remove(index);
            System.out.println("Successfully deleted!");
        }
    }

    //change teacher information
    public void updateTeacher(ArrayList<Teacher> array){

        sc = new Scanner(System.in);
        System.out.println("Please enter the ID you want to change");
        sid = sc.nextLine();


      //Determine if the id exists when deleting or modifying teacher information
      //if not existed, remind user enter again
        int index = -1;
        for(int i = 0; i < array.size(); i++){
            Teacher t = array.get(i);
            if(t.getSid().equals(sid)){
                index = i;
                break;
            }
        }
        if(index == -1){
            System.out.println("This ID not found, please enter again");
        }else {
   
            System.out.println("Please enter teacher's new name:");
            String name = sc.nextLine();
            System.out.println("Please enter teacher's new skill:");
            String skill = sc.nextLine();

            //create teacher object
            Teacher t = new Teacher();
            t.setSid(sid);
            t.setName(name);
            t.setSkill(skill);

            for(int i = 0; i < array.size(); i++){
                Teacher teacher = array.get(i);
                if(teacher.getSid().equals(sid)){
                    array.set(i,t);
                    break;
                }
            }

            System.out.println("Successfully changed!");
        }

    }

}



