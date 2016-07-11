package DataBase;

import Beans.Admin;
import Beans.Movie;
import Beans.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {

    private Connection connect = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    public Database() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/movie_rent", "root", "123456789");
            statement = connect.createStatement();
            System.out.println("connected");
        } catch (SQLException ex) {
            System.out.println("not connected");
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
public ArrayList<String> getMoviesRentedBy(String u_ID) {

        ArrayList<String> names = new ArrayList<>();
        String query = "SELECT m_name FROM movie WHERE u_ID = " + u_ID ;
        try {
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {

                names.add(resultSet.getString("m_name"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(names);
        return names;

    }
    
    public boolean checkLogin(Admin admin) {
        String query = "SELECT * FROM admin ";

        try {
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                if (resultSet.getString("a_email").equals(admin.getEmail())
                        && resultSet.getString("a_password").equals(admin.getPassword())) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean checkCreditCard(String userID,String userCredit) {
        String query = "SELECT u_credit from user where u_id = " + userID;

        try {
            resultSet = statement.executeQuery(query);
            String credit = "";
            while (resultSet.next()) {
                credit = resultSet.getString(1);
                if (credit.equals(userCredit))
                    return true;
            }
            //return credit;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public Movie getMovieDetails(String movieName) {

        String query = "SELECT * FROM movie";
        try {
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                if (resultSet.getString("m_name").equals(movieName) == true) {
                    String nameOfThMovie = resultSet.getString("m_name");
                    String description = resultSet.getString("m_descripition");
                    String releaseDate = resultSet.getString("m_releaseDate");
                    float rate = resultSet.getFloat("m_rate");
                    double price = resultSet.getDouble("m_price");
                    boolean isRented = resultSet.getBoolean("m_isRent");
                    int id=resultSet.getInt("m_id");
                    Movie movie = new Movie(id,movieName, releaseDate, description, rate, price, isRented);
                    return movie;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Movie getMovieDetails2(String movieName) {

        String query = "SELECT * FROM movie";
        try {
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                if (resultSet.getString("m_name").equals(movieName) == true) {
                    String nameOfThMovie = resultSet.getString("m_name");
                    String description = resultSet.getString("m_descripition");
                    String releaseDate = resultSet.getString("m_releaseDate");
                    float rate = resultSet.getFloat("m_rate");
                    double price = resultSet.getDouble("m_price");
                    boolean isRented = resultSet.getBoolean("m_isRent");
                    String startDate = resultSet.getString("m_sDate");
                    String endDate = resultSet.getString("m_eDate");
                    Movie movie = new Movie(movieName, releaseDate, description,startDate,endDate, rate, price, isRented);
                    return movie;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Movie getMovieDetailsByID(String movieID) {

        String query = "SELECT * FROM movie";
        try {
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                if (resultSet.getString("m_ID").equals(movieID) == true) {
                    String nameOfThMovie = resultSet.getString("m_name");
                    String description = resultSet.getString("m_descripition");
                    String releaseDate = resultSet.getString("m_releaseDate");
                    float rate = resultSet.getFloat("m_rate");
                    double price = resultSet.getDouble("m_price");
                    boolean isRented = resultSet.getBoolean("m_isRent");
                    Movie movie = new Movie(nameOfThMovie, releaseDate, description, rate, price, isRented);
                    return movie;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public int getNumberOfAdmins() {
        String query = "SELECT * FROM admin ";
        int count = 0;
        try {
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                count++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

    public ArrayList<String> getMoviesNames() {
        ArrayList<String> names = new ArrayList<>();
        String query = "SELECT m_name FROM movie ";
        try {
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                names.add(resultSet.getString("m_name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(names);
        return names;
    }

    public boolean insertNewAdmin(Admin admin) {

        // hwa el id dah auto increament (L2)
        if (checkLogin(admin) == true) {
            return false;
        } else {
            int id = getNumberOfAdmins();
            System.out.println(id);
            id = id + 1;
            System.out.println("id " + id);
            String query = " insert into admin (a_id, a_fname,a_lname,a_email, a_password)"
                    + " values (?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt;
            try {
                preparedStmt = connect.prepareStatement(query);
                preparedStmt.setInt(1, id);
                preparedStmt.setString(2, admin.getFirstName());
                preparedStmt.setString(3, admin.getLastName());
                preparedStmt.setString(4, admin.getEmail());
                preparedStmt.setString(5, admin.getPassword());
                preparedStmt.execute();
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        close();
        return true;
    }

    public int getNumberOfMovies() {
        String query = "SELECT * FROM movie ";
        int count = 0;
        try {
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                count++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

    public boolean insertNewMovie(Movie movie, int adminId) {
        int movieId = getNumberOfMovies();
        movieId++;

        String query = "insert into movie (m_id,a_id,m_name,m_releaseDate,m_descripition,m_rate,m_price,m_isRent)"
                + " values (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStmt;
        try {
            preparedStmt = connect.prepareStatement(query);
            preparedStmt.setInt(1, movieId);
            preparedStmt.setInt(2, adminId);
            preparedStmt.setString(3, movie.getMovieName());
            preparedStmt.setString(4, movie.getReleaseDate());
            preparedStmt.setString(5, movie.getDescription());
            preparedStmt.setFloat(6, movie.getRate());
            preparedStmt.setDouble(7, movie.getPrice());
            preparedStmt.setBoolean(8, false);
            preparedStmt.execute();
            System.out.println("movie inserted");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("movie not  inserted");

        }
        close();
        return false;
    }

    public int getIdOfCurrentAdmin(Admin admin) {
        String query = "SELECT * FROM admin ";

        try {
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                if (resultSet.getString("a_email").equals(admin.getEmail())
                        && resultSet.getString("a_password").equals(admin.getPassword())) {
                    return resultSet.getInt("a_id");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return -1;
    }

    public boolean inserNewUser(User user) {

        String query = "insert into user (u_fname,u_lname,u_email,u_password , u_credit) "
                + " values (?, ?, ?, ?, ?)";
        PreparedStatement preparedStmt;
        try {
            preparedStmt = connect.prepareStatement(query);
            preparedStmt.setString(1, user.Fname);
            preparedStmt.setString(2, user.Lname);
            preparedStmt.setString(3, user.Email);
            preparedStmt.setString(4, user.Password);
            preparedStmt.setString(5, user.Credit);

            preparedStmt.execute();
            System.out.println("user inserted");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("movie not  inserted");

        }
        close();
        return false;

    }

    public boolean checkEmail(String email) {
        try {
            String query = "select * from user";
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                if (resultSet.getString("u_email").equals(email)) {
                    return true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean checkUser(String email, String pass) {
        try {
            String query = "select * from user";
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                if (resultSet.getString("u_email").equals(email) && resultSet.getString("u_password").equals(pass)) {
                    return true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<String> getMovieNotRent() {

        ArrayList<String> names = new ArrayList<>();
        String query = "SELECT m_name FROM movie WHERE m_isRent = 0 ";
        try {
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {

                names.add(resultSet.getString("m_name"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(names);
        return names;

    }
    
    public ArrayList<String> getMovieNotRentId() {

        ArrayList<String> namesAndIds = new ArrayList<>();
        String query = "SELECT m_name, m_id FROM movie WHERE m_isRent = 1 ";
        try {
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {

                namesAndIds.add(resultSet.getString("m_name"));
                namesAndIds.add(resultSet.getString("m_id"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return namesAndIds;

    }
    
    
    public ArrayList<String> getMoviesIDRentedBy(String u_ID) {

        ArrayList<String> names = new ArrayList<>();
        String query = "SELECT m_ID FROM movie WHERE u_ID = " + u_ID ;
        try {
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {

                names.add(resultSet.getString(1));

            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(names);
        return names;

    }
    
    
    public void updateRentedMovie(int id ){
        
     String query = "update movie set u_id =null , m_isRent = 0 , m_sDate =null , m_eDate = null where m_id = "+id;
        try {
            int row = statement.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 
    
    public String getUserId(String email, String Password) {
        String query = "select u_id from user where u_email = '" + email + "' and u_password = '" + Password + "'";
        try {
            resultSet = statement.executeQuery(query);
            String id = null;
            while (resultSet.next()) {
                id = resultSet.getString("u_id");
            }

            return id;
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }
    
     public String getMovieId(String name, String releaseDate) {
        String query = "select m_id from movie where m_name = '" + name + "' and m_releaseDate = '" + releaseDate + "'";
        try {
            resultSet = statement.executeQuery(query);
            String id = null;
            while (resultSet.next()) {
                id = resultSet.getString("m_id");
            }

            return id;
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    public User getDate(String email) {

        String query = "select * from user where u_email = '" + email + "'";
        try {
            resultSet = statement.executeQuery(query);
            User user = new User();
            while (resultSet.next()) {

                user.Fname = resultSet.getString("u_fname");
                user.Lname = resultSet.getString("u_lname");
                user.Email = resultSet.getString("u_email");
                user.Password = resultSet.getString("u_password");
                user.Credit = resultSet.getString("u_credit");

            }

            return user;
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }
    
    public int rentMovie(String u_id , String m_id , String SDate , String EDate) {
     String query = "update movie set u_id = "+u_id+" , m_isRent = 1 , m_sDate = '"+SDate+"' , m_eDate = '"+EDate+"' where m_id = "+m_id;
        try {
            int row = statement.executeUpdate(query);
            return row;
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public Movie getMovieDetailsByID(int movieID) {

        String query = "SELECT * FROM movie";
        try {
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                if (resultSet.getInt("m_ID") == movieID) {
                    String nameOfThMovie = resultSet.getString("m_name");
                    String description = resultSet.getString("m_descripition");
                    String releaseDate = resultSet.getString("m_releaseDate");
                    float rate = resultSet.getFloat("m_rate");
                    double price = resultSet.getDouble("m_price");
                    boolean isRented = resultSet.getBoolean("m_isRent");
                    //int ID=resultSet.getInt("m_id");
                    Movie movie = new Movie(movieID, nameOfThMovie, releaseDate, description, rate, price, isRented);
                    return movie;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
        public boolean UpdateMovie(Movie movie, int adminId) {

        System.out.println(movie.getID() +""+
        movie.getMovieName()+""+movie.getReleaseDate()+""+movie.getDescription()+""+movie.getPrice());
        String UQuery = "update movie  set a_id="+adminId+","
                + "m_name='"+movie.getMovieName()+"',"
                +"m_releaseDate='"+movie.getReleaseDate()+"',"
                + "m_descripition='"+movie.getDescription()+"' ,"
                + "m_rate="+movie.getRate()+" ,"
                + "m_price="+movie.getPrice()
                + "where m_id="+movie.getID();
      
        
        //String UQuery="update movie  set a_id=\"+adminId"
          //      + "";
        //String UQuery="update movie  set a_id=1 ,m_name= 'Movie1' ,m_releaseDate=2010 ,m_descripition='Film Laziz awy w7yatk' , m_rate=8 ,m_price=25  where m_id=1";
        try {
            int n=statement.executeUpdate(UQuery);
            if (n > 0) {
                System.out.println("movie Updated");
                return true;
            } else {
                System.out.println("movie not Updated");
                return false;
            }

            //return true;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("movie not Updated");

        }
        close();
        return false;
    }

 public int rentMovie(String m_id , Movie movie) {
        String query = "update movie set  m_eDate = '"+movie.getEndDate()+"' where m_id = "+m_id;
        try {
            int row = statement.executeUpdate(query);
            return row;
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
   
    public int updateUser(User user , String u_id) {
        String query = "update user set u_fname = '"+user.Fname+"' , u_lname = '"+user.Lname+"' , u_email = '"+user.Email+"' , u_password = '"+user.Password+"' , u_credit = "+user.Credit+" where u_id = "+u_id;
        System.out.println(query);
        try {
            int row = statement.executeUpdate(query);
            return row;
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    // You need to close the resultSet
    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }

}
