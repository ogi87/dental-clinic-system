package rs.ac.bg.fon.ps.server.so.kategorijaklijenta;

import java.util.List;
import rs.ac.bg.fon.ps.common.domain.GenericEntity;
import rs.ac.bg.fon.ps.common.domain.KategorijaKlijenta;
import rs.ac.bg.fon.ps.server.so.AbstractSO;

public class GetAllKategorijaKlijentaSO extends AbstractSO {

    private List<GenericEntity> lista;

    public List<GenericEntity> getLista() {
        return lista;
    }

    @Override
    protected void validate(GenericEntity entity) throws Exception {
        if (!(entity instanceof KategorijaKlijenta)) {
            throw new Exception("Prosledjeni objekat nije tipa KategorijaKlijenta.");
        }
    }

    @Override
    protected void execute(GenericEntity entity) throws Exception {
        lista = broker.getAll(entity);
    }
}