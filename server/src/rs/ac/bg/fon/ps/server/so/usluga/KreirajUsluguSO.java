package rs.ac.bg.fon.ps.server.so.usluga;
import rs.ac.bg.fon.ps.common.domain.*;
import rs.ac.bg.fon.ps.server.so.AbstractSO;

public class KreirajUsluguSO extends AbstractSO {
    @Override
    protected void validate(GenericEntity entity) throws Exception { }

    @Override
    protected void execute(GenericEntity entity) throws Exception {
        
        /*
        if(true){
            throw new Exception("");
        }
        */
        
        Usluga u = (Usluga) entity;
        // Inicijalne vrednosti da prođe NOT NULL ogranicenja
        u.setNaziv("Nova usluga");
        u.setUkupanIznos(0); u.setPopust(0); u.setUkupanIznosSaPopustom(0);

        Zubar z = new Zubar(); z.setZubarId(1L); u.setZubar(z);
        Klijent k = new Klijent(); k.setKlijentId(1L); u.setKlijent(k);

        broker.save(u);
    }
}