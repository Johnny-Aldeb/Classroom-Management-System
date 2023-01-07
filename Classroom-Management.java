




// ------------------------------------------------------------------------------- //
// Assignment (4) question 1 and 2
// Written by: (Johnny Aldeb and Student ID Number:40187248)
// For COMP 248 Section ( U ) – Winter 2022
// ---------------------------------------------------------------------------------


/*  This program allows new students to enroll in COMP-248 course section U with respect to class size, find their position in class,
 *  Unenroll from class, update their first and last name, update their assignments and other scores such that labs, Mid-Term, final exam, 
 *  And get their personal information and evaluation record including first and last name of the existence student, his/her studentID, 
 *  grades in labs, assignments 1,2,3,4 as well as their mid-Term, final exam,cumulative weight score, and final letter grade.
 *  
 *  this program calculate the minimum, maximum, and the average score among all the student enrolled in COMP-248 course section U.
 *  
 * finally this program display the report of all students in COMP-248 course section U 
 * 
 */




import java.util.Scanner;


// create class named Comp248secU
class Comp248secU {
	
	   // declare all attributes 
	   private static int classSize;
	   private static String semesterYear;
	   private static String lectureRoom;
	   private static String instructorFname;
	   private static String instructorLname;
	   private  String[] studFname;
	   private  String[] studLname;
	   private  int[] studID;
	   private  double[] assgt1;
	   private  double[] assgt2;
	   private  double[] assgt3;
	   private  double[] assgt4;
	   private  double[] labs;
	   private  double[] midTerm;
	   private  double[] finalExam;
	   
	   
	   // declare and initialize a static variable
	   static int index = 0;
	   
	   
	    // default constructor
	    public Comp248secU() {
	    }
	   
	    
	    
	    // constructor with parameters for the user to pass
	    public Comp248secU(String fname,String lname, String room,String semYr, int size) {
	    	
	    	//initialize our attributes 
	      this.setInstructorFname(fname);
	      this.setInstructorLname(lname);
	      this.setLectureRoom(room);
	      this.setSemesterYear(semYr);
	      this.setClassSize(size);
	    }
	    
	    
	    
	    // Method to add new student in course with respect to class size 
		public void addStudent(String fname, String lname, int studId, int arrIdx) {
			if (getStudentIdx(studId) == -1) {
				if (arrIdx < getClassSize()) {
					
					//initialize our attributes 
					studID[arrIdx] = studId;
					studFname[arrIdx] = fname;
					studLname[arrIdx] = lname;
					assgt1[arrIdx] = 0.0;
					assgt2[arrIdx] = 0.0;
					assgt3[arrIdx] = 0.0;
					assgt4[arrIdx] = 0.0;
					labs[arrIdx] = 0.0;
					midTerm[arrIdx] = 0.0;
					finalExam[arrIdx] = 0.0;

					index++;
					System.out.println("Student with ID: "  + studId + " added successfully");
			
				} else
					System.out.println("Student with ID: " + studId + " CANNOT be added. Class is already full");
			} else
				System.out.println("Student with ID: " + studId + " is already exist");

		}
		
		
		
	    
	    // method to get the position of an existence student using his/her Student ID. and if the student does not exist it will return -1
		public int getStudentIdx(int studId) {
			int ind = -1;

			for (int i = 0; i < getClassSize(); i++)
				if (studID[i] == studId) {
					ind = i;
					break;
				}

			return ind;
		}
	    
		
		
		
	    // method return informations of a student in an array using his/her Student ID.
		public String[] getStudentInfo(int studId) {
			String[] info = new String[10];
			int inx = getStudentIdx(studId);
			info[0] = String.valueOf(studID[inx]);
			info[1] = studFname[inx];
			info[2] = studLname[inx];
			info[3] = String.valueOf(assgt1[inx]);
			info[4] = String.valueOf(assgt2[inx]);
			info[5] = String.valueOf(assgt3[inx]);
			info[6] = String.valueOf(assgt4[inx]);
			info[7] = String.valueOf(labs[inx]);
			info[8] = String.valueOf(midTerm[inx]);
			info[9] = String.valueOf(finalExam[inx]);

			return info;

		}
		
		
		
	    
	    // method to Unenroll student using his/her Student ID.
		public int delStudent(int studId) {

			int indx = getStudentIdx(studId);
			if (indx != -1) {
				for (int i = 0; i < getClassSize(); i++) {
					if (i == indx) {
						for (int j = i; j < getClassSize() - 1; j++) {
							studID[j] = studID[j + 1];
							studFname[j] = studFname[j + 1];
							studLname[j] = studLname[j + 1];
							assgt1[j] = assgt1[j + 1];
							assgt2[j] = assgt2[j + 1];
							assgt3[j] = assgt3[j + 1];
							assgt4[j] = assgt4[j + 1];
							labs[j] = labs[j + 1];
							midTerm[j] = midTerm[j + 1];
							finalExam[j] = finalExam[j + 1];
							
							index-=1;
						}
						break;
					}
				}
				return 1;
			} else
				return -1;
		}
		
		
		

