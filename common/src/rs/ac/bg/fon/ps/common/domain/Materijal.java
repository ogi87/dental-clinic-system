package rs.ac.bg.fon.ps.common.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Materijal implements GenericEntity {

    private Long materijalId;
    private String naziv;
    private double cena;

    public Materijal() {
    }

    public Materijal(Long materijalId, String naziv, double cena) {
        this.materijalId = materijalId;
        this.naziv = naziv;
        this.cena = cena;
    }

    public Long getMaterijalId() {
        return materijalId;
    }

    public void setMaterijalId(Long materijalId) {
        this.materijalId = materijalId;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    @Override
    public String getTableName() {
        return "materijal";
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
        return "naziv, cena";
    }

    @Override
    public String getInsertValues() {
        return "'" + naziv + "', " + cena;
    }

    @Override
    public void setId(Long id) {
        this.materijalId = id;
    }

    @Override
    public List<GenericEntity> getListFromResultSet(ResultSet rs) throws Exception {
        List<GenericEntity> lista = new ArrayList<>();

        while (rs.next()) {
            Long id = rs.getLong("id_materijal");
            String naziv = rs.getString("naziv");
            double cena = rs.getDouble("cena");

            Materijal m = new Materijal(id, naziv, cena);
            lista.add(m);
        }

        return lista;
    }

    @Override
    public String getPrimaryKeyColumnName() {
        return "id_materijal";
    }

    @Override
    public Long getPrimaryKeyValue() {
        return materijalId;
    }

    @Override
    public String getUpdateSetClause() {
        return "naziv='" + naziv + "', cena=" + cena;
    }

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public String getWhereCondition() {
        return "id_materijal = " + materijalId;
    }
}
