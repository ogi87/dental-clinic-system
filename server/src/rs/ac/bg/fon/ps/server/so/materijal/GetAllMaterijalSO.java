package rs.ac.bg.fon.ps.server.so.materijal;

import java.util.List;
import rs.ac.bg.fon.ps.common.domain.GenericEntity;
import rs.ac.bg.fon.ps.common.domain.Materijal;
import rs.ac.bg.fon.ps.server.so.AbstractSO;

public class GetAllMaterijalSO extends AbstractSO {

    private List<GenericEntity> lista;

    public List<GenericEntity> getLista() {
        return lista;
    }

    @Override
    protected void validate(GenericEntity entity) throws Exception {
        if (!(entity instanceof Materijal)) {
            throw new Exception("Prosledjeni objekat nije tipa Materijal.");
        }
    }

    @Override
    protected void execute(GenericEntity entity) throws Exception {
        lista = broker.getAll(entity);
    }
}