package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {
    public static final String DAY = "select[1]";
    public static final String MONTH = "select[2]";
    public static final String YEAR = "select[3]";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);
        driver.get("https://www.facebook.com/");

        getSelect(driver, getXpath(DAY)).selectByIndex(22);
        getSelect(driver, getXpath(MONTH)).selectByIndex(5);
        getSelect(driver, getXpath(YEAR)).selectByIndex(27);
    }

    private static Select getSelect(WebDriver driver, String xpath) {
        WebElement element = driver.findElement(By.xpath(xpath));
        return new Select(element);
    }

    private static String getXpath(String select) {
        return "//div[contains(@class, \"_58mq _5dbb\")]/div/span/span/" + select;
    }
}
