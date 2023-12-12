package nsukrpo.backend.services.impls;

import nsukrpo.backend.config.AdvStatus;
import nsukrpo.backend.config.BlockStatus;
import nsukrpo.backend.config.StrikeReason;
import nsukrpo.backend.model.dtos.*;
import nsukrpo.backend.model.entities.user.User;
import nsukrpo.backend.repository.advertsimenent.CategoryRep;
import nsukrpo.backend.repository.user.UserAvatarRep;
import nsukrpo.backend.repository.user.UserRep;
import nsukrpo.backend.repository.user.UserTypeRep;
import nsukrpo.backend.services.CategoryService;
import nsukrpo.backend.services.UserService;
import nsukrpo.backend.services.impls.utils.UserManager;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

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
