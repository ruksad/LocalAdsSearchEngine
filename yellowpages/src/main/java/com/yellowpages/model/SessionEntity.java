package com.yellowpages.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Ruksad siddiqui on 5/4/18
 */
@Entity
@Table(name = "session")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class SessionEntity implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "session_id", unique = true)
    private long sessionId;

    @Column(name = "user_id", unique = true)
    private long userId;

    @Column(name = "login_time")
    private Date loginTime;

    @Column(name = "service_id")
    private long serviceId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = NodeEntity.class)
    @JoinColumn(name = "node_id")
    @JsonIgnore
    private NodeEntity nodeEntity;
}
