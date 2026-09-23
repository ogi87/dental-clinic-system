package rs.ac.bg.fon.ps.client.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import rs.ac.bg.fon.ps.common.domain.Materijal;

public class MaterijalTableModel extends AbstractTableModel {

    private List<Materijal> listaMaterijala;
    private final String[] kolone = {"ID", "Naziv", "Cena"};

    public MaterijalTableModel() {
        listaMaterijala = new ArrayList<>();
    }

    public void setListaMaterijala(List<Materijal> listaMaterijala) {
        this.listaMaterijala = listaMaterijala;
        fireTableDataChanged();
    }

    public Materijal getMaterijalAt(int row) {
        return listaMaterijala.get(row);
    }

    @Override
    public int getRowCount() {
        return listaMaterijala.size();
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
        Materijal m = listaMaterijala.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return m.getMaterijalId();
            case 1:
                return m.getNaziv();
            case 2:
                return m.getCena();
            default:
                return "N/A";
        }
    }
}