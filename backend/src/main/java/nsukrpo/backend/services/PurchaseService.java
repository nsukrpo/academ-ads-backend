package nsukrpo.backend.services;

import nsukrpo.backend.model.dtos.IdDto;
import nsukrpo.backend.model.dtos.PurchaseDto;
import nsukrpo.backend.model.dtos.PurchasePostBody;

import java.util.List;

public interface PurchaseService {

    List<PurchaseDto> purchaseGet(Long userId);

    IdDto purchasePost(PurchasePostBody body);

}

