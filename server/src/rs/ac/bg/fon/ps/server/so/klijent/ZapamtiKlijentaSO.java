/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ps.server.so.klijent;

import rs.ac.bg.fon.ps.common.domain.GenericEntity;
import rs.ac.bg.fon.ps.server.so.AbstractSO;

/**
 *
 * @author ognje
 */
public class ZapamtiKlijentaSO extends AbstractSO
{
    @Override
    protected void execute(GenericEntity entity) throws Exception {
        
        broker.save(entity);
    }

    @Override
    protected void validate(GenericEntity entity) throws Exception {
        
    }
}
