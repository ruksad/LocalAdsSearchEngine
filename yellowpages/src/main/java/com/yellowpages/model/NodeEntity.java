package com.yellowpages.model;

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
@Table(name = "NODE")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class NodeEntity implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "node_id", unique = true)
    private int nodeId;

    @Column(name = "node_name", unique = true)
    private String nodeName;

    @Column(name = "node_status")
    private String nodeStatus;

    @Column(name = "time_stamp", unique = true)
    private Date timeStamp;

    @Column(name = "machine_id", unique = true)
    private String machineId;
}
