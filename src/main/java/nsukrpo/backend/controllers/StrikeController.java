package nsukrpo.backend.controllers;

import nsukrpo.backend.controllers.api.StrikeApi;
import nsukrpo.backend.model.dtos.IdDto;
import nsukrpo.backend.model.dtos.StrikeDto;
import nsukrpo.backend.model.dtos.StrikePostDto;
import nsukrpo.backend.services.StrikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StrikeController implements StrikeApi {
    private final StrikeService service;

    @Autowired
    public StrikeController(StrikeService strikeService){
        service = strikeService;
    }
    @Override
    public ResponseEntity<StrikeDto> getStrike(Long id) {
        var res = service.getStrike(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<IdDto> putStrike(Long id, StrikeDto body) {
        var res = service.putStrike(id, body);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<StrikeDto>> getUserStrikes(Long user_id) {
        var res = service.getUserStrikes(user_id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<IdDto> postStrike(StrikePostDto body) {
        var res = service.postStrike(body);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
