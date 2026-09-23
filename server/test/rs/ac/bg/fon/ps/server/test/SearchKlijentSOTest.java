package rs.ac.bg.fon.ps.server.test;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

import rs.ac.bg.fon.ps.common.domain.GenericEntity;
import rs.ac.bg.fon.ps.common.domain.Klijent;
import rs.ac.bg.fon.ps.server.so.klijent.SearchKlijentSO;

public class SearchKlijentSOTest {

    @Test
    public void testSearchKlijentUspeh() throws Exception {

        Klijent kriterijum = new Klijent();
        kriterijum.setIme("Ognjen"); 

        SearchKlijentSO so = new SearchKlijentSO();
        so.templateExecute(kriterijum);

        List<GenericEntity> lista = so.getLista();

        assertNotNull(lista);
        assertTrue(lista.size() > 0);
    }

    @Test
    public void testSearchKlijentBezRezultata() throws Exception {

        Klijent kriterijum = new Klijent();
        kriterijum.setIme("NEPOSTOJECI_KLIJENT_123");

        SearchKlijentSO so = new SearchKlijentSO();
        so.templateExecute(kriterijum);

        List<GenericEntity> lista = so.getLista();

        assertNotNull(lista);
        assertEquals(0, lista.size());
    }
}