package com.example.vendingMachine.api;

import api.db.DBHelper;

import vendingMachine.components.Bucket;
import vendingMachine.abstracts.VendingMachine;
import vendingMachine.Objects.State;
import vendingMachine.Objects.Coin;
import vendingMachine.Objects.Drink;
import vendingMachine.Objects.Order;

import vendingMachine.Tools.ChangeHandler;

import java.util.List;

public class VendingMachineImpl extends VendingMachine {

  private DBHelper dbhelper;

  public VendingMachineImpl() {
    super();
    dbhelper = new DBHelper();
  }

  @Override
  public Bucket<Enum, List<Coin>, State, Double> vend(Order order) {
    Drink drink = (Drink) Drink.getDrinkByName((String) order.getItem());
    double balance =  order.getBalance();

    double remainingBalance = balance - drink.getPrice();

    State state = new State(dbhelper.hasItem(drink.getName()), dbhelper.getCoinTotal() >= remainingBalance, remainingBalance >= 0 );

    if(state.possible()) {
      List<Coin> change = ChangeHandler.convertToChange(remainingBalance);
      dbhelper.removeOneItem(drink.getName());
      dbhelper.removeCoins(change);
      return new Bucket<>(drink, change, state, ChangeHandler.getChangeValue(change));
    }
    List<Coin> refund = ChangeHandler.convertToChange(balance);
    return new Bucket<>(null, refund, state, ChangeHandler.getChangeValue(refund));
  }
}
