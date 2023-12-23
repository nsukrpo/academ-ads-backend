package nsukrpo.backend.repository.advertsimenent;

import nsukrpo.backend.model.entities.user.Purchase;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PurchaseRep  extends CrudRepository<Purchase, Long> {
    List<Purchase> findPurchasesByBuyerId(Long buyerId);
}
