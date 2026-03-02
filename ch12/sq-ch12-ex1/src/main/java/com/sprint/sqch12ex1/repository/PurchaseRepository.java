package com.sprint.sqch12ex1.repository;

import com.sprint.sqch12ex1.model.Purchase;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PurchaseRepository {
    private final JdbcTemplate jdbc; //field

    public PurchaseRepository(JdbcTemplate jdbc){ //parameter
        //Store the injected JdbcTemplate inside THIS PurchaseRepository object.
        //Take the constructor parameter jdbc and assign it to this object’s field jdbc
        this.jdbc = jdbc;
    }

    // this method takes a parameter that represents the data to be stored
    public void storePurchase(Purchase purchase){
        // the question marks replace the queries' parameter values
        // for the ID, DB will auto-gen value
        // best practice: provide column names
        String sql =
                "INSERT INTO purchase (product, price) VALUES (?, ?)";

        jdbc.update(sql,
                purchase.getProduct(),
                purchase.getPrice());
    }

    // this method returns records from db in a list of Purchase objects

    public List<Purchase> findAllPurchases(){
        String sql = "SELECT * FROM purchase";

        RowMapper<Purchase> purchaseRowMapper = (r, i) -> {
            Purchase rowObject = new Purchase();
            rowObject.setId(r.getInt("id"));
            rowObject.setProduct(r.getString("product"));
            rowObject.setPrice(r.getBigDecimal("price"));

            return rowObject;
        };

        return jdbc.query(sql, purchaseRowMapper);
    }

}
