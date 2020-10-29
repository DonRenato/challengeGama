package com.thejavinhos.tvchannel.service;

import com.thejavinhos.tvchannel.entity.Actor;
import com.thejavinhos.tvchannel.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class ActorService {

    @Autowired
    private ActorRepository actorRepository;

    public Actor saveActor(Actor actor) {
        return actorRepository.save(actor);
    }

    public Actor reservationDates(Actor actor, int id) {
        var inicial = actor.getDateReserveBegin();
        var end = actor.getDateReserveEnd();
        var dates = actor.datas(inicial, end);
        return (Actor) actorRepository.findById(id).map(a -> {
            if (a.getReservations().contains(inicial) || a.getReservations().contains(end)) {
                throw new IllegalArgumentException("Data indisponivel");
            }

            a.setReservations(incrementList(a.getReservations(), dates));
            return actorRepository.save(a);

        }).orElseThrow();
    }

    public List<Actor> listAllActors() {
        return (List<Actor>) actorRepository.findAll();
    }

    public Actor listActor(int id) {
        return actorRepository.findById(id).orElseThrow();
    }

    public List<Date> incrementList(List<Date> currentDates, List<Date> newDates) {
        return Stream.of(currentDates, newDates)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

    }

    public List<Date> reserves(int id){
        return actorRepository.findById(id).map(r ->{
            return r.getReservations();
        }).orElseThrow();
    }

}
