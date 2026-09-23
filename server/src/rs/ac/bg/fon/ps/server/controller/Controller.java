package rs.ac.bg.fon.ps.server.controller;

import java.util.List;
import rs.ac.bg.fon.ps.common.domain.GenericEntity;
import rs.ac.bg.fon.ps.common.domain.Klijent;
import rs.ac.bg.fon.ps.common.domain.Materijal;
import rs.ac.bg.fon.ps.common.domain.Usluga;
import rs.ac.bg.fon.ps.common.domain.Zubar;
import rs.ac.bg.fon.ps.common.domain.KategorijaKlijenta;
import rs.ac.bg.fon.ps.common.domain.Kvalifikacija;
import rs.ac.bg.fon.ps.server.so.klijent.*;
import rs.ac.bg.fon.ps.server.so.login.LoginSO;
import rs.ac.bg.fon.ps.server.so.materijal.*;
import rs.ac.bg.fon.ps.server.so.usluga.*;
import rs.ac.bg.fon.ps.server.so.zubar.*;
import rs.ac.bg.fon.ps.server.so.kategorijaklijenta.*;
import rs.ac.bg.fon.ps.server.so.kvalifikacija.*;

public class Controller {

    private static Controller instance;

    private Controller() {
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    // ================== LOGIN ==================
    public Zubar login(Zubar zubar) throws Exception {
        LoginSO so = new LoginSO();
        so.templateExecute(zubar);
        return so.getUlogovaniZubar();
    }
    
    // ================== KLIJENT ==================
    public Klijent kreirajKlijenta() throws Exception {
        KreirajKlijentaSO so = new KreirajKlijentaSO();
        so.templateExecute(new Klijent()); 
        return so.getKlijent();
    }

    public void zapamtiKlijenta(Klijent klijent) throws Exception {
        ZapamtiKlijentaSO so = new ZapamtiKlijentaSO();
        so.templateExecute(klijent);
    }

    public List<GenericEntity> getAllKlijent() throws Exception {
        GetAllKlijentSO so = new GetAllKlijentSO();
        so.templateExecute(new Klijent());
        return so.getLista();
    }

    public void deleteKlijent(Klijent klijent) throws Exception {
        DeleteKlijentSO so = new DeleteKlijentSO();
        so.templateExecute(klijent);
    }

    public List<GenericEntity> searchKlijent(Klijent klijent) throws Exception {
        SearchKlijentSO so = new SearchKlijentSO();
        so.templateExecute(klijent); 
        return so.getLista();
    }

    // ================== USLUGA ==================
    public Usluga kreirajUslugu(Usluga usluga) throws Exception {
        KreirajUsluguSO so = new KreirajUsluguSO();
        so.templateExecute(usluga);
        return usluga; 
    }

    public void zapamtiUslugu(Usluga usluga) throws Exception {
        ZapamtiUsluguSO so = new ZapamtiUsluguSO();
        so.templateExecute(usluga);
    }

    public List<GenericEntity> getAllUsluga() throws Exception {
        GetAllUslugaSO so = new GetAllUslugaSO();
        so.templateExecute(new Usluga());
        return so.getLista();
    }

    public List<GenericEntity> searchUsluga(Usluga u) throws Exception {
        SearchUslugaSO so = new SearchUslugaSO();
        so.templateExecute(u);
        return so.getLista();
    }

    public List<GenericEntity> getStavkeByUsluga(Usluga usluga) throws Exception {
        GetStavkeByUslugaSO so = new GetStavkeByUslugaSO();
        so.templateExecute(usluga);
        return so.getLista();
    }

    // ================== SIFARNICI ==================
    public List<GenericEntity> getAllMaterijal() throws Exception {
        GetAllMaterijalSO so = new GetAllMaterijalSO();
        so.templateExecute(new Materijal());
        return so.getLista();
    }

    public List<GenericEntity> getAllZubar() throws Exception {
        GetAllZubarSO so = new GetAllZubarSO();
        so.templateExecute(new Zubar());
        return so.getLista();
    }

    public List<GenericEntity> getAllKategorijaKlijenta() throws Exception {
        GetAllKategorijaKlijentaSO so = new GetAllKategorijaKlijentaSO();
        so.templateExecute(new KategorijaKlijenta());
        return so.getLista();
    }

    public List<GenericEntity> getAllKvalifikacija() throws Exception {
        GetAllKvalifikacijaSO so = new GetAllKvalifikacijaSO();
        so.templateExecute(new Kvalifikacija());
        return so.getLista();
    }
    
    public void addKvalifikacija(Kvalifikacija kvalifikacija) throws Exception {
        AddKvalifikacijaSO so = new AddKvalifikacijaSO();
        so.templateExecute(kvalifikacija);
    }
}