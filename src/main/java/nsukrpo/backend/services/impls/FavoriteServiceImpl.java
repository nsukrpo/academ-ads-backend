package nsukrpo.backend.services.impls;

import nsukrpo.backend.model.dtos.AdvertisementDto;
import nsukrpo.backend.model.dtos.FavoriteAdvertisementDto;
import nsukrpo.backend.model.dtos.IdDto;
import nsukrpo.backend.model.entities.user.Favourite;
import nsukrpo.backend.model.exceptions.NotFoundException;
import nsukrpo.backend.repository.user.FavoriteRep;
import nsukrpo.backend.services.FavoriteService;
import nsukrpo.backend.services.impls.utils.AdvManager;
import nsukrpo.backend.services.impls.utils.UserManager;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class FavoriteServiceImpl implements FavoriteService {
    private final FavoriteRep favoriteRep;
    private final AdvManager advManager;
    private final UserManager userManager;
    private final ModelMapper modelMapper;

    @Autowired
    public FavoriteServiceImpl(FavoriteRep favoriteRep, AdvManager advManager, UserManager userManager, ModelMapper modelMapper) {
        this.favoriteRep = favoriteRep;
        this.advManager = advManager;
        this.userManager = userManager;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<AdvertisementDto> getFavoriteAds(Long user_id) {
        List<Favourite> favoriteRecords = favoriteRep.findByUserId(user_id);
        List<AdvertisementDto> res = new ArrayList<>();
        for (var record: favoriteRecords)
            res.add(modelMapper.map(record.getAds(), AdvertisementDto.class));
        return res;
    }

    @Override
    public IdDto postFavoriteAds(FavoriteAdvertisementDto body) {
        Favourite favourite = Favourite.builder()
                .ads(advManager.getAdvOrThrow(body.getAdsId()))
                .user(userManager.getUserOrThrow(body.getUserId()))
                .dateAdd(new Timestamp(System.currentTimeMillis()))
                .build();
        favourite = favoriteRep.save(favourite);
        return new IdDto(favourite.getId());
    }

    @Override
    public HttpStatus deleteFavoriteAds(Long user_id, Long ads_id) {
        Favourite favourite = favoriteRep.findByUserIdAndAdsId(user_id, ads_id).orElseThrow(() -> new NotFoundException("Couldn't find favorite"));
        favoriteRep.delete(favourite);
        return HttpStatus.OK;
    }
}
