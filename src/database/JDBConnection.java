package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JDBConnection {

	public static void main(String[] args) throws SQLException
	{
		String url = "jdbc:mysql://localhost:3306/Qadbt";
		String username = "root";
		String password = "2116";
		
	Connection con=DriverManager.getConnection(url, username, password);
	System.out.println("Connection successful");
	Statement s=con.createStatement();
	ResultSet rs =s.executeQuery("select * from Employeeinfo where name= 'Ram'");
	while(rs.next())
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();	
		driver.get("https://rahulshettyacademy.com/client");
		
		driver.findElement(By.id("userEmail")).sendKeys(rs.getString("name"));
		System.out.println(rs.getString("age"));
	}
	}

}
