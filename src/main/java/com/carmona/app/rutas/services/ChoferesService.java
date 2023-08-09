package com.carmona.app.rutas.services;

import com.carmona.app.rutas.models.Chofer;
import com.carmona.app.rutas.repositories.ChoferesReposotory;
import com.carmona.app.rutas.repositories.IRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ChoferesService implements IService<Chofer> {

    //atri
    private IRepository<Chofer> choferesRepo;
    @Override
    public List<Chofer> listar() {
        try {
            return  choferesRepo.lista();
        }
        catch (SQLException e){
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public Optional<Chofer> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public void guardar(Chofer chofer) {

    }

    @Override
    public void eliminar(Long id) {

    }

    public ChoferesService(Connection conn) {
        choferesRepo = new ChoferesReposotory(conn);

    }

}
