package com.cn.nlg.service.impl;

import com.cn.nlg.domain.Damage;
import com.cn.nlg.domain.DamageRepository;
import com.cn.nlg.service.DamageService;
import lombok.experimental.var;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 62746326@qq.com
 * @date create by 2018/6/12 10:48
 */
@Log
@Service
public class DamageServiceImpl implements DamageService {


    @Resource
    private DamageRepository damageRepository;


    @Override
    public List<Damage> findAll() {
        return damageRepository.findAll();
    }

    @Override
    public Damage insertByDamage(Damage damage) {
        damage  = finalCount(damage);
        return damageRepository.save(damage);
    }

    @Override
    public Damage update(Damage damage) {
        damage  = finalCount(damage);
        return damageRepository.save(damage);
    }

    @Override
    public Damage delete(Long id) {
        Damage damage = damageRepository.findById(id).orElse(null);
        if (damage != null) {
            damageRepository.delete(damage);
        }
        return damage;
    }

    @Override
    public Damage findById(Long id) {
        return damageRepository.findById(id).orElse(null);
    }


    private Damage finalCount(Damage damage) {
       var hurt =  damage.getCount();
       var realGetResistance = damage.getResistance() -damage.getPenetration();
       var reduction = realGetResistance /(realGetResistance+100.00) ;
       var finalCount = hurt * (1.00 -reduction);
       damage.setFinalDamage(finalCount);
       return damage;


    }
}
