sed -i '/Schema/d' dtos/*
sed -i '/Generated/d' dtos/*
sed -i '/javax.validation/d' dtos/*
sed -i '/import org.threeten/d' dtos/*
sed -i 's/io.swagger/nsukrpo.backend/' dtos/*
sed -i 's/OffsetDateTime/Timestamp/' dtos/*
