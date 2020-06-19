package teligram.teligram_s;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Hello world!
 *
 */
public class App {

	static String my_message = "This is my message";
	static String name = "dipak";
	//static String MobileNum = "11111122222";
    public static String[] MobileNum = {"1111112222","1111114444","9904481050","1111114446"};
    public static String[] namee = {"abhay","vijay","mohak","vijay"};
	
	public static WebDriverWait wait;
	public static boolean number_not_found_so_skip_steps;
	public static boolean stop;
	static String URL = "https://web.telegram.org/#/im";
	static WebDriver driver;
	static ChromeOptions driverOption;

	@BeforeTest
	public static void setup() {
	
		WebDriverManager.chromedriver().setup();
		// String path = System.getProperty("user.dir");
		// System.setProperty("webdriver.chrome.driver", path +
		// "\\dependency\\chromedriver.exe");
		driverOption = new ChromeOptions();
		driverOption.setExperimentalOption("debuggerAddress", "localhost:9014");
		driver = new ChromeDriver(driverOption);
		wait = new WebDriverWait(driver, 20);
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public static void teligram() throws InterruptedException {
	//	Methodes.type_message();
		try{
		for (int a = 0; a<=MobileNum.length; a++) {
			System.out.println(MobileNum[a]);
			if (number_not_found_so_skip_steps == false) {
				System.out.println("im in the if part==========================");
				Methodes.click_on_burger_menu();
				Methodes.click_on_contact_option();
				Methodes.click_on_new_contact_btn();
				Methodes.insert_phone_number(MobileNum[a], namee[a]);
			//	Methodes.insert_First_name(name);
				Methodes.click_on_save_btn();
				Methodes.select_methode();
			} else {
				System.out.println("else part ++++++++++++++++++++++++++++++");
				Methodes.click_on_new_contact_btn();
				Methodes.insert_phone_number(MobileNum[a], namee[a]);
			//	Methodes.insert_First_name(namee[a]);
				Methodes.click_on_save_btn();
				Methodes.select_methode();
			}
		}
		}catch(Exception e){
		System.out.println("There is No New Number!");
		}
	}
	@AfterTest
	public static void close(){
		driver.findElement(By.xpath("//a[@class='md_modal_action md_modal_action_close']")).click();
	}

}
