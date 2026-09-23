package rs.ac.bg.fon.ps.server.so.zubar;

import java.util.List;
import rs.ac.bg.fon.ps.common.domain.GenericEntity;
import rs.ac.bg.fon.ps.common.domain.Zubar;
import rs.ac.bg.fon.ps.server.so.AbstractSO;

public class GetAllZubarSO extends AbstractSO {

    private List<GenericEntity> lista;

    public List<GenericEntity> getLista() {
        return lista;
    }

    @Override
    protected void validate(GenericEntity entity) throws Exception {
        if (!(entity instanceof Zubar)) {
            throw new Exception("Prosledjeni objekat nije tipa Zubar.");
        }
    }

    @Override
    protected void execute(GenericEntity entity) throws Exception {
        lista = broker.getAll(entity);
    }
}