package nsukrpo.backend;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(maxAge = 1440)
public class MediaApiController{

    @GetMapping(value = "/media")
    public ResponseEntity<String> mediaPost(String contentTypeHeader, byte[] data){
        return new ResponseEntity<>("Hello there!",HttpStatus.OK);
    }


}