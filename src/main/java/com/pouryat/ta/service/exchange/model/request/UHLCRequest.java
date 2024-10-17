package com.pouryat.ta.service.exchange.model.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

import java.sql.Timestamp;

@EqualsAndHashCode(callSuper = true)
@Setter
public class UHLCRequest extends Exchange {
    private String url; // like : /udf/history
    private String symbol;
    private Integer resolution;
    private Timestamp to;
    private Timestamp from;
    private Integer countback;
    private Integer page;


    public UHLCRequest(
            String baseUrl,
            String token,
            String url,
            String symbol,
            Integer resolution,
            Timestamp to
    ) {
        super(baseUrl, token);
        this.url = url;
        this.symbol = symbol;
        this.resolution = resolution;
        this.to = to;
    }


    public String getUrl() {
        String result = getBaseUrl() + url + "?" + "symbol=" + symbol + "&" + "resolution=" + resolution
                + "&" + "to=" + to.getTime();
        if (from != null)
            result += "&from=" + from.getTime();
        if (countback != null)
            result += "&countback=" + countback;
        if (page != null)
            result += "&page=" + page;
        return result;
    }
}
