package com.example.BookMyShow.Model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Getter
@Setter
@Entity
@EntityListeners(value = { AuditingEntityListener.class })
@Table(name = "tickets")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "allotted_seats", nullable = false)
    private String allottedSeats;
    
    @Column(name = "amount", nullable = false)
    private double amount;
    
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "booked_at" , nullable = false)
    private Date bookedAt;
    
    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private UserEntity user;
    
    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private ShowEntity show;
    
    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ShowSeatsEntity> seats;

}
