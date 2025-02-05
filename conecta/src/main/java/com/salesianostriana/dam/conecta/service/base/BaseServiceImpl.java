package com.salesianostriana.dam.conecta.service.base;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public abstract class BaseServiceImpl<T, ID, R extends JpaRepository<T,ID>>
                            implements BaseService<T, ID>{

    protected R repository;


    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }

    @Override
    public T save(T t) {
        return repository.save(t);
    }

    @Override
    public T edit(T t) {
        return repository.save(t);
    }

    @Override
    public void delete(T t) {
        repository.delete(t);

    }

    @Override
    public void deleteById(ID id) {
        repository.deleteById(id);
    }


}
