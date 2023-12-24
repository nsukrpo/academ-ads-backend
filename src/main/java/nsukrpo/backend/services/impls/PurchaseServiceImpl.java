package nsukrpo.backend.services.impls;

import nsukrpo.backend.config.AdvStatus;
import nsukrpo.backend.model.dtos.BookingDto;
import nsukrpo.backend.model.dtos.IdDto;
import nsukrpo.backend.model.dtos.PurchaseDto;
import nsukrpo.backend.model.dtos.PurchasePostBody;
import nsukrpo.backend.model.entities.user.Purchase;
import nsukrpo.backend.repository.advertsimenent.AdvRep;
import nsukrpo.backend.repository.advertsimenent.BookingRep;
import nsukrpo.backend.repository.advertsimenent.PurchaseRep;
import nsukrpo.backend.services.PurchaseService;
import nsukrpo.backend.services.impls.utils.AdvManager;
import nsukrpo.backend.services.impls.utils.BookingManager;
import nsukrpo.backend.services.impls.utils.UserManager;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    private final ModelMapper modelMapper;
    private final PurchaseRep purchaseRep;
    private final AdvManager advManager;
    private final UserManager userManager;
    private final BookingRep bookingRep;

    @Autowired
    public PurchaseServiceImpl(
            AdvRep advRep1,
            ModelMapper modelMapper1,
            AdvManager advManager1,
            UserManager userManager1,
            BookingRep bookingRep1,
            PurchaseRep purchaseRep1)
    {
        purchaseRep = purchaseRep1;
        bookingRep = bookingRep1;
        modelMapper = modelMapper1;
        advManager = advManager1;
        userManager = userManager1;
    }

    @Override
    public List<PurchaseDto> purchaseGet(Long userId) {
        userManager.getUserOrThrow(userId);

        return modelMapper.map(purchaseRep.findPurchasesByBuyerId(userId),new TypeToken<List<PurchaseDto>>() {}.getType());
    }

    @Override
    public IdDto purchasePost(PurchasePostBody body) {
        var purchase = modelMapper.map(body, Purchase.class);

        purchase.setSeller(userManager.getUserOrThrow(purchase.getSeller().getId()));
        purchase.setBuyer(userManager.getUserOrThrow(purchase.getBuyer().getId()));
        purchase.setAds(advManager.getAdvOrThrow(purchase.getAds().getId()));
        purchase.setDate(new Timestamp(System.currentTimeMillis()));

        purchase = purchaseRep.save(purchase);
        purchase.getAds().setStatus(advManager.getAdvStatusOrThrow(AdvStatus.PURCHASED));

        return new IdDto(purchase.getId());
    }
}

