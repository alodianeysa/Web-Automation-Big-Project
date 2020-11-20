package Test;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumJar {
	public static String browser;
	static WebDriver driver;

	public static void main(String[] args) {
		SeleniumJar test = new SeleniumJar();
		test.setBrowser("Chrome");
		test.setBrowserConfig();
		test.verifyTitle();
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public void setBrowserConfig() {
		String projectLocation = System.getProperty("user.dir");
		if (browser.contains("Chrome")) {
			System.setProperty("webdriver.chrome.driver", projectLocation + "\\lib\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
		}
		if (browser.contains("Firefox")) {
			System.setProperty("webdriver.gecko.driver", projectLocation + "\\lib\\driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
	}

	@Test
	public void verifyTitle() {
		driver.get("https://qa.cilsy.id/symfony/web/index.php/auth/login");
		String expectedTitle = "OrangeHRM";
		String actualTitle = "";
		// get the actual value of the title
		actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		
		System.out.println("Assert  PASSED");

		//Login
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("txtUsername")).sendKeys("baddminn");
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.id("spanMessage")).getText();
		driver.findElement(By.id("txtUsername")).clear();
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("s3Kol4HQA!*");
		driver.findElement(By.id("btnLogin")).click();
		
		System.out.println("Login  PASSED");

		// Admin
		// User
		driver.findElement(By.xpath("//*[@id=\"menu_admin_viewAdminModule\"]/b")).click();
		driver.findElement(By.xpath("//*[@id=\"systemUser-information\"]/a")).getText();
		
		driver.findElement(By.xpath("//*[@id=\"menu_admin_viewAdminModule\"]/b")).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		driver.findElement(By.id("searchSystemUser_userName")).sendKeys("neysa");

		driver.findElement(By.id("searchSystemUser_userType")).click();
		driver.findElement(By.xpath("//*[@id=\"searchSystemUser_userType\"]/option[3]")).click();
		driver.findElement(By.id("searchSystemUser_employeeName_empName")).sendKeys("nurivah alodia neysa");
		driver.findElement(By.id("searchSystemUser_status")).click();
		driver.findElement(By.xpath("//*[@id=\"searchSystemUser_status\"]/option[2]")).click();
		driver.findElement(By.id("searchBtn")).click();
		driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr/td[2]/a")).getText();
		driver.findElement(By.id("ohrmList_chkSelectRecord_2")).click();
		driver.findElement(By.id("resetBtn")).click();
		
		System.out.println("Admin-User  PASSED");

		// Job
		// job title
		driver.findElement(By.id("menu_admin_Job")).click();
		driver.findElement(By.id("menu_admin_viewJobTitleList")).click();
		driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.id("jobTitle_jobTitle")).sendKeys("Quality Assurance");
		driver.findElement(By.id("btnSave")).click();

		driver.findElement(By.name("chkSelectRow[]")).click();
		driver.findElement(By.id("btnDelete")).click();
		driver.findElement(By.id("dialogDeleteBtn")).click();
		
		System.out.println("Admin-Job-JobTitle  PASSED");

		// paygrades
		driver.findElement(By.id("menu_admin_Job")).click();
		driver.findElement(By.id("menu_admin_viewPayGrades")).click();
		driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.id("payGrade_name")).sendKeys("Manager");
		driver.findElement(By.id("btnSave")).click();
		driver.findElement(By.id("btnCancel")).click();
		driver.findElement(By.name("chkSelectRow[]")).click();
		driver.findElement(By.id("btnDelete")).click();
		driver.findElement(By.id("dialogDeleteBtn")).click();
		
		System.out.println("Admin-Job-Paygrades  PASSED");

		// employeeStatus
		driver.findElement(By.id("menu_admin_Job")).click();
		driver.findElement(By.id("menu_admin_employmentStatus")).click();
		driver.findElement(By.id("empStatusHeading")).getText();
		driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.id("empStatus_name")).sendKeys("Ainternship");
		driver.findElement(By.id("btnSave")).click();
		driver.findElement(By.name("chkSelectRow[]")).click();
		driver.findElement(By.id("btnDelete")).click();
		driver.findElement(By.id("dialogDeleteBtn")).click();
		
		System.out.println("Admin-Job-EmployeeStatus  PASSED");

		// jobCategories
		driver.findElement(By.id("menu_admin_Job")).click();
		driver.findElement(By.id("menu_admin_jobCategory")).click();
		driver.findElement(By.xpath("//*[@id=\"search-results\"]/div[1]/h1")).getText();
		driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.id("jobCategory_name")).sendKeys("amatir");
		driver.findElement(By.id("btnSave")).click();
		driver.findElement(By.name("chkSelectRow[]")).click();
		driver.findElement(By.id("btnDelete")).click();
		driver.findElement(By.id("dialogDeleteBtn")).click();
		
		System.out.println("Admin-Job-JobCategories  PASSED");

		// workshift
		driver.findElement(By.id("menu_admin_Job")).click();
		driver.findElement(By.id("menu_admin_workShift")).click();
		// driver.findElement(By.id("//*[@id=\"search-results\"]/div[1]/h1")).getText();
		driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.id("workShift_name")).sendKeys("Admin");
		driver.findElement(By.id("workShift_workHours_from")).click();
		driver.findElement(By.xpath("//*[@id=\"workShift_workHours_from\"]/option[38]")).click();
		driver.findElement(By.id("workShift_workHours_to")).click();
		driver.findElement(By.xpath("//*[@id=\"workShift_workHours_to\"]/option[46]")).click();
		driver.findElement(By.xpath("//*[@id=\"workShift_availableEmp\"]/option[1]")).click();
		driver.findElement(By.id("btnAssignEmployee")).click();
		driver.findElement(By.id("btnSave")).click();
		driver.findElement(By.name("chkSelectRow[]")).click();
		driver.findElement(By.id("btnDelete")).click();
		driver.findElement(By.id("dialogDeleteBtn")).click();
		
		System.out.println("Admin-Job-Workshift  PASSED");

		// Organization
		// generalInformation
		driver.findElement(By.id("menu_admin_Organization")).click();
		driver.findElement(By.id("menu_admin_viewOrganizationGeneralInformation")).click();
		driver.findElement(By.id("genInfoHeading")).getText();
		driver.findElement(By.id("btnSaveGenInfo")).click();
		driver.findElement(By.id("organization_fax")).clear();
		driver.findElement(By.id("organization_fax")).sendKeys("fax");
		driver.findElement(By.className("validation-error")).getText();
		driver.findElement(By.id("organization_fax")).clear();
		driver.findElement(By.id("organization_fax")).sendKeys("1234567");
		driver.findElement(By.id("btnSaveGenInfo")).click();
		
		System.out.println("Admin-Organization-GeneralOrganization  PASSED");

