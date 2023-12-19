package nsukrpo.backend.services.impls;

import nsukrpo.backend.model.dtos.*;
import nsukrpo.backend.repository.advertsimenent.CategoryRep;
import nsukrpo.backend.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRep categoryRep;
    private final ModelMapper modelMapper;

    @Autowired
    public CategoryServiceImpl(CategoryRep rep, ModelMapper mapper)
    {
        categoryRep = rep;
        modelMapper = mapper;
    }


    @Override
    public List<CategoryDto> categoryGet() {
        return modelMapper.map(categoryRep.findAll(),new TypeToken<List<CategoryDto>>() {}.getType());
    }
}
