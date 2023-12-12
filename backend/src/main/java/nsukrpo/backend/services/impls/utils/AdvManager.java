package nsukrpo.backend.services.impls.utils;

import nsukrpo.backend.config.AdvStatus;
import nsukrpo.backend.model.entities.advertisement.Advertisement;
import nsukrpo.backend.model.entities.advertisement.Category;
import nsukrpo.backend.model.entities.advertisement.StatusAd;
import nsukrpo.backend.model.entities.user.User;
import nsukrpo.backend.model.entities.user.UserAvatar;
import nsukrpo.backend.model.entities.user.UserType;
import nsukrpo.backend.model.exceptions.NotFoundException;

public interface AdvManager {
    Advertisement getAdvOrThrow(Long id);

    Category getAdvCategoryOrThrow(nsukrpo.backend.config.AdvCategory category);
    Category getAdvCategoryOrThrow(Long id);

    StatusAd getAdvStatusOrThrow(AdvStatus status);
}
