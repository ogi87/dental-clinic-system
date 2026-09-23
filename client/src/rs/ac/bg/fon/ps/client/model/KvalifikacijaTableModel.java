package rs.ac.bg.fon.ps.client.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import rs.ac.bg.fon.ps.common.domain.Kvalifikacija;

public class KvalifikacijaTableModel extends AbstractTableModel {

    private List<Kvalifikacija> listaKvalifikacija;
    private final String[] kolone = {"ID", "Naziv"};

    public KvalifikacijaTableModel() {
        listaKvalifikacija = new ArrayList<>();
    }

    public void setListaKvalifikacija(List<Kvalifikacija> listaKvalifikacija) {
        this.listaKvalifikacija = listaKvalifikacija;
        fireTableDataChanged();
    }

    public Kvalifikacija getKvalifikacijaAt(int row) {
        return listaKvalifikacija.get(row);
    }

    @Override
    public int getRowCount() {
        return listaKvalifikacija.size();
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
        Kvalifikacija k = listaKvalifikacija.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return k.getKvalifikacijaId();
            case 1:
                return k.getNaziv();
            default:
                return "N/A";
        }
    }
}