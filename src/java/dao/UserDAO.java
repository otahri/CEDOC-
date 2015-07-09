/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import authenti.LoginBean;
import java.sql.*;

public class UserDAO {

    public static String login(String user, String password) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = Database.getConnection();
            ps = con.prepareStatement(
                    "select * from utilisateur where Login= ? and Mot_passe= ? ");

            ps.setString(1, user);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) // found
            {

                System.out.println(rs.getString("Login"));
                System.out.println(rs.getString("Role"));

                return rs.getString("Role");
            } else {
                return null;
            }
        } catch (Exception ex) {
            System.out.println("Error in login() -->" + ex.getMessage());
            return ex.toString();
        } finally {
            Database.close(con);
        }
    }

    public static String exist(String pass) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = Database.getConnection();
            ps = con.prepareStatement(
                    "select * from doctorant where code= ? ");

            ps.setString(1, pass);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) // found
            {

                System.out.println(rs.getString("Nom"));

                return rs.getString("Nom");
            } else {
                return null;
            }
        } catch (Exception ex) {
            System.out.println("Error  -->" + ex.getMessage());
            return ex.toString();
        } finally {
            Database.close(con);
        }
    }
    
    
    public static int iddoc(String pass) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = Database.getConnection();
            ps = con.prepareStatement(
                    "select * from doctorant where code= ? ");

            ps.setString(1, pass);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) // found
            {

                System.out.println(rs.getInt("idDoctorant"));

                return rs.getInt("idDoctorant");
            } else {
                return 0;
            }
        } catch (Exception ex) {
            System.out.println("Error  -->" + ex.getMessage());
            return 0;
        } finally {
            Database.close(con);
        }
    }
    
    
    public static String etat(int id) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = Database.getConnection();
            ps = con.prepareStatement(
                    "select * from inscription where id_doctorant= ? ");

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) // found
            {

                System.out.println(rs.getString("etat"));

                return rs.getString("etat");
            } else {
                return null;
            }
        } catch (Exception ex) {
            System.out.println("Error  -->" + ex.getMessage());
            return ex.toString();
        } finally {
            Database.close(con);
        }
    }
    
    
    

//    public static String logRole(String user, String password) throws SQLException {
//
//        Connection con = null;
//        PreparedStatement ps = null;
//
//        con = Database.getConnection();
//        ps = con.prepareStatement(
//                "select * from utilisateur where Login= ? and Mot_passe= ? ");
//
//        ps.setString(1, user);
//        ps.setString(2, password);
//
//        ResultSet rs = ps.executeQuery();
//
//        return rs.getString("Role");
//
//    }
}
