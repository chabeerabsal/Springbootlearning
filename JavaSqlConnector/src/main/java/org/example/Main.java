package org.example;
import java.sql.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        String url= "jdbc:mysql://localhost:3306/student";
        String user = "root";
        String password = "0000";
        String sql = "select * from studentsrecord";
        Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con= DriverManager.getConnection(url,user,password);
        System.out.println("Connected to database");
        Statement st=con.createStatement();
        // fetchStatement(sql,st);
         String sq1 = "insert into studentsrecord (name,age) values ('Shakila',47)";
         //crudStatement(sq1,st);
        String sq2 = "update studentsrecord set name='Rhiswanabegam' where id=3";
        //crudStatement(sq2,st);
        String sq3 = "DELETE FROM studentsrecord WHERE id BETWEEN 10 AND 11;";
        crudStatement(sq3,st);


        con.close();
        System.out.println("connection closed");


        }

    private static void crudStatement(String sq1, Statement st) throws SQLException {
        st.execute(sq1);
    }


    public static void fetchStatement(String sql,Statement st) throws SQLException {

        ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                System.out.print(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
                System.out.println();
            }
        }
    }