	    // method to update first name and last name of a student using his/her Student ID.
		public int updateStudentPart(String fname, String lname, int studId) {
			int indx = getStudentIdx(studId);
			if (indx != -1) {
				studFname[indx] = fname;
				studLname[indx] = lname;
				return 1;
			} else
				return -1;
		}
		
		
		
		
	    // method to update assignments scores of a student using his/her Student ID.
		public int updateAssgtScore(double a1, double a2, double a3, double a4, int studID) {
			int indx = getStudentIdx(studID);
			if (indx != -1) {
				assgt1[indx] = a1;
				assgt2[indx] = a2;
				assgt3[indx] = a3;
				assgt4[indx] = a4;
				return 1;
			} else
				return -1;
		}
		
		
		
	    
		 // method to update lab, mid-term, and final exam score of a student using his/her Student ID.
		public int updateOtherScore(double lab, double test, double exam, int studID) {
			int indx = getStudentIdx(studID);
			if (indx != -1) {
				labs[indx] = lab;
				midTerm[indx] = test;
				finalExam[indx] = exam;
				return 1;
			} else
				return -1;
		}
		
		
		
		

		// method calculate the weighted score and return the the student's weighted score using his/her Student ID.
		public double computeWeightScore(int studID) {
			int indx = getStudentIdx(studID);
			if (indx != -1) {
				double a1 = ((assgt1[indx]) / 20) * 2;
				double a2 = ((assgt2[indx]) / 20) * 3;
				double a3 = ((assgt3[indx]) / 20) * 5;
				double a4 = ((assgt4[indx]) / 20) * 8;
				double cum = ((labs[indx]) / 12) * 12;
				double mid = ((midTerm[indx]) / 30) * 30;
				double fin = ((finalExam[indx]) / 40) * 40;
				double wgt = a1 + a2 + a3 + a4 + cum + mid + fin;
				return wgt;
			} else
				return 0.0;

		}
		
		
		
		
		
        // method return a grade letter depending on the student's weighted score
		public static char computeGrade(double wgtScore) {
			if (wgtScore >= 88)
				return 'A';
			else if (wgtScore >= 80)
				return 'B';
			else if (wgtScore >= 67)
				return 'C';
			else if (wgtScore >= 60)
				return 'D';
			else
				return 'F';

		}
		
		
		
		
		
        // method find the minimum score in class and return it 
		public static double findMin(double[] dataArr) {
			double min = dataArr[0];
			for (int i = 0; i < dataArr.length; i++) {
				if (dataArr[i] < min && dataArr[i] != 0)
					min = dataArr[i];
			}
			return min;
		}
		// method find the maximum score in class and return it 
		public static double findMax(double[] dataArr) {
			double max = 0;
			for (int i = 0; i < dataArr.length; i++) {
				if (dataArr[i] > max && dataArr[i] != 0)
					max = dataArr[i];
			}
			return max;
		}
	   
