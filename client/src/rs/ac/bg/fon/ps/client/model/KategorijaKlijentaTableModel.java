package rs.ac.bg.fon.ps.client.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import rs.ac.bg.fon.ps.common.domain.KategorijaKlijenta;

public class KategorijaKlijentaTableModel extends AbstractTableModel {

    private List<KategorijaKlijenta> listaKategorija;
    private final String[] kolone = {"ID", "Naziv", "Popust"};

    public KategorijaKlijentaTableModel() {
        listaKategorija = new ArrayList<>();
    }

    public void setListaKategorija(List<KategorijaKlijenta> listaKategorija) {
        this.listaKategorija = listaKategorija;
        fireTableDataChanged();
    }

    public KategorijaKlijenta getKategorijaAt(int row) {
        return listaKategorija.get(row);
    }

    @Override
    public int getRowCount() {
        return listaKategorija.size();
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
        KategorijaKlijenta k = listaKategorija.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return k.getKategorijaId();
            case 1:
                return k.getNaziv();
            case 2:
                return k.getPopust();
            default:
                return "N/A";
        }
    }
}