package br.com.polizello.servlet;

import br.com.polizello.dao.ContatoDao;
import br.com.polizello.model.Contato;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@WebServlet("/adicionaContato")
public class AdicionaContatoServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        log("Iniciando a servlet");
    }

    @Override
    public void destroy() {
        super.destroy();
        log("Destruindo a servlet");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        //pegando os parâmetros do request
        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        String email = request.getParameter("email");
        String dataEmTexto = request.getParameter("dataNascimento");
        Calendar dataNascimento = null;

        //fazendo a conversão da data
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
            dataNascimento = Calendar.getInstance();
            dataNascimento.setTime(date);
        } catch (ParseException e) {
            out.println("Erro de conversão da data");
            return;    //para a execução do método
        }
        //monta um objeto contato
        Contato contato = new Contato();
        contato.setNome(nome);
        contato.setEndereco(endereco);
        contato.setEmail(email);
        contato.setDataNascimento(dataNascimento);
        // salva o contato
        ContatoDao dao = new ContatoDao();
        dao.adiciona(contato);
        // imprime o nome do contato que foi adicionado
        out.println("<%@\tpage import=\"java.util.*, br.com.polizello.dao.*, br.com.polizello.model.*, java.text.*\" language=\"java\" contentType=\"text/html; charset=UTF-8\" pageEncoding=\"UTF-8\"%>");
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<body>");
        out.println("Contato " + contato.getNome() + " adicionado com sucesso");
        out.println("</body>");
        out.println("</html>");
    }
}
