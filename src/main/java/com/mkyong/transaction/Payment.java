package com.mkyong.transaction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

  private String productId;

  private String description;

  private double price;

  private boolean processed;

}
