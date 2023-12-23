package nsukrpo.backend.controllers;

import nsukrpo.backend.controllers.api.BookingApi;
import nsukrpo.backend.model.dtos.BookingDto;
import nsukrpo.backend.model.dtos.BookingPostBody;
import nsukrpo.backend.model.dtos.IdDto;
import nsukrpo.backend.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookingController implements BookingApi {

    private BookingService service;

    @Autowired
    public BookingController(BookingService s){
        service = s;
    }

    @Override
    public ResponseEntity<Void> bookingDelete(Long bookingId) {
        service.bookingDelete(bookingId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<BookingDto>> bookingGet(Long userId) {
        return new ResponseEntity<>(service.bookingGet(userId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<IdDto> bookingPost(BookingPostBody body) {
        return new ResponseEntity<>(service.bookingPost(body), HttpStatus.OK);
    }
}
