package com.ecommerce.posgrado.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

/**
 * @author gclaure from CochaSoft Date: 5/18/23 Time: 21:26 Project Name: posgrado
 */
@Getter
@Setter
@Entity
@Table(name = "orders")
public class OrderEntity implements Serializable {

  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  @Column(name = "id", columnDefinition = "char(36)")
  @Type(type = "org.hibernate.type.UUIDCharType")
  private UUID id;

  @Column(nullable = false)
  private LocalDateTime date;

  @Column(nullable = false)
  private String comment;

  @Enumerated(EnumType.STRING)
  private OrderStateEnum state;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private UserEntity user;

  @OneToMany(mappedBy = "order", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
  List<OrderItemsEntity> items;

}
