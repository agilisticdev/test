package com.mkyong.transaction;

public interface TransactionDao {

  void setPayment(Payment s);

  Payment getPayment(int articleId);
}
