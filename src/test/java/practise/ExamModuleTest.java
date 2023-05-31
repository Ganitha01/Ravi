package practise;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class ExamModuleTest {

	@Test(invocationCount =2)
	public void createExam() {
		Reporter.log("createdExam",true);
	}
	@Test()
	public void editExam() {
		Reporter.log("editExam",true);
	}
	@Test(dependsOnMethods = "editExam",groups = "smokeTesting")
	public void deleteExam() {
		Reporter.log("deleteExam",true);
	}
}
