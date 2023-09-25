package com.myntra.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ordertracking")
@Getter
@Setter
public class OrderTrackingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "orderedDate")
    private String orderedDate;

    @OneToOne
    @JoinColumn(name = "order_response_id")
    private OrderEntity orderEntity;





}
