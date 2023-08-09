package com.carmona.app.rutas.filter;


import com.carmona.app.rutas.utils.ConexionBD;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;
import java.sql.Connection;

@WebFilter("/*")
public class ConexionFilter implements Filter {
    private Connection getConnection(){
        ConexionBD c = new ConexionBD();
        return c.getInstance();
    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        Connection conn = this.getConnection();//conexion a la bd
        servletRequest.setAttribute("conn",conn);
        try{
            filterChain.doFilter(servletRequest,servletResponse);

        }catch (ServletException e){
            throw new RuntimeException(e);
        }


    }
}