////		// locations
////		driver.findElement(By.id("menu_admin_Organization")).click();
////		driver.findElement(By.id("menu_admin_viewLocations")).click();
////		driver.findElement(By.id("btnAdd")).click();
////		driver.findElement(By.id("location_name")).sendKeys("inosuke");
////		driver.findElement(By.id("location_country")).click();
////		driver.findElement(By.xpath("//*[@id=\"location_country\"]/option[101]")).click();
////		driver.findElement(By.id("location_province")).sendKeys("Jawa Timur");
////		driver.findElement(By.id("location_city")).sendKeys("Malang");
////		driver.findElement(By.id("btnSave")).click();
////		
////
////		
////		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
////		driver.findElement(By.id("searchLocation_name")).sendKeys("inosuke");
////		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
////		driver.findElement(By.id("searchLocation_city")).sendKeys("Malang");
////		driver.findElement(By.id("searchLocation_country")).click();
////		driver.findElement(By.xpath("//*[@id=\"searchLocation_country\"]/option[101]")).click();
////		driver.findElement(By.id("btnSearch")).click();
////		driver.findElement(By.xpath("//*[@id=\"frmSearchLocation\"]/fieldset/ol/li[1]/label")).getText();
//		
//		
////		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
////		driver.findElement(By.xpath("//*[@id=\"ohrmList_chkSelectRecord_30\"]")).click();
////		driver.findElement(By.id("btnDelete")).click();
////		driver.findElement(By.id("dialogDeleteBtn")).click();
////
		// structure
		driver.findElement(By.id("menu_admin_Organization")).click();
		driver.findElement(By.id("menu_admin_viewCompanyStructure")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[1]/h1")).getText();
		driver.findElement(By.id("btnEdit")).click();
		driver.findElement(By.id("treeLink_addChild_1")).click();
		driver.findElement(By.id("txtName")).sendKeys("zenitsu");
		driver.findElement(By.id("btnSave")).click();
		
		System.out.println("Admin-Organization-Structure  PASSED");

		// Qualification
		// skills
		driver.findElement(By.id("menu_admin_Qualifications")).click();
		driver.findElement(By.id("menu_admin_viewSkills")).click();
		driver.findElement(By.id("saveFormHeading")).getText();
		driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.id("skill_name")).sendKeys("ara");
		driver.findElement(By.id("btnSave")).click();
		driver.findElement(By.name("chkListRecord[]")).click();
		driver.findElement(By.id("btnDel")).click();
		
		System.out.println("Admin-Qualification-Skills  PASSED");

		// education
		driver.findElement(By.id("menu_admin_Qualifications")).click();
		driver.findElement(By.id("menu_admin_viewEducation")).click();
		driver.findElement(By.xpath("//*[@id=\"recordsListDiv\"]/div[1]/h1")).getText();
		driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.id("education_name")).sendKeys("Advance");
		driver.findElement(By.id("btnSave")).click();
		driver.findElement(By.name("chkListRecord[]")).click();
		driver.findElement(By.id("btnDel")).click();
		
		System.out.println("Admin-Qualification-Education  PASSED");

		// licences
		driver.findElement(By.id("menu_admin_Qualifications")).click();
		driver.findElement(By.id("menu_admin_viewLicenses")).click();
		driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.id("license_name")).sendKeys("A Sim");
		driver.findElement(By.id("btnSave")).click();
		driver.findElement(By.name("chkListRecord[]")).click();
		driver.findElement(By.id("btnDel")).click();
		
		System.out.println("Admin-Qualification-Licences  PASSED");

		// languages
		driver.findElement(By.id("menu_admin_Qualifications")).click();
		driver.findElement(By.id("menu_admin_viewLanguages")).click();
		driver.findElement(By.xpath("//*[@id=\"recordsListDiv\"]/div[1]/h1")).getText();
		driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.id("language_name")).sendKeys("Deutch");
		driver.findElement(By.id("btnSave")).click();
		driver.findElement(By.name("chkListRecord[]")).click();
		driver.findElement(By.id("btnDel")).click();
		
		System.out.println("Admin-Qualification-Languages  PASSED");

