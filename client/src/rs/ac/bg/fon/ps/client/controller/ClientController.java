package rs.ac.bg.fon.ps.client.controller;

import java.util.List;
import rs.ac.bg.fon.ps.client.communication.Communication;
import rs.ac.bg.fon.ps.common.communication.Request;
import rs.ac.bg.fon.ps.common.communication.Response;
import rs.ac.bg.fon.ps.common.communication.ResponseType;
import rs.ac.bg.fon.ps.common.domain.GenericEntity;
import rs.ac.bg.fon.ps.common.domain.KategorijaKlijenta;
import rs.ac.bg.fon.ps.common.domain.Klijent;
import rs.ac.bg.fon.ps.common.domain.Kvalifikacija;
import rs.ac.bg.fon.ps.common.domain.Materijal;
import rs.ac.bg.fon.ps.common.domain.Usluga;
import rs.ac.bg.fon.ps.common.domain.Zubar;
import rs.ac.bg.fon.ps.common.operations.Operations;

public class ClientController {

    private static ClientController instance;

    private ClientController() {
    }

    public static ClientController getInstance() {
        if (instance == null) {
            instance = new ClientController();
        }
        return instance;
    }

    // ================== LOGIN ==================
    public Zubar login(Zubar zubar) throws Exception {
        Request request = new Request(Operations.LOGIN, zubar);
        Communication.getInstance().sendRequest(request);

        Response response = Communication.getInstance().receiveResponse();

        if (response.getResponseType() == ResponseType.SUCCESS) {
            return (Zubar) response.getResult();
        } else {
            throw response.getException();
        }
    }

    // ================== KLIJENT ==================
    public Klijent kreirajKlijenta() throws Exception {
        Request request = new Request(Operations.KREIRAJ_KLIJENTA, null);
        Communication.getInstance().sendRequest(request);

        Response response = Communication.getInstance().receiveResponse();
        if (response.getResponseType() == ResponseType.SUCCESS) {
            return (Klijent) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public void zapamtiKlijenta(Klijent klijent) throws Exception {
        Request request = new Request(Operations.ZAPAMTI_KLIJENTA, klijent);
        Communication.getInstance().sendRequest(request);

        Response response = Communication.getInstance().receiveResponse();
        if (response.getResponseType() != ResponseType.SUCCESS) {
            throw response.getException();
        }
    }

    public List<GenericEntity> getAllKlijent() throws Exception {
        Request request = new Request(Operations.GET_ALL_KLIJENT, null);
        Communication.getInstance().sendRequest(request);

        Response response = Communication.getInstance().receiveResponse();
        if (response.getResponseType() == ResponseType.SUCCESS) {
            return (List<GenericEntity>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public void deleteKlijent(Klijent klijent) throws Exception {
        Request request = new Request(Operations.DELETE_KLIJENT, klijent);
        Communication.getInstance().sendRequest(request);

        Response response = Communication.getInstance().receiveResponse();
        if (response.getResponseType() == ResponseType.ERROR) {
            throw response.getException();
        }
    }

    public List<GenericEntity> searchKlijent(Klijent klijent) throws Exception {
        Request request = new Request(Operations.SEARCH_KLIJENT, klijent);
        Communication.getInstance().sendRequest(request);

        Response response = Communication.getInstance().receiveResponse();
        if (response.getResponseType() == ResponseType.SUCCESS) {
            return (List<GenericEntity>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    // ================== USLUGA ==================
    public Usluga kreirajUslugu(Usluga u) throws Exception {
        Request request = new Request(Operations.KREIRAJ_USLUGU, u);
        Communication.getInstance().sendRequest(request);

        Response response = Communication.getInstance().receiveResponse();
        if (response.getResponseType() == ResponseType.SUCCESS) {
            return (Usluga) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public void zapamtiUslugu(Usluga u) throws Exception {
        Request request = new Request(Operations.ZAPAMTI_USLUGU, u);
        Communication.getInstance().sendRequest(request);

        Response response = Communication.getInstance().receiveResponse();
        if (response.getResponseType() == ResponseType.ERROR) {
            throw response.getException();
        }
    }

    public List<GenericEntity> getAllUsluga() throws Exception {
        Request request = new Request(Operations.GET_ALL_USLUGA, null);
        Communication.getInstance().sendRequest(request);

        Response response = Communication.getInstance().receiveResponse();
        if (response.getResponseType() == ResponseType.SUCCESS) {
            return (List<GenericEntity>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public List<GenericEntity> searchUsluga(Usluga u) throws Exception {
        Request request = new Request(Operations.SEARCH_USLUGA, u);
        Communication.getInstance().sendRequest(request);

        Response response = Communication.getInstance().receiveResponse();
        if (response.getResponseType() == ResponseType.SUCCESS) {
            return (List<GenericEntity>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public List<GenericEntity> getStavkeByUsluga(Usluga usluga) throws Exception {
        Request request = new Request(Operations.GET_STAVKE_BY_USLUGA, usluga);
        Communication.getInstance().sendRequest(request);

        Response response = Communication.getInstance().receiveResponse();
        if (response.getResponseType() == ResponseType.SUCCESS) {
            return (List<GenericEntity>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    // ================== SIFARNICI ==================
    public List<GenericEntity> getAllZubar() throws Exception {
        Request request = new Request(Operations.GET_ALL_ZUBAR, null);
        Communication.getInstance().sendRequest(request);

        Response response = Communication.getInstance().receiveResponse();
        if (response.getResponseType() == ResponseType.SUCCESS) {
            return (List<GenericEntity>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public List<GenericEntity> getAllMaterijal() throws Exception {
        Request request = new Request(Operations.GET_ALL_MATERIJAL, null);
        Communication.getInstance().sendRequest(request);

        Response response = Communication.getInstance().receiveResponse();
        if (response.getResponseType() == ResponseType.SUCCESS) {
            return (List<GenericEntity>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public List<GenericEntity> getAllKategorijaKlijenta() throws Exception {
        Request request = new Request(Operations.GET_ALL_KATEGORIJA_KLIJENTA, null);
        Communication.getInstance().sendRequest(request);

        Response response = Communication.getInstance().receiveResponse();
        if (response.getResponseType() == ResponseType.SUCCESS) {
            return (List<GenericEntity>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public List<GenericEntity> getAllKvalifikacija() throws Exception {
        Request request = new Request(Operations.GET_ALL_KVALIFIKACIJA, null);
        Communication.getInstance().sendRequest(request);

        Response response = Communication.getInstance().receiveResponse();
        if (response.getResponseType() == ResponseType.SUCCESS) {
            return (List<GenericEntity>) response.getResult();
        } else {
            throw response.getException();
        }
    }
    
    public void addKvalifikacija(Kvalifikacija kvalifikacija) throws Exception {
        Request request = new Request(Operations.ADD_KVALIFIKACIJA, kvalifikacija);
        Communication.getInstance().sendRequest(request);

        Response response = Communication.getInstance().receiveResponse();
        if (response.getResponseType() == ResponseType.ERROR) {
            throw response.getException();
        }
    }
}