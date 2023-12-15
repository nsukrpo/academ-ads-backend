package nsukrpo.backend.services;

import nsukrpo.backend.model.dtos.IdDto;
import nsukrpo.backend.model.dtos.StrikeDto;
import nsukrpo.backend.model.dtos.StrikePostDto;

import java.util.List;

public interface StrikeService {
    StrikeDto getStrike(Long id);

    IdDto putStrike(Long id, StrikeDto body);

    List<StrikeDto> getUserStrikes(Long user_id);

    IdDto postStrike(StrikePostDto body);
}
