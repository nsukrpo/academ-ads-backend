package nsukrpo.backend.services;

import jakarta.validation.constraints.NotNull;
import nsukrpo.backend.model.dtos.IdDto;

public interface MediaService {


    @NotNull byte[] mediaAvatarIdGet(Long id);

    IdDto mediaAvatarPost(Long userId, byte[] body);

    @NotNull byte[] mediaPhotosIdGet(Long id);

    IdDto mediaPhotosPost(
            Long adsId, byte[] body);
}

