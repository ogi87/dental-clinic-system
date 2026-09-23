package rs.ac.bg.fon.ps.server.so.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import rs.ac.bg.fon.ps.common.domain.GenericEntity;
import rs.ac.bg.fon.ps.common.domain.Zubar;
import rs.ac.bg.fon.ps.server.db.DbConnectionFactory;
import rs.ac.bg.fon.ps.server.so.AbstractSO;

public class LoginSO extends AbstractSO {

    private Zubar ulogovaniZubar;

    public Zubar getUlogovaniZubar() {
        return ulogovaniZubar;
    }

    @Override
    protected void validate(GenericEntity entity) throws Exception {
        if (!(entity instanceof Zubar)) {
            throw new Exception("Prosledjeni objekat nije tipa Zubar.");
        }
    }

    @Override
    protected void execute(GenericEntity entity) throws Exception {
        List<GenericEntity> lista = broker.getByCondition(entity);

        if (lista != null && !lista.isEmpty()) {
            ulogovaniZubar = (Zubar) lista.get(0);
        } else {
            throw new Exception("Корисничко име и шифра нису исправни");
        }
    }
}