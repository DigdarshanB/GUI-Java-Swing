

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Iterator;


public class TeacherGUI{
    
    private JFrame frame;
    private Tutor Tutor;
    private Lecturer Lecturer;
    private JPanel LecturerPanel, TutorPanel;
    private JLabel LecturerLabel,TutorLabel,TeacherIdLabel, TeacherNameLabel, AddressLabel, WorkingTypeLabel, EmploymentStatusLabel,
            YearsOfExperienceLabel,workingHoursLabel, SalaryLabel,GradedScoreLabel, SpecializationLabel, AcademicQualificationsLabel,
            PerformanceIndexLabel,DepartmentLabel;
    private JTextField TeacherIdTxtLecturer, TeacherNameTxtLecturer, AddressTxtLecturer, WorkingTypeTxtLecturer, EmploymentStatusTxtLecturer,
            YearsOfExperienceTxtLecturer,workingHoursTxtLecturer,DepartmentTxtLecturer;
    private JTextField TeacherIdTxtTutor, TeacherNameTxtTutor, WorkingTypeTxtTutor, EmploymentStatusTxtTutor,
            workingHoursTxtTutor, SalaryTxtTutor,AddressTxtTutor, SpecializationTxtTutor, AcademicQualificationsTxtTutor,
            PerformanceIndexTxtTutor;
    private JButton AddLecturer, AddTutor, GradeAssignment,SetSalary,RemoveTutor, DisplayLecturer, ClearLecturer, DisplayTutor, ClearTutor;
    private JComboBox comboBoxLecturer, comboBoxTutor;
    //declaring arraylist to store the objects of Teacher
    private ArrayList<Teacher>teacherAL=new ArrayList<>();
    private int tutorId=0;
    
   
    public TeacherGUI(){
    
    //creating the frame
    frame=new JFrame("TeacherGUI");
    frame.setSize(1000,500);//(width,height)
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("");
       
    //creating JPanel with Grid bag layout
    LecturerPanel = new JPanel(new GridBagLayout());
    GridBagConstraints gbc= new GridBagConstraints();
    gbc.fill=GridBagConstraints.HORIZONTAL;
    gbc.insets= new Insets(15,5,15,10); //top,left,bottom,right
       
    //LECTURER PANEL
    JLabel LecturerLabel=new JLabel("Lecturer");
    gbc.gridx=0;
    gbc.gridy=0;
    LecturerPanel.add(LecturerLabel,gbc);
    LecturerLabel.setPreferredSize(new Dimension(200,80)); //used this to increase the gap(padding)
    Font font1 = LecturerLabel.getFont().deriveFont(Font.BOLD, 24f);
    LecturerLabel.setFont(font1);
       
    //for teacherID
    TeacherIdLabel=new JLabel("Teacher ID:");
    TeacherIdTxtLecturer=new JTextField(15);
   
    //for label
    gbc.gridx=0;
    gbc.gridy=1;
    LecturerPanel.add(TeacherIdLabel, gbc);
    //for textfield
    gbc.gridx=1;
    gbc.gridy=1;
    LecturerPanel.add(TeacherIdTxtLecturer, gbc);
        
    //for teacher name
    TeacherNameLabel=new JLabel("Teacher Name:");
    TeacherNameTxtLecturer=new JTextField(15);
    gbc.gridx=0;
    gbc.gridy=2;
    LecturerPanel.add(TeacherNameLabel,gbc);
    gbc.gridx=1;
    gbc.gridy=2;
    LecturerPanel.add(TeacherNameTxtLecturer,gbc);
        
    //for address
    AddressLabel=new JLabel("Address:");
    AddressTxtLecturer=new JTextField(15);
    gbc.gridx=0;
    gbc.gridy=3;
    LecturerPanel.add(AddressLabel,gbc);
    gbc.gridx=1;
    gbc.gridy=3;
    LecturerPanel.add(AddressTxtLecturer,gbc);
       
    //for YearsOfExperience
    YearsOfExperienceLabel=new JLabel(" Years of Experience:");
    YearsOfExperienceTxtLecturer=new JTextField(15);
    gbc.gridx=0;
    gbc.gridy=4;
    LecturerPanel.add(YearsOfExperienceLabel,gbc);
    gbc.gridx=1;
    gbc.gridy=4;
    LecturerPanel.add(YearsOfExperienceTxtLecturer,gbc);
       
    //for WorkingType
    WorkingTypeLabel=new JLabel("Working Type:");
    WorkingTypeTxtLecturer=new JTextField(15);
    gbc.gridx=5;
    gbc.gridy=1;
    LecturerPanel.add(WorkingTypeLabel,gbc);
    gbc.gridx=6;
    gbc.gridy=1;
    LecturerPanel.add(WorkingTypeTxtLecturer,gbc);
       
    //for workingHours
    workingHoursLabel=new JLabel("Working Hours:");
    workingHoursTxtLecturer=new JTextField(10);
    gbc.gridx=5;
    gbc.gridy=3;
    LecturerPanel.add(workingHoursLabel,gbc);
    gbc.gridx=6;
    gbc.gridy=3;
    LecturerPanel.add(workingHoursTxtLecturer,gbc);
        
    //for Department
    DepartmentLabel=new JLabel("Department:");
    gbc.gridx=5;
    gbc.gridy=4;
    LecturerPanel.add(DepartmentLabel,gbc);
    DepartmentTxtLecturer=new JTextField(15);
    gbc.gridx=6;
    gbc.gridy=4;
    LecturerPanel.add(DepartmentTxtLecturer,gbc);
        
    //for EmploymentStatus
    EmploymentStatusLabel=new JLabel("Employment Status:");
    EmploymentStatusTxtLecturer=new JTextField(15);
    gbc.gridx=5;
    gbc.gridy=2;
    LecturerPanel.add(EmploymentStatusLabel,gbc);
    gbc.gridx=6;
    gbc.gridy=2;
    LecturerPanel.add(EmploymentStatusTxtLecturer,gbc);
       
    //button to add lecturer
    JButton AddLecturer=new JButton("Add Lecturer");
    gbc.gridx=0;
    gbc.gridy=12;
    LecturerPanel.add(AddLecturer,gbc);
    //adding action listener to make addLecturer functional
    AddLecturer.addActionListener(new ActionListener(){
     public void actionPerformed(ActionEvent e){
            //this helps to get values from the textfield which is required for making an object
                try{
                int teacherId=Integer.parseInt(TeacherIdTxtLecturer.getText());
                String teacherName= TeacherNameTxtLecturer.getText();
                String address = AddressTxtLecturer.getText(); 
                String workingType = WorkingTypeTxtLecturer.getText();
                String employmentStatus = EmploymentStatusTxtLecturer.getText();
                int workingHours =Integer.parseInt(workingHoursTxtLecturer.getText());
                int yearsOfExperience = Integer.parseInt(YearsOfExperienceTxtLecturer.getText());
                String department=DepartmentTxtLecturer.getText();
                
                //creating new lecturer object
                Lecturer LecturerObj=new Lecturer(teacherId,teacherName,address,workingType,employmentStatus,department, yearsOfExperience, workingHours);
                
                
                //adding the lecturer object to the arraylist
                teacherAL.add(LecturerObj);
               
                JOptionPane.showMessageDialog(null, "Lecturer added successfully.");
            
            } catch(NumberFormatException ex){
               JOptionPane.showMessageDialog(null, "Make sure to enter appropriate values.","error",JOptionPane.ERROR_MESSAGE);
            
            }
               
        }
        });
       
        //button to grade assignments
        JButton GradeAssignment=new JButton("Grade Assignments");
        gbc.gridx=1;
        gbc.gridy=12;
        LecturerPanel.add(GradeAssignment,gbc);
        //adding action listener to grade assignment button:
        GradeAssignment.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            //creating a new frame to grade assignment
            JFrame GA_Frame = new JFrame("Grade Assignment");
            GA_Frame.setVisible(true);
            GA_Frame.setSize(400,400); 
            GA_Frame.setLayout(new GridBagLayout());
               
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.HORIZONTAL;
            constraints.insets = new Insets(10,10,10,10);
            
            //for teacher id
            JLabel TeacherIdLabel = new JLabel("Teacher id");
            constraints.gridx = 0;
            constraints.gridy = 0;
            GA_Frame.add(TeacherIdLabel,constraints);
               
            JTextField TeacherIdField = new JTextField(10);
            constraints.gridx = 1;
            constraints.gridy = 0;
            GA_Frame.add(TeacherIdField,constraints);
            
            //for years of experience
            JLabel yearsOfExperienceLabel = new JLabel("Years of experience:");
            constraints.gridx = 0;
            constraints.gridy = 1;
            GA_Frame.add(yearsOfExperienceLabel,constraints);
               
            JTextField yearsOfExperienceField = new JTextField(10);
            constraints.gridx = 1;
            constraints.gridy = 1;
            GA_Frame.add(yearsOfExperienceField,constraints);
               
            //for gradedScore
            JLabel gradedScoreLabel = new JLabel("Graded Score");
            constraints.gridx = 0;
            constraints.gridy = 2;
            GA_Frame.add(gradedScoreLabel,constraints);
               
            JTextField gradedScoreField = new JTextField(10);
            constraints.gridx = 1;
            constraints.gridy = 2;
            GA_Frame.add(gradedScoreField,constraints);
                  
            //for department
            JLabel departmentLabel = new JLabel("Department");
            constraints.gridx = 0;
            constraints.gridy = 3;
            GA_Frame.add(departmentLabel ,constraints);
               
            JTextField departmentField = new JTextField(10);
            constraints.gridx = 1;
            constraints.gridy = 3;
            GA_Frame.add(departmentField,constraints);
               
               
            //for gradeAssignment button in the new frame
            JButton gradeAssignment = new JButton("Grade Assignment");
            constraints.gridx = 1;
            constraints.gridy = 4;
            GA_Frame.add(gradeAssignment,constraints);
               
        
            //making the gradeAssignment button functional
            gradeAssignment.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ev){
                try{
                    int teacherId = Integer.parseInt(TeacherIdField.getText());
                    int yearsOfExp = Integer.parseInt(yearsOfExperienceField.getText());
                    int gradedScore = Integer.parseInt(gradedScoreField.getText());
                    String department = departmentField.getText();
                    boolean idFound = false;
                    
                    
                    Iterator <Teacher> iterator = teacherAL.iterator();
                    Lecturer lec = new Lecturer(teacherId,null, null, null, null, department, yearsOfExp,0);
                    while(iterator.hasNext()){
                       Teacher lect = iterator.next();
                        if(lect instanceof Lecturer){
                           if (lect.getTeacherId() == teacherId){
                               lec = (Lecturer) lect;
                               idFound = true;
                           }
                       }
                    }
                    
                    if(idFound){
                
                        
                        JOptionPane.showMessageDialog(null,lec.gradeAssignment(gradedScore, department, yearsOfExp),"grade assignment",JOptionPane.INFORMATION_MESSAGE);
                    }

                    else{
                        JOptionPane.showMessageDialog(null,"Id not found","error",JOptionPane.ERROR_MESSAGE);
                    }
                
                
                }
                    
                catch(Exception e){
                    JOptionPane.showMessageDialog(null,"Invalid input","error",JOptionPane.ERROR_MESSAGE);
                }
               }
            });
           }
        }
    );
    

        //Clear button
        JButton ClearLecturer = new JButton("Clear");
        gbc.gridx = 5;
        gbc.gridy = 12;
        LecturerPanel.add(ClearLecturer,gbc);
        //adding action listener for Clear Button:
        ClearLecturer.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(e.getSource()==ClearLecturer){
                TeacherIdTxtLecturer.setText("");
                TeacherNameTxtLecturer.setText("");
                AddressTxtLecturer.setText("");
                EmploymentStatusTxtLecturer.setText("");
                WorkingTypeTxtLecturer.setText("");
                YearsOfExperienceTxtLecturer.setText("");
                workingHoursTxtLecturer.setText("");
                DepartmentTxtLecturer.setText("");
                }
            }
        });
        
        
        
        //Display Button
        JButton DisplayLecturer = new JButton("Display");
        gbc.gridx = 6;
        gbc.gridy = 12;
        LecturerPanel.add(DisplayLecturer,gbc);
        //adding action listener for display lecturer button
        DisplayLecturer.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                String LecturerValueHolder = " ";
                Iterator <Teacher> iterator=teacherAL.iterator();
                while(iterator.hasNext()){
                    Teacher lecturer=iterator.next();
                    if(lecturer instanceof Lecturer){
                        Lecturer lec =(Lecturer) lecturer;
                        LecturerValueHolder= "Lecturer Name:"+ lec.getTeacherName()+"\n"
                                             +"Lecturer ID:" + lec.getTeacherId()+"\n"
                                             +"Address:" + lec.getAddress()+"\n"
                                             +"WorkingType" + lec.getWorkingType()+"\n"
                                             +"Employment Status:" + lec.getEmploymentStatus()+"\n"
                                             +"Department:" + lec.getDepartment()+"\n"
                                             +"Years Of Experience:" + lec.getYearsOfExperience()+"\n"
                                             +"WorkingHours:" + lec.getWorkingHours()+"\n";
                                             
                    }
                }
                JOptionPane.showMessageDialog(null, LecturerValueHolder);
                
            } catch(NumberFormatException ex){
                //(this value sets where the popup comes from (name of button can be added),)
                JOptionPane.showMessageDialog(null, "Please enter valid values for TeacherID, GradedScore, YearsOfExperience and Department");
            
            }
        }
    });
            
        

       
        //for combobox
        JComboBox<String>comboBoxLecturer=new JComboBox<>();
        comboBoxLecturer.addItem("Lecturer");
        comboBoxLecturer.addItem("Tutor");
        gbc.gridx=6;
        gbc.gridy=0;
        LecturerPanel.add(comboBoxLecturer,gbc);
        comboBoxLecturer.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String selectedOption=(String) comboBoxLecturer.getSelectedItem(); //getSelectedItem is a function so to be called properly () is reqd
                if(selectedOption.equals("Lecturer")){
                    LecturerPanel.setVisible(true);
                    TutorPanel.setVisible(false);
                }else if(selectedOption.equals("Tutor")){
                    LecturerPanel.setVisible(false);
                    TutorPanel.setVisible(true);
                }
            }
        });
       
       
       
       
        //TUTOR PANEL
        TutorPanel = new JPanel(new GridBagLayout());
        //GridBagConstraints gbc= new GridBagConstraints();
        gbc.fill=GridBagConstraints.HORIZONTAL;
        gbc.insets= new Insets(15,10,15,5); //top,left,bottom,right
       
       
        JLabel TutorLabel=new JLabel("Tutor");
        gbc.gridx=0;
        gbc.gridy=0;
        TutorPanel.add(TutorLabel,gbc);
        TutorLabel.setPreferredSize(new Dimension(200,80)); //used this to increase the gap(padding)
        Font font2 = TutorLabel.getFont().deriveFont(Font.BOLD, 24f);
        TutorLabel.setFont(font2);
       
        //for TeacherID
        TeacherIdLabel=new JLabel("Teacher ID:");
        gbc.gridx=0;
        gbc.gridy=1;
        TutorPanel.add(TeacherIdLabel,gbc);
        TeacherIdTxtTutor=new JTextField(15);
        gbc.gridx=1;
        gbc.gridy=1;
        TutorPanel.add(TeacherIdTxtTutor,gbc);
       
        //for TEACHER NAME
        TeacherNameLabel=new JLabel("Teacher Name:");
        gbc.gridx=0;
        gbc.gridy=2;
        TutorPanel.add(TeacherNameLabel,gbc);
        TeacherNameTxtTutor=new JTextField(15);
        gbc.gridx=1;
        gbc.gridy=2;
        TutorPanel.add(TeacherNameTxtTutor,gbc);
       
     
        //for WorkingType
        WorkingTypeLabel=new JLabel("Working Type:");
        WorkingTypeTxtTutor=new JTextField(15);
        gbc.gridx=0;
        gbc.gridy=3;
        TutorPanel.add(WorkingTypeLabel,gbc);
        gbc.gridx=1;
        gbc.gridy=3;
        TutorPanel.add(WorkingTypeTxtTutor,gbc);
       
        //for EmploymentStatus
        EmploymentStatusLabel=new JLabel("Employment Status:");
        EmploymentStatusTxtTutor=new JTextField(15);
        gbc.gridx=0;
        gbc.gridy=4;
        TutorPanel.add(EmploymentStatusLabel,gbc);
        gbc.gridx=1;
        gbc.gridy=4;
        TutorPanel.add(EmploymentStatusTxtTutor,gbc);
       
        //for salary
        SalaryLabel=new JLabel("Salary:");
        SalaryTxtTutor=new JTextField(15);
        gbc.gridx=5;
        gbc.gridy=1;
        TutorPanel.add(SalaryLabel,gbc);
        gbc.gridx=6;
        gbc.gridy=1;
        TutorPanel.add(SalaryTxtTutor,gbc);
        
        //for address
        AddressLabel=new JLabel("Address:");
        AddressTxtTutor=new JTextField(15);
        gbc.gridx=5;
        gbc.gridy=2;
        TutorPanel.add(AddressLabel,gbc);
        gbc.gridx=6;
        gbc.gridy=2;
        TutorPanel.add(AddressTxtTutor,gbc);
       
       
        //for working hours
        workingHoursLabel=new JLabel("Working Hours:");
        workingHoursTxtTutor=new JTextField(15);
        gbc.gridx=5;
        gbc.gridy=3;
        TutorPanel.add(workingHoursLabel,gbc);
        gbc.gridx=6;
        gbc.gridy=3;
        TutorPanel.add(workingHoursTxtTutor,gbc);
       
        //for specializatiom
        SpecializationLabel=new JLabel(" Specialization:");
        SpecializationTxtTutor=new JTextField(15);
        gbc.gridx=5;
        gbc.gridy=4;
        TutorPanel.add(SpecializationLabel,gbc);
        gbc.gridx=6;
        gbc.gridy=4;
        TutorPanel.add(SpecializationTxtTutor,gbc);
       
        //for academic qualifications
        AcademicQualificationsLabel=new JLabel("Academic Qualifications:");
        AcademicQualificationsTxtTutor=new JTextField(15);
        gbc.gridx=5;
        gbc.gridy=5;
        TutorPanel.add(AcademicQualificationsLabel,gbc);
        gbc.gridx=6;
        gbc.gridy=5;
        TutorPanel.add(AcademicQualificationsTxtTutor,gbc);

       
        //for performance index
        PerformanceIndexLabel=new JLabel("Performance Index:");
        PerformanceIndexTxtTutor=new JTextField(15);
        gbc.gridx=0;
        gbc.gridy=5;
        TutorPanel.add(PerformanceIndexLabel,gbc);
        gbc.gridx=1;
        gbc.gridy=5;
        TutorPanel.add(PerformanceIndexTxtTutor,gbc);
       
       
        //button to add tutor
        JButton AddTutor=new JButton("Add Tutor");
        gbc.gridx=0;
        gbc.gridy=7;
        TutorPanel.add(AddTutor,gbc);
        //making addTutor functional
        AddTutor.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
                try{
                    
                
                int teacherId=Integer.parseInt(TeacherIdTxtTutor.getText());
                tutorId=teacherId;
                String teacherName=TeacherNameTxtTutor.getText();
                String workingType = WorkingTypeTxtTutor.getText();
                String employmentStatus = EmploymentStatusTxtTutor.getText();
                int performanceIndex=Integer.parseInt(PerformanceIndexTxtTutor.getText());
                int salary=Integer.parseInt(SalaryTxtTutor.getText());
                String address = AddressTxtTutor.getText();
                int workingHours =Integer.parseInt(workingHoursTxtTutor.getText());
                String specialization=SpecializationTxtTutor.getText();
                String academicQualifications=AcademicQualificationsTxtTutor.getText();
                
               
                Tutor TutorObj=new Tutor(teacherId,teacherName,address,workingType,employmentStatus,workingHours,salary,specialization,academicQualifications,performanceIndex);
                
                teacherAL.add(TutorObj);
                JOptionPane.showMessageDialog(null, "Tutor added successfully.");
                
                
                
                
           }catch(NumberFormatException ex){
               JOptionPane.showMessageDialog(null, "Make sure to enter appropriate values.","error",JOptionPane.ERROR_MESSAGE);
            
           }
            
        }
    });
    
    
        
        //button to remove tutor
        JButton RemoveTutor=new JButton("Remove Tutor");
        gbc.gridx=1;
        gbc.gridy=7;
        TutorPanel.add(RemoveTutor,gbc);
        RemoveTutor.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            JFrame RT_Frame=new JFrame("Remove Tutor");
            RT_Frame.setVisible(true);
            RT_Frame.setSize(300,300); 
            RT_Frame.setLayout(new GridBagLayout());
               
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.HORIZONTAL;
            constraints.insets = new Insets(10,10,10,10);
            
            //for Teacher ID
            JLabel TeacherID=new JLabel("Teacher ID:");
            constraints.gridx=0;
            constraints.gridy=0;
            RT_Frame.add(TeacherID,constraints);
            
            JTextField TeacherIdTF=new JTextField(10);
            constraints.gridx=1;
            constraints.gridy=0;
            RT_Frame.add(TeacherIdTF,constraints);
            
            //button
            JButton newRemoveTutor=new JButton("Remove Tutor");
            constraints.gridx=1;
            constraints.gridy=1;
            RT_Frame.add(newRemoveTutor,constraints);
            newRemoveTutor.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
                try{
                int teacherId=Integer.parseInt(TeacherIdTF.getText());
                Tutor TutorObj=new Tutor(teacherId);
                boolean teacherFound= false;
                for(Teacher teachers: teacherAL){
                    if(teachers.getTeacherId()==teacherId){
                     teacherFound=true;
                     teacherAL.remove(TutorObj);
                     break;
                    }
                }
                teacherAL.remove(TutorObj);
                teacherId=0;
                String message= "";
                TeacherIdTF.setText("");
                if(teacherFound){
                    message= "Tutor removed successfully.";
                }else{
                    message= "Tutor with that Id is missing";
                }
                JOptionPane.showMessageDialog(null, message);
           }catch(NumberFormatException ex){
               JOptionPane.showMessageDialog(null, "Please enter valid values","error",JOptionPane.ERROR_MESSAGE);
            
           }
            
        }
    });
        }
    });
       
       
        //button to set salary
        JButton SetSalary=new JButton("Set Salary");
        gbc.gridx=6;
        gbc.gridy=8;
        TutorPanel.add(SetSalary,gbc);
        //making the button functional
        SetSalary.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            JFrame SS_Frame = new JFrame("Set Salary");
            SS_Frame.setVisible(true);
            SS_Frame.setSize(400,400); 
            SS_Frame.setLayout(new GridBagLayout());
               
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.HORIZONTAL;
            constraints.insets = new Insets(10,10,10,10);
            
            //for Teacher ID
            JLabel TeacherID=new JLabel("Teacher ID:");
            constraints.gridx=0;
            constraints.gridy=0;
            SS_Frame.add(TeacherID,constraints);
            
            JTextField newTeacherIdTF=new JTextField(10);
            constraints.gridx=1;
            constraints.gridy=0;
            SS_Frame.add(newTeacherIdTF,constraints);
            
            //for New Salary
            JLabel salary=new JLabel("Salary:");
            constraints.gridx=0;
            constraints.gridy=1;
            SS_Frame.add(salary,constraints);
            
            JTextField salaryTF=new JTextField(10);
            constraints.gridx=1;
            constraints.gridy=1;
            SS_Frame.add(salaryTF,constraints);
            
            //for new Performance Index
            JLabel performanceIndex=new JLabel("Performance Index:");
            constraints.gridx=0;
            constraints.gridy=2;
            SS_Frame.add(performanceIndex,constraints);
            
            JTextField performanceIndexTF=new JTextField(10);
            constraints.gridx=1;
            constraints.gridy=2;
            SS_Frame.add(performanceIndexTF,constraints);
            
            //adding set salary button
            JButton newSetSalary=new JButton("Set Salary");
            constraints.gridx=1;
            constraints.gridy=3;
            SS_Frame.add(newSetSalary,constraints);
            newSetSalary.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                 int teacherId=Integer.parseInt(newTeacherIdTF.getText());
    
                 String message="";
                 if(teacherId == tutorId){                                                                                        
                     message="New Salary is "+salaryTF.getText();
                 }else{
                    message="Teacher Id do not match";
                 }

                JOptionPane.showMessageDialog(null, message);
           }catch(NumberFormatException ex){
               JOptionPane.showMessageDialog(null, "Please enter valid values","error",JOptionPane.ERROR_MESSAGE);
            
           }
            
        }
      });
                
     }
            
    });
        
       
        //display button
        JButton DisplayTutor=new JButton("Display");
        gbc.gridx=5;
        gbc.gridy=7;
        TutorPanel.add(DisplayTutor,gbc);
         //adding action listener for display lecturer button
        DisplayTutor.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                String TutorValueHolder = " ";
                Iterator <Teacher> iterator=teacherAL.iterator();
                while(iterator.hasNext()){
                    Teacher tutor=iterator.next();
                    if(tutor instanceof Tutor){
                        Tutor tut =(Tutor) tutor;
                        TutorValueHolder="Tutor Name:"+ tut.getTeacherName()+"\n"
                                         +"Tutor ID:" + tut.getTeacherId()+"\n"
                                         +"Address:" + tut.getAddress()+"\n"
                                         +"WorkingType:" + tut.getWorkingType()+"\n"
                                         +"Employment Status:" + tut.getEmploymentStatus()+"\n"
                                         +"WorkingHours:" + tut.getWorkingHours()+"\n";
                                             
                    }
                }
                JOptionPane.showMessageDialog(null, TutorValueHolder);
                
            } catch(NumberFormatException ex){
                //(this value sets where the popup comes from (name of button can be added),)
                JOptionPane.showMessageDialog(null, "Please enter valid values for TeacherID, GradedScore, YearsOfExperience and Department");
            
            }
        }
    });
            
       
       
        //clear button
        JButton ClearTutor=new JButton("Clear");
        gbc.gridx=6;
        gbc.gridy=7;
        TutorPanel.add(ClearTutor,gbc);
        //adding action listener to the Clear Button
        ClearTutor.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(e.getSource()==ClearTutor){
                TeacherIdTxtTutor.setText("");
                TeacherNameTxtTutor.setText("");
                WorkingTypeTxtTutor.setText("");
                EmploymentStatusTxtTutor.setText("");
                PerformanceIndexTxtTutor.setText("");          
                SalaryTxtTutor.setText("");
                AddressTxtTutor.setText("");
                workingHoursTxtTutor.setText("");
                SpecializationTxtTutor.setText("");
                AcademicQualificationsTxtTutor.setText("");  
                
                }
            }
        });
        
       
       
        //for combobox
        JComboBox<String>comboBoxTutor=new JComboBox<>();
        comboBoxTutor.addItem("Tutor");
        comboBoxTutor.addItem("Lecturer");
        gbc.gridx=6;
        gbc.gridy=0;
        TutorPanel.add(comboBoxTutor,gbc);
        TutorPanel.setVisible(false);
        comboBoxTutor.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String selectedOption=(String) comboBoxTutor.getSelectedItem(); //getSelectedItem is a function so to be called properly () is reqd
                if(selectedOption.equals("Tutor")){
                    LecturerPanel.setVisible(false);
                    TutorPanel.setVisible(true);
                }else if(selectedOption.equals("Lecturer")){
                    LecturerPanel.setVisible(true);
                    TutorPanel.setVisible(false);
                }
            }
        });
       
        frame.getContentPane().add(LecturerPanel, BorderLayout.NORTH);
        frame.getContentPane().add(TutorPanel, BorderLayout.CENTER);
        frame.setVisible(true);
       
        
        
       
       
    }
    public static void main(String args[]){
        new TeacherGUI();
       
    }
}
