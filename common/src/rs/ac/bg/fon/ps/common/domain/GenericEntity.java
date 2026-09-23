package rs.ac.bg.fon.ps.common.domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;

public interface GenericEntity extends Serializable {

    String getTableName();

    String getColumnNamesForInsert();

    String getInsertValues();

    void setId(Long id);

    List<GenericEntity> getListFromResultSet(ResultSet rs) throws Exception;

    String getPrimaryKeyColumnName();

    Long getPrimaryKeyValue();

    String getUpdateSetClause();

    String getWhereCondition();

    String getAliases(); 

    String getJoinClause(); 

    String getSelectValues();
}
