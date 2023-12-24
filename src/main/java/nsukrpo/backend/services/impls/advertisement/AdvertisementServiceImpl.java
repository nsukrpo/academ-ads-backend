package nsukrpo.backend.services.impls.advertisement;

import jakarta.validation.ValidationException;
import nsukrpo.backend.config.AdvCategory;
import nsukrpo.backend.config.AdvStatus;
import nsukrpo.backend.model.dtos.AdvertisementDto;
import nsukrpo.backend.model.dtos.AdvertisementPostBody;
import nsukrpo.backend.model.dtos.AdvertisementPutBody;
import nsukrpo.backend.model.dtos.IdDto;
import nsukrpo.backend.model.entities.advertisement.Advertisement;
import nsukrpo.backend.model.entities.advertisement.Category;
import nsukrpo.backend.model.entities.user.User;
import nsukrpo.backend.repository.advertsimenent.AdvRep;
import nsukrpo.backend.services.AdvertisementService;
import nsukrpo.backend.services.impls.utils.AdvManager;
import nsukrpo.backend.services.impls.utils.UserManager;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class AdvertisementServiceImpl implements AdvertisementService {

    private final ModelMapper modelMapper;
    private final AdvRep advRep;
    private final AdvManager advManager;
    private final UserManager userManager;

    @Autowired
    public AdvertisementServiceImpl(
            AdvRep advRep1,
            ModelMapper modelMapper1,
            AdvManager advManager1,
            UserManager userManager1)
    {
        advRep = advRep1;
        modelMapper = modelMapper1;
        advManager = advManager1;
        userManager = userManager1;
    }


    @Override
    public List<AdvertisementDto> advertisementGet(Long category, Date date, Long countWatch) {
        return modelMapper.
                map(
                        Optional.ofNullable(category)
                                .map(this::findByCategoryUseCase)
                                .orElseGet(advRep::findAll),
                        new TypeToken<List<AdvertisementDto>>() {}.getType()
                );

    }

    private Iterable<Advertisement> findByCategoryUseCase(Long category){
        Category cat = throw400IfThrow(advManager::getAdvCategoryOrThrow, category);
        return advRep.findByCategoryIdAndStatusId(cat.getId(), advManager.getAdvStatusOrThrow(AdvStatus.SENT_MODERATION).getId());
    }

    @Override
    public HttpStatus advertisementIdDelete(Long id) {
        advRep.delete(advManager.getAdvOrThrow(id));
        return HttpStatus.OK;
    }

    @Override
    public AdvertisementDto advertisementIdGet(Long id) {
        var adv = advManager.getAdvOrThrow(id);
        adv.setCountWatch(adv.getCountWatch() + 1);
        advRep.save(adv);
        return modelMapper.map(adv, AdvertisementDto.class);
    }

    @Override
    public IdDto advertisementIdPut(Long id, AdvertisementPutBody body) {

        var adv = advManager.getAdvOrThrow(id);

        throw400IfBooked(adv);

        /*
//        Optional.ofNullable(body.getStatus()).map(AdvStatus::valueOf).map(advManager::getAdvStatusOrThrow).ifPresent(HANDLE);
        TODO когда появятся авторизация
        https://ai.nsu.ru/projects/forstudents/wiki/Data_Base
        событие1:
        UPDATE ON Advertisement SET status = "Снято с продажи"
        событие2:


         */

        adv.setEditDate(new Timestamp(System.currentTimeMillis()));
        Optional.ofNullable(body.getCategory()).map(advManager::getAdvCategoryOrThrow).ifPresent(adv::setCategory);
        Optional.ofNullable(body.getDescription()).ifPresent(adv::setDescription);
        Optional.ofNullable(body.getHeader()).ifPresent(adv::setHeader);
        Optional.ofNullable(body.getStatus()).map(AdvStatus::valueOf).map(advManager::getAdvStatusOrThrow).ifPresent(adv::setStatus);
        Optional.ofNullable(body.getPrice()).ifPresent(adv::setPrice);
        advRep.save(adv);

        return new IdDto(adv.getId());

    }

    private void handleStatusChange(AdvertisementPutBody body, AdvStatus status){

    }

    @Override
    public IdDto advertisementPost(AdvertisementPostBody body) {
        var author = userManager.getUserOrThrow(body.getAuthor());

        throw400IfBlocked(author);

        var adv = modelMapper.map(body, Advertisement.class);
        adv.setCategory(advManager.getAdvCategoryOrThrow(AdvCategory.valueOf(body.getCategory())));
        adv.setStatus(advManager.getAdvStatusOrThrow(AdvStatus.SENT_MODERATION));
        adv.setAuthor(author);
        adv.setCountWatch(0);
        adv.setEditDate(new Timestamp(System.currentTimeMillis()));
        adv.setPublicationDate(new Timestamp(System.currentTimeMillis()));
        adv = advRep.save(adv);
        return new IdDto(adv.getId());
    }

    private void throw400IfBlocked(User user){
        if (user.isBlocked()){
            throw new ValidationException("Validation Failed");
        }
    }

    private void throw400IfBooked(Advertisement adv){
        if (adv.isBooked()){
            throw new ValidationException("Validation Failed");
        }
    }

    private <T,R> R throw400IfThrow(Function<T,R> f, T obj){
        try {
            return f.apply(obj);
        } catch (Exception e){
            throw new ValidationException("Validation Failed");
        }
    }




}
