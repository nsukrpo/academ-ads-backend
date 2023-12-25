package nsukrpo.backend.services.impls;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import nsukrpo.backend.model.dtos.IdDto;
import nsukrpo.backend.model.entities.advertisement.AdPhoto;
import nsukrpo.backend.model.entities.user.UserAvatar;
import nsukrpo.backend.repository.advertsimenent.PhotoRep;
import nsukrpo.backend.repository.user.AvatarRep;
import nsukrpo.backend.repository.user.UserRep;
import nsukrpo.backend.services.MediaService;
import nsukrpo.backend.services.impls.utils.AdvManager;
import nsukrpo.backend.services.impls.utils.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class MediaServiceImpl implements MediaService {

    private final UserManager userManager;
    private final AdvManager advManager;
    private final AvatarRep avatarRep;
    private final UserRep userRep;
    private final PhotoRep photoRep;


    @Autowired
    public MediaServiceImpl(UserManager userManager1,
                            AvatarRep avatarRep1,
                            UserRep userRep1,
                            AdvManager advManager1,
                            PhotoRep photoRep){
        userManager = userManager1;
        avatarRep = avatarRep1;
        userRep = userRep1;
        advManager = advManager1;
        this.photoRep = photoRep;
    }
    @Override
    public @NotNull byte[] mediaAvatarIdGet(Long id) {
        return userManager.getAvatarOrThrow(id).getPhoto();
    }

    @Override
    public IdDto mediaAvatarPost(Long userId, byte[] body) {
        var user = userManager.getUserOrThrow(userId);
        var avatar = avatarRep.save(UserAvatar.builder().photo(body).build());

        user.setAvatar(avatar);
        userRep.save(user);

        return new IdDto(avatar.getId());
    }

    @Override
    public byte[] mediaPhotosIdGet(Long id) {
        return advManager.getPhotoOrThrow(id).getPhoto();
    }

    @Override
    public IdDto mediaPhotosPost(Long adsId, byte[] body) {
        var test1 = AdPhoto.builder().photo(body).advertisement(advManager.getAdvOrThrow(adsId)).build();
        photoRep.save(test1);

        return new IdDto(adsId);
    }
}

