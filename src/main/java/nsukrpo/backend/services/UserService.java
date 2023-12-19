package nsukrpo.backend.services;

import nsukrpo.backend.config.BlockStatus;
import nsukrpo.backend.config.StrikeReason;
import nsukrpo.backend.model.dtos.IdDto;
import nsukrpo.backend.model.dtos.UserDto;
import nsukrpo.backend.model.dtos.UserPostDto;
import nsukrpo.backend.model.dtos.UserPutDto;

import java.util.List;

public interface UserService {
    List<UserDto> getUserFiltered(
            Long rejectedAds,
            StrikeReason rejectReason,
            Long publishedAds,
            Integer blockings,
            BlockStatus blockingStatus
    );

    UserDto userIdGet(Long id);

    IdDto userIdPut(Long id, UserPutDto body);

    IdDto userPost(UserPostDto body);
}
