package com.bzzzzz.farm.product.mapper;

import com.bzzzzz.farm.product.dto.ProductPostDto;
import com.bzzzzz.farm.product.dto.ProductSimpleResponseDto;
import com.bzzzzz.farm.product.entity.Product;
import com.bzzzzz.farm.product.entity.ProductOption;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    default Product productPostDtoToProduct(ProductPostDto productPostDto) {
        if (productPostDto == null) {
            return null;
        }

        Product product = new Product();

        product.setName(productPostDto.getName());
        product.setPrice(productPostDto.getPrice());
        product.setDescription(productPostDto.getDescription());
        product.setPhoto(productPostDto.getPhoto());
        product.setBrand(productPostDto.getBrand());
        product.setShippingCountry(Product.ShippingCountry.valueOf(productPostDto.getShippingCountry()));
        product.setShippingMethod(Product.ShippingMethod.valueOf(productPostDto.getShippingMethod()));
        product.setShippingPrice(productPostDto.getShippingPrice());

        productPostDto.getProductOptionPostDtos().stream()
                .forEach(productOptionPostDto -> {
                    ProductOption productOption = new ProductOption();

                    productOption.setProduct(product);
                    productOption.setProductOptionName(productOptionPostDto.getProductOptionName());
                    productOption.setPrice(productOptionPostDto.getPrice());
                    productOption.setStock(productOptionPostDto.getStock());

                    product.addProductOption(productOption);
                });

        return product;
    }

    List<ProductSimpleResponseDto> productsToProductSimpleResponseDtos(List<Product> products);

}
