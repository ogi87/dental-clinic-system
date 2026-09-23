package rs.ac.bg.fon.ps.common.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Zubar implements GenericEntity {

    private Long zubarId;
    private String ime;
    private String prezime;
    private String korisnickoIme;
    private String sifra;

    public Zubar() {
    }

    public Zubar(Long zubarId, String ime, String prezime, String korisnickoIme, String sifra) {
        this.zubarId = zubarId;
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.sifra = sifra;
    }

    public Long getZubarId() {
        return zubarId;
    }

    public void setZubarId(Long zubarId) {
        this.zubarId = zubarId;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    @Override
    public String getTableName() {
        return "zubar";
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
        return "ime, prezime, korisnicko_ime, sifra";
    }

    @Override
    public String getInsertValues() {
        return "'" + ime + "', '" + prezime + "', '" + korisnickoIme + "', '" + sifra + "'";
    }

    @Override
    public void setId(Long id) {
        this.zubarId = id;
    }

    @Override
    public List<GenericEntity> getListFromResultSet(ResultSet rs) throws Exception {
        List<GenericEntity> lista = new ArrayList<>();

        while (rs.next()) {
            Long id = rs.getLong("id_zubar");
            String ime = rs.getString("ime");
            String prezime = rs.getString("prezime");
            String korisnickoIme = rs.getString("korisnicko_ime");
            String sifra = rs.getString("sifra");

            Zubar z = new Zubar(id, ime, prezime, korisnickoIme, sifra);
            lista.add(z);
        }

        return lista;
    }

    @Override
    public String getPrimaryKeyColumnName() {
        return "id_zubar";
    }

    @Override
    public Long getPrimaryKeyValue() {
        return zubarId;
    }

    @Override
    public String getUpdateSetClause() {
        return "ime='" + ime +
                "', prezime='" + prezime +
                "', korisnicko_ime='" + korisnickoIme +
                "', sifra='" + sifra + "'";
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }
    
    @Override
    public String getWhereCondition() {
        return "korisnicko_ime = '" + korisnickoIme + "' AND sifra = '" + sifra + "'";
    }
}