		// method find the average score in class and return it 
		public static double findAvg(double[] dataArr) {
			double avg = 0;
			double sum = 0;
			for (int i = 0; i < dataArr.length; i++) {
				if (dataArr[i] != 0)
					sum += dataArr[i];
			}
			avg = sum / dataArr.length;

			return avg;
		}
		
		
		
		
		
		
        // method to find the lowest score among all students in class for each A1,A2,A3,A4,Lab,Mid-Term,and Final-Exam and return it
		public double[] getClassMin() {
			double[] min = new double[7];

			min[0] = findMin(assgt1);
			min[1] = findMin(assgt2);
			min[2] = findMin(assgt3);
			min[3] = findMin(assgt4);
			min[4] = findMin(labs);
			min[5] = findMin(midTerm);
			min[6] = findMin(finalExam);

			return min;
		}

		// method to find the greatest score among all students in class for each A1,A2,A3,A4,Lab,Mid-Term,and Final-Exam and return it
		public double[] getClassMax() {
			double[] max = new double[7];
			max[0] = findMax(assgt1);
			max[1] = findMax(assgt2);
			max[2] = findMax(assgt3);
			max[3] = findMax(assgt4);
			max[4] = findMax(labs);
			max[5] = findMax(midTerm);
			max[6] = findMax(finalExam);

			return max;
		}

		// method to find the average score among all students in class for each A1,A2,A3,A4,Lab,Mid-Term,and Final-Exam and return it
		public double[] getClassAvg() {
			double[] avg = new double[7];
			avg[0] = findAvg(assgt1);
			avg[1] = findAvg(assgt2);
			avg[2] = findAvg(assgt3);
			avg[3] = findAvg(assgt4);
			avg[4] = findAvg(labs);
			avg[5] = findAvg(midTerm);
			avg[6] = findAvg(finalExam);

			return avg;
		}
	   
		
		
		
		
	  // method to display the report include all students enrolled in comp248 course.
	   public void classReportCard() {
		   System.out.println();
		   System.out.println("-----------------------------------------------------------------------------------------------------");
		   System.out.printf("%-16s%-16s%s%7s%7s%7s%7s%7s%8s%7s%8s%4s", "First Name", "Last Name", "Stud.ID", "A1","A2","A3","A4", "Labs", "Test", "Final", "Wgt.", "*");
		   System.out.println();
	       System.out.println("-----------------------------------------------------------------------------------------------------");
	      
	      for(int i=0; i<studID.length; i++){
	          if(studID[i] != 0){
	          double wgt = computeWeightScore(studID[i]);
	          char sc = computeGrade(wgt);
	         
	          System.out.printf("%-16s%-16s%8d%7.2f%7.2f%7.2f%7.2f%7.2f%7.2f%7.2f%8.2f%4s%n", studFname[i], studLname[i],studID[i],assgt1[i], assgt2[i], assgt3[i] ,assgt4[i], labs[i],  midTerm[i], finalExam[i],wgt, sc );
	          }
	      }
	      System.out.println("-----------------------------------------------------------------------------------------------------");
	      double[] min = getClassMin();
	       
	      System.out.printf("%40s", "Minimum Score in Class:" );
	       
	       for(int i=0; i<7; i++){
	           
	    	   System.out.printf("%7.2f", min[i]);
	      } 
	       System.out.println("");
	       double[] avg = getClassAvg();
	       
	       System.out.printf("%40s", "Average Score in Class:" );
	       for(int i=0; i<7; i++){
	         
	          System.out.printf("%7.2f", avg[i]);
	      } 
	       System.out.println("");
	       double[] max = getClassMax();
	       
	       System.out.printf("%40s", "Maximum Score in Class:" );
	       for(int i=0; i<7; i++){
	    	   System.out.printf("%7.2f", max[i]);
	      }
	             System.out.println("");
	             System.out.println("-----------------------------------------------------------------------------------------------------");

	   }
	   
	   
	   
	   
	   
	   
	// setters for the private static attributes declared above.  
	public static void setInstructorFname(String instructorFname) {
		Comp248secU.instructorFname = instructorFname;
	}

