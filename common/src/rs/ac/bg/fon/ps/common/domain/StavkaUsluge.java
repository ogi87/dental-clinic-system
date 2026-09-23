package rs.ac.bg.fon.ps.common.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StavkaUsluge implements GenericEntity {

    private Usluga usluga;
    private int rb;
    private int kolicina;
    private double cena;
    private double iznos;
    private Materijal materijal;

    public StavkaUsluge() {
    }

    public StavkaUsluge(Usluga usluga, int rb, int kolicina, double cena, double iznos, Materijal materijal) {
        this.usluga = usluga;
        this.rb = rb;
        this.kolicina = kolicina;
        this.cena = cena;
        this.iznos = iznos;
        this.materijal = materijal;
    }

    public Usluga getUsluga() {
        return usluga;
    }

    public void setUsluga(Usluga usluga) {
        this.usluga = usluga;
    }

    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public double getIznos() {
        return iznos;
    }

    public void setIznos(double iznos) {
        this.iznos = iznos;
    }

    public Materijal getMaterijal() {
        return materijal;
    }

    public void setMaterijal(Materijal materijal) {
        this.materijal = materijal;
    }

    @Override
    public String getTableName() {
        return "stavka_usluge";
    }

    @Override
    public String getAliases() {
        return "su";
    }
    @Override
    public String getSelectValues() {
        return "su.*, m.naziv AS materijal_naziv, m.cena AS materijal_cena";
    }

    @Override
    public String getJoinClause() {
        return "JOIN materijal m ON su.id_materijal = m.id_materijal";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "id_usluga, rb, kolicina, cena, iznos, id_materijal";
    }

    @Override
    public String getInsertValues() {
        return usluga.getUslugaId() + ", "
                + rb + ", "
                + kolicina + ", "
                + cena + ", "
                + iznos + ", "
                + materijal.getMaterijalId();
    }

    @Override
    public void setId(Long id) {
        
    }

    @Override
    public List<GenericEntity> getListFromResultSet(ResultSet rs) throws Exception {
        List<GenericEntity> lista = new ArrayList<>();

        while (rs.next()) {
            Long idUsluga = rs.getLong("id_usluga");
            int rb = rs.getInt("rb");
            int kolicina = rs.getInt("kolicina");
            double cena = rs.getDouble("cena");
            double iznos = rs.getDouble("iznos");

            Long materijalId = rs.getLong("id_materijal");
            String nazivMaterijala = rs.getString("materijal_naziv");
            double cenaMaterijala = rs.getDouble("materijal_cena");

            Usluga u = new Usluga();
            u.setUslugaId(idUsluga);

            Materijal m = new Materijal(materijalId, nazivMaterijala, cenaMaterijala);

            StavkaUsluge s = new StavkaUsluge(u, rb, kolicina, cena, iznos, m);
            lista.add(s);
        }

        return lista;
    }

    @Override
    public String getPrimaryKeyColumnName() {
        return "rb";
    }

    @Override
    public Long getPrimaryKeyValue() {
        return (long) rb;
    }

    @Override
    public String getUpdateSetClause() {
        return "kolicina=" + kolicina
                + ", cena=" + cena
                + ", iznos=" + iznos
                + ", id_materijal=" + materijal.getMaterijalId();
    }

    @Override
    public String getWhereCondition() {
        if (rb > 0) {
            return "id_usluga = " + usluga.getUslugaId() + " AND rb = " + rb;
        } else {
            return "id_usluga = " + usluga.getUslugaId();
        }
    }

    @Override
    public String toString() {
        return rb + ". " + materijal;
    }

}
