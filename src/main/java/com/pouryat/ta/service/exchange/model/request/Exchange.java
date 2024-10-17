package com.pouryat.ta.service.exchange.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Exchange {
    private String baseUrl; // like : https://api.wallex.ir/v1
    private String token;
}
