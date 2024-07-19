package codewars.six;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

/*
 * Some new cashiers started to work at your restaurant.
 * 
 * They are good at taking orders, but they don't know how to capitalize words, or use a space bar!
 * 
 * All the orders they create look something like this:
 * 
 * "milkshakepizzachickenfriescokeburgerpizzasandwichmilkshakepizza"
 * 
 * The kitchen staff are threatening to quit, because of how difficult it is to read the orders.
 * 
 * Their preference is to get the orders as a nice clean string with spaces and capitals like so:
 * 
 * "Burger Fries Chicken Pizza Pizza Pizza Sandwich Milkshake Milkshake Coke"
 * 
 * The kitchen staff expect the items to be in the same order as they appear in the menu.
 * 
 * The menu items are fairly simple, there is no overlap in the names of the items:
 * 
 * 1. Burger
 * 2. Fries
 * 3. Chicken
 * 4. Pizza
 * 5. Sandwich
 * 6. Onionrings
 * 7. Milkshake
 * 8. Coke
 * 
 */

public class NewCashier {
	
    public static String getOrder(String input) {
    	List<String> menu = List.of("Burger","Fries","Chicken","Pizza","Sandwich","Onionrings","Milkshake","Coke");
    	List<String> order = new ArrayList<>();
    	for (String s : menu) {
    		while (input.indexOf(s.toLowerCase()) > -1) {
    			input = input.replaceFirst(s.toLowerCase(), "");
    			order.add(s);
    		}
    	}
        return order.stream().collect(Collectors.joining(" "));
    }
    
    @Test
    public void test() {
        assertEquals("Burger Fries Chicken Pizza Pizza Pizza Sandwich Milkshake Milkshake Coke", getOrder("milkshakepizzachickenfriescokeburgerpizzasandwichmilkshakepizza"));
        assertEquals("Burger Fries Fries Chicken Pizza Sandwich Milkshake Coke", getOrder("pizzachickenfriesburgercokemilkshakefriessandwich"));
    }

}
