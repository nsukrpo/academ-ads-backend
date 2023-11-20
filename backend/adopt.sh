sed -i '/Operation/d' src/main/java/nsukrpo/backend/api/*
sed -i '/ApiResponse/d' src/main/java/nsukrpo/backend/api/*
sed -i '/ApiResponses/d' src/main/java/nsukrpo/backend/api/*
sed -i '/Generated/d' src/main/java/nsukrpo/backend/api/*
sed -i '/import io.swagger.v3/d' src/main/java/nsukrpo/backend/api/*
sed -i '/Generated/d' src/main/java/nsukrpo/backend/api/*
sed -i '/javax.validation/d' src/main/java/nsukrpo/backend/api/*
sed -i 's/io.swagger/nsukrpo.backend/' src/main/java/nsukrpo/backend/api/*
sed -i '/import org.threeten/d' src/main/java/nsukrpo/backend/api/*

sed -i '/Schema/d' src/main/java/nsukrpo/backend/model/*
sed -i '/Generated/d' src/main/java/nsukrpo/backend/model/*
sed -i '/javax.validation/d' src/main/java/nsukrpo/backend/model/*
sed -i 's/io.swagger/nsukrpo.backend/' src/main/java/nsukrpo/backend/model/*

