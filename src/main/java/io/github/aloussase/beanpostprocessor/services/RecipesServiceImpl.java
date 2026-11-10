package io.github.aloussase.beanpostprocessor.services;

import io.github.aloussase.beanpostprocessor.entities.Recipe;
import org.springframework.stereotype.Service;

@Service
public class RecipesServiceImpl implements RecipesService {

    @Override
    public void newRecipe(Recipe recipe) {
        System.out.println("Saving new recipe...");
    }

}
