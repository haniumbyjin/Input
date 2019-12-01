package com.conference.push.model.stock;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Stock {
    String name;
    float price;
}
