package alkemy.challenge.Challenge.Alkemy.controller;

import alkemy.challenge.Challenge.Alkemy.model.Category;
import alkemy.challenge.Challenge.Alkemy.repository.CategoryRepository;
import alkemy.challenge.Challenge.Alkemy.service.CategoryService;
import alkemy.challenge.Challenge.Alkemy.util.Message;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping()
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryService categoryService;


	@PostMapping
	//error de logica: tiene que devolver la clase con parametro object y no con "?"
    public ResponseEntity<Object> addCategories(@RequestBody @Valid Category category) {
    	
        if (StringUtils.isBlank(category.getName())) {
            return new ResponseEntity<Object>(new Message("campo nombre no puede estar vacio."),
                    HttpStatus.BAD_REQUEST);
        }
        if (!StringUtils.isAlpha(category.getName())) {
            return new ResponseEntity<Object>(new Message("Debe contener solo letras."),
                    HttpStatus.BAD_REQUEST);
        } else {
            categoryService.createCategory(category);
            return new ResponseEntity<Object>(new Message("categoria creada."),
                    HttpStatus.OK);
        }
    }

    @GetMapping
    public ResponseEntity<Object> getCategories(){
        List<Category> listCategories = categoryRepository.findAll();
        List<String> listCategoriesByname = new ArrayList<>();
        for (Category c : listCategories) {
            listCategoriesByname.add(c.getName());
        }
        return new ResponseEntity<Object>(listCategoriesByname, HttpStatus.OK);
    }
}
