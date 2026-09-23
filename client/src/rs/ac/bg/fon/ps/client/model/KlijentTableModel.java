package rs.ac.bg.fon.ps.client.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import rs.ac.bg.fon.ps.common.domain.Klijent;

public class KlijentTableModel extends AbstractTableModel {

    private List<Klijent> listaKlijenata;
    private final String[] kolone = {"ID", "Ime", "Prezime", "Kontakt", "Kategorija"};

    public KlijentTableModel() {
        listaKlijenata = new ArrayList<>();
    }

    public void setListaKlijenata(List<Klijent> listaKlijenata) {
        this.listaKlijenata = listaKlijenata;
        fireTableDataChanged();
    }

    public Klijent getKlijentAt(int row) {
        return listaKlijenata.get(row);
    }

    @Override
    public int getRowCount() {
        return listaKlijenata.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Klijent k = listaKlijenata.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return k.getKlijentId();
            case 1:
                return k.getIme();
            case 2:
                return k.getPrezime();
            case 3:
                return k.getKontakt();
            case 4:
                return k.getKategorija().getNaziv();
            default:
                return "N/A";
        }
    }
}