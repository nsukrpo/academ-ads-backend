package nsukrpo.backend.services.impls;

import nsukrpo.backend.config.BlockStatus;
import nsukrpo.backend.config.StrikeReason;
import nsukrpo.backend.model.dtos.IdDto;
import nsukrpo.backend.model.dtos.UserDto;
import nsukrpo.backend.model.dtos.UserPostDto;
import nsukrpo.backend.model.dtos.UserPutDto;
import nsukrpo.backend.model.entities.user.User;
import nsukrpo.backend.model.entities.user.UserAvatar;
import nsukrpo.backend.model.entities.user.UserType;
import nsukrpo.backend.model.exceptions.NotFoundException;
import nsukrpo.backend.repository.user.UserAvatarRep;
import nsukrpo.backend.repository.user.UserRep;
import nsukrpo.backend.repository.user.UserTypeRep;
import nsukrpo.backend.services.UserService;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    private final UserRep userRep;
    private final UserTypeRep typeRep;
    private final UserAvatarRep avatarRep;
    private final EnumMap<nsukrpo.backend.config.UserType,UserType> types = new EnumMap<>(nsukrpo.backend.config.UserType.class);

    @Autowired
    public UserServiceImpl(UserRep userRep1, UserTypeRep typeRep1, UserAvatarRep avatarRep1)
    {
        typeRep = typeRep1;
        userRep = userRep1;
        avatarRep = avatarRep1;
    }
    public List<UserDto> getUserFiltered(
            Long rejectedAds,
            StrikeReason rejectReason,
            Long publishedAds,
            Integer blockings,
            BlockStatus blockingStatus
    ){
        throw new NotImplementedException();
    }
    public UserDto userIdGet(Long id){
        return new UserDto(getUserOrThrow(id));
    }

    public IdDto userIdPut(Long id, UserPutDto body){
        var user = getUserOrThrow(id);
        Optional.ofNullable(body.getName()).ifPresent(user::setName);
        Optional.ofNullable(body.getAvatar()).map(this::getAvatarOrThrow).ifPresent(user::setAvatar);
        return new IdDto(user.getId());
    }

    public IdDto userPost(UserPostDto body){
        var user = User.builder()
                .name(body.getName())
                .regDate(Date.valueOf(LocalDate.now()))
                .type(getUserTypeOrThrow(nsukrpo.backend.config.UserType.REGULAR)).build();
        user = userRep.save(user);
        return new IdDto(user.getId());
    }

    private UserAvatar getAvatarOrThrow(Long id){
        return avatarRep.findById(id).orElseThrow(() -> new NotFoundException("Couldn't find user avatar: " + id));
    }
    private User getUserOrThrow(Long id){
        return userRep.findById(id).orElseThrow(() -> new NotFoundException("Couldn't find user: " + id));
    }

    private UserType getUserTypeOrThrow(nsukrpo.backend.config.UserType type){
        return types.computeIfAbsent(type, t -> {
            synchronized (types){
                return types.computeIfAbsent(t, t2 -> {
                    UserType userType = typeRep.findByType(t2.name()).orElseThrow(() -> new NotFoundException("Couldn't find user type: " + t2.name()));
                    types.put(t2,userType);
                    return userType;
                });
            }
        });
    }



}
