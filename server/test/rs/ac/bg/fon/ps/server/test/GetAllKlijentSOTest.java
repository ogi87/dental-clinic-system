package rs.ac.bg.fon.ps.server.test;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

import rs.ac.bg.fon.ps.common.domain.GenericEntity;
import rs.ac.bg.fon.ps.common.domain.Klijent;
import rs.ac.bg.fon.ps.server.so.klijent.GetAllKlijentSO;

public class GetAllKlijentSOTest {

    @Test
    public void testGetAllKlijenti() throws Exception {

        GetAllKlijentSO so = new GetAllKlijentSO();

        // prosleđujemo prazan objekat jer operacija vraća sve klijente
        so.templateExecute(new Klijent());

        List<GenericEntity> lista = so.getLista();

        assertNotNull(lista);
        assertTrue(lista.size() >= 0);
    }
}