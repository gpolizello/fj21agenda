package br.com.polizello.dao;

import br.com.polizello.jdbc.ConnectionFactory;
import br.com.polizello.model.Contato;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ContatoDao {
    //a conexão com o banco de dados
    private Connection connection;

    public ContatoDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void adiciona(Contato contato) {
        String sql = " INSERT INTO Contatos " +
                " (nome, email, endereco, dataNascimento) " +
                " values (?, ?, ? ,?)";

        try {
            PreparedStatement stm = connection.prepareStatement(sql);

            //Preenchendo os campos
            stm.setString(1, contato.getNome());
            stm.setString(2, contato.getEmail());
            stm.setString(3, contato.getEndereco());
            Date date = new Date(contato.getDataNascimento().getTimeInMillis());
            stm.setDate(4, date);

            //Executando o statement
            stm.execute();
            stm.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Contato> getLista() {
        try {
            List<Contato> contatos = new ArrayList<>();
            PreparedStatement stm = connection.prepareStatement("SELECT * FROM Contatos;");

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Contato contato = new Contato();
                contato.setId(rs.getLong("id"));
                contato.setNome(rs.getString("nome"));
                contato.setEmail(rs.getString("email"));
                contato.setEndereco(rs.getString("endereco"));

                Calendar data = Calendar.getInstance();
                data.setTime(rs.getDate("dataNascimento"));
                contato.setDataNascimento(data);

                contatos.add(contato);
            }

            return contatos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
