package ru.microservice.forex.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.microservice.forex.model.ExchangeValue;
import ru.microservice.forex.repository.ExchangeValueRepository;

@Service
@AllArgsConstructor
public class ForexService {
    private final ExchangeValueRepository exchangeValueRepository;

    public ExchangeValue findByFromAndTo(String from, String to) {
        return exchangeValueRepository.findByFromAndTo(from, to);
    }
}
