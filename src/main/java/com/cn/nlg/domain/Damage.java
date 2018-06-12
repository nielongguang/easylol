package com.cn.nlg.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author  nlg
 * 不能同时使用  @Accessors(fluent=true) 标签
 */


 @Data
 @Entity
public class Damage {

   @Id
   @GeneratedValue
   private Long id;
   private String name;
   private String sufferer;
   private String type;
   private int count;
   private int resistance;
   private int penetration;
   private double finalDamage;
}



