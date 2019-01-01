package homePage;


import base.CommonApi;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchFunctionality extends CommonApi {

    @FindBy(xpath = "//*[@id=\"primary-navigation\"]/div[6]/form/input")
    public static WebElement searchTextBox;
    @FindBy(xpath = "//*[@id=\"primary-navigation\"]/div[6]/form/button")
    public static WebElement searchSubmitButton;
    @FindBy(xpath = "//a[@class='search']")
    public static WebElement searchIcon;
    @FindBy(id = "section1heading")
    public static WebElement tagLine;


    public static  void waitToBeVisible(){

        searchIcon.click();
        wait.until(ExpectedConditions.visibilityOf(searchTextBox));


    }
    public void searchWithENTER(String searchKeys){


        waitToBeVisible();
        clearField(searchTextBox);
        searchTextBox.sendKeys(searchKeys, Keys.ENTER);

    }
    public void searchUsingButton(String searchKeys){


        waitToBeVisible();
        clearField(searchTextBox);
        //searchTextBox.clear();
        searchTextBox.sendKeys(searchKeys);
        searchSubmitButton.click();

    }






}
