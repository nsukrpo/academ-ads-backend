/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.51).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package nsukrpo.backend.services;

import nsukrpo.backend.model.dtos.PurchaseDto;

import java.util.List;

public interface SalesService {

    List<PurchaseDto> salesGet(Long userId);
}

