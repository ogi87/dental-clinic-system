package rs.ac.bg.fon.ps.common.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class KategorijaKlijenta implements GenericEntity {

    private Long kategorijaId;
    private String naziv;
    private double popust;

    public KategorijaKlijenta() {
    }

    public KategorijaKlijenta(Long kategorijaId, String naziv, double popust) {
        this.kategorijaId = kategorijaId;
        this.naziv = naziv;
        this.popust = popust;
    }

    public Long getKategorijaId() {
        return kategorijaId;
    }

    public void setKategorijaId(Long kategorijaId) {
        this.kategorijaId = kategorijaId;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getPopust() {
        return popust;
    }

    public void setPopust(double popust) {
        this.popust = popust;
    }

    @Override
    public String getTableName() {
        return "kategorija_klijenta";
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
        return "naziv, popust";
    }

    @Override
    public String getInsertValues() {
        return "'" + naziv + "', " + popust;
    }

    @Override
    public void setId(Long id) {
        this.kategorijaId = id;
    }

    @Override
    public List<GenericEntity> getListFromResultSet(ResultSet rs) throws Exception {
        List<GenericEntity> lista = new ArrayList<>();

        while (rs.next()) {
            Long id = rs.getLong("id_kategorija");
            String naziv = rs.getString("naziv");
            double popust = rs.getDouble("popust");

            KategorijaKlijenta kk = new KategorijaKlijenta(id, naziv, popust);
            lista.add(kk);
        }

        return lista;
    }

    @Override
    public String getPrimaryKeyColumnName() {
        return "id_kategorija";
    }

    @Override
    public Long getPrimaryKeyValue() {
        return kategorijaId;
    }

    @Override
    public String getUpdateSetClause() {
        return "naziv='" + naziv + "', popust=" + popust;
    }

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public String getWhereCondition() {
        return "id_kategorija = " + kategorijaId;
    }

}
