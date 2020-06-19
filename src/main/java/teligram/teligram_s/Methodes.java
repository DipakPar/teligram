package teligram.teligram_s;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Methodes extends App {

	public static void click_on_burger_menu() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='icon-hamburger-wrap']")));
			driver.findElement(By.xpath("//div[@class='icon-hamburger-wrap']")).click();
		} catch (Exception e) {
			stop = true;
			System.out.println("there is some issue in the click_on_burger_menu methode");
			
		}
	}

	public static void click_on_contact_option() {
		if (stop == false) {
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Contacts')]")));
				driver.findElement(By.xpath("//span[contains(text(),'Contacts')]")).click();
			} catch (Exception e) {
				stop = true;
				System.out.println("there is some issue in the click_on_contact_option methode");
				
			}
		} else {
			System.out.println("there is some issue");
		}
	}
	
	public static void click_on_new_contact_btn() {
		if (stop == false) {
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-md btn-md-primary']")));
				driver.findElement(By.xpath("//button[@class='btn btn-md btn-md-primary']")).click();
			} catch (Exception e) {
				stop = true;
				System.out.println("there is some issue in the click_on_new_contact_btn methode");
				
			}
		} else {
			System.out.println("there is some issue");
		}
	}
	
	public static void insert_phone_number(String mobileNum,String F_name) {
		if (stop == false) {
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='phone']")));
				driver.findElement(By.xpath("//input[@name='phone']")).click();
				driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(mobileNum);
				driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(Keys.TAB,F_name);
			} catch (Exception e) {
				stop = true;
				System.out.println("there is some issue in the insert_phone_number methode");
				
			}
		} else {
			System.out.println("there is some issue");
		}
	}
	
	public static void insert_First_name(String F_name) {
		if (stop == false) {
			try {
			//	Thread.sleep(1000);
			//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[7]/div[2]/div/div/div[1]/form/div[2]/input")));
				driver.findElement(By.xpath("//input[@class='md-input ng-pristine ng-valid ng-empty ng-touched']")).click();
				driver.findElement(By.xpath("//input[@class='md-input']")).sendKeys(F_name);
			} catch (Exception e) {
				stop = true;
				System.out.println(e);
				System.out.println("there is some issue in the insert_First_name methode");
				
			}
		} else {
			System.out.println("there is some issue");
		}
	}
	
	public static void click_on_save_btn() {
		if (stop == false) {
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Save')]")));
				driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
				
			} catch (Exception e) {
				stop = true;
				System.out.println(e);
				System.out.println("there is some issue in the click_on_save_btn methode");
			}
		} else {
			System.out.println("there is some issue");
		}
	}
	
	public static void select_methode() throws InterruptedException{
		number_not_found_so_skip_steps = false;
		try{
		if(driver.findElement(By.xpath("//span[contains(text(),'Not found')]")).isDisplayed()){
			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[contains(text(),'OK')]")).click();
			number_not_found_so_skip_steps = true;
		}
		}	catch(Exception e){
		//}else{
			Methodes.type_message();
			Methodes.click_on_send_btn();
		}
		
	}
	
	public static void type_message() {
		if (stop == false) {
			try {
			//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/form[1]/div[2]/div[5]")));
			//	driver.findElement(By.xpath("//div[@className='composer_rich_textarea']")).click();
			//	driver.findElement(By.xpath("//div[@className='composer_rich_textarea']")).sendKeys(Keys.chord(Keys.CONTROL,"v"));
				//div[@placeholder='Write a message...']
				// class name = composer_rich_textarea
				//div[@className='composer_rich_textarea']
				driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/form[1]/div[2]/div[5]")).sendKeys(my_message);
			} catch (Exception e) {
				stop = true;
				System.out.println(e);
				System.out.println("there is some issue in the type_message methode");
			}
		} else {
			System.out.println("there is some issue");
		}
	}
	
	public static void click_on_send_btn() {
		if (stop == false) {
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='im_submit_send_label nocopy']")));
				driver.findElement(By.xpath("//span[@class='im_submit_send_label nocopy']")).click();
			//	driver.findElement(By.className("im_submit_send_label nocopy")).sendKeys(my_message);
			    System.out.println("====================================");
				System.out.println("clicked Send button Successfully");
				System.out.println("====================================");
			} catch (Exception e) {
				stop = true;
				System.out.println(e);
				System.out.println("there is some issue in the click_on_send_btn methode");
			}
		} else {
			System.out.println("there is some issue");
		}
	}
	
	public static void copydata(){
		  StringSelection data = new StringSelection
			         ("This is copied to the clipboard");
			      Clipboard cb = Toolkit.getDefaultToolkit()
			         .getSystemClipboard();
			      cb.setContents(data, data);
	}
}
