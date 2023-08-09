package com.carmona.app.rutas.controllers;

import com.carmona.app.rutas.models.Chofer;
import com.carmona.app.rutas.services.ChoferesService;
import com.carmona.app.rutas.services.IService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebFilter("/choferes/listar")
public class ListaChoferesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //recuperamos un objeto
        Connection conn = (Connection)  req.getAttribute("name");
        //declaramos un objeto de tipo servicio

        IService<Chofer> service = new ChoferesService(conn);
        List<Chofer> choferes = service.listar();

       /*
       *  for(int i = 0; i < choferes.size();i++){
            resp.getWriter().println("<h1>"+ choferes.get(i).getId()+"->"
            + choferes.get(i).getNombre()+"->"+choferes.get(i).getApMaterno()
            +"<h1>");
        }*/

        req.setAttribute("choferes",choferes);
        getServletContext().getRequestDispatcher("/listaChoferes.jsp").forward(req,resp);
    }
}
