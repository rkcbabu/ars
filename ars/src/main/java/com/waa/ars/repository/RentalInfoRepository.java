/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.waa.ars.repository;

import com.waa.ars.domain.RentalInfo;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface RentalInfoRepository extends CrudRepository<RentalInfo, String> {

    @Override
    public RentalInfo findOne(String arg0);

    @Override
    public List<RentalInfo> findAll();

    @Override
    public <S extends RentalInfo> S save(S arg0);
}
