package com.example.jramirez.tuparking;

        import java.sql.*;


// a database class to create a data base object
public class DBConnect {
    private Connection con = null;
    private Statement st;
    private ResultSet rs;

    // try to connect to data base
    public DBConnect(){
        try{
            //Class.forName("com.mysql.jdbc.Driver").newInstance();
            System.out.println("Found Class");
            try{
                con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/test" + "user=root&password=");
                System.out.println("did it work??");

            }catch (Exception ex){
                ex.printStackTrace();
                System.out.println("cant with url");
            }
            //st = con.createStatement();

        }catch (Exception ex){
            ex.printStackTrace();
            System.out.println("Error: " + ex);
        }
    }

    public void getData(){
        try{
            String query = "select * from parking_lots";
            rs = st.executeQuery(query);
            System.out.println("Records from database:");
            while (rs.next()){
                String name = rs.getString("name");
                String number_of_spots = rs.getString("number_of_spots");
                System.out.println("Name: " + name + "  Spots: " + number_of_spots );
            }
        }catch (Exception ex){
            System.out.println(ex);
        }
    }

}
