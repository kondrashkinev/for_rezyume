package triangleTests;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.TestMethodOrder;					//Чтобы сработала аннотация Order
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;		//Чтобы сработала аннотация Order


@TestMethodOrder(OrderAnnotation.class)//Чтобы сработала аннотация Order
@Execution(ExecutionMode.CONCURRENT)   //аннотация для распараллеливания тестов
@TestInstance (Lifecycle.PER_CLASS)
public class homwork4_SeleniumGrid<WebDriverWait> {	//имя файла д. совпадатать с именем класса
		private WebDriver driver1, driver2, driver3, driver4, driver5, driver6;   //drivers
		String nodeURL;
		Long id1, id2, id3, id4, id5, id6;
		String WebDriverWait;
		
		@BeforeAll			//в предусловии создаём драйвер
		public void setUp() throws MalformedURLException {	
			
			//прописываем опции для драйверов
			ChromeOptions opt1 = new ChromeOptions(); 
			EdgeOptions opt2 = new EdgeOptions(); 
			ChromeOptions opt3 = new ChromeOptions(); 
			FirefoxOptions opt4 = new FirefoxOptions();
			ChromeOptions opt5 = new ChromeOptions();
			FirefoxOptions opt6 = new FirefoxOptions();
			
			nodeURL = "http://localhost:4444";    //зададим переменную nodeURL
			
			//запускаем драйвера
			driver1 = new RemoteWebDriver(new URL(nodeURL),opt1); 	
			driver2 = new RemoteWebDriver(new URL(nodeURL),opt2);
			driver3 = new RemoteWebDriver(new URL(nodeURL),opt3);
			driver4 = new RemoteWebDriver(new URL(nodeURL),opt4);
			driver5 = new RemoteWebDriver(new URL(nodeURL),opt5);
			driver6 = new RemoteWebDriver(new URL(nodeURL),opt6);
			}
			
		@AfterAll
		public void tearDown() {
			//закрываем наши драйвера
			driver1.quit(); 
			driver2.quit(); 
			driver3.quit(); 
			driver4.quit(); 
			driver5.quit(); 
			driver6.quit(); 
		}
		
		@Test
		@Order(4)
		public void nothing() {
		    driver4.get("https://allcalc.ru/node/1051");					//запускаем сайт
		    driver4.manage().window().setSize(new Dimension(1400, 1024));
		    driver4.findElement(By.id("value1")).sendKeys("50");
		    driver4.findElement(By.id("value2")).sendKeys("90");
		    driver4.findElement(By.id("value3")).sendKeys("10");
		    driver4.findElement(By.cssSelector("td:nth-child(1) > input")).click();
			 id4 = Thread.currentThread().getId();  //идентификатор потока, в к-м будет запускаться наш тест
			 System.out.println("Firefox id = " + id4);
		  assertEquals(driver4.findElement(By.xpath("//*[@id=\"answer\"]")).getText(), "Треугольник не существует"); //Сравнение ожидаемого результата с фактическим
		}
		@Test
		@Order(1)
		public void Obtuse_Isosceles_Triangle() {
			driver1.get("https://www.calculator.net/triangle-calculator.html?vc=90&vx=1&vy=1&va=&vz=&vb=&angleunits=d&x=Calculate"); //запускаем сайт
			driver1.manage().window().setSize(new Dimension(1084, 1012));
			driver1.findElement(By.xpath("//*[@id=\"content\"]/div[15]/form/table/tbody/tr[5]/td/input[2]")).click();
			driver1.findElement(By.name("vc")).sendKeys("150");
			driver1.findElement(By.name("vx")).sendKeys("1");
			driver1.findElement(By.name("vy")).sendKeys("1");
			driver1.findElement(By.xpath("//*[@id=\"content\"]/div[15]/form/table/tbody/tr[5]/td/input[1]")).click();
		    id1 = Thread.currentThread().getId();  //идентификатор потока, в к-м будет запускаться наш тест
			 System.out.println("Chrome id = " + id1);
		    assertEquals(driver1.findElement(By.xpath("//*[@id=\"content\"]/table[1]/tbody/tr/td[1]/h3")).getText(), "Obtuse Isosceles Triangle"); //Сравнение ожидаемого результата с фактическим
		}
		
