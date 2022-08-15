package com.sel.tests;

import com.sel.pages.Boxture_LoginPage;
import com.sel.pages.Boxture_Purchase;
import com.sel.pages.Sidebar_Click;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.awt.*;

public class Boxture_PurchaseOrder extends BaseTest {

    private String username;
    private String password;



    @BeforeTest
    @Parameters({"username1", "password"})
    public void setupParameters(String username1, String password) {
        this.username = username1;
        this.password = password;

        //change parameter for PURCHASE ORDER
    }

    @Test
    public void loginPage() throws AWTException, InterruptedException {

        Boxture_LoginPage loginPage = new Boxture_LoginPage(driver);
        loginPage.loginUrl();
        Thread.sleep(3000);
        loginPage.username_enter(username);
        loginPage.password_enter(password);
        loginPage.login_buttonClick();
        System.out.println("I'm in purchase page");
    }


}