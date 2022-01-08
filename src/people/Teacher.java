package people;

/***************/
/*             */
/*  Teacher  */
/*             */
/***************/

/*======================*/
public class Teacher {
/*======================*/
	
    //Teacher ID
    private String sid;
    //Teacher name
    private String name;
    //Teacher skill
    private String skill;

 
//    public Teacher() {
//    }
  
// public Teacher(String sid, String name, String skill) {
//
//        this.sid = sid;
//        this.name = name;
//        this.skill = skill;
//    }
 
    public String getSid() {

        return sid;
    }
    
    public void setSid(String sid) {

        this.sid = sid;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

}