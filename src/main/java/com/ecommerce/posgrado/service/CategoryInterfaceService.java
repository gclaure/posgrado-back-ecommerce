package com.ecommerce.posgrado.service;

import com.ecommerce.posgrado.entity.CategoryEntity;
import java.util.List;
import java.util.UUID;

/**
 * @author gclaure from CochaSoft Date: 5/20/23 Time: 19:53 Project Name: posgrado
 */
public interface CategoryInterfaceService {

  CategoryEntity getById(UUID id);

  List<CategoryEntity> getAll();

}
