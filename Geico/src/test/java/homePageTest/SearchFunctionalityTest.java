package homePageTest;


import homePage.SearchFunctionality;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class SearchFunctionalityTest extends SearchFunctionality
 {

    public String keys = "Property";
    SearchFunctionality search;
    @BeforeMethod
    public void initialisationOfElements(){
        search = PageFactory.initElements(driver,SearchFunctionality.class);
    }
    @Test
    public void testSearchWithButtonAndEnterKey(){

        String actualText=tagLine.getText();
        Assert.assertEquals(actualText, "More than just car insurance");
        System.out.println("Test verified");
        searchWithENTER(keys);
        navigateBack();
        searchUsingButton(keys);



    }


//    @Test
//    public void testSearchWithButton(){
//        String actualText=tagLine.getText();
//        Assert.assertEquals(actualText, "More than just car insurance");
//        System.out.println("Test verified");
//
//        searchUsingButton(keys);
//


}
