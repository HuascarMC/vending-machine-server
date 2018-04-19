package api;

import static spark.Spark.*;

import com.google.gson.Gson;

import vendingMachine.DrinkVendingMachine;

import api.db.DBHelper;

import vendingMachine.Objects.Order;
import vendingMachine.Objects.Drink;
import vendingMachine.Objects.Coin;

import vendingMachine.components.Bucket;

import java.util.Map;

import api.Tools.CorsFilter;

import api.models.DBItem;
import api.models.DBCoin;

import java.util.List;

public class App {
  public static void main(String[] args) {
    CorsFilter corsFilter = new CorsFilter();
    corsFilter.apply();

    post("/order", (request, response) -> {
      // Create something
      Gson gson = new Gson();
      DBHelper dbhelper = new DBHelper();
      return gson.toJson(dbhelper.hasItem("COKE"));
    });
    }

  //   get("/cointemp", (request, response) -> {
  //     // Show something
  //     Gson gson = new Gson();
  //     //Temporal route coins that work in memory.
  //     EntityManager session = sf.createEntityManager();
  //     try {
  //       Map<Coin, Integer> coins = vm.coinInventory.getInventory();
  //       return gson.toJson(coins);
  //     } catch (Exception e) {
  //       return "Error: " + e.getMessage();
  //     } finally {
  //       if (session.isOpen()) {
  //         session.close();
  //       }
  //     }
  //
  //   });
  //
  //   get("/itemtemp", (request, response) -> {
  //     // Temporal route for items that work in memory.
  //     Gson gson = new Gson();
  //
  //     EntityManager session = sf.createEntityManager();
  //     try {
  //       Map<Drink, Integer> items = vm.stockInventory.getInventory();
  //       return gson.toJson(items);
  //     } catch (Exception e) {
  //       return "Error: " + e.getMessage();
  //     } finally {
  //       if (session.isOpen()) {
  //         session.close();
  //       }
  //     }
  //
  //   });
  //
  //
  //
  //
  //   get("/machine/:inventory", (request, response) -> {
  //     // Get all from chosen inventory
  //     Gson gson = new Gson();
  //     EntityManager session = sf.createEntityManager();
  //
  //     try {
  //       List<Coin> items = session.createQuery("FROM " + request.params(":inventory")).getResultList();
  //       return gson.toJson(items);
  //
  //     } catch (Exception e) {
  //
  //       return "Error: " + e.getMessage();
  //     } finally {
  //
  //       if (session.isOpen()) {
  //         session.close();
  //       }
  //     }
  //
  //   });
  //
  //   post("/machine/DBCoin", (request, response) -> {
  //     // Create coin
  //     Gson gson = new Gson();
  //     EntityManager session = sf.createEntityManager();
  //     try {
  //       request.attribute("org.eclipse.jetty.multipartConfig", new MultipartConfigElement(""));
  //       DBCoin coin = (DBCoin) gson.fromJson(request.body(), DBCoin.class);
  //
  //       session.getTransaction().begin();
  //       session.persist(coin);
  //       session.getTransaction().commit();
  //
  //       return gson.toJson(coin);
  //     } catch (Exception e) {
  //       return "Error: " + e.getMessage();
  //     } finally {
  //       if (session.isOpen()) {
  //         session.close();
  //       }
  //
  //     }
  //   });
  //   // Update coin
  //   put("/machine/DBCoin", (request, response) -> {
  //     EntityManager session = sf.createEntityManager();
  //     try{
  //       Gson gson = new Gson();
  //
  //       String query = String.format("FROM DBCoin WHERE name = '%s'", request.queryParams("name"));
  //       DBCoin coin = (DBCoin) session.createQuery(query).getSingleResult();
  //       coin.setQuantity(Integer.parseInt(request.queryParams("quantity")));
  //       session.getTransaction().begin();
  //       session.merge(coin);
  //       session.getTransaction().commit();
  //       return gson.toJson(coin);
  //     } catch(Exception e) {
  //       return "Error: " + e.getMessage();
  //     } finally {
  //       if(session.isOpen()) {
  //         session.close();
  //       }
  //     }
  //   });
  //
  //   // Delete all items
  //   delete("/machine/:inventory", (request, response) -> {
  //     Gson gson = new Gson();
  //     EntityManager session = sf.createEntityManager();
  //     try {
  //       request.attribute("org.eclipse.jetty.multipartConfig", new MultipartConfigElement(""));
  //       session.getTransaction().begin();
  //       session.createQuery("DELETE FROM " + request.params(":inventory")).executeUpdate();
  //       session.getTransaction().commit();
  //       return "OK";
  //     } catch (Exception e) {
  //       return "Error: " + e.getMessage();
  //     } finally {
  //       if (session.isOpen()) {
  //         session.close();
  //       }
  //     }
  //   });
  //   // Create item
  //   post("/machine/DBItem", (request, response) -> {
  //     Gson gson = new Gson();
  //     EntityManager session = sf.createEntityManager();
  //     try {
  //       request.attribute("org.eclipse.jetty.multipartConfig", new MultipartConfigElement(""));
  //
  //       DBItem item = (DBItem) gson.fromJson(request.body(), DBItem.class);
  //
  //       session.getTransaction().begin();
  //       session.persist(item);
  //       session.getTransaction().commit();
  //
  //       return gson.toJson(item);
  //     } catch (Exception e) {
  //       return "Error: " + e.getMessage();
  //     } finally {
  //       if (session.isOpen()) {
  //         session.close();
  //       }
  //
  //     }
  //   });
  //
  //   put("/machine/DBItem", (request, response) -> {
  //     // Update item
  //     EntityManager session = sf.createEntityManager();
  //     try{
  //       Gson gson = new Gson();
  //
  //       String query = String.format("FROM DBItem WHERE name = '%s'", request.queryParams("name"));
  //       DBItem item = (DBItem) session.createQuery(query).getSingleResult();
  //       item.setQuantity(Integer.parseInt(request.queryParams("quantity")));
  //       session.getTransaction().begin();
  //       session.merge(item);
  //       session.getTransaction().commit();
  //       return gson.toJson(item);
  //     } catch(Exception e) {
  //       return "Error: " + e.getMessage();
  //     } finally {
  //       if(session.isOpen()) {
  //         session.close();
  //       }
  //     }
  //   });
  //
  //
  //   options("/options", (request, response) -> {
  //     // Appease something
  //     return "options";
  //   });
  // }
}
