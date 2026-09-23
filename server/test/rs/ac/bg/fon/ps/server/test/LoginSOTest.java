package rs.ac.bg.fon.ps.server.test;

import org.junit.Test;
import static org.junit.Assert.*;

import rs.ac.bg.fon.ps.common.domain.Zubar;
import rs.ac.bg.fon.ps.server.so.login.LoginSO;

public class LoginSOTest {

    @Test
    public void testLoginUspeh() throws Exception {

        Zubar z = new Zubar();
        z.setKorisnickoIme("ana"); // mora postojati u bazi
        z.setSifra("123");

        LoginSO so = new LoginSO();
        so.templateExecute(z);

        Zubar rezultat = so.getUlogovaniZubar();

        assertNotNull(rezultat);
        assertEquals("ana", rezultat.getKorisnickoIme());
    }

    @Test
    public void testLoginNeuspeh() {

        Zubar z = new Zubar();
        z.setKorisnickoIme("pogresno");
        z.setSifra("pogresno");

        LoginSO so = new LoginSO();

        try {
            so.templateExecute(z);
            fail("Očekivan je exception jer su podaci pogrešni.");
        } catch (Exception e) {
            assertEquals("Корисничко име и шифра нису исправни", e.getMessage());
        }
    }
}