//		// membership
//		driver.findElement(By.id("menu_admin_Qualifications")).click();
//		driver.findElement(By.id("menu_admin_membership")).click();
//		driver.findElement(By.xpath("//*[@id=\"search-results\"]/div[1]/h1")).getText();
//		driver.findElement(By.id("btnAdd")).click();
//		driver.findElement(By.id("membership_name")).sendKeys("ara");
//		driver.findElement(By.id("btnSave")).click();
//		
//		driver.findElement(By.xpath("//*[@id=\"search-results\"]/div[1]/h1")).getText();
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		driver.findElement(By.xpath("//*[@id=\"ohrmList_chkSelectRecord_9\"]")).click();
//		driver.findElement(By.id("btnDelete")).click();
//		driver.findElement(By.id("dialogDeleteBtn")).click();

		// Nationalities
		driver.findElement(By.id("menu_admin_nationality")).click();
		driver.findElement(By.xpath("//*[@id=\"search-results\"]/div[1]/h1")).getText();
		driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.id("nationality_name")).sendKeys("Aborigin");
		driver.findElement(By.id("btnSave")).click();
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		driver.findElement(By.name("chkSelectRow[]")).click();
//		driver.findElement(By.id("btnDelete")).click();
//		driver.findElement(By.id("dialogDeleteBtn")).click();
		
		System.out.println("Admin-Qualification-Nationalities  PASSED");

		// Configuration
		// emailConfiguration
		driver.findElement(By.id("menu_admin_Configuration")).click();
		driver.findElement(By.id("menu_admin_listMailConfiguration")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/h1")).getText();
		driver.findElement(By.id("editBtn")).click();
		driver.findElement(By.id("emailConfigurationForm_txtMailAddress")).clear();
		driver.findElement(By.id("emailConfigurationForm_txtMailAddress")).sendKeys("email.com");
		driver.findElement(By.id("emailConfigurationForm_txtMailAddress")).clear();
		driver.findElement(By.id("emailConfigurationForm_txtMailAddress")).sendKeys("email@email.com");
		driver.findElement(By.id("editBtn")).click();
		
		System.out.println("Admin-Configuration-EmailConfig  PASSED");

		// emailSubs
		driver.findElement(By.id("menu_admin_Configuration")).click();
		driver.findElement(By.id("menu_admin_viewEmailNotification")).click();
		driver.findElement(By.xpath("//*[@id=\"search-results\"]/div[1]/h1")).getText();
		driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr[1]/td[1]/a")).click();
		driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.id("subscriber_name")).sendKeys("ara");
		driver.findElement(By.id("subscriber_email")).sendKeys("ara@email.com");
		driver.findElement(By.id("btnSave")).click();
		driver.findElement(By.name("chkSelectRow[]")).click();
		driver.findElement(By.id("btnDelete")).click();
		driver.findElement(By.id("dialogDeleteBtn")).click();
		
		System.out.println("Admin-Configuration-EmailSubs  PASSED");
		
		//localization
		driver.findElement(By.id("menu_admin_Configuration")).click();
		driver.findElement(By.id("menu_admin_localization")).click();
		driver.findElement(By.id("localizationHeading")).getText();
		driver.findElement(By.id("btnSave")).click();
		driver.findElement(By.id("localization_dafault_language")).click();
		driver.findElement(By.xpath("//*[@id=\"localization_dafault_language\"]/option[3]")).click();
		driver.findElement(By.id("btnSave")).click();
		driver.findElement(By.id("localizationHeading")).getText();
		driver.findElement(By.id("btnSave")).click();
		driver.findElement(By.id("localization_dafault_language")).click();
		driver.findElement(By.xpath("//*[@id=\"localization_dafault_language\"]/option[4]")).click();
		driver.findElement(By.id("btnSave")).click();
		
		System.out.println("Admin-Configuration-Localization  PASSED");
		
