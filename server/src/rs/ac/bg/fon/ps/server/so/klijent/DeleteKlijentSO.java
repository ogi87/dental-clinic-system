package rs.ac.bg.fon.ps.server.so.klijent;

import rs.ac.bg.fon.ps.common.domain.GenericEntity;
import rs.ac.bg.fon.ps.common.domain.Klijent;
import rs.ac.bg.fon.ps.server.so.AbstractSO;

public class DeleteKlijentSO extends AbstractSO {

    @Override
    protected void validate(GenericEntity entity) throws Exception {

        if (!(entity instanceof Klijent)) {
            throw new Exception("Prosledjeni objekat nije tipa Klijent.");
        }

        Klijent klijent = (Klijent) entity;

        if (klijent.getKlijentId() == null) {
            throw new Exception("Klijent mora imati ID za brisanje.");
        }
    }

    @Override
    protected void execute(GenericEntity entity) throws Exception {
        broker.delete(entity);
    }
}