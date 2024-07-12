package ru.microservice.conversion.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CurrencyConversionBean {

    @EqualsAndHashCode.Include
    private Long id;

    private String from;

    private String to;

    private BigDecimal conversionMultiple;

    private int port;
}
