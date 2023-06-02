package com.ecommerce.posgrado.mapper;

import com.ecommerce.posgrado.entity.RoleEntity;
import com.ecommerce.posgrado.request.RoleRequest;
import org.springframework.stereotype.Component;

/**
 * @author gclaure Gustavo Claure Flores
 * Date: 6/1/23
 * Time: 20:30
 * Project Name: posgrado
 */
@Component
public class RoleMapper {

    public RoleEntity roleRequestFromEntity(RoleRequest request){
        RoleEntity role = new RoleEntity();
        role.setName(request.getName().toUpperCase());
        role.setDescription(request.getDescription());
        return role;
    }
}
