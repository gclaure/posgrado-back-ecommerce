package com.ecommerce.posgrado.entity;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

/**
 * @author gclaure from CochaSoft Date: 5/18/23 Time: 19:57 Project Name: posgrado
 */
@Getter
@Setter
@Entity
@Table(name = "category")
public class CategoryEntity implements Serializable {

  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  @Column(name = "id", columnDefinition = "char(36)")
  @Type(type = "org.hibernate.type.UUIDCharType")
  private UUID id;

  @Column(length = 35, nullable = false)
  private String name;

  @Column(length = 125)
  private String description;

}