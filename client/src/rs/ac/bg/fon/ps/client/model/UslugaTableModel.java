package rs.ac.bg.fon.ps.client.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import rs.ac.bg.fon.ps.common.domain.Usluga;

public class UslugaTableModel extends AbstractTableModel {

    private List<Usluga> listaUsluga;
    private final String[] kolone = {
        "ID", "Naziv", "Ukupan iznos", "Popust", "Ukupno sa popustom", "Zubar", "Klijent"
    };

    public UslugaTableModel() {
        listaUsluga = new ArrayList<>();
    }

    public void setListaUsluga(List<Usluga> listaUsluga) {
        this.listaUsluga = listaUsluga;
        fireTableDataChanged();
    }

    public Usluga getUslugaAt(int row) {
        return listaUsluga.get(row);
    }

    @Override
    public int getRowCount() {
        return listaUsluga.size();
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
        Usluga u = listaUsluga.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return u.getUslugaId();
            case 1:
                return u.getNaziv();
            case 2:
                return u.getUkupanIznos();
            case 3:
                return u.getPopust();
            case 4:
                return u.getUkupanIznosSaPopustom();
            case 5:
                return u.getZubar().getIme() + " " + u.getZubar().getPrezime();
            case 6:
                return u.getKlijent().getIme() + " " + u.getKlijent().getPrezime();
            default:
                return "N/A";
        }
    }
}