//		driver.findElement(By.id("btnSave")).click();
//		driver.findElement(By.id("localization_dafault_language")).click();
//		driver.findElement(By.xpath("//*[@id=\"localization_dafault_language\"]/option[4]")).click();
//		driver.findElement(By.id("btnSave")).click();
//		
		//modules
		driver.findElement(By.id("menu_admin_Configuration")).click();
		driver.findElement(By.id("menu_admin_viewModules")).click();
		driver.findElement(By.id("saveFormHeading")).getText();
		
		System.out.println("Admin-Configuation-Modules  PASSED");
		
		//socialMedia
		driver.findElement(By.id("menu_admin_Configuration")).click();
		driver.findElement(By.id("menu_admin_openIdProvider")).click();
		driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.id("openIdProvider_name")).sendKeys("ara");
		driver.findElement(By.id("openIdProvider_url")).sendKeys("https://qa.cilsy.id/");
		driver.findElement(By.id("btnSave")).click();
		driver.findElement(By.xpath("//*[@id=\"search-results\"]/div[1]/h1")).getText();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.name("chkSelectRow[]")).click();
		driver.findElement(By.id("btnDelete")).click();
		driver.findElement(By.id("dialogDeleteBtn")).click();
		
		System.out.println("Admin-Configuration-SocialMedia  PASSED");
		
		//registerOAUTH
		driver.findElement(By.id("menu_admin_Configuration")).click();
		driver.findElement(By.id("menu_admin_registerOAuthClient")).click();
		driver.findElement(By.id("oauth_client_id")).sendKeys("ara1");
		driver.findElement(By.id("oauth_client_secret")).sendKeys("ara11");
		driver.findElement(By.id("oauth_redirect_uri")).sendKeys("ara ara");
		driver.findElement(By.id("btnSave")).click();
		driver.findElement(By.name("chkSelectRow[]")).click();
		driver.findElement(By.id("btnDelete")).click();
		driver.findElement(By.id("dialogDeleteBtn")).click();
		
		System.out.println("Admin-Configuration-RegisterOAUTH  PASSED");
		
		//PIM
		//employeeList
		driver.findElement(By.xpath("//*[@id=\"menu_pim_viewPimModule\"]/b")).click();
		driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
		driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.id("firstName")).sendKeys("ara");
		driver.findElement(By.id("lastName")).sendKeys("ara");
		driver.findElement(By.id("employeeId")).clear();
		driver.findElement(By.id("employeeId")).sendKeys("0719AM");
		driver.findElement(By.id("btnSave")).click();
		
		driver.findElement(By.xpath("//*[@id=\"pdMainContainer\"]/div[1]/h1")).getText();
		driver.findElement(By.id("btnSave")).click();
		driver.findElement(By.id("personal_txtLicenNo")).sendKeys("00012345a");
		driver.findElement(By.id("personal_txtLicExpDate")).click();
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[4]/td[5]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[2]/option[102]")).click();
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[1]/td[4]/a")).click();
		driver.findElement(By.id("personal_optGender_2")).click();
		driver.findElement(By.id("personal_cmbMarital")).click();
		driver.findElement(By.xpath("//*[@id=\"personal_cmbMarital\"]/option[2]")).click();
		
		driver.findElement(By.id("personal_DOB")).click();
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[1]/option[10]")).click();
		driver.findElement(By.className("ui-datepicker-year")).click();
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[2]/option[80]")).click();
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[4]/td[7]/a")).click();
		driver.findElement(By.id("btnSave")).click();
		
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		driver.findElement(By.xpath("//*[@id=\"search_form\"]/fieldset/ol/li[1]/label")).getText();
//		driver.findElement(By.name("chkSelectRow[]")).click();
//		driver.findElement(By.id("btnDelete")).click();
//		driver.findElement(By.id("dialogDeleteBtn")).click();
		
		System.out.println("PIM-EmployeeList  PASSED");
		
		//Time
		//employeeRecords
		driver.findElement(By.xpath("//*[@id=\"menu_time_viewTimeModule\"]/b")).click();
		driver.findElement(By.id("menu_attendance_Attendance")).click();
		driver.findElement(By.id("menu_attendance_viewAttendanceRecord")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[1]/h1")).getText();
		driver.findElement(By.id("attendance_employeeName_empName")).sendKeys("Inosuke Chan (Past Employee)");
		driver.findElement(By.id("attendance_date")).click();
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[5]/td[5]/a")).click();
		driver.findElement(By.id("btView")).click();
		driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr/td[1]")).getText();
		
		System.out.println("Time-EmployeeRecords  PASSED");
		
		//Logout
		driver.findElement(By.id("welcome")).click();
		driver.findElement(By.xpath("//*[@id=\"welcome-menu\"]/ul/li[3]/a")).click();
		
		System.out.println("Logout  PASSED");
		
		
		
		
		

		//driver.close();

	}
}