	public static void setInstructorLname(String instructorLname) {
		Comp248secU.instructorLname = instructorLname;
	}

	public static void setLectureRoom(String lectureRoom) {
		Comp248secU.lectureRoom = lectureRoom;
	}

	public static void setSemesterYear(String semesterYear) {
		Comp248secU.semesterYear = semesterYear;
	}

	public static int getClassSize() {
		return classSize;
	}

	public static void setClassSize(int classSize) {
		Comp248secU.classSize = classSize;
	}

	public void setStudFname(String[] studFname) {
		this.studFname = studFname;
	}

	public void setStudLname(String[] studLname) {
		this.studLname = studLname;
	}

	public void setStudID(int[] studID) {
		this.studID = studID;
	}

	public void setAssgt1(double[] assgt1) {
		this.assgt1 = assgt1;
	}

	public void setAssgt2(double[] assgt2) {
		this.assgt2 = assgt2;
	}

	public void setAssgt3(double[] assgt3) {
		this.assgt3 = assgt3;
	}

	public void setAssgt4(double[] assgt4) {
		this.assgt4 = assgt4;
	}

	public void setLabs(double[] labs) {
		this.labs = labs;
	}

	public void setMidTerm(double[] midTerm) {
		this.midTerm = midTerm;
	}

	public void setFinalExam(double[] finalExam) {
		this.finalExam = finalExam;
	}
 }
	   






public class A4_Q1_Q2 {

