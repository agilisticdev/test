package com.mkyong.transaction;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class TransactionDaoImpl implements TransactionDao {

  @Inject
  private DataSource dataSource;

  private JdbcTemplate jdbcTemplate;

  private final Payment value;

  public TransactionDaoImpl() {
    value = new Payment("123-abc-456", "Toy", 9.95, false);
  }

  @PostConstruct
  public void init() {
    jdbcTemplate = new JdbcTemplate(dataSource);
  }

  public void setPayment(Payment s) {
    Object[] values = new Object[] { s.getProductId(), s.getDescription(), s.getPrice() };
    String insert = "insert into article (article_name, article_desc, price) values (?, ?, ?)";
    jdbcTemplate.update(insert, values);
  }

  public Payment getPayment(int articleId) {
    String query = "SELECT * from article where article_id = ?";
    return jdbcTemplate.queryForObject(query, new Object[] { Integer.valueOf(articleId) },
        new RowMapper<Payment>() {
          public Payment mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            String name = resultSet.getString("article_name");
            String desc = resultSet.getString("article_desc");
            double price = resultSet.getDouble("price");

            Payment p = new Payment();

            p.setProductId(name);
            p.setDescription(desc);
            p.setPrice(price);

            return p;
            }
        });
  }

}
