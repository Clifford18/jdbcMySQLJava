import java.sql.*;

public class MyJDBCDriver {
    public static void main(String[] args){

        Connection myConn = null; ;
        Statement myStatement = null; ;
        ResultSet myResult = null;

        try {

        myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management_system","root","Pa55w0rd");

        myStatement = myConn.createStatement();

        myResult = myStatement.executeQuery("select * from tasks");

        while (myResult.next()){
            System.out.println(myResult.getString("task_id"));
        }
        myResult.close();
        myStatement.close();
        myConn.close();

        myConn =null; myStatement = null; myResult = null;

        }
        catch (Exception e){
            e.printStackTrace();
            if(myResult != null) try { myResult.close(); } catch (SQLException ignore) {}
            if(myStatement != null) try { myStatement.close(); } catch (SQLException ignore) {}
            if(myConn != null) try { myConn.close(); } catch (SQLException ignore) {}

            myConn = null; myStatement = null; myResult = null;
        }  finally {
            if(myResult != null) try { myResult.close(); } catch (SQLException ignore) {}
            if(myStatement != null) try { myStatement.close(); } catch (SQLException ignore) {}
            if(myConn != null) try { myConn.close(); } catch (SQLException ignore) {}

            myConn = null; myStatement = null; myResult = null;
        }


    }
}