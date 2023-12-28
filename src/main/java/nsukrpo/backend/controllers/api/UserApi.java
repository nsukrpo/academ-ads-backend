package nsukrpo.backend.controllers.api;

import jakarta.validation.Valid;
import nsukrpo.backend.config.BlockStatus;
import nsukrpo.backend.config.StrikeReason;
import nsukrpo.backend.model.dtos.IdDto;
import nsukrpo.backend.model.dtos.UserDto;
import nsukrpo.backend.model.dtos.UserPostDto;
import nsukrpo.backend.model.dtos.UserPutDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Valid
@RequestMapping("/user")
public interface UserApi {
    @GetMapping(produces = { "application/json" })
    ResponseEntity<List<UserDto>> getUserFiltered(
            @RequestParam(value = "rejected_ads", required = false) Long rejectedAds,
            @RequestParam(value = "reject_reason", required = false) StrikeReason rejectReason,
            @RequestParam(value = "published_ads", required = false) Long publishedAds,
            @RequestParam(value = "blockings", required = false) Integer blockings,
            @RequestParam(value = "blocking_status", required = false) BlockStatus blockingStatus,
            @RequestParam(value = "page", required = false) Integer page
    );

    @GetMapping(value = "/{id}", produces = { "application/json" })
    ResponseEntity<UserDto> userIdGet(@PathVariable("id") Long id);

    @PutMapping(value = "/{id}",
            produces = { "application/json", "application/json" },
            consumes = { "application/json" })
    ResponseEntity<IdDto> userIdPut(@PathVariable("id") Long id, @RequestBody UserPutDto body);

    @PostMapping(produces = { "application/json"},
            consumes = { "application/json" })
    ResponseEntity<IdDto> userPost(@RequestBody UserPostDto body);


}
