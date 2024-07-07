/**
 * This class represents Lecturer, which is a sub-class of the parent-class, Teacher.
 *
 * @author (Digdarshan Bhattarai)
 * @version (1.0)
 */

    public class Lecturer extends Teacher
    {
    private String department;
    private int yearsOfExperience;
    private int gradedScore;
    private boolean hasGraded;
    private int workingHours;
    
    public Lecturer(int teacherId, String teacherName, String address, String workingType, String employmentStatus,
                    String department,int yearsOfExperience, int workingHours){
        //super calls the constructor of the parent class
        super(teacherId, teacherName, address, workingType, employmentStatus);
        this.department=department;
        this.yearsOfExperience=yearsOfExperience;
        this.gradedScore=0;
        this.hasGraded=false; 
        this.workingHours=workingHours;
    }
    
//accessor method
    public String getDepartment()
    {
        return this.department;
    }
    
    public int getYearsOfExperience()
    {
        return this.yearsOfExperience;
    }
    
    public int getGradedScore()
    {
        return this.gradedScore;
    }
    
    public boolean getHasGraded()
    {
        return this.hasGraded;
    }
    
//mutator method/setter method: modifies state of an object by updating the values of its attributes
    public void setGradedScore()
    {
        this.gradedScore=gradedScore;
    }
    
//method to grade assignments
    public String gradeAssignment(int score, String Department, int YearsOfexperience) {
        String Grade;
        hasGraded=false;
        if (!hasGraded && yearsOfExperience >= 5 && department.equals(Department)) {
            if (score >= 70) {
                Grade="A";
            } else if (score >= 60) {
                Grade="B"; 
            } else if (score >= 50) {
                Grade="C";
            } else if (score >= 40) {
                Grade="D";
            } else {
                Grade="E";
            }

            hasGraded = true;
        } else {
            Grade="Assignment not graded yet or conditions not met.";
        }
        return Grade;
    }  

//display method
    public void display(){
    super.display();
            
    if(hasGraded){
     System.out.println("Graded score:" + this.gradedScore);
    }
    else{
     System.out.println("Assignment hasn't been graded yet.");
    }

  }
}
    
     
    
    
    

