package com.sel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Boxture_Purchase {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(css = "input[placeholder='Destination location']")
    private WebElement destination;
    @FindBy(css = "input[placeholder='Product']")
    private WebElement product;
    @FindBy(css = "button[value='save']")
    private WebElement createButton;
    @FindBy(css = "satis-copyable[scrub='#']")
    private WebElement orderNum;

    @FindBy(xpath = "//main/div/div/div/div/div/div/div[2]/h3/satis-copyable")
    private WebElement orderNumNew;
    public Boxture_Purchase(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void destination(String destinationLOcation) throws InterruptedException {

        this.wait.until(ExpectedConditions.visibilityOf(this.destination));
        this.destination.click();
        this.destination.clear();
        this.destination.sendKeys(destinationLOcation);
        Thread.sleep(3000);
    }

    public void product(String product) throws InterruptedException {
        this.wait.until(ExpectedConditions.visibilityOf(this.product));
        this.product.click();
        this.product.sendKeys(product);
        Thread.sleep(3000);

    }

    public void createPurchase() {
        this.createButton.click();
    }

    public String orderNum() throws InterruptedException {
//        SearchContext shadow = this.orderNum.getShadowRoot();
//        WebElement a = shadow.findElement(By.cssSelector("span"));
//        String k = a.getText().substring(1);
//        System.out.println(k);

        String b = orderNumNew.getText().substring(1);
        return b;


    }
}
