package people;
/***************/
/*             */
/*  Requirement  */
/*             */
/***************/

/*======================*/
public class Requirement {
/*======================*/
	
	//Course name
    private String className;
    //Lab ID
    private String lid;
    //Required teacher number
    private String teaNum;
    //Required skill
    private String skill;

    public String getLid() {
        return lid;
    }
    
    public void setLid(String lid) {
        this.lid = lid;
    }
    
    public String getClassName() {
        return className;
    }
 
    public void setClassName(String className) {
        this.className = className;
    }
    
    public String getTeaNum() {
        return teaNum;
    }

    public void setTeaNum(String teaNum) {
        this.teaNum = teaNum;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
	
}