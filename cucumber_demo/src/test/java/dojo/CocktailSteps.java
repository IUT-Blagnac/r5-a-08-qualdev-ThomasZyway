package dojo;

import java.util.List;

import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CocktailSteps {

    private Order order;

    @Given("{string} who wants to buy a drink")
    public void who_wants_to_buy_a_drink(String name) {
        order = new Order();
        order.declareOwner(name);
    }

    @When("an order is declared for {string}")
    public void an_order_is_declared_for(String targetName) {
        order.declareTarget(targetName);
    }

    @Then("there are {int} cocktails in the order")
    public void there_are_cocktails_in_the_order(int expectedCocktails) {
        List<String> cocktails = order.getCocktails();
        assertEquals(expectedCocktails, cocktails.size());
    }
}
