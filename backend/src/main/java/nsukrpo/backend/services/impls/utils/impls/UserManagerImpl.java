package nsukrpo.backend.services.impls.utils.impls;

import nsukrpo.backend.model.entities.user.User;
import nsukrpo.backend.model.entities.user.UserAvatar;
import nsukrpo.backend.model.entities.user.UserType;
import nsukrpo.backend.model.exceptions.NotFoundException;
import nsukrpo.backend.repository.user.UserAvatarRep;
import nsukrpo.backend.repository.user.UserRep;
import nsukrpo.backend.repository.user.UserTypeRep;
import nsukrpo.backend.services.impls.utils.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.EnumMap;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class UserManagerImpl implements UserManager {
    private final EnumMap<nsukrpo.backend.config.UserType,UserType> types = new EnumMap<>(nsukrpo.backend.config.UserType.class);
    private final UserRep userRep;
    private final UserTypeRep typeRep;
    private final UserAvatarRep avatarRep;

    @Autowired
    public UserManagerImpl(UserRep userRep1, UserTypeRep typeRep1, UserAvatarRep avatarRep1){
        typeRep = typeRep1;
        userRep = userRep1;
        avatarRep = avatarRep1;
    }

    @Override
    public UserAvatar getAvatarOrThrow(Long id){
        return avatarRep.findById(id).orElseThrow(() -> new NotFoundException("Couldn't find user avatar: " + id));
    }
    @Override
    public User getUserOrThrow(Long id){
        return userRep.findById(id).orElseThrow(() -> new NotFoundException("Couldn't find user: " + id));
    }

    @Override
    public UserType getUserTypeOrThrow(nsukrpo.backend.config.UserType type){
        return types.computeIfAbsent(type, t -> {
            synchronized (types){
                return types.containsKey(t) ?
                       types.get(t) :
                       typeRep.findByType(t.name()).orElseThrow(() -> new NotFoundException("Couldn't find user type: " + t.name()));
            }
        });
    }
}
