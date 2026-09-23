package rs.ac.bg.fon.ps.client.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import rs.ac.bg.fon.ps.common.domain.Zubar;

public class ZubarTableModel extends AbstractTableModel {

    private List<Zubar> listaZubara;
    private final String[] kolone = {"ID", "Ime", "Prezime", "Korisnicko ime", "Sifra"};

    public ZubarTableModel() {
        listaZubara = new ArrayList<>();
    }

    public void setListaZubara(List<Zubar> listaZubara) {
        this.listaZubara = listaZubara;
        fireTableDataChanged();
    }

    public Zubar getZubarAt(int row) {
        return listaZubara.get(row);
    }

    @Override
    public int getRowCount() {
        return listaZubara.size();
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
        Zubar z = listaZubara.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return z.getZubarId();
            case 1:
                return z.getIme();
            case 2:
                return z.getPrezime();
            case 3:
                return z.getKorisnickoIme();
            case 4:
                return z.getSifra();
            default:
                return "N/A";
        }
    }
}