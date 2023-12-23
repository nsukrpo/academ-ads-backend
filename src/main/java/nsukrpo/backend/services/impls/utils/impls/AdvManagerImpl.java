package nsukrpo.backend.services.impls.utils.impls;

import nsukrpo.backend.config.AdvStatus;
import nsukrpo.backend.model.entities.advertisement.Advertisement;
import nsukrpo.backend.model.entities.advertisement.Category;
import nsukrpo.backend.model.entities.advertisement.StatusAd;
import nsukrpo.backend.model.exceptions.NotFoundException;
import nsukrpo.backend.repository.advertsimenent.AdvCategoryRep;
import nsukrpo.backend.repository.advertsimenent.AdvRep;
import nsukrpo.backend.repository.advertsimenent.AdvStatusRep;
import nsukrpo.backend.services.impls.utils.AdvManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.HashMap;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class AdvManagerImpl implements AdvManager {
    private final EnumMap<nsukrpo.backend.config.AdvCategory, Category> categories = new EnumMap<>(nsukrpo.backend.config.AdvCategory.class);
    private final HashMap<Long, Category> categoriesById = new HashMap<>();
    private final EnumMap<nsukrpo.backend.config.AdvStatus, StatusAd> statuses = new EnumMap<>(nsukrpo.backend.config.AdvStatus.class);
    private final AdvCategoryRep categoryRep;
    private final AdvRep advRep;
    private final AdvStatusRep statusRep;

    @Autowired
    public AdvManagerImpl(AdvCategoryRep categoryRep1,AdvRep advRep1, AdvStatusRep statusRep1){
        categoryRep = categoryRep1;
        advRep = advRep1;
        statusRep = statusRep1;
    }

    @Override
    public Advertisement getAdvOrThrow(Long id){
        return advRep.findById(id).orElseThrow(() -> new NotFoundException("Couldn't find adv: " + id));
    }


    // не ну там явная дубликация надо переделывать нормально
    @Override
    public Category getAdvCategoryOrThrow(nsukrpo.backend.config.AdvCategory category){
        return categories.computeIfAbsent(category, t -> {
            synchronized (categories){
                return categories.containsKey(t) ?
                        categories.get(t) :
                        categoryRep.findByName(t.name()).orElseThrow(() -> new NotFoundException("Couldn't find category: " + t.name()));
            }
        });
    }

    @Override
    public StatusAd getAdvStatusOrThrow(AdvStatus status) {
        return statuses.computeIfAbsent(status, t -> {
            synchronized (statuses){
                return statuses.containsKey(t) ?
                        statuses.get(t) :
                        statusRep.findByName(t.name()).orElseThrow(() -> new NotFoundException("Couldn't find adv status: " + t.name()));
            }
        });
    }

    @Override
    public Category getAdvCategoryOrThrow(Long id){
        return categoriesById.computeIfAbsent(id, t -> {
            synchronized (categoriesById){
                return categoriesById.containsKey(t) ?
                        categoriesById.get(t) :
                        categoryRep.findById(t).orElseThrow(() -> new NotFoundException("Couldn't find category: " + t));
            }
        });
    }

}
