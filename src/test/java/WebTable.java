import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;


// Here in this Programme, we will try to get all the data present inside a WebTable on the WebPage.
public class WebTable {

    static WebDriver driver;
    static WebDriverWait wait;


    public static void main(String[] args) {

        driver = new ChromeDriver();

//Initialising Explicit Wait in order to use it in this programme if required.
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.tutorialspoint.com/selenium/practice/menu.php");
        System.out.println("Launched webSite by providing the URL on ChromeBrowser");
        System.out.println();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("driver waited using ImplicitWaits so that all the webElements present on the webPage get loaded up i.e. Synchronization");
        System.out.println();

        String pageHeading = driver.findElement(By.xpath("//h1[normalize-space()='Selenium - Automation Practice Form']")).getText();
        System.out.println("Page Heading is : "+pageHeading);
        System.out.println();

// Navigating to Elements_Bar button present on upper left side over the webPage.
        WebElement elementsTab = driver.findElement(By.xpath("//button[normalize-space()='Elements']"));

        //Using explicit wait initialised earlier so that our WebElement is visible for driver to make Click action.
        wait.until(ExpectedConditions.visibilityOf(elementsTab));
        System.out.println("driver waited using Explicit wait so that our target webElement gets visible for the driver to perform further actions");
        System.out.println();

        String elementsTabText = elementsTab.getText();
        System.out.println("driver moved to this Button : "+elementsTabText);
        System.out.println();

        elementsTab.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("clicked on "+elementsTabText);
        System.out.println();



 // Navigating to WebTable button present under Elements_Bar button.
        WebElement webTablesTab = driver.findElement(By.xpath("//a[normalize-space()='Web Tables']"));

        //Using explicit wait initialised earlier so that our WebElement is visible for driver to make Click action.
        wait.until(ExpectedConditions.visibilityOf(webTablesTab));
        System.out.println("driver waited using Explicit wait so that our target webElement gets visible for the driver to perform further actions");
        System.out.println();

        String webTablesTabText = webTablesTab.getText();

        System.out.println("driver moved to this Button : "+webTablesTabText);
        System.out.println();

        webTablesTab.click();
        System.out.println("clicked on "+webTablesTabText);
        System.out.println();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("driver waited using ImplicitWait so that all the webElements present on the webPage get loaded i.e. Synchronization");
        System.out.println();

        String pageText = driver.findElement(By.xpath("//h1[normalize-space()='Web Tables']")).getText();
        System.out.println("Text present on the top of this Page is : "+pageText);
        System.out.println();

        System.out.println("Employee Details from the WebTable are as follows ,");
        System.out.println();
        System.out.println("FirstName"+" , "+"LastName"+" , "+"Age"+" , "+"EmailId"+" , "+"Salary"+" ,  "+"Department");


        // Now we will get total number of rows present inside our WebTable
        List<WebElement> listOfRows = driver.findElements(By.xpath("//table[@class=\"table table-striped mt-3\"]/tbody/tr"));

        // Similarly getting total number of cells present inside every row
        List<WebElement> listOfCells = driver.findElements(By.xpath("//table[@class=\"table table-striped mt-3\"]/tbody/tr[1]/td"));

        int totalRows = listOfRows.size();
        int totalCells = listOfCells.size()-1;


// Getting the data present inside the every cell of the respective row of the WebTable present on this WebPage....one by one.
        for(int i = 1; i<=totalRows; i++){
            for(int j = 1 ; j<=totalCells; j++){

                WebElement TableElement = driver.findElement(By.xpath("//table[@class=\"table table-striped mt-3\"]/tbody/tr["+i+"]/td["+j+"]"));

                wait.until(ExpectedConditions.visibilityOf(TableElement));

                String text1 = TableElement.getText();

                if(j<6){
                    System.out.print(text1+" , ");
                }
                else{
                    System.out.print(text1);
                }
            }
            System.out.println();
        }


        driver.close();
        driver.quit();

        System.out.println();
        System.out.println("closed all the tabs opened");



    }






}
