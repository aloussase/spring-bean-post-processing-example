package io.github.aloussase.beanpostprocessor.controller;

import io.github.aloussase.beanpostprocessor.entities.Recipe;
import io.github.aloussase.beanpostprocessor.services.RecipesServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/recipes")
public class RecipesController {

    private final RecipesServiceImpl recipesService;

    public RecipesController(RecipesServiceImpl recipesService) {
        this.recipesService = recipesService;
    }

    @PostMapping
    public ResponseEntity<?> createRecipe(
            @RequestParam("sendNull") boolean sendNull
    ) {
        final var recipe = sendNull ? null : new Recipe("", List.of());
        recipesService.newRecipe(recipe);
        return ResponseEntity.ok().build();
    }

}
