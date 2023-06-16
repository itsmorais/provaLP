package Dao;

import Factory.ConnectionFactory;
import java.sql.*;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import Model.Aluno;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {
    private final Connection connection;

    public AlunoDAO() {
        this.connection = ConnectionFactory.getConexaoMySQL();

    }

    public void cadastrarAluno(Aluno aluno) {
        String sql = "INSERT INTO aluno(aluno_nome,data_nascimento,peso,altura,cpf)\n" +
                "VALUES(?,?,?,?,?);";

        try (PreparedStatement stmt = connection.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, aluno.getNome());
            stmt.setDate(2, java.sql.Date.valueOf(LocalDate.parse(aluno.getDataNascimento())));
            stmt.setFloat(3, aluno.getPeso());
            stmt.setFloat(4, aluno.getAltura());
            stmt.setLong(5, aluno.getCpf());

            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }

    }

    public void deleteAluno(long cpf) {
        String sql = "DELETE from aluno where cpf = ?;";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, cpf);
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }

    }

    public void updateAluno(Aluno aluno) {
        String sql = "UPDATE aluno SET aluno_nome = ?,peso = ?,altura = ? WHERE cpf = ?;";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, aluno.getNome());
            stmt.setFloat(2, aluno.getPeso());
            stmt.setFloat(3, aluno.getAltura());
            stmt.setLong(4, aluno.getCpf());

            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }

    public List<Aluno> buscarAlunos() {
        List<Aluno> alunos = new ArrayList<>();

        String sql = "SELECT * from provaLP.aluno";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    String alunoNome = rs.getString("aluno_nome");
                    String data = rs.getDate("data_nascimento").toString();
                    float peso = rs.getFloat("peso");
                    float altura = rs.getFloat("altura");
                    long cpf = rs.getLong("cpf");
                    Aluno novoAluno = new Aluno(cpf, alunoNome, peso, altura, data);
                    alunos.add(novoAluno);

                }
            } catch (SQLException e) {
                throw new RuntimeException(e);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        return alunos;

    }

    public String interpretadorDeIMC(String imc) {
        imc = imc.replace(',', '.');
        float imcFloat = Float.parseFloat(imc);
        String mensagem = "Interpretação do resultado imc de acordo com a OMS: ";

        if (imcFloat < 16) {
            mensagem += "Magreza grave";
        } else if (imcFloat >= 16 && imcFloat <= 17) {
            mensagem += "Magreza moderada";
        } else if (imcFloat >= 17 && imcFloat <= 18.5) {
            mensagem += "Magreza leve";
        } else if (imcFloat >= 18.5 && imcFloat <= 25) {
            mensagem += "Saudável";
        } else if (imcFloat >= 25 && imcFloat <= 30) {
            mensagem += "Sobrepeso";
        } else if (imcFloat >= 30 && imcFloat <= 35) {
            mensagem += "Obesidade grau I";
        } else if (imcFloat >= 35 && imcFloat <= 40) {
            mensagem += "Obesidade grau III (Obesidade severa)";
        } else {
            mensagem += "Obesidade grau III (Obesidade mórbida)";
        }

        return mensagem;
    }

    public List<Aluno> pesquisarAluno(String nome) {
        List<Aluno> alunos = new ArrayList<>();

        String sql = "SELECT * from provaLP.aluno where aluno_nome LIKE ?; ";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, "%" + nome + "%");

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    String alunoNome = rs.getString("aluno_nome");
                    String data = rs.getDate("data_nascimento").toString();
                    float peso = rs.getFloat("peso");
                    float altura = rs.getFloat("altura");
                    long cpf = rs.getLong("cpf");
                    Aluno novoAluno = new Aluno(cpf, alunoNome, peso, altura, data);
                    alunos.add(novoAluno);

                }
            } catch (SQLException e) {
                throw new RuntimeException(e);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        return alunos;

    }

}
