package rs.ac.bg.fon.ps.server.so.usluga;

import java.util.List;
import rs.ac.bg.fon.ps.common.domain.GenericEntity;
import rs.ac.bg.fon.ps.common.domain.Usluga;
import rs.ac.bg.fon.ps.server.so.AbstractSO;

public class SearchUslugaSO extends AbstractSO {

    private List<GenericEntity> lista;

    public List<GenericEntity> getLista() {
        return lista;
    }

    @Override
    protected void validate(GenericEntity entity) throws Exception {
        if (!(entity instanceof Usluga)) {
            throw new Exception("Prosledjeni objekat nije tipa Usluga.");
        }
    }

    @Override
    protected void execute(GenericEntity entity) throws Exception {
        lista = broker.getByCondition((Usluga) entity);
    }
}