package nsukrpo.backend.controllers;

import nsukrpo.backend.config.BlockStatus;
import nsukrpo.backend.config.StrikeReason;
import nsukrpo.backend.controllers.api.UserApi;
import nsukrpo.backend.model.dtos.IdDto;
import nsukrpo.backend.model.dtos.UserDto;
import nsukrpo.backend.model.dtos.UserPostDto;
import nsukrpo.backend.model.dtos.UserPutDto;
import nsukrpo.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController implements UserApi {

    private final UserService userService;

    @Autowired
    public UserController(UserService service){
        userService = service;
    }

    @Override
    public ResponseEntity<List<UserDto>> getUserFiltered(Long rejectedAds, StrikeReason rejectReason, Long publishedAds, Integer blockings, BlockStatus blockingStatus) {
        var res = userService.getUserFiltered(rejectedAds,rejectReason,publishedAds,blockings, blockingStatus);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserDto> userIdGet(Long id) {
        var res = userService.userIdGet(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<IdDto> userIdPut(Long id, UserPutDto body) {
        var res = userService.userIdPut(id,body);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<IdDto> userPost(UserPostDto body) {
        var res = userService.userPost(body);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
