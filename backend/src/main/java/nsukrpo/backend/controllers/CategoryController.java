package nsukrpo.backend.controllers;

import nsukrpo.backend.controllers.api.AdvertisementApi;
import nsukrpo.backend.controllers.api.CategoryApi;
import nsukrpo.backend.model.dtos.*;
import nsukrpo.backend.services.AdvertisementService;
import nsukrpo.backend.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

@RestController
public class CategoryController implements CategoryApi {

    private final CategoryService service;

    @Autowired
    public CategoryController(CategoryService categoryService){
        service = categoryService;
    }


    @Override
    public ResponseEntity<List<CategoryDto>> categoryGet() {
        return new ResponseEntity<>(service.categoryGet(), HttpStatus.OK);
    }
}
