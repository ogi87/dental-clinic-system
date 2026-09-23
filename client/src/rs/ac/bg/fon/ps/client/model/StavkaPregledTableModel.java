package rs.ac.bg.fon.ps.client.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import rs.ac.bg.fon.ps.common.domain.StavkaUsluge;

public class StavkaPregledTableModel extends AbstractTableModel {

    private List<StavkaUsluge> listaStavki;
    private final String[] kolone = {"RB", "Materijal", "Kolicina", "Cena", "Iznos"};

    public StavkaPregledTableModel() {
        listaStavki = new ArrayList<>();
    }

    public void setListaStavki(List<StavkaUsluge> listaStavki) {
        this.listaStavki = listaStavki;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return listaStavki.size();
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
        StavkaUsluge s = listaStavki.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return s.getRb();
            case 1:
                return s.getMaterijal().getNaziv();
            case 2:
                return s.getKolicina();
            case 3:
                return s.getCena();
            case 4:
                return s.getIznos();
            default:
                return "N/A";
        }
    }
}