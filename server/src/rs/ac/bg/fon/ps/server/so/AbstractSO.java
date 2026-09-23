package rs.ac.bg.fon.ps.server.so;

import rs.ac.bg.fon.ps.common.domain.GenericEntity;
import rs.ac.bg.fon.ps.server.db.DbConnectionFactory;
import rs.ac.bg.fon.ps.server.repository.RepositoryDBGeneric;

public abstract class AbstractSO {

    protected RepositoryDBGeneric broker;

    public AbstractSO() {
        broker = new RepositoryDBGeneric();
    }

    public final void templateExecute(GenericEntity entity) throws Exception {
        try {
            validate(entity);
            execute(entity);
            DbConnectionFactory.getInstance().commit();
        } catch (Exception e) {
            DbConnectionFactory.getInstance().rollback();
            throw e;
        }
    }

    protected abstract void validate(GenericEntity entity) throws Exception;

    protected abstract void execute(GenericEntity entity) throws Exception;
}