package nsukrpo.backend.controllers;

import nsukrpo.backend.controllers.api.MediaApi;
import nsukrpo.backend.model.dtos.IdDto;
import nsukrpo.backend.services.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(maxAge = 3000)
public class MediaController implements MediaApi {

    private final MediaService service;

    @Autowired
    public MediaController(MediaService mediaService){
        service = mediaService;
    }


    @Override
    public ResponseEntity<byte[]> mediaAvatarIdGet(Long id) {
        return new ResponseEntity<>(service.mediaAvatarIdGet(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<IdDto> mediaAvatarPost(Long userId, byte[] body) {
        return new ResponseEntity<>(service.mediaAvatarPost(userId, body),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<byte[]> mediaPhotosIdGet(Long id) {
        return new ResponseEntity<>(service.mediaPhotosIdGet(id),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<IdDto> mediaPhotosPost(Long adsId, byte[] body) {
        return new ResponseEntity<>(service.mediaPhotosPost(adsId, body), HttpStatus.OK);
    }
}
