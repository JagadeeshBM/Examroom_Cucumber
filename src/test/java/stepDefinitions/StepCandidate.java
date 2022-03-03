package stepDefinitions;

import ch.qos.logback.core.util.FileUtil;
import com.sun.deploy.cache.BaseLocalApplicationProperties;
import io.cucumber.java.en.*;
import javafx.scene.input.InputMethodTextRun;
import jdk.nashorn.internal.ir.IfNode;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class StepCandidate {
    WebDriver driver;
    public WebElement element;

    public void main(String[] args)
    {

    }
    // String month = "MAY 2020";
    //String exp_date = "7";

    @Given(": Connect to DB")
    public void connect_to_DB() throws SQLException {
        Connection con= DriverManager.getConnection("jdbc:sqlserver://localhost:1433/ExamRoomV2UAT","ExamRoomV2UatUser","S0oprS3cur1t3M@n");
                // Connection con= DriverManager.getConnection("jdbc:sqlserver://sqlexamroom.czljrwemwniw.us-east-2.rds.amazonaws.com/ExamRoomV2UAT","ExamRoomV2UatUser","S0oprS3cur1t3M@n");
                Statement stmt =con.createStatement();
        String query="GO\n" +
                "declare @emailId varchar(100) ='jmcandidatems@mailinator.com';\n" +
                "declare @persontenantroleId as int;\n" +
                "declare @PID as int;\n" +
                "\n" +
                "select @persontenantroleId = ptr.Id, @PID = p.Id\n" +
                "from dbo.person p\n" +
                "inner join dbo.PersonTenantRole ptr\n" +
                "on p.Id = ptr.PersonId\n" +
                "and p.EmailId = @emailId\n" +
                "\n" +
                "select @persontenantroleId = ptr.Id\n" +
                "from dbo.person p\n" +
                "inner join dbo.PersonTenantRole ptr\n" +
                "on p.Id = ptr.PersonId\n" +
                "and p.EmailId = @emailId\n" +
                "and ptr.PersonRoleId = 1\n" +
                "where emailid = @emailId;\n" +
                "\n" +
                "delete PFNF\n" +
                "from dbo.PersonFormNoteFile PFNF\n" +
                "inner join dbo.PersonFormNote PFN\n" +
                "on PFNF.PersonFormNOteId = PFN.Id\n" +
                "inner join dbo.PersonForm PF\n" +
                "on PF.Id = PFN.PersonFormId\n" +
                "and PF.PersonTenantRoleId = @persontenantroleId\n" +
                "\n" +
                "delete PFN\n" +
                "from dbo.PersonFormNote PFN\n" +
                "inner join dbo.PersonForm PF\n" +
                "on PF.Id = PFN.PersonFormId\n" +
                "and PF.PersonTenantRoleId = @persontenantroleId\n" +
                "\n" +
                "delete sl from dbo.PersonForm pf\n" +
                "inner join dbo.PersonFormStatusLog sl\n" +
                "on pf.id = sl.PersonFormId\n" +
                "and pf.persontenantroleid = @persontenantroleId\n" +
                "\n" +
                "delete pfr from dbo.PersonForm pf\n" +
                "inner join dbo.PersonFormReview pfr\n" +
                "on pf.id = pfr.PersonFormId\n" +
                "and pf.persontenantroleid = @persontenantroleId\n" +
                "\n" +
                "delete pf from dbo.PersonForm pf\n" +
                "where  pf.persontenantroleid = @persontenantroleId\n" +
                "\n" +
                "\n" +
                "delete pf from dbo.PersonEligibilityRoute pf\n" +
                "where  pf.persontenantroleid = @persontenantroleId\n" +
                "\n" +
                "UPDATE PERSON SET DATADETAIL = JSON_MODIFY(DATADETAIL, '$.TrainingInstituteId', 0) WHERE ID = @PID\n" +
                "delete from Voucher where assigntopersonid= @PID\n" +
                "\t\n" +
                "update voucher set assigntopersonid=null\n" +
                "where id in (select id from voucher where assigntopersonid in (select id from person where emailid='jmcandidatems@mailinator.com '))\n";
        ResultSet rs = stmt.executeQuery(query);
        System.out.println("Application is cleared successfully");

    }

    @When(":Run cleanup query for Applications")
    public void run_cleanup_query_for_Applications() {

    }

    @When(":Run Cleanup query for Exams")
    public void run_Cleanup_query_for_Exams() {

    }

    @Then(":Application should be cleared")
    public void application_should_be_cleared() {

    }


    @Given("Candidate launch Chrome Browser")
    public void candidate_launch_Chrome_Browser() throws IOException {
        System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

    }

    @When("Candidate opens URL {string}")
    public void candidate_opens_URL(String string) {
        driver.get("https://credentiauat.examroom.ai/");

    }

    @When("Candidate click on GetStarted button")
    public void candidate_click_on_GetStarted_button() {
        driver.findElement(By.xpath("/html/body/main/div/div/div[2]/div/div/a")).click();
    }

    @When("Candidate Enters Email as {string} and password as {string}")
    public void candidate_Enters_Email_as_and_password_as(String string, String string2) {
        driver.findElement(By.xpath("//*[@id=\"mat-input-0\"]")).sendKeys("jmcandidatems@mailinator.com");
        driver.findElement(By.xpath("//*[@id=\"mat-input-1\"]")).sendKeys("Exam@123");
    }

    @When("Candidate click on login button")
    public void candidate_click_on_login_button() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/exai-root/exai-login/div/div/form/button")).click();
        Thread.sleep(10000);
    }

    //@Then("Candidate can view Dashboard details")
    //public void candidate_can_view_Dashboard_details()
    //{

    //}

    // @When("Candidate click on Dashboard")
    //public void candidate_click_on_Dashboard()
    // {


    //}

    @When("Click on Start New Application")
    public void click_on_Start_New_Application() throws IOException {
        //driver.findElement(By.xpath("/html/body/exai-root/exai-custom-layout/exai-layout/div/mat-sidenav-container/mat-sidenav-content/main/exai-dashboard/div/div/div/div/div[4]/button/span[1]")).click();

        //driver.findElement(By.xpath("//*[text()=\" Start New Application \"]")).click();
        //driver.findElement(By.className("mat-button-wrapper")).click();
        // Create object of WebDriverWait class.


// Wait till the element is not visible.
        //WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/exai-root/exai-custom-layout/exai-layout/div/mat-sidenav-container/mat-sidenav-content/main/exai-dashboard/div/div/div/div/div[4]/button/span[1]")));
        //WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[text()=\" Start New Application \"])[1]")));
        WebDriverWait wait = new WebDriverWait(driver, 500);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/exai-root/exai-custom-layout/exai-layout/div/mat-sidenav-container/mat-sidenav-content/main/exai-dashboard/div/div/div/div/div[4]/button")));

        element.click();

        TakesScreenshot ts=(TakesScreenshot)driver;
        File src=ts.getScreenshotAs(OutputType.FILE);
        File trg=new File(".\\screenshots\\homepage_CR.png");
        FileUtils.copyFile(src, trg);

        // WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\" Start New Application \"] "))).click();
    }

    @When("Click on Eligibility Route {int}")
    public void click_on_Eligibility_Route(Integer int1) throws IOException {
        driver.findElement(By.xpath("/html/body/exai-root/exai-custom-layout/exai-layout/div/mat-sidenav-container/mat-sidenav-content/main/exai-application/div/div[2]/div[1]/div/div[3]/div/button[1]")).click();

        TakesScreenshot ts=(TakesScreenshot)driver;
        File src=ts.getScreenshotAs(OutputType.FILE);
        File trg=new File(".\\screenshots\\ER_Validation.png");
        FileUtils.copyFile(src, trg);

    }

    @When("click on check box")
    public void click_on_check_box() {
        driver.findElement(By.xpath("//*[@id=\"mat-checkbox-1\"]/label/span[1]")).click();

    }

    @When("click on Start button")
    public void click_on_Start_button() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/exai-root/exai-custom-layout/exai-layout/div/mat-sidenav-container/mat-sidenav-content/main/exai-application/div/div[2]/div[2]/div/div[2]/button")).click();
        Thread.sleep(1200);
    }


    @When("Candidate Fill the Application Form_EnterTraining Program")
    public void candidate_Fill_the_Application_Form_EnterTraining_Program() {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"aa8314efb2904c78948de88d24ddc49a\"]/div/div[2]/div"));
        element.click();
        //WebElement TraingCenter = driver.findElement(By.xpath("//mat-option[@id='mat-option-1']//span[contains(text(),'MS_Training Center')]"));
        WebElement TraingCenter = driver.findElement(By.xpath("//span[contains(text(),'MS_Training Center1')]"));
        TraingCenter.click();
        //Select sel = new Select(element);
        //sel.selectByVisibleText("MS_Training Center1");

    }

    @When("Candidate Fill the Application Form_Select Course Completion Date")
    public void candidate_Fill_the_Application_Form_Select_Course_Completion_Date() throws InterruptedException {


        WebDriverWait wait = new WebDriverWait(driver, 800);

        WebElement calender = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Open calendar']")));

        calender.click();

        // try {
        //   calender.click();
        ;
        // } catch (StaleElementReferenceException e) {
        //  calender = driver.findElement(By.xpath("//button[@aria-label='Open calendar']"));
        //  calender.click();

        while (true) {
            String text = driver.findElement(By.xpath("//button[@aria-label='Choose month and year']")).getText();
            String month = "MAY 2020";

            if (text.equals(month)) {
                break;
            } else {

                driver.findElement(By.xpath("//button[@aria-label='Previous month']")).click();
            }
        }


        driver.findElement(By.xpath("//div[normalize-space()='7']")).click();

        //  List <WebElement> allDates = driver.findElements(By.xpath("//div[normalize-space()='']"));
        // for(WebElement ele:allDates)



        //{
        //    System.out.println(ele.getText());
        //}
        //String date_text = ele.getText();
        // String[] date = date_text.split("\n");

        // String exp_date = "7";

        //if (date[1].equals(exp_date))
        //if (date_text.equals(exp_date))
        // {
        //  ele.click();
        //   break;
        // }

        //}

    }
    @When("Select ACCOMMODATIONS as No")
    public void select_ACCOMMODATIONS_as_No() throws InterruptedException {
        driver.findElement(By.xpath("//span[@class='mat-expansion-indicator ng-tns-c133-16 ng-trigger ng-trigger-indicatorRotate ng-star-inserted']")).click();
        //span[@class='mat-expansion-indicator ng-tns-c133-16 ng-trigger ng-trigger-indicatorRotate ng-star-inserted']
        Thread.sleep(800);
        driver.findElement(By.xpath("//label[@for='mat-radio-12-input']//span[@class='mat-radio-inner-circle']")).click();
    }

    @When("Certify REGISTRANT CERTIFICATION")
    public void certify_REGISTRANT_CERTIFICATION() throws InterruptedException {
        driver.findElement(By.xpath("//span[@class='mat-expansion-indicator ng-tns-c133-18 ng-trigger ng-trigger-indicatorRotate ng-star-inserted']")).click();
        Thread.sleep(1500);
        //span[@class='mat-expansion-indicator ng-tns-c133-18 ng-trigger ng-trigger-indicatorRotate ng-star-inserted']
        driver.findElement(By.xpath("//span[@class='mat-checkbox-inner-container']")).click();
    }

    @When("Click on Submit Button")
    public void click_on_Submit_Button() throws InterruptedException {

        driver.findElement(By.xpath("//body//exai-root//button[4]")).click();
        Thread.sleep(800);
        driver.findElement(By.xpath("//button[@class='mat-focus-indicator btn-1 mat-button mat-button-base mat-primary']")).click();
        Thread.sleep(16000);

    }

    @Then("Candidate can view confirmation message  {string}")
    public void candidate_can_view_confirmation_message(String string) throws InterruptedException, IOException
    {
        // String actual_message= driver.findElement(By.xpath("//div[@class='cdk-overlay-container']")).getText();
        //Thread.sleep(5000);
        //String expected_message="\n" + " Successfully Saved Response.";

        //Type1
        //Assert.assertEquals(actual_message,expected_message);
        //Type2
        //Assert.assertTrue(actual_message.contains("\n" + "Successfully Saved Response."));
        TakesScreenshot ts=(TakesScreenshot)driver;
        File src=ts.getScreenshotAs(OutputType.FILE);
        File trg=new File(".\\screenshots\\homepage_CR.png");
        FileUtils.copyFile(src, trg);
    }

    // @Then("close browser")
    //public void close_browser() {
    //driver.close();

    //}

    @Given("Launch Chrome Browser")
    public void launch_Chrome_Browser() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(2000);
        // ((JavascriptExecutor)driver).executeScript("window.open()");

        //ArrayList<String> tabs =new ArrayList<>(driver.getWindowHandles());
        //driver.switchTo().window(tabs.get(1));


    }

    @When("TP opens URL {string}")
    public void tp_opens_URL(String string) {

        driver.get("https://credentiauat.examroom.ai/");

    }
    @When("TP click on GetStarted button")
    public void tp_click_on_GetStarted_button() {

        driver.findElement(By.xpath("/html/body/main/div/div/div[2]/div/div/a")).click();

    }
    @When("TP Enters Email as {string} and password as {string}")
    public void tp_Enters_Email_as_and_password_as(String string, String string2)
    {
        driver.findElement(By.xpath("//*[@id=\"mat-input-0\"]")).sendKeys("jmtrainingms1@mailinator.com");
        driver.findElement(By.xpath("//*[@id=\"mat-input-1\"]")).sendKeys("Exam@123");


    }
    @When("TP click on login button")
    public void tp_click_on_login_button() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/exai-root/exai-login/div/div/form/button")).click();
        Thread.sleep(35000);


    }
    @When("TP click on Candidate Search")
    public void tp_click_on_Candidate_Search() throws InterruptedException {
        driver.findElement(By.xpath("//mat-icon[normalize-space()='ballot']")).click();

        //span[@class='item-label ng-tns-c298-20']
        //mat-icon[normalize-space()='ballot']
        Thread.sleep(20000);
    }
    @When("TP Search with candidate name")
    public void tp_Search_with_candidate_name() {

        driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("%Appa B Mulimani%");

    }
    @When("TP click on Action button for candidate")
    public void tp_click_on_Action_button_for_candidate() throws InterruptedException {
        driver.findElement(By.xpath("//button[@class='mat-focus-indicator text-left mat-icon-button mat-button-base ng-star-inserted']")).click();
        Thread.sleep(1000);
    }
    @When("select radio button as No Changes")
    public void select_radio_button_as_No_Changes()
    {
        driver.findElement(By.xpath("//label[@for='mat-radio-9-input']//span[@class='mat-radio-container']")).click();

        //label[@for='mat-radio-9-input']//span[@class='mat-radio-outer-circle']
        //label[@for='mat-radio-9-input']//span[@class='mat-radio-container']
        //mat-radio-button[@id='mat-radio-9']



    }
    @When("Click on Submit Button for Approval")
    public void click_on_Submit_Button_for_Approval() throws InterruptedException {

        driver.findElement(By.xpath("//button[@class='mat-focus-indicator btn-11 text-xs mat-button mat-button-base']")).click();

        Thread.sleep(20000);

    }
    @Then("Validate Approved success message")
    public void validate_Approved_success_message() throws InterruptedException {

        //driver.findElement(By.xpath("//p[normalize-space()='Submitted Successfully']"));

        // String actual_message= driver.findElement(By.xpath("//p[normalize-space()='Submitted Successfully']")).getText();
        // Thread.sleep(12000);
        // String expected_message="\n" + "Submitted Successfully";
        //Type1
        // Assert.assertEquals(actual_message,expected_message);


    }
    @Then("login to candidate and validate approved status.")
    public void login_to_candidate_and_validate_approved_status() throws IOException, InterruptedException {
        driver.get("https://credentiauat.examroom.ai/");
        driver.findElement(By.xpath("/html/body/main/div/div/div[2]/div/div/a")).click();
        driver.findElement(By.xpath("//*[@id=\"mat-input-0\"]")).sendKeys("jmcandidatems@mailinator.com");
        driver.findElement(By.xpath("//*[@id=\"mat-input-1\"]")).sendKeys("Exam@123");
        driver.findElement(By.xpath("/html/body/exai-root/exai-login/div/div/form/button")).click();
        Thread.sleep(25000);
        String actual_status=driver.findElement(By.xpath("//span[@class='t-xs ml-2 -mt-3']")).getText();
        String expected_status="Approved";
        //Type1
        Assert.assertEquals(actual_status,expected_status);

        TakesScreenshot ts=(TakesScreenshot)driver;
        File src=ts.getScreenshotAs(OutputType.FILE);
        File trg=new File(".\\screenshots\\Application Approved by TP.png");
        FileUtils.copyFile(src, trg);

    }

}

