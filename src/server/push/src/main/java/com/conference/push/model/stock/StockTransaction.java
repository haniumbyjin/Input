package com.conference.push.model.stock;

import lombok.*;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StockTransaction {

    String user;
    Stock stock;
    Date when;

}
