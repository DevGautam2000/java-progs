package scraping;/*
     AUTHOR: GAUTAM CHANDRA SAHA
     DATE & TIME: 10/05/21 AT 1:02 PM
     DESCRIPTION: 
     
*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Dictionary;
import java.util.Hashtable;

public class Scrape {

    private static final String uri = "https://result.smuexam.in/search.php?eid=NOVEMBER/DECEMBER%20SEMESTER%20EXAMINATION%202020&examType=202";

    public static void main(String[] args) {


        String[] regs = new String[]{"201900099", "201900097", "201900196"};


        for (String id : regs) {
            driveGet(id);
        }
    }

    private static void driveGet(String id) {

        System.setProperty("webdriver.chrome.driver",
                "/usr/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.get(uri);
        driver.navigate().refresh();
        driver.findElement(By.xpath("//input[@name='search']")).sendKeys(id);
        driver.findElement(By.xpath("//button[@class='searchButton']")).click();

        var text = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//section[@id='portfolio']/div/div/div[1]")));

        var arr = text.getText().split("\n");

        var str = arr[2];

        System.out.println(str);

        Dictionary dictionary = new Hashtable();

        if (arr.length > 1 && id != null) {
            dictionary.put(id, dictionary.get(id));
            var join = str.split(":");

            var name = join[1].strip();

        }

        System.out.println(dictionary);


        driver.close();

        System.out.println(dictionary);
    }
}

