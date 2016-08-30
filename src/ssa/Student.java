package ssa;
import java.util.*;
public class Student {

	public String id;
	public String firstName;
	public String lastName;
	public String eyeColor;
	public int monthsEmployed;
	public static ArrayList<Student> ourClass = new ArrayList<Student>();
	
	public static void main(String[] args) {
		printClassRoster(); 
	}
	
	public Student(){}
	
	public Student(String id, String firstName, String lastName, String eyeColor, int monthsEmployed){
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.eyeColor = eyeColor;
		this.monthsEmployed = monthsEmployed;		
	}

	public static void printClassRoster() {

		
		//Populates ArrayList
	ourClass.add(new Student("001122", "Michael", "Clair", "Other", 12));
	ourClass.add(new Student("001212", "Stephen", "Rook", "Brown", 112));
	ourClass.add(new Student("474143", "Jonathan", "Stafford", "Brown", 13));
	ourClass.add(new Student("005295", "Kyle", "Deen", "Blue", 2));
	ourClass.add(new Student("004400", "Kevin", "Tran", "Other", 12));
	ourClass.add(new Student("132617", "Reuben", "Turner", "Blue", 12));
	ourClass.add(new Student("306700", "Li", "Lui", "Brown", 12));
	ourClass.add(new Student("215296", "Joshua", "Franey", "Other", 27));
	ourClass.add(new Student("523420", "Gabriel", "Hamilton", "Other", 10));
	ourClass.add(new Student("004014", "Aisha", "Covington", "Brown", 10));
	ourClass.add(new Student("006789", "Arun", "Soma", "Brown", 2));
	ourClass.add(new Student("009999", "Steve", "Ellwood", "Other", 2));
	ourClass.add(new Student("343769", "Shaquil", "Timmons", "Brown", 11));
	ourClass.add(new Student("001449", "Karen", "Reiter", "Blue", 10));
	ourClass.add(new Student("267252", "Dax", "Richards", "Brown", 12));
	ourClass.add(new Student("229949", "Mike", "Sykes", "Brown", 13));
	ourClass.add(new Student("772223", "Daniel", "Kiros", "Brown", 3));
	ourClass.add(new Student("005255", "Joe", "Hill", "Brown", 13));

	//Sorts by First Name and prints entire array
	Collections.sort(ourClass, Student.StuNameComparator);
	System.out.println("Empl Id  First Name  Last Name  Eye Color  Months At SSA");
	System.out.println("=======  ==========  =========  =========  =============");
	for (Student student : ourClass) {
		System.out.printf("%-8s %-11s %-10s %-10s %-10d\n", student.id, student.firstName, student.lastName, student.eyeColor ,student.monthsEmployed);
	}
	
	//Creates HashMap with data from ArrayList
	HashMap<String, Student> classMap = new HashMap<String, Student>();
	for (int j = 0; j <ourClass.size(); j++) {
		classMap.put(ourClass.get(j).id, ourClass.get(j));
//		classMap.put(ourClass.get(0).id, ourClass.get(0));
//		classMap.put("008888", new Student("008888", "Evan", "Tizard", "Brown", 12) );
	}
	
	String idToBeChecked;
	
//	System.out.println("Input a Student ID to search ");
//	Scanner in= new Scanner(System.in);
//	String idToBeChecked = in.nextLine();
//	in.close();
	
	System.out.println("******Prints Student Record by HashMap key*******");
	
	idToBeChecked="001122";
	System.out.printf("%-8s %-11s %-10s %-10s %-10d", classMap.get(idToBeChecked).id, classMap.get(idToBeChecked).firstName, classMap.get(idToBeChecked).lastName, classMap.get(idToBeChecked).eyeColor ,classMap.get(idToBeChecked).monthsEmployed);
	System.out.println(" is the record you searched for");

	System.out.println("******Finds Students with IDs one Lower and One Higher*******");
	
	ArrayList sortedKeys=new ArrayList(classMap.keySet());
	Collections.sort(sortedKeys);
	
	for (int i=0; i < classMap.size(); i++) {
		if (sortedKeys.get(i).equals(idToBeChecked)) {
			if ( i > 0 && i != (classMap.size() - 1)) {
				System.out.printf("%-8s %-11s %-10s %-10s %-10d", classMap.get(sortedKeys.get(i)).id, classMap.get(sortedKeys.get(i)).firstName, classMap.get(sortedKeys.get(i)).lastName, classMap.get(sortedKeys.get(i)).eyeColor ,classMap.get(sortedKeys.get(i)).monthsEmployed);
				System.out.println(" is the record you searched for");
				System.out.printf("%-8s %-11s %-10s %-10s %-10d", classMap.get(sortedKeys.get(i-1)).id, classMap.get(sortedKeys.get(i-1)).firstName, classMap.get(sortedKeys.get(i-1)).lastName, classMap.get(sortedKeys.get(i-1)).eyeColor ,classMap.get(sortedKeys.get(i-1)).monthsEmployed);
				System.out.println(" is the next lowest record");
				System.out.printf("%-8s %-11s %-10s %-10s %-10d", classMap.get(sortedKeys.get(i+1)).id, classMap.get(sortedKeys.get(i+1)).firstName, classMap.get(sortedKeys.get(i+1)).lastName, classMap.get(sortedKeys.get(i+1)).eyeColor ,classMap.get(sortedKeys.get(i+1)).monthsEmployed);
				System.out.println(" is the next highest record");
			} 
			if (i == 0) {
				System.out.printf("%-8s %-11s %-10s %-10s %-10d", classMap.get(sortedKeys.get(i)).id, classMap.get(sortedKeys.get(i)).firstName, classMap.get(sortedKeys.get(i)).lastName, classMap.get(sortedKeys.get(i)).eyeColor ,classMap.get(sortedKeys.get(i)).monthsEmployed);
				System.out.println(" is the record you searched for");
				System.out.printf("%-8s %-11s %-10s %-10s %-10d", classMap.get(sortedKeys.get(i+1)).id, classMap.get(sortedKeys.get(i+1)).firstName, classMap.get(sortedKeys.get(i+1)).lastName, classMap.get(sortedKeys.get(i+1)).eyeColor ,classMap.get(sortedKeys.get(i+1)).monthsEmployed);
				System.out.println(" is the next highest record");
				System.out.println("And there is no lower record");
				}
			if (i == (classMap.size() - 1)) {
				System.out.printf("%-8s %-11s %-10s %-10s %-10d", classMap.get(sortedKeys.get(i)).id, classMap.get(sortedKeys.get(i)).firstName, classMap.get(sortedKeys.get(i)).lastName, classMap.get(sortedKeys.get(i)).eyeColor ,classMap.get(sortedKeys.get(i)).monthsEmployed);
				System.out.println(" is the record you searched for");
				System.out.printf("%-8s %-11s %-10s %-10s %-10d", classMap.get(sortedKeys.get(i-1)).id, classMap.get(sortedKeys.get(i-1)).firstName, classMap.get(sortedKeys.get(i-1)).lastName, classMap.get(sortedKeys.get(i-1)).eyeColor ,classMap.get(sortedKeys.get(i-1)).monthsEmployed);
				System.out.println(" is the next lowest record");
				System.out.println("And there is no higher record");
			}	
		}
	}
	}
	
	
	public static Comparator<Student> StuNameComparator = new Comparator<Student>() {

	public int compare(Student s1, Student s2) {
		String StudentName1 = s1.firstName.toUpperCase();
		String StudentName2 = s2.firstName.toUpperCase();
		return StudentName1.compareTo(StudentName2);
	}
	};
}