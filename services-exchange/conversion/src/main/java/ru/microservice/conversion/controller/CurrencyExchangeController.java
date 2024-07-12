package ru.microservice.conversion.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ru.microservice.conversion.model.CurrencyConversionBean;
import ru.microservice.conversion.service.CurrencyExchangeService;
import ru.microservice.conversion.service.CurrencyExchangeServiceProxy;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/currency-converter")
@Slf4j
public class CurrencyExchangeController {

    private final CurrencyExchangeService currencyExchangeService;

    private CurrencyExchangeServiceProxy proxy;

    @GetMapping("/feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convertCurrencyFeign(@PathVariable String from,
                                                       @PathVariable String to,
                                                       @PathVariable BigDecimal quantity) {
        CurrencyConversionBean response = proxy.retrieveExchangeValue(from, to);
        log.info("{}", response);
        return new CurrencyConversionBean(response.getId(),
                from,
                to,
                response.getConversionMultiple(),
                response.getPort());
    }

    @GetMapping("/rest/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convertCurrency
            (@PathVariable String from, @PathVariable String to,
             @PathVariable BigDecimal quantity) {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("from", from);
        uriVariables.put("to", to);
        ResponseEntity<CurrencyConversionBean> responseEntity =
                new RestTemplate().getForEntity(
                        "http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class,
                        uriVariables
                );
        CurrencyConversionBean response = responseEntity.getBody();
        return new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple(), response.getPort());
    }
}
