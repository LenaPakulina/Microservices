package ru.microservice.conversion.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import ru.microservice.conversion.model.CurrencyConversionBean;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class CurrencyExchangeService {
    private final CurrencyExchangeServiceProxy proxy;

    public CurrencyConversionBean retrieveExchangeValue
            (String from, String to) {
        return proxy.retrieveExchangeValue(from, to);
    }
}
