package rs.ac.bg.fon.ps.common.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Usluga implements GenericEntity {

    private Long uslugaId;
    private String naziv;
    private double ukupanIznos;
    private double popust;
    private double ukupanIznosSaPopustom;
    private Materijal materijalZaPretragu;

    private Zubar zubar;
    private Klijent klijent;

    private List<StavkaUsluge> stavke;

    public Usluga() {
        stavke = new ArrayList<>();
    }

    public Usluga(Long uslugaId, String naziv, double ukupanIznos, double popust,
            double ukupanIznosSaPopustom, Zubar zubar, Klijent klijent) {
        this.uslugaId = uslugaId;
        this.naziv = naziv;
        this.ukupanIznos = ukupanIznos;
        this.popust = popust;
        this.ukupanIznosSaPopustom = ukupanIznosSaPopustom;
        this.zubar = zubar;
        this.klijent = klijent;
        this.stavke = new ArrayList<>();
    }

    public Long getUslugaId() {
        return uslugaId;
    }

    public void setUslugaId(Long uslugaId) {
        this.uslugaId = uslugaId;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getUkupanIznos() {
        return ukupanIznos;
    }

    public void setUkupanIznos(double ukupanIznos) {
        this.ukupanIznos = ukupanIznos;
    }

    public double getPopust() {
        return popust;
    }

    public void setPopust(double popust) {
        this.popust = popust;
    }

    public double getUkupanIznosSaPopustom() {
        return ukupanIznosSaPopustom;
    }

    public void setUkupanIznosSaPopustom(double ukupanIznosSaPopustom) {
        this.ukupanIznosSaPopustom = ukupanIznosSaPopustom;
    }

    public Materijal getMaterijalZaPretragu() {
        return materijalZaPretragu;
    }

    public void setMaterijalZaPretragu(Materijal materijalZaPretragu) {
        this.materijalZaPretragu = materijalZaPretragu;
    }

    public Zubar getZubar() {
        return zubar;
    }

    public void setZubar(Zubar zubar) {
        this.zubar = zubar;
    }

    public Klijent getKlijent() {
        return klijent;
    }

    public void setKlijent(Klijent klijent) {
        this.klijent = klijent;
    }

    public List<StavkaUsluge> getStavke() {
        return stavke;
    }

    public void setStavke(List<StavkaUsluge> stavke) {
        this.stavke = stavke;
    }

    @Override
    public String getTableName() {
        return "usluga";
    }

    @Override
    public String getSelectValues() {
        return "u.*, z.ime AS zubar_ime, z.prezime AS zubar_prezime, k.ime AS klijent_ime, k.prezime AS klijent_prezime";
    }

    @Override
    public String getAliases() {
        return "u";
    }

    @Override
    public String getJoinClause() {
        return "JOIN zubar z ON u.id_zubar = z.id_zubar JOIN klijent k ON u.id_klijent = k.id_klijent";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "naziv, ukupan_iznos, popust, ukupan_iznos_sa_popustom, id_zubar, id_klijent";
    }

    @Override
    public String getInsertValues() {
        String zId = (zubar != null && zubar.getZubarId() != null) ? String.valueOf(zubar.getZubarId()) : "NULL";
        String kId = (klijent != null && klijent.getKlijentId() != null) ? String.valueOf(klijent.getKlijentId()) : "NULL";
        String n = (naziv != null) ? naziv : "Nova Usluga";

        return "'" + n + "', "
                + ukupanIznos + ", "
                + popust + ", "
                + ukupanIznosSaPopustom + ", "
                + zId + ", "
                + kId;
    }

    @Override
    public void setId(Long id) {
        this.uslugaId = id;
    }

    @Override
    public List<GenericEntity> getListFromResultSet(ResultSet rs) throws Exception {

        List<GenericEntity> lista = new ArrayList<>();

        while (rs.next()) {

            Long id = rs.getLong("id_usluga");
            String nazivIzBaze = rs.getString("naziv");
            double ukupan = rs.getDouble("ukupan_iznos");
            double popustBaza = rs.getDouble("popust");
            double ukupanSaPopustom = rs.getDouble("ukupan_iznos_sa_popustom");

            Long zubarId = rs.getLong("id_zubar");
            String zubarIme = rs.getString("zubar_ime");
            String zubarPrezime = rs.getString("zubar_prezime");

            Long klijentId = rs.getLong("id_klijent");
            String klijentIme = rs.getString("klijent_ime");
            String klijentPrezime = rs.getString("klijent_prezime");

            Zubar z = new Zubar();
            z.setZubarId(zubarId);
            z.setIme(zubarIme);
            z.setPrezime(zubarPrezime);

            Klijent k = new Klijent();
            k.setKlijentId(klijentId);
            k.setIme(klijentIme);
            k.setPrezime(klijentPrezime);

            Usluga u = new Usluga(id, nazivIzBaze, ukupan, popustBaza, ukupanSaPopustom, z, k);

            lista.add(u);
        }

        return lista;
    }

    @Override
    public String getPrimaryKeyColumnName() {
        return "id_usluga";
    }

    @Override
    public Long getPrimaryKeyValue() {
        return uslugaId;
    }

    @Override
    public String getUpdateSetClause() {
        return "naziv='" + naziv
                + "', ukupan_iznos=" + ukupanIznos
                + ", popust=" + popust
                + ", ukupan_iznos_sa_popustom=" + ukupanIznosSaPopustom
                + ", id_zubar=" + zubar.getZubarId()
                + ", id_klijent=" + klijent.getKlijentId();
    }

    public String getWhereCondition() {
        if (uslugaId != null && uslugaId > 0) {
            return "u.id_usluga = " + uslugaId;
        }

        StringBuilder sb = new StringBuilder("1=1 ");

        if (naziv != null && !naziv.trim().isEmpty()) {
            sb.append(" AND u.naziv LIKE '%").append(naziv).append("%'");
        }

        if (zubar != null && zubar.getZubarId() != null && zubar.getZubarId() > 0) {
            sb.append(" AND u.id_zubar = ").append(zubar.getZubarId());
        }

        if (klijent != null && klijent.getKlijentId() != null && klijent.getKlijentId() > 0) {
            sb.append(" AND u.id_klijent = ").append(klijent.getKlijentId());
        }

        if (materijalZaPretragu != null && materijalZaPretragu.getMaterijalId() != null) {
            sb.append(" AND u.id_usluga IN (SELECT id_usluga FROM stavka_usluge WHERE id_materijal = ")
                    .append(materijalZaPretragu.getMaterijalId()).append(")");
        }

        return sb.toString();
    }

}
