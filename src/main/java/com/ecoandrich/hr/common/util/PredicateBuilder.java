package com.ecoandrich.hr.common.util;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PredicateBuilder {

    private final List<Predicate> predicateBuilders = new ArrayList<>();

    public static PredicateBuilder builder() {
        return new PredicateBuilder();
    }

    public Predicate build() {
        return ExpressionUtils.allOf(predicateBuilders);
    }

    public PredicateBuilder eqString(StringPath column, String value) {

        if (StringUtils.hasText(value)) {
            predicateBuilders.add(column.eq(value));
        }

        return this;
    }

    public PredicateBuilder containsString(StringPath column, String value) {

        if (StringUtils.hasText(value)) {
            predicateBuilders.add(column.contains(value));
        }

        return this;
    }

    public PredicateBuilder containsStringDesc(String value, StringPath... columns) {

        if (StringUtils.hasText(value)) {
            BooleanExpression[] booleanExpressions = Arrays.stream(columns)
                    .map(c -> c.contains(value))
                    .toArray(BooleanExpression[]::new);
            predicateBuilders.add(new BooleanBuilder().andAnyOf(booleanExpressions));
        }

        return this;
    }

    public <N extends Number & Comparable<?>> PredicateBuilder eqNumber(NumberPath<N> column, N value) {
        if (value != null) {
            predicateBuilders.add(column.eq(value));
        }

        return this;
    }

}
