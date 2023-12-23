package nsukrpo.backend.controllers.api;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import nsukrpo.backend.model.dtos.BookingPostBody;
import nsukrpo.backend.model.dtos.BookingDto;
import nsukrpo.backend.model.dtos.IdDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RequestMapping("/booking")
public interface BookingApi {

        
        
    @DeleteMapping(produces = { "application/json" })
    ResponseEntity<Void> bookingDelete(@NotNull @Valid @RequestParam(value = "booking_id", required = true) Long bookingId);


        
        
    @GetMapping(produces = { "application/json" })
    ResponseEntity<List<BookingDto>> bookingGet(@NotNull @Valid @RequestParam(value = "user_id", required = true) Long userId);


        
        
    @PostMapping(produces = { "application/json" },
        consumes = { "application/json" })
    ResponseEntity<IdDto> bookingPost(@Valid @RequestBody BookingPostBody body);

}

