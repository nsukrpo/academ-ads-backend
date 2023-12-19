package nsukrpo.backend.services.impls;

import nsukrpo.backend.config.BlockStatus;
import nsukrpo.backend.config.StrikeReason;
import nsukrpo.backend.model.dtos.IdDto;
import nsukrpo.backend.model.dtos.UserDto;
import nsukrpo.backend.model.dtos.UserPostDto;
import nsukrpo.backend.model.dtos.UserPutDto;
import nsukrpo.backend.model.entities.user.User;
import nsukrpo.backend.repository.user.UserAvatarRep;
import nsukrpo.backend.repository.user.UserRep;
import nsukrpo.backend.repository.user.UserTypeRep;
import nsukrpo.backend.services.UserService;
import nsukrpo.backend.services.impls.utils.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    private final UserRep userRep;
    private final UserManager userManager;

    @Autowired
    public UserServiceImpl(UserRep userRep1, UserTypeRep typeRep1, UserAvatarRep avatarRep1, UserManager userManager1)
    {
        userRep = userRep1;
        userManager = userManager1;
    }

    @Override
    public List<UserDto> getUserFiltered(
            Long rejectedAds,
            StrikeReason rejectReason,
            Long publishedAds,
            Integer blockings,
            BlockStatus blockingStatus
    ){
        ArrayList<UserDto> dtos = new ArrayList<>();
        for (var u : userRep.findAll()){
            dtos.add(new UserDto(u));
        }
        return dtos;
    }

    @Override
    public UserDto userIdGet(Long id){
        return new UserDto(userManager.getUserOrThrow(id));
    }

    @Override
    public IdDto userIdPut(Long id, UserPutDto body){
        var user = userManager.getUserOrThrow(id);
        Optional.ofNullable(body.getName()).ifPresent(user::setName);
        Optional.ofNullable(body.getAvatar()).map(userManager::getAvatarOrThrow).ifPresent(user::setAvatar);
        userRep.save(user);
        return new IdDto(user.getId());
    }

    private final Random random = new Random(System.nanoTime());
    @Override
    public IdDto userPost(UserPostDto body){
        var user = User.builder()
                .name(body.getName())
                .regDate(Date.valueOf(LocalDate.now()))
                .type(userManager.getUserTypeOrThrow(nsukrpo.backend.config.UserType.REGULAR))
                .login("name" + random.nextInt())
                .passwordHash(random.nextInt()).build();
        user = userRep.save(user);
        return new IdDto(user.getId());
    }

}
