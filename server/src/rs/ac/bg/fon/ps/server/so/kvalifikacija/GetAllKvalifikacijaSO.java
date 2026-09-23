package rs.ac.bg.fon.ps.server.so.kvalifikacija;

import java.util.List;
import rs.ac.bg.fon.ps.common.domain.GenericEntity;
import rs.ac.bg.fon.ps.common.domain.Kvalifikacija;
import rs.ac.bg.fon.ps.server.so.AbstractSO;

public class GetAllKvalifikacijaSO extends AbstractSO {

    private List<GenericEntity> lista;

    public List<GenericEntity> getLista() {
        return lista;
    }

    @Override
    protected void validate(GenericEntity entity) throws Exception {
        if (!(entity instanceof Kvalifikacija)) {
            throw new Exception("Prosledjeni objekat nije tipa Kvalifikacija.");
        }
    }

    @Override
    protected void execute(GenericEntity entity) throws Exception {
        lista = broker.getAll(entity);
    }
}