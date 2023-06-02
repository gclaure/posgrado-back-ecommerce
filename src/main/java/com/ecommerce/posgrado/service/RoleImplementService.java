package com.ecommerce.posgrado.service;

import com.ecommerce.posgrado.entity.RoleEntity;
import com.ecommerce.posgrado.exception.AppHandleException;
import com.ecommerce.posgrado.mapper.RoleMapper;
import com.ecommerce.posgrado.repository.RoleRepository;
import com.ecommerce.posgrado.request.RoleRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gclaure from CochaSoft Date: 5/20/23 Time: 21:31 Project Name: posgrado
 */
@Service
public class RoleImplementService implements RoleInterfaceService {

    private final RoleRepository roleRepository;

    private final RoleMapper roleMapper;

    public RoleImplementService(RoleRepository roleRepository,
                                RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }

    @Override
    public RoleEntity createRole(RoleRequest request) {
        if (this.roleRepository.existsByName(request.getName()))
            throw new AppHandleException("Role Name Already Exists", HttpStatus.CONFLICT);
        return this.roleRepository.save(this.roleMapper.roleRequestFromEntity(request));
    }

    @Override
    public RoleEntity getByName(String name) {
        return this.roleRepository.findByName(name.trim())
                .orElseThrow(() -> new AppHandleException("Role not found!", HttpStatus.NOT_FOUND));
    }

    @Override
    public List<RoleEntity> getAll() {
        return (List<RoleEntity>) this.roleRepository.findAll();
    }
}
