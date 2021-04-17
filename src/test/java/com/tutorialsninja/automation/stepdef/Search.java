package com.tutorialsninja.automation.stepdef;

import org.junit.Assert;

import com.tutorialsninja.automation.framework.Elements;
import com.tutorialsninja.automation.pages.HeaderSection;
import com.tutorialsninja.automation.pages.SearchResultPage;

import cucumber.api.java.en.*;

public class Search {
	HeaderSection headerSection = new HeaderSection();
	SearchResultPage searchResultPage = new SearchResultPage();
	

@When("^I search for a product \"([^\"]*)\"$")
public void i_search_for_a_product(String product)
{
	Elements.TypeText(HeaderSection.SearchBoxField, product);
	Elements.click(HeaderSection.searchButton);
   
}

@Then("^I should see the product in the search results$")
public void i_should_see_the_product_in_the_search_results()  
{
Assert.assertTrue(Elements.isDisplayed(SearchResultPage.syncMasterProduct));    
}

@Then("^I should see a message saying \"([^\"]*)\"$")
public void i_should_see_a_message_saying(String message) 
{
	Assert.assertTrue(Elements.VerifyTextEquals(SearchResultPage.Displaymessage, message));
}




}
