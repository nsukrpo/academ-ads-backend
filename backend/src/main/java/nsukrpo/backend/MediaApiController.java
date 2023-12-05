package nsukrpo.backend;

import nsukrpo.backend.model.entities.advertisement.StatusAd;
import nsukrpo.backend.repository.StatusAdRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(maxAge = 1440)
public class MediaApiController{

    @Autowired
    private StatusAdRep rep;
    @GetMapping(value = "/add")
    public ResponseEntity<String> add(){
        StatusAd ad = new StatusAd();
        ad.setName("momo");
        rep.save(ad);
        return new ResponseEntity<>("OK",HttpStatus.OK);
    }

    @GetMapping(value = "/get")
    public ResponseEntity<String> get(){
        var res = rep.findAll();
        StringBuilder builder = new StringBuilder();
        for (var t : res)
        {
            builder.append(t.getName());
            builder.append('\n');
        }
        return new ResponseEntity<>(builder.toString(),HttpStatus.OK);
    }


}