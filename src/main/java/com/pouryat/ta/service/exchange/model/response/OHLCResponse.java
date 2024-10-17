package com.pouryat.ta.service.exchange.model.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Getter
public class OHLCResponse {
    private String s;
    private List<Timestamp> t;
    private List<BigDecimal> o;
    private List<BigDecimal> h;
    private List<BigDecimal> l;
    private List<BigDecimal> c;
    private List<Float> v;



    @JsonCreator
    public OHLCResponse(
            @JsonProperty("s") String s,
            @JsonProperty("t") List<Long> t,
            @JsonProperty("c") List<String> c,
            @JsonProperty("o") List<String> o,
            @JsonProperty("h") List<String> h,
            @JsonProperty("l") List<String> l,
            @JsonProperty("v") List<String> v
    ) {
        this.s = s;
        this.t = t.stream().map(Timestamp::new).collect(Collectors.toList());
        this.o = o.stream().map(BigDecimal::new).collect(Collectors.toList());
        this.h = h.stream().map(BigDecimal::new).collect(Collectors.toList());
        this.l = l.stream().map(BigDecimal::new).collect(Collectors.toList());
        this.c = c.stream().map(BigDecimal::new).collect(Collectors.toList());
        this.v = v.stream().map(Float::valueOf).collect(Collectors.toList());
    }


    public void setS(String s) {
        this.s = s;
    }


    public void setT(List<Long> t) {
        this.t = t.stream().map(Timestamp::new).collect(Collectors.toList());
    }


    public void setC(List<String> c) {
        this.c = c.stream().map(BigDecimal::new).collect(Collectors.toList());
    }


    public void setO(List<String> o) {
        this.o = o.stream().map(BigDecimal::new).collect(Collectors.toList());
    }


    public void setH(List<String> h) {
        this.h = h.stream().map(BigDecimal::new).collect(Collectors.toList());
    }


    public void setL(List<String> l) {
        this.l = l.stream().map(BigDecimal::new).collect(Collectors.toList());
    }


    public void setV(List<String> v) {
        this.v = v.stream().map(Float::valueOf).collect(Collectors.toList());
    }
}
