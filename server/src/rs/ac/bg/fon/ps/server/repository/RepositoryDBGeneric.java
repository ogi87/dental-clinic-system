package rs.ac.bg.fon.ps.server.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import rs.ac.bg.fon.ps.common.domain.GenericEntity;
import rs.ac.bg.fon.ps.common.domain.Klijent;
import rs.ac.bg.fon.ps.common.domain.StavkaUsluge;
import rs.ac.bg.fon.ps.common.domain.Usluga;
import rs.ac.bg.fon.ps.common.domain.Zubar;
import rs.ac.bg.fon.ps.server.db.DbConnectionFactory;

public class RepositoryDBGeneric {

    // 1. GENERIČKO ČUVANJE (INSERT)
    public void save(GenericEntity entity) throws Exception {
        try {
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO ")
                    .append(entity.getTableName())
                    .append(" (").append(entity.getColumnNamesForInsert()).append(") ")
                    .append("VALUES (").append(entity.getInsertValues()).append(")");

            String query = sb.toString();
            System.out.println("Izvršavam upit: " + query);

            // RETURN_GENERATED_KEYS nam vraća ID koji je baza napravila (npr. za Uslugu ili Klijenta)
            Statement statement = connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);

            ResultSet rsKey = statement.getGeneratedKeys();
            if (rsKey.next()) {
                Long id = rsKey.getLong(1);
                entity.setId(id);
            }
            statement.close();
            rsKey.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Greška pri čuvanju objekta: " + ex.getMessage());
        }
    }

    // 2. GENERIČKO UČITAVANJE SVIH (SELECT *)
    public List<GenericEntity> getAll(GenericEntity entity) throws Exception {
        try {
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT ")
              .append(entity.getSelectValues()).append(" FROM ")
              .append(entity.getTableName()).append(" ")
              .append(entity.getAliases()).append(" ")
              .append(entity.getJoinClause());

            String query = sb.toString();
            System.out.println("Izvršavam upit: " + query);

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            List<GenericEntity> lista = entity.getListFromResultSet(rs);
            statement.close();
            rs.close();
            return lista;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Greška pri učitavanju objekata: " + ex.getMessage());
        }
    }

    // 3. GENERIČKA PRETRAGA SA USLOVOM (SELECT * WHERE...)
    public List<GenericEntity> getByCondition(GenericEntity entity) throws Exception {
        try {
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT ")
              .append(entity.getSelectValues()).append(" FROM ")
              .append(entity.getTableName()).append(" ")
              .append(entity.getAliases()).append(" ")
              .append(entity.getJoinClause()).append(" ")
              .append("WHERE ").append(entity.getWhereCondition());

            String query = sb.toString();
            System.out.println("Izvršavam upit: " + query);

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            List<GenericEntity> lista = entity.getListFromResultSet(rs);
            statement.close();
            rs.close();
            return lista;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Greška pri pretrazi objekata: " + ex.getMessage());
        }
    }

    // 4. GENERIČKA IZMENA (UPDATE)
    public void update(GenericEntity entity) throws Exception {
        try {
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append("UPDATE ")
                    .append(entity.getTableName())
                    .append(" SET ")
                    .append(entity.getUpdateSetClause())
                    .append(" WHERE ")
                    .append(entity.getPrimaryKeyColumnName()).append(" = ").append(entity.getPrimaryKeyValue());

            String query = sb.toString();
            System.out.println("Izvršavam upit: " + query);

            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Greška pri ažuriranju objekta: " + ex.getMessage());
        }
    }

    // 5. GENERIČKO BRISANJE PO ID-u (DELETE)
    public void delete(GenericEntity entity) throws Exception {
        try {
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append("DELETE FROM ")
                    .append(entity.getTableName())
                    .append(" WHERE ")
                    .append(entity.getPrimaryKeyColumnName()).append(" = ").append(entity.getPrimaryKeyValue());

            String query = sb.toString();
            System.out.println("Izvršavam upit: " + query);

            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Greška pri brisanju objekta: " + ex.getMessage());
        }
    }

    // 6. GENERIČKO BRISANJE PO USLOVU
    public void deleteByCondition(GenericEntity entity) throws Exception {
        try {
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append("DELETE FROM ")
                    .append(entity.getTableName())
                    .append(" WHERE ")
                    .append(entity.getWhereCondition());

            String query = sb.toString();
            System.out.println("Izvršavam upit: " + query);

            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Greška pri uslovnom brisanju: " + ex.getMessage());
        }
    }

}
