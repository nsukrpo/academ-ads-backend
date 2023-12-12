package nsukrpo.backend.repository.advertsimenent;

import nsukrpo.backend.model.entities.advertisement.StatusAd;
import nsukrpo.backend.model.entities.user.Purchase;
import org.springframework.data.repository.CrudRepository;

public interface PurchaseRep  extends CrudRepository<Purchase, Long> {
}
