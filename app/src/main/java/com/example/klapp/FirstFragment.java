package com.example.klapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.klapp.databinding.FragmentFirstBinding;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    ResultSet results = null;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }
    // ACHTUNG DIESE FUNKTION UNSICHER MUSS NOCH MIT ZWISCHEN Handler(Server) gemacht werden
    public ResultSet DbConnection() throws SQLException {
        /*
        final String JdbcUrl = "jdbc:mysql://xserv:3306/klapp";
        final String user = "klapp";
        final String password = "superklapp";
        */

        //LoginData für WimmerHomeOffice
        final String JdbcUrl = "jdbc:mysql://localhost:3306";
        final String user = "root";
        final String password = "my-secret-pw";

        Connection connection = DriverManager.getConnection(JdbcUrl,user,password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Account");

        while (resultSet.next()){
            System.out.println(resultSet.toString());
            System.out.println(resultSet.getString("username"));
            String DbUsernames = resultSet.getString("username");
            System.out.println(resultSet.getString("email"));
        }


        statement.close();
        resultSet.close();
        connection.close();

        return resultSet;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        try {
            results =  DbConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        binding.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                    try {
                       while (!Objects.equals(results.getString("username"), binding.usernameEditText.toString())){
                           // for password also needed &&
                           System.out.println("USER NOT FOUND");
                        }
                        System.out.println("USER FOUND");
                        NavHostFragment.findNavController(FirstFragment.this)
                                .navigate(R.id.action_FirstFragment_to_SecondFragment);



                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }


            }
        });
    }




    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}