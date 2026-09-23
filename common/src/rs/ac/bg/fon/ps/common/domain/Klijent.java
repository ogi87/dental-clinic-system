package rs.ac.bg.fon.ps.common.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Klijent implements GenericEntity {

    private Long klijentId;
    private String ime;
    private String prezime;
    private String kontakt;
    private KategorijaKlijenta kategorija;

    public Klijent() {
    }

    public Klijent(Long klijentId, String ime, String prezime, String kontakt, KategorijaKlijenta kategorija) {
        this.klijentId = klijentId;
        this.ime = ime;
        this.prezime = prezime;
        this.kontakt = kontakt;
        this.kategorija = kategorija;
    }

    public Long getKlijentId() {
        return klijentId;
    }

    public void setKlijentId(Long klijentId) {
        this.klijentId = klijentId;
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

    public String getKontakt() {
        return kontakt;
    }

    public void setKontakt(String kontakt) {
        this.kontakt = kontakt;
    }

    public KategorijaKlijenta getKategorija() {
        return kategorija;
    }

    public void setKategorija(KategorijaKlijenta kategorija) {
        this.kategorija = kategorija;
    }

    @Override
    public String getTableName() {
        return "klijent";
    }
    
    @Override
    public String getSelectValues() {
        return "k.*, kk.naziv AS kategorija_naziv, kk.popust AS kategorija_popust";
    }

    @Override
    public String getAliases() {
        return "k";
    }

    @Override
    public String getJoinClause() {
        return "JOIN kategorija_klijenta kk ON k.id_kategorija = kk.id_kategorija";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "ime, prezime, kontakt, id_kategorija";
    }

    @Override
    public String getInsertValues() {
        return "'" + ime + "', '" + prezime + "', '" + kontakt + "', " + kategorija.getKategorijaId();
    }
    
    

    @Override
    public void setId(Long id) {
        this.klijentId = id;
    }

    @Override
    public List<GenericEntity> getListFromResultSet(ResultSet rs) throws Exception {

        List<GenericEntity> lista = new ArrayList<>();

        while (rs.next()) {

            Long klijentId = rs.getLong("id_klijent");
            String ime = rs.getString("ime");
            String prezime = rs.getString("prezime");
            String kontakt = rs.getString("kontakt");

            Long kategorijaId = rs.getLong("id_kategorija");
            String kategorijaNaziv = rs.getString("kategorija_naziv");
            double kategorijaPopust = rs.getDouble("kategorija_popust");

            KategorijaKlijenta kategorija = new KategorijaKlijenta(
                    kategorijaId,
                    kategorijaNaziv,
                    kategorijaPopust
            );

            Klijent k = new Klijent(
                    klijentId,
                    ime,
                    prezime,
                    kontakt,
                    kategorija
            );

            lista.add(k);
        }

        return lista;
    }

    @Override
    public String getPrimaryKeyColumnName() {
        return "id_klijent";
    }

    @Override
    public Long getPrimaryKeyValue() {
        return klijentId;
    }

    @Override
    public String getUpdateSetClause() {
        return "ime='" + ime
                + "', prezime='" + prezime
                + "', kontakt='" + kontakt
                + "', id_kategorija=" + kategorija.getKategorijaId();
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    @Override
    public String getWhereCondition() {
        
        if (klijentId != null && klijentId > 0) {
            return "k.id_klijent = " + klijentId;
        }
        
        StringBuilder sb = new StringBuilder("1=1 ");
        
        if (ime != null && !ime.trim().isEmpty()) {
            sb.append(" AND (LOWER(k.ime) LIKE '%").append(ime.toLowerCase()).append("%' OR LOWER(k.prezime) LIKE '%").append(ime.toLowerCase()).append("%')");
        }
        if (kategorija != null && kategorija.getKategorijaId() != null && kategorija.getKategorijaId() > 0) {
            sb.append(" AND k.id_kategorija = ").append(kategorija.getKategorijaId());
        }
        
        return sb.toString();
    }
}
