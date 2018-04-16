package com.example.vendingMachine.api;

import vendingMachine.Objects.Coin;
import vendingMachine.Objects.Order;
import vendingMachine.components.CoinInventory;
import vendingMachine.components.Bucket;
import vendingMachine.components.StockInventory;
import vendingMachine.Objects.Drink;
import vendingMachine.Objects.State;

import org.junit.Before;
import org.junit.Test;

import org.apache.commons.lang.builder.EqualsBuilder;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertSame;
import static junit.framework.Assert.assertTrue;
import junit.framework.Assert;

public class TestDrinkVendingMachine {

  private Order cokeOrderChange;
  private Order pepsiOrderNoChange;
  private Order sodaOrderOutStock;
  private Order cokeOrderOutBalance;
  private Order sodaOrderOutChange;

  private DrinkVendingMachine vendingMachine;

  @Before
  public void before() {
    vendingMachine = new DrinkVendingMachine();

    cokeOrderChange = new Order("coke", 5);
    pepsiOrderNoChange = new Order("coke", 1);
    sodaOrderOutStock = new Order("coke", 5);
    cokeOrderOutBalance = new Order("coke", 0);
    sodaOrderOutChange = new Order("coke", 50);
  }

  @Test
  public void testVendWithChange() {
    Bucket result = vendingMachine.vend(cokeOrderChange);

    List<Coin> change = new ArrayList<>();
    change.add(Coin.QUARTER);
    change.add(Coin.QUARTER);
    change.add(Coin.QUARTER);

    State state = new State(true, true, true);

    Bucket expectedResult = new Bucket<>(Drink.COKE, change, state);
    Assert.assertTrue(EqualsBuilder.reflectionEquals( result, expectedResult ));
  }

  // @Test
  // public void testVendWithNoChange() {
  //   Bucket result = vendingMachine.vend(pepsiOrderNoChange);
  // }
  //
  // @Test
  // public void testVendNoStock() {
  //   Bucket result = vendingMachine.vend(sodaOrderOutStock);
  // }
  //
  // @Test
  // public void testVendNotEnoughBalance() {
  //   Bucket result = vendingMachine.vend(cokeOrderOutBalance);
  // }
  //
  // @Test
  // public void testVendNotEnoughChange() {
  //   Bucket result = vendingMachine.vend(sodaOrderOutChange);
  // }
}