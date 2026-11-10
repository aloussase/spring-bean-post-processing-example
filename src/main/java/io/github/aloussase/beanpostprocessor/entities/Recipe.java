package io.github.aloussase.beanpostprocessor.entities;

import java.util.List;

public record Recipe(
        String name,
        List<String> ingredients
) {
}
