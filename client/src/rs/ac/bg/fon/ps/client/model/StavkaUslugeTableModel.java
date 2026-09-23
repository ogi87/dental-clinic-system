package rs.ac.bg.fon.ps.client.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import rs.ac.bg.fon.ps.common.domain.StavkaUsluge;

public class StavkaUslugeTableModel extends AbstractTableModel {

    private List<StavkaUsluge> lista;
    private final String[] kolone = {"RB", "Materijal", "Kolicina", "Cena", "Iznos"};

    public StavkaUslugeTableModel() {
        lista = new ArrayList<>();
    }

    public void setLista(List<StavkaUsluge> lista) {
        this.lista = lista;
        fireTableDataChanged();
    }

    public List<StavkaUsluge> getLista() {
        return lista;
    }

    public void addStavka(StavkaUsluge stavka) {
        stavka.setRb(lista.size() + 1);
        lista.add(stavka);
        fireTableDataChanged();
    }

    public void removeStavka(int row) {

        lista.remove(row);

        for (int i = 0; i < lista.size(); i++) {
            lista.get(i).setRb(i + 1);
        }

        fireTableDataChanged();
    }

    public StavkaUsluge getStavkaAt(int row) {
        return lista.get(row);
    }

    @Override
    public int getRowCount() {
        return lista.size();
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

        StavkaUsluge s = lista.get(rowIndex);

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