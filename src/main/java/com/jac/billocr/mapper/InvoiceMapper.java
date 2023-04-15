package com.jac.billocr.mapper;

import com.jac.billocr.entity.Invoice;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceMapper {
    Boolean add(Invoice invoice);
}
