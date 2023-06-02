package com.ecommerce.posgrado.service;

import com.ecommerce.posgrado.entity.RoleEntity;
import com.ecommerce.posgrado.request.RoleRequest;

import java.util.List;

/**
 * @author gclaure from CochaSoft Date: 5/20/23 Time: 21:31 Project Name: posgrado
 */
public interface RoleInterfaceService {

    RoleEntity createRole(RoleRequest request);

    RoleEntity getByName(String name);

    List<RoleEntity> getAll();
}
