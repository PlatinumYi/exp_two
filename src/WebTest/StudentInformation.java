package WebTest;

public class StudentInformation {

	private String name ;
	private String student_number ;
	private String password ;
	private String git_location ;
	
	public StudentInformation(String name,String student_number,String git_location) {
		
		this.name = name ;
		this.student_number = student_number ;
		this.password = student_number.substring(4,10);		
		this.git_location = git_location ;
	}
	
	public String getGitLocation() {
		return git_location;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getStudentNumber() {
		return student_number;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[ "+name+" "+password+" "+student_number+" "+git_location+" ]";
	}
//	public static void main(String[] args) {
//		StudentInformation studentInformation = new StudentInformation("ZCY","3016218102","asdasd");
//		System.out.println(studentInformation.getPassword());
//	}
}
