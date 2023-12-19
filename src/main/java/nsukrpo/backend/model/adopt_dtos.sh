sed -i '/Schema/d' dtos/*
sed -i '/Generated/d' dtos/*
sed -i '/javax.validation/d' dtos/*
sed -i 's/io.swagger/nsukrpo.backend/' dtos/*
