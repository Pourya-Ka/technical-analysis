package com.pouryat.ta.service.exchange;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pouryat.ta.service.exchange.model.request.UHLCRequest;
import com.pouryat.ta.service.exchange.model.response.OHLCResponse;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class ExchangeService {
    private static RestTemplate restTemplate;


    public ExchangeService() {
        if (restTemplate == null)
            restTemplate = new RestTemplate();
    }


    public OHLCResponse getOHLC(UHLCRequest request) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>("body", headers);
        try {
            ResponseEntity<String> response = restTemplate.exchange(request.getUrl(), HttpMethod.GET, entity, String.class);
            System.out.println(response.getBody());
            return new ObjectMapper()
                    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                    .readValue(response.getBody(), OHLCResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
