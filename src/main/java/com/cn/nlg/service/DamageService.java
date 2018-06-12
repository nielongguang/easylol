package com.cn.nlg.service;

import com.cn.nlg.domain.Damage;

import java.util.List;

/**
 * @author  nlg
 */
public interface DamageService {

    List<Damage> findAll();


    Damage insertByDamage(Damage damage);

    Damage update(Damage damage);

    Damage delete(Long id);

    Damage findById(Long id);


}