	public static void main(String[] args) {
		
		// create an object from class Comp248secU
		Comp248secU c = new Comp248secU();
		
		//Prints a welcome message.
		System.out.println("Welcome to the simple Classroom Management System : ");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("\n");
		
		// ask the user for input
		System.out.println("Enter instructor's particular (FirstName , LastName, LectureRoom, Semester, MaxClassSize) as a single-line entry :");
		
		//declare our scanner
		Scanner sc = new Scanner(System.in);
		
		// declare an array and separate String input by space.
		String[] line = sc.nextLine().split(" ");
		
		Comp248secU.setInstructorFname(line[0]);
		Comp248secU.setInstructorLname(line[1]);
		Comp248secU.setLectureRoom(line[2]);
		Comp248secU.setSemesterYear(line[3]);
		
		// use try-catch to check if the user enter a invalid input for ClassSize so it prints an error message otherwise it display the all codes
		try {
		
			Comp248secU.setClassSize(Integer.parseInt(line[4]));
			c.setStudFname(new String[Comp248secU.getClassSize()]);
			c.setStudLname(new String[Comp248secU.getClassSize()]);
			c.setStudID(new int[Comp248secU.getClassSize()]);
			c.setAssgt1(new double[Comp248secU.getClassSize()]);
			c.setAssgt2(new double[Comp248secU.getClassSize()]);
			c.setAssgt3(new double[Comp248secU.getClassSize()]);
			c.setAssgt4(new double[Comp248secU.getClassSize()]);
			c.setLabs(new double[Comp248secU.getClassSize()]);
			c.setMidTerm(new double[Comp248secU.getClassSize()]);
			c.setFinalExam(new double[Comp248secU.getClassSize()]);
			
			// display all the codes for the user 
			System.out.println("\n");
			System.out.println("Code => Description");
			System.out.println("------------------------");
			System.out.println("103 => Enrol New Student");
			System.out.println("106 => Find Student Position in Class List");
			System.out.println("109 => Retrieve Student's Information");
			System.out.println("112 => Unenrol Student");
			System.out.println("115 => Update Student's Particulars");
			System.out.println("118 => Update Assignment Scores");
			System.out.println("121 => Update Other Scores");
			System.out.println("124 => Display Student's Report Card");
			System.out.println("127 => Display Class Report Card");
			System.out.println("0 ===> Exit"+"\n");
			
			System.out.print("Please enter a Code, from the aformentioned, that corresponds to your task: ");
        
			
			
			
			
	    // using while to re-promote the user for choosing one of the codes displayed
        while(true) {
			
			int code = sc.nextInt();
			
			// display an error message if the user enter invalid byte value
			if (code > 127 || code < -128) {
				System.out.println("Error: Your input/entry is NOT a valid integer between -128 to 127 . kindly retry again!");
				break;
			}
			
            
			
			else if (code == 103) {
				System.out.println("\n");
				System.out.println("Enrolling New Student...");
				System.out.println("------------------------");
				System.out.println("Enter Student's particulars (FirstName, LastName, StudentID) as a single-line entry:");
				
				Scanner scan = new Scanner(System.in);
				String[] st = scan.nextLine().split(" ");
				
				// use try-catch to check if the user enter an invalid input for Student ID 
				try {
					String f = st[0];
					String l = st[1];
					int id = Integer.parseInt(st[2]);
					
					// call the method addStudent
					c.addStudent(f, l, id, Comp248secU.index);

				} 
				
				// display an error message if the user enter an invalid (integer) input for Student ID
				catch (NumberFormatException ex) {
					System.out.println("Error: Your input/entry for 'StudentID' is NOT a valid integer. Kindly retry again!");
				}
			}
			
			
			

			else if (code == 106) {
				System.out.println("\n");
				System.out.println("Finding Student's Positiion in Class List...");
				System.out.println("--------------------------------------------");
				System.out.println("Enter StudentID: ");
				
				Scanner ss = new Scanner(System.in);
				String idst = ss.next();
				
				// use try-catch to check if the user enter an invalid input for Student ID 
				try {
					int sid = Integer.parseInt(idst);
					
					// call the method getStudentIdx
					int idx = c.getStudentIdx(sid);
					if (idx != -1)
						System.out.println("The position of student with ID: " + sid + ", in class list, is: " + idx);
					else
						System.out.println("Student with ID: " + sid + " does NOT exist");
				} 
				
				// display an error message if the user enter an invalid (integer) input for Student ID
				catch (NumberFormatException t) {
					System.out.println("Error: Your input/entry for 'StudentID' is NOT a valid integer. Kindly retry again!");
				}
			}

			
			
			
			
			else if (code == 109) {
				System.out.println("\n");
				System.out.println("Retrieving Student's Information...");
				System.out.println("-----------------------------------");
				System.out.println("Enter StudentID:");
				
				Scanner s2 = new Scanner(System.in);
				String idst = s2.next();
				
				// use try-catch to check if the user enter an invalid input for Student ID 
				try {
					int id109 = Integer.parseInt(idst);
					int in = c.getStudentIdx(id109);
					if (in != -1) {
						String[] info = c.getStudentInfo(id109);
						System.out.println("Student's First Name = " + info[1]);
						System.out.println("Student's Last Name = " + info[2]);
						System.out.println("Student's ID = " + info[0]);
						System.out.println("Score in Assignment 1 = " + info[3]);
						System.out.println("Score in Assignment 2 = " + info[4]);
						System.out.println("Score in Assignment 3 = " + info[5]);
						System.out.println("Score in Assignment 4 = " + info[6]);
						System.out.println("Cummulative Score in Labs = " + info[7]);
						System.out.println("Mid-Term Test Score = " + info[8]);
						System.out.println("Final Examination Score = " + info[9]);
					} else {
						System.out.println("Student with ID: " + id109 + " does NOT exist");
						System.out.println("Unable to retrieve information for student with ID: " + id109);
					}
				} 
				
				// display an error message if the user enter an invalid (integer) input for Student ID
				catch (NumberFormatException ex) {
					System.out.println("Error: Your input/entry for 'StudentID' is NOT a valid integer. Kindly retry again!");
				}
			}

			
			
			
			
			else if (code == 112) {
				System.out.println("\n");
				System.out.println("Unenrolling Student...");
				System.out.println("----------------------");
				System.out.println("Enter StudentID:");
				
				Scanner d = new Scanner(System.in);
				String idst = d.next();
				
				// use try-catch to check if the user enter an invalid input for Student ID 
				try {
					int sid = Integer.parseInt(idst);
					
					// call the method delStudent
					int x = c.delStudent(sid);
					if (x > 0)
						System.out.println("Successfully removed Student with ID: " + sid);
					else {
						System.out.println("Student with ID: " + sid + " does NOT exist");
						System.out.println("Unable to retrieve information for Student with ID: " +  sid);
						}
				} 
				
				// display an error message if the user enter an invalid (integer) input for Student ID
				catch (NumberFormatException ex) {
					System.out.println("Error: Your input/entry for 'StudentID' is NOT a valid integer. Kindly retry again!");
				}
			}
			
			
			

			else if (code == 115) {
				System.out.println("\n");
				System.out.println("Updating Student's Particulars...");
				System.out.println("---------------------------------");
				System.out.println(
						"Enter update to  Student's particulars (FirstName, LastName, StudentID) as a single-line entry:");
				Scanner scn = new Scanner(System.in);
				String[] st2 = scn.nextLine().split(" ");
				
				// use try-catch to check if the user enter an invalid input for Student ID 
				try {
					String f = st2[0];
					String l = st2[1];
					int id = Integer.parseInt(st2[2]);
					
					// call the method updateStudentPart
					int i = c.updateStudentPart(f, l, id);
					if (i > 0)
						System.out
								.println("Successfully updated identification particulars for Student with ID: " + id);
					else {
						System.out.println("Student with ID: " + id + " does NOT exist");
						System.out.println("Unable to retrieve information for Student with ID: " + id);
					}

				} 
				
				// display an error message if the user enter an invalid (integer) input for Student ID
				catch (NumberFormatException ex) {
					System.out.println(
							"Error: Your input/entry for 'StudentID' is NOT a valid integer. Kindly retry again!");
				}

			} 
			
			
			
			// ask the user (an an existent student) to update A1,A2,A3, and A4 scores 
			else if (code == 118) {
				System.out.println("\n");
				System.out.println("Updating Assignment Scores...");
				System.out.println("-----------------------------");
				System.out.println("Enter update to student's Assignment scores (Assignment1, Assignment2, Assignment3, Assignment4, StudentID) as a single-line entry:");
				
				Scanner sn = new Scanner(System.in);
				String[] r2 = sn.nextLine().split(" ");
				
				// use try-catch to check if the user enter an invalid input for Student ID 
				try {
					double a1 = Double.parseDouble(r2[0]);
					double a2 = Double.parseDouble(r2[1]);
					double a3 = Double.parseDouble(r2[2]);
					double a4 = Double.parseDouble(r2[3]);
					int id = Integer.parseInt(r2[4]);
					
					// call the method updateStudentPart
					int i = c.updateAssgtScore(a1, a2, a3, a4, id);
					if (i > 0)
						System.out.println("Successfully updated Assignments' scores for Student with ID: " + id);
					else {
						System.out.println("Student with ID: " + id + " does NOT exist");
						System.out.println("Unable to retrieve information for student with ID: " + id);
					}

				} 
				
				// display an error message if the user enter an invalid (integer) input for Student ID
				catch (NumberFormatException ex) {
					System.out.println("Error: Your input/entry for 'StudentID' is NOT a valid integer. Kindly retry again!");
				}
				
		
			}
			
			
			
			// ask the user (student) to update the labs, Mid-term, and Final Exam scores
			else if (code == 121) {
				System.out.println("\n");
				System.out.println("Updating Other Scores...");
				System.out.println("------------------------");
				System.out.println("Enter update to Student's other scores (CummulativeLabs, Midterm, FinalExam, StudentID) as a single-line entry:");
				
				Scanner sn = new Scanner(System.in);
				String[] r2 = sn.nextLine().split(" ");
				
				// use try-catch to check if the user enter an invalid input for Student ID 
				try {
					double a1 = Double.parseDouble(r2[0]);
					double a2 = Double.parseDouble(r2[1]);
					double a3 = Double.parseDouble(r2[2]);
					int id = Integer.parseInt(r2[3]);
					
					// call the method updateOtherScore
					int i = c.updateOtherScore(a1, a2, a3, id);
					if (i > 0)
						System.out.println("Successfully updated Cummulative Labs, Mid-term Test, Final Examination scores for Student with ID: " + id);
					else {
						System.out.println("Student with ID: " + id + " does NOT exist");
						System.out.println("Unable to retrieve information for student with ID: " + id);
					}

				} 
				
				// display an error message if the user enter an invalid (integer) input for Student ID
				catch (NumberFormatException ex) {
					System.out.println("Error: Your input/entry for 'StudentID' is NOT a valid integer. Kindly retry again!");
				}
			}
			
			
			
			
			
			// display a report card for an existent student
			else if (code == 124) {
				System.out.println("\n");
				System.out.println("Displaying student's Report card...");
				System.out.println("---------------------------------------------");
				System.out.println("Enter StudentID:");
				
				Scanner dg = new Scanner(System.in);
				String st = dg.next();
				
				// use try-catch to check if the user enter an invalid input for Student ID so it prints an error message otherwise it display a report card
				try {
					int std = Integer.parseInt(st);
					if (c.getStudentIdx(std) != -1) {
						
						// call the method getStudentInfo
						String[] info = c.getStudentInfo(std);
						System.out.println("Student's First Name = " + info[1]);
						System.out.println("Student's Last Name = " + info[2]);
						System.out.println("Student's ID = " + info[0]);
						System.out.println("Score in Assignment 1 = " + info[3]);
						System.out.println("Score in Assignment 2 = " + info[4]);
						System.out.println("Score in Assignment 3 = " + info[5]);
						System.out.println("Score in Assignment 4 = " + info[6]);
						System.out.println("Cummulative Score in Labs = " + info[7]);
						System.out.println("Mid-Term Test Score = " + info[8]);
						System.out.println("Final Examination Score = " + info[9]);
						System.out.println("-------------------------------------");
						
						// call the method computeWeightScore
						double wgt = c.computeWeightScore(std);
						System.out.println("Cummulative weighted Score = " + wgt);
						
						// call the method computeGrade
						System.out.println("final Letter Grade = " + c.computeGrade(wgt));

					} else {
						System.out.println("Student with ID: " + std + " does NOT exist");
						System.out.println("Unable to retrieve information for student with ID: " + std);
					}
					
				} 
				
				// display an error message if the user enter an invalid (integer) input for Student ID
				catch (NumberFormatException ex) {
					System.out.println("Error: Your input/entry for 'StudentID' is NOT a valid integer. Kindly retry again!");
				}
				
			}

			
			
			
			
			// displaying the reports of all student enrolled in the comp248 section U course
			else if (code == 127) {
				System.out.println("\n");
				System.out.println("Displaying class Report card...");
				System.out.println("-------------------------------");
				
				// call the method classReportCard
				c.classReportCard();
			}
			
			
			
			
			// for exit code when the user input is 0
			else if (code == 0) {
				System.exit(0);
			} 
			
			
			
			// Closing message for the user for invalid menu code 
			else {
				System.out.println("\n" + "Thank you for patronizing our Simple Classroom Management System.");
				break;
			}

			System.out.print("Kindly contiune by entering a Code, from the menu above, that corresponds to your task: ");

		}
        
        
// display an error message if the user enter invalid (integer) input for ClassSize 
} catch (NumberFormatException e) {
	System.out.println("Error: Your input/entry for 'MaxClassSize' is NOT a valid integer. Kindly retry again!");
}
		
		
		
		

	}

}
