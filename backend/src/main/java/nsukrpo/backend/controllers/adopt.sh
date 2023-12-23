sed -i '/.Generated/d' api/* ;
sed -i '/@Operation/d' api/* ;
sed -i '/@ApiResponses/d' api/* ;
sed -i '/import io.swagger./d' api/* ;
sed -i '/javax./d' api/* ;
sed -i '/@ApiResponse/d' api/* ;