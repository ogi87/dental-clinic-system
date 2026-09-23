/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ps.server.so.usluga;

import rs.ac.bg.fon.ps.common.domain.GenericEntity;
import rs.ac.bg.fon.ps.common.domain.StavkaUsluge;
import rs.ac.bg.fon.ps.common.domain.Usluga;
import rs.ac.bg.fon.ps.server.so.AbstractSO;

/**
 *
 * @author ognje
 */
public class ZapamtiUsluguSO extends AbstractSO {

    @Override
    protected void validate(GenericEntity entity) throws Exception {

        if (!(entity instanceof Usluga)) {
            throw new Exception("Prosledjeni objekat nije tipa Usluga.");
        }

        Usluga usluga = (Usluga) entity;

        if (usluga.getUslugaId() == null) {
            throw new Exception("Usluga mora imati ID za izmenu.");
        }

        if (usluga.getNaziv() == null || usluga.getNaziv().trim().isEmpty()) {
            throw new Exception("Naziv usluge je obavezan.");
        }

        if (usluga.getStavke() == null || usluga.getStavke().isEmpty()) {
            throw new Exception("Usluga mora imati bar jednu stavku.");
        }
    }

    @Override
    protected void execute(GenericEntity entity) throws Exception {

        Usluga usluga = (Usluga) entity;

        broker.update(usluga);

        StavkaUsluge stavkaZaBrisanje = new StavkaUsluge();
        stavkaZaBrisanje.setUsluga(usluga);
        broker.deleteByCondition(stavkaZaBrisanje);

        int rb = 1;
        for (StavkaUsluge stavka : usluga.getStavke()) {
            stavka.setUsluga(usluga);
            stavka.setRb(rb++);
            broker.save(stavka);
        }
    }
}
