package nsukrpo.backend.controllers;

import nsukrpo.backend.controllers.api.BlockingApi;
import nsukrpo.backend.model.dtos.BlockingDto;
import nsukrpo.backend.model.dtos.BlockingPostDto;
import nsukrpo.backend.model.dtos.BlockingPutDto;
import nsukrpo.backend.model.dtos.IdDto;
import nsukrpo.backend.services.BlockingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BlockingController implements BlockingApi {

    private final BlockingService service;

    @Autowired
    public BlockingController(BlockingService service){
        this.service = service;
    }
    @Override
    public ResponseEntity<BlockingDto> getBlocking(Long id) {
        var res = service.getBlocking(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<IdDto> putBlocking(Long id, BlockingPutDto body) {
        var res = service.putBlocking(id, body);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteBlocking(Long id) {
        return new ResponseEntity<>(service.deleteBlocking(id));
    }

    @Override
    public ResponseEntity<List<BlockingDto>> getUserBlocking(Long user_id) {
        var res = service.getUserBlocking(user_id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<IdDto> postBlocking(BlockingPostDto body) {
        var res = service.postBlocking(body);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
