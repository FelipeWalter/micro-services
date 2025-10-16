package br.edu.atitus.product_service.clients;

import org.springframework.stereotype.Component;


@Component
public class CurrencyClientFallback implements CurrencyClient {

    @Override
    public CurrencyResponse getCurrency(double value, String source, String target) {

        CurrencyResponse fallback = new CurrencyResponse();

        fallback.setConvertedPrice(-1.0);


        fallback.setConversionFactor(0.0);
        fallback.setEnvironment("Fallback - Currency Service Offline");

        return fallback;
    }
}