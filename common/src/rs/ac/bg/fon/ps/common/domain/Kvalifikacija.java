package rs.ac.bg.fon.ps.common.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Kvalifikacija implements GenericEntity {

    private Long kvalifikacijaId;
    private String naziv;

    public Kvalifikacija() {
    }

    public Kvalifikacija(Long kvalifikacijaId, String naziv) {
        this.kvalifikacijaId = kvalifikacijaId;
        this.naziv = naziv;
    }

    public Long getKvalifikacijaId() {
        return kvalifikacijaId;
    }

    public void setKvalifikacijaId(Long kvalifikacijaId) {
        this.kvalifikacijaId = kvalifikacijaId;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String getTableName() {
        return "kvalifikacija";
    }

    @Override
    public String getAliases() {
        return "";
    }

    @Override
    public String getJoinClause() {
        return "";
    }
    
    @Override
    public String getSelectValues() {
        return "*";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "naziv";
    }

    @Override
    public String getInsertValues() {
        return "'" + naziv + "'";
    }

    @Override
    public void setId(Long id) {
        this.kvalifikacijaId = id;
    }

    @Override
    public List<GenericEntity> getListFromResultSet(ResultSet rs) throws Exception {
        List<GenericEntity> lista = new ArrayList<>();

        while (rs.next()) {
            Long id = rs.getLong("id_kvalifikacija");
            String naziv = rs.getString("naziv");

            Kvalifikacija k = new Kvalifikacija(id, naziv);
            lista.add(k);
        }

        return lista;
    }

    @Override
    public String getPrimaryKeyColumnName() {
        return "id_kvalifikacija";
    }

    @Override
    public Long getPrimaryKeyValue() {
        return kvalifikacijaId;
    }

    @Override
    public String getUpdateSetClause() {
        return "naziv='" + naziv + "'";
    }

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public String getWhereCondition() {
        return "id_kvalifikacija = " + kvalifikacijaId;
    }

}
