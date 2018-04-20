package ch02;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.Assert.*;

import static ch02.NyPizza.Size.SMALL;
import static ch02.Pizza.Topping.HAM;
import static ch02.Pizza.Topping.ONION;
import static ch02.Pizza.Topping.SAUSAGE;

public class PizzaTests {
  @Test
  public void pizzaTest() throws Exception {
    NyPizza nyPizza = new NyPizza.Builder(SMALL).addTopping(SAUSAGE).addTopping(ONION).build();
    assertEquals(SMALL, nyPizza.size);
    assertEquals(new HashSet<Pizza.Topping>(Arrays.asList(ONION,SAUSAGE)),nyPizza.toppings);

    Calzone calzone = new Calzone.Builder().addTopping(HAM).sauceInside().build();
    assertEquals(new HashSet<Pizza.Topping>(Arrays.asList(HAM)),calzone.toppings);

  }
}
