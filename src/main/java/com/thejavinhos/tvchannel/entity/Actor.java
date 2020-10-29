package com.thejavinhos.tvchannel.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;
    @Column(name = "gender")
    private String gender;
    @Column(name = "password")
    private int password;
    @Column(name = "username")
    private String username;

    @Column(name = "payment")
    private double payment;

    @Column(name = "available")
    private boolean available;

    @Column(name = "genre_work")
    private String genreWork;

    @ElementCollection
    @Column(name = "reservations")
    private List<Date> reservations = new ArrayList();

    private Date dateReserveBegin;
    private Date dateReserveEnd;

    private int reservationTotal = 0;




    public List<Date> datas(Date dataInicial, Date dataFinal){
        List<Date> datas = new ArrayList<Date>();
        datas.add(dataInicial);
        Calendar inicio = Calendar.getInstance();
        inicio.setTime(dataInicial);
        while(inicio.getTime().before(dataFinal)){
            inicio.add(Calendar.DAY_OF_YEAR,1);
            datas.add(inicio.getTime());
        }
        return datas;
    }


}
