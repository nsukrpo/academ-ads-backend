package nsukrpo.backend.controllers.api;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import nsukrpo.backend.model.dtos.IdDto;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
public interface MediaApi {

        
        
    @GetMapping(value = "/media/avatar/{id}", produces = { "application/json", "image/*" })
    ResponseEntity<byte[]> mediaAvatarIdGet(@PathVariable(value = "id", required = true) Long id);


        
        
    @PostMapping(value = "/media/avatar",
        produces = { "application/json" }, 
        consumes = { "image/*" })
    ResponseEntity<IdDto> mediaAvatarPost(@NotNull @Valid @RequestParam(value = "user_id") Long userId, @Valid @RequestBody byte[] body);


        
        
    @GetMapping(value = "/media/photos/{id}",
        produces = { "image/*", "application/json" })
    ResponseEntity<byte[]> mediaPhotosIdGet(@PathVariable("id") Long id);


        
        
    @PostMapping(value = "/media/photos",
        produces = { "application/json" }, 
        consumes = { "image/*" })
    ResponseEntity<IdDto> mediaPhotosPost(
            @NotNull @Valid @RequestParam(value = "ads_id", required = true) Long adsId,
            @Valid @RequestBody byte[] body);
}