		@Test
		@Order(2)
		public void Obtuse_Scalene_Triangle() {
		  driver3.get("https://www.calculator.net/triangle-calculator.html?vc=90&vx=1&vy=1&va=&vz=&vb=&angleunits=d&x=Calculate"); //запускаем сайт
		  driver3.findElement(By.xpath("//*[@id=\"content\"]/div[15]/form/table/tbody/tr[5]/td/input[2]")).click();
		  driver3.findElement(By.name("vx")).sendKeys("1");
		  driver3.findElement(By.name("vy")).sendKeys("1");
		  driver3.findElement(By.name("va")).sendKeys("100");
		  driver3.findElement(By.xpath("//*[@id=\"content\"]/div[15]/form/table/tbody/tr[5]/td/input[1]")).click();
			 id3 = Thread.currentThread().getId();  //идентификатор потока, в к-м будет запускаться наш тест
			 System.out.println("Chrome id = " + id3);
		  assertEquals(driver3.findElement(By.xpath("//*[@id=\"content\"]/table[1]/tbody/tr/td[1]/h3")).getText(), "Obtuse Scalene Triangle"); //Сравнение ожидаемого результата с фактическим
		}

		@Test
		@Order(3)
		public void no_conditions() {
		  driver5.get("https://www.calculator.net/triangle-calculator.html?vc=90&vx=1&vy=1&va=&vz=&vb=&angleunits=d&x=Calculate"); //запускаем сайт
		  driver5.findElement(By.xpath("//*[@id=\"content\"]/div[15]/form/table/tbody/tr[5]/td/input[2]")).click();
		  driver5.findElement(By.name("vc")).sendKeys("50");
		  driver5.findElement(By.name("va")).sendKeys("50");
		  driver5.findElement(By.name("vb")).sendKeys("50");
		  driver5.findElement(By.name("vz")).sendKeys("4");
		  driver5.findElement(By.xpath("//*[@id=\"content\"]/div[15]/form/table/tbody/tr[5]/td/input[1]")).click();
			 id5 = Thread.currentThread().getId();  //идентификатор потока, в к-м будет запускаться наш тест
			 System.out.println("Chrome id = " + id5);
		  assertEquals(driver5.findElement(By.xpath("//*[@id=\"content\"]/p[2]/font")).getText(), "The sum of the three angles must equal 180° or π radians."); //Сравнение ожидаемого результата с фактическим
		}	
		
		@Test
		@Order(5)
		public void Equilateral_Triangle() {
			driver2.get("https://www.calculator.net/triangle-calculator.html?vc=90&vx=1&vy=1&va=&vz=&vb=&angleunits=d&x=Calculate"); //запускаем сайт
		    driver2.manage().window().setSize(new Dimension(1084, 1012));
		    driver2.findElement(By.xpath("//*[@id=\"content\"]/div[15]/form/table/tbody/tr[5]/td/input[2]")).click();
		    driver2.findElement(By.name("vc")).sendKeys("60");
		    driver2.findElement(By.name("vx")).sendKeys("60");
		    driver2.findElement(By.name("vy")).sendKeys("60");
		    driver2.findElement(By.xpath("//*[@id=\"content\"]/div[15]/form/table/tbody/tr[5]/td/input[1]")).click();
			 id2 = Thread.currentThread().getId();  //идентификатор потока, в к-м будет запускаться наш тест
			 System.out.println("Edge id = " + id2);			
		  assertEquals(driver2.findElement(By.xpath("//*[@id=\"content\"]/table[1]/tbody/tr/td[1]/h3")).getText(), "Equilateral Triangle"); //Сравнение ожидаемого результата с фактическим
		}
		
		@Test    
		@Order(6) 		
		public void citilink() throws InterruptedException {
			driver6.get("https://stroyparkdiy.ru/?ysclid=m1tnz6kvlk740948162"); //запускаем сайт
			driver6.findElement(By.xpath("/html/body/div[5]/div[2]/button")).click(); //закрываем всплывающий баннер о скачивании приложения, чтобы добраться до сайта
			driver6.findElement(By.xpath("//*[@id=\"edit-search--2\"]")).click();  //выбираем строку поиска для ввода необходимого
			driver6.findElement(By.name("search")).sendKeys("лопата"); //вводим необходимое слово, для поиска
			driver6.findElement(By.name("search")).sendKeys(Keys.ENTER); //жмём ENTER
			TimeUnit.SECONDS.sleep(3);   //задаём задержку в 3 секунды для корректной отработки запроса
			 id6 = Thread.currentThread().getId();  //идентификатор потока, в к-м будет запускаться наш тест
			 System.out.println("Firefox id = " + id6);			 
		  assertEquals(driver6.findElement(By.xpath("/html/body/div[1]/main/section[2]/section/div/h2")).getText(), "Вы ищете: лопата"); //Сравнение ожидаемого результата с фактическим
		}
}
