package WebTest;

import java.io.*;
import java.util.ArrayList;

public class FileParser {

	private final String txtLocationString = System.getProperty("user.dir") + "/src/student.txt";
	public ArrayList<StudentInformation> getInformation(){
		
		File file = new File(txtLocationString);
		ArrayList<StudentInformation> studentInformations = new ArrayList<StudentInformation>();
		if(file.isFile() && file.exists()){
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream,"GBK");
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                 
                StringBuffer sb = new StringBuffer();
                String text = null;
                while((text = bufferedReader.readLine()) != null){

                    String[] currentStrings = text.split("\t");
                    String student_number = currentStrings[1];
                    String name = currentStrings[2];
                    String git_location = currentStrings.length>3 ? currentStrings[3]:"";

                    
                    StudentInformation newInformation = new StudentInformation(name,student_number,git_location);
                    studentInformations.add(newInformation);
                    
                }
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
		return studentInformations;
	}
	
	
}
