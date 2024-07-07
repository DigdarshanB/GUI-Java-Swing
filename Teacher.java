/**
 * This is the parent class representing Teacher.
 *
 * @author (Digdarshan Bhattarai)
 * @version (1.0)
 */

    public  class Teacher
    { 
     private int teacherId;
     private String teacherName;
     private String address;
     private String workingType;
     private String employmentStatus;
     private int workingHours;
    
     //constructor
    public Teacher(int teacherId, String teacherName, String address,String workingType,String employmentStatus){ 
        this.teacherId=teacherId;
        this.teacherName=teacherName;
        this.address=address;
        this.workingType=workingType;
        this.employmentStatus=employmentStatus;
    }
    
    public Teacher(int teacherId){
        this.teacherId= teacherId;
    }
    
    //accessor method
    public int getTeacherId()
    {
        return this.teacherId;
    }
    public String getTeacherName()
    {
        return this.teacherName;
    }
    public String getAddress()
    {
        return this.address;
    }
    public String getWorkingType()
    {
        return this.workingType;
    }
    public String getEmploymentStatus()
    {
    return this.employmentStatus;
    } 
    public int getWorkingHours()
    {
    return this.workingHours;
    }

//setter method
    public void  setWorkingHours()
    {
    this.workingHours=workingHours;
    }

//display method
    public void display()
    {
        System.out.println("Teacher Name:" + " " + this.teacherName);
        System.out.println("Teacher ID:" + " " + this.teacherId);
        System.out.println("Address:" + " " + this.address);
        System.out.println("Working type:" + " " + this.workingType);
        System.out.println("Employment Status:" + " " + this.employmentStatus);
        
    
        if(workingHours==0){
        System.out.println("Working hour has not been set.");
    }
    else{
         System.out.println("Working hours:" + " " + this.workingHours);  
    }

  }
}

    
   
