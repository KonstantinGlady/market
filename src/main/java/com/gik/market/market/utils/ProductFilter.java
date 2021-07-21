package com.gik.market.market.utils;

import com.gik.market.market.entities.Product;
import com.gik.market.market.repositories.specifications.ProductSpecification;
import lombok.Getter;
import org.springframework.data.jpa.domain.Specification;

import java.util.Map;

@Getter
public class ProductFilter {

    private Specification<Product> spec;
    private final StringBuilder filterDef;

    public ProductFilter(Map<String, String> map) {
        filterDef = new StringBuilder();
        spec = Specification.where(null);
        if (map.containsKey("max_price") && !map.get("max_price").isEmpty()) {
            spec = spec.and(ProductSpecification.lessThanOrEqualTo(Integer.parseInt(map.get("max_price"))));
            this.filterDef.append("&max_price=").append(map.get("max_price"));
        }

        if (map.containsKey("min_price") && !map.get("min_price").isEmpty()) {
            spec = spec.and(ProductSpecification.greaterThanOrEqualTo(Integer.parseInt(map.get("min_price"))));
            this.filterDef.append("&min_price=").append(map.get("min_price"));
        }
    }
}
