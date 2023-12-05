package nsukrpo.backend.config;

import org.springframework.stereotype.Component;

@Component
public class ConstConfImp implements ConstConf{
    @Override
    public String getUserType() {
        return "USER";
    }
}
