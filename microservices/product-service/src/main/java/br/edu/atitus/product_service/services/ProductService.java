package br.edu.atitus.product_service.services;

import br.edu.atitus.product_service.clients.CurrencyClient;
import br.edu.atitus.product_service.clients.CurrencyResponse; // DTO que vem do currency-service
import br.edu.atitus.product_service.entities.ProductEntity; // Sua entidade de produto
import br.edu.atitus.product_service.repositories.ProductRepository;
import br.edu.atitus.product_service.dto.ProductDto;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@org.springframework.cache.annotation.CacheConfig(cacheNames = "product-conversion")
public class ProductService {

    private final ProductRepository productRepository;
    private final CurrencyClient currencyClient;

    public ProductService(ProductRepository productRepository, CurrencyClient currencyClient) {
        this.productRepository = productRepository;
        this.currencyClient = currencyClient;
    }


    @Cacheable(key = "#productId.toString().concat('-').concat(#toCurrency)")
    public ProductDto getProductDetailsWithConversion(Long productId, String toCurrency) {

        ProductEntity product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with ID: " + productId));

        CurrencyResponse conversion = currencyClient.getCurrency(product.getPrice(), product.getCurrency(), toCurrency);

        Double convertedPrice;

        if (conversion.getConvertedPrice() == -1.0) {
            convertedPrice = -1.0;
        } else {
            convertedPrice = conversion.getConvertedPrice();

        }

        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getPrice(),
                toCurrency,
                convertedPrice,
                conversion.getEnvironment()
        );
    }
}