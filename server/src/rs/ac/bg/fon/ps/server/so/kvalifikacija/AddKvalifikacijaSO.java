package rs.ac.bg.fon.ps.server.so.kvalifikacija;

import rs.ac.bg.fon.ps.common.domain.GenericEntity;
import rs.ac.bg.fon.ps.common.domain.Kvalifikacija;
import rs.ac.bg.fon.ps.server.so.AbstractSO;

public class AddKvalifikacijaSO extends AbstractSO {

    @Override
    protected void validate(GenericEntity entity) throws Exception {
        if (!(entity instanceof Kvalifikacija)) {
            throw new Exception("Prosledjeni objekat nije tipa Kvalifikacija.");
        }
        
        Kvalifikacija k = (Kvalifikacija) entity;
        if (k.getNaziv() == null || k.getNaziv().trim().isEmpty()) {
            throw new Exception("Naziv kvalifikacije ne sme biti prazan.");
        }
    }

    @Override
    protected void execute(GenericEntity entity) throws Exception {
        broker.save(entity);
    }
    
}