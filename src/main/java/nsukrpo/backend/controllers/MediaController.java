//package nsukrpo.backend.controllers;
//
//import nsukrpo.backend.controllers.api.MediaApi;
//import nsukrpo.backend.model.dtos.IdDto;
//import nsukrpo.backend.services.MediaService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.Resource;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@CrossOrigin(maxAge = 3000)
//public class MediaController implements MediaApi {
//
//    private final MediaService service;
//
//    @Autowired
//    public MediaController(MediaService mediaService){
//        service = mediaService;
//    }
//
//
//    @Override
//    public ResponseEntity<Resource> mediaAvatarIdGet(Long id) {
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//    @Override
//    public ResponseEntity<IdDto> mediaAvatarPost(Long userId, byte[] body) {
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//    @Override
//    public ResponseEntity<Resource> mediaPhotosIdGet(Long id) {
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//    @Override
//    public ResponseEntity<IdDto> mediaPhotosPost(Long adsId, byte[] body) {
//        return null;
//    }
//}
