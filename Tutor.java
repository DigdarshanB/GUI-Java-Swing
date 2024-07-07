/**
 * This class represents Tutor, which is a sub-class of the parent-class, Teacher.
 *
 * @author (Digdarshan Bhattarai)
 * @version (1.0)
 */

    public class Tutor extends Teacher{
    
    private double salary;
    private String specialization;
    private String academicQualifications;
    private int performanceIndex;
    private boolean isCertified;
    
    //constructor
    public Tutor(int teacherId, String teacherName, String address, String workingType,String employmentStatus,int workingHours,
                 double salary, String specialization, String academicQualifications, int performanceIndex) {
        super(teacherId, teacherName, address, workingType, employmentStatus);
        this.salary = salary;
        this.specialization = specialization;
        this.academicQualifications = academicQualifications;
        this.performanceIndex = performanceIndex;
        this.isCertified = false; 
}
   public Tutor(int teacherId){
        super(teacherId);
    }
    // Accessor methods
    public double getSalary() 
    {
        return this.salary;
    }

    public String getSpecialization() 
    {
        return this.specialization;
    }

    public String getAcademicQualifications() 
    {
        return this.academicQualifications;
    }

    public int getPerformanceIndex()
    {
        return this.performanceIndex;
    }

    public boolean getIsCertified() 
    {
        return this.isCertified;
    }
    
    //method to set salary
    public void setSalary(double newSalary, int newPerformanceIndex) 
    {
        if (newPerformanceIndex > 5 && getWorkingHours() > 20) {
            double appraisalPercentage;

            if (newPerformanceIndex >= 5 && newPerformanceIndex <= 7) {
                appraisalPercentage = 0.05;
            } else if (newPerformanceIndex >= 8 && newPerformanceIndex <= 9) {
                appraisalPercentage = 0.10;
            } else { 
                appraisalPercentage = 0.20;
            }
            this.salary = newSalary + (appraisalPercentage * newSalary);
            
            this.isCertified = true;
        } else {
            System.out.println("Salary cannot be approved as the tutor hasn't been certified yet.");
        }
    }
    // Method to remove tutor(uncertified)
    public void removeTutor() {
        if (!isCertified) {
            this.salary = 0;
            this.specialization = "";
            this.academicQualifications = "";
            this.performanceIndex = 0;
            this.isCertified = false;
        } else {
            System.out.println("Certified tutors cannot be removed.");
        }
    }
    // Display method
    public void display() {
    super.display();
    if (!isCertified) {
            System.out.println("Salary: The tutor is not certified, can't be shown.");
        } else {
            System.out.println("Salary: " + this.salary);
            System.out.println("Specialization: " + this.specialization);
            System.out.println("Academic Qualifications: " + this.academicQualifications);
            System.out.println("Performance Index: " + this.performanceIndex);
    }
  }
}
