package nsukrpo.backend.services;

import nsukrpo.backend.model.dtos.BlockingDto;
import nsukrpo.backend.model.dtos.BlockingPostDto;
import nsukrpo.backend.model.dtos.BlockingPutDto;
import nsukrpo.backend.model.dtos.IdDto;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface BlockingService {

    BlockingDto getBlocking(Long id);
    IdDto putBlocking(Long id, BlockingPutDto body);
    HttpStatus deleteBlocking(Long id);
    List<BlockingDto> getUserBlocking(Long user_id);
    IdDto postBlocking(BlockingPostDto body);
}
