package com.kazanovskiy.cinema.services.impl;

import com.kazanovskiy.cinema.model.Actor;
import com.kazanovskiy.cinema.repository.ActorRepository;
import com.kazanovskiy.cinema.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements ActorService {

    @Value("${page.size}")
    private Integer pageSize;

    private final ActorRepository actorRepository;

    @Autowired
    public ActorServiceImpl(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public void addActor(Actor actor) {
        actorRepository.saveAndFlush(actor);
    }

    public List<Actor> getAllActors() {
        return actorRepository.findAll();
    }

    public Page<Actor> getAllActorsPage(Integer pageNumber) {
        return actorRepository.findAll(PageRequest.of(pageNumber - 1,pageSize,Sort.by(Sort.Direction.ASC,"lastName")));
    }

    public Actor getActorByID(Long id) {
        return actorRepository.findById(id).orElseThrow(NoSuchFieldError::new);
    }

    public void deleteActorByID(Long id) {
        if (actorRepository.findById(id).isPresent()) {
            actorRepository.deleteById(id);
        }
    }

}
