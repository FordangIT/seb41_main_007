package com.bzzzzz.farm.repository.querydsl;

import com.bzzzzz.farm.model.entity.Product;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.support.PageableExecutionUtils;

import java.util.List;
import java.util.stream.Collectors;

import static com.bzzzzz.farm.model.entity.QProduct.product;

@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    @Override
    public Page<Product> searchAll(Long categoryId, String keyword, Pageable pageable) {
        JPAQuery<Product> query = queryFactory
                .selectFrom(product)
                .where(
                        eqCategory(categoryId),
                        eqKeyword(keyword)
                );

        List<Product> result = query
                .orderBy(getOrderSpecifier(pageable))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        return PageableExecutionUtils.getPage(result, pageable, query::fetchCount);
    }

    private BooleanExpression eqCategory(Long categoryId) {
        return categoryId == null
                ? null
                : product.productCategories.any().category.categoryId.eq(categoryId);
    }

    private BooleanExpression eqKeyword(String keyword) {
        return keyword == null
                ? null
                : product.name.contains(keyword)
                .or(product.description.contains(keyword))
                .or(product.brand.contains(keyword));
    }

    private OrderSpecifier getOrderSpecifier(Pageable pageable) {
        Sort.Order direction = pageable.getSort().get().collect(Collectors.toList()).get(0);

        Order order = direction.getDirection().isAscending()
                ? Order.ASC
                : Order.DESC;

        switch (direction.getProperty()) {
            case "name":
                return new OrderSpecifier(order, product.name);
            case "price":
                return new OrderSpecifier(order, product.price);
            case "brand":
                return new OrderSpecifier(order, product.brand);
            case "likeCount":
                return new OrderSpecifier(order, product.likeCount);
            case "soldCount":
                return new OrderSpecifier(order, product.soldCount);
            default:
                return new OrderSpecifier(order, product.productId);
        }
    }
}
