import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Serv02
 */
@WebServlet("/serv02")
public class Serv02 extends HttpServlet {
	private static final long serialVersionUID = 101L;

    public Serv02() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String msgHead = "<html> <title>Server de Practica - Arquitectura y Servicios Distribuidos</title>\n<body><br>";
		String msgTail = "</body> </html>";
        String resp, aux1, aux2;
        float res1, res2 = 0;
    	resp = msgHead+"<H1><body><p style=\"color:blue\">Convertidor de monedas.</body></H2><hr><i><body><p style=\"color:red\"></body><br> "
        		+ "Escriba el valor que desea convertir:</i> <br>\n"
        		+ "<form action= \"Serv02\" name=\"calc\" method=\"post\">\n"
        		+ "	<h3>Cantidad: <input type=\"text\" name=\"cantidad\" size=\"20\"> </h3>\n"
        		+ "	Tipos de conversion:\n"
        		+ "	<select name=\"conv\" size=\"1\" align=\"left\" >\n"
        		+ "	<option value=\"1\"> USD --> Euros </option>\n"
        		+ "	<option value=\"2\"> Euros --> USD </option>\n"
        		+ "	</select>\n"
        		+ "<input type=\"submit\" name=\"submit\" value=\"Convertir\" >\n"
        		+ "<input type=\"submit\" name=\"submit\" value=\"Recargar\" >\n</form>\n";
        if (request.getQueryString()!=null) {
          aux1 = request.getParameter("submit");
          if (aux1.equalsIgnoreCase("Convertir")) {
        	aux1 = request.getParameter("cantidad");
        	aux2 = request.getParameter("conv");
        	
            if (!aux1.equalsIgnoreCase("") && aux1!=null) {
            	res1 = Float.parseFloat(aux1);
            	if (aux2.equalsIgnoreCase("1")) {
            		//HACER LA OPERACION Y GUARDAR RESULTADO EN res2
            		res2 = (float) (res1 / 1.05);
            		resp = resp +"<br> Resultado: "+ res1 +" USD equivalen a "+ res2 +"Euros.<br>"+msgTail;
            	}else if (aux2.equalsIgnoreCase("2")) {
            		//HACER LA OPERACION Y GUARDAR RESULTADO EN res2
            		res2 = (float) (res1 * 1.05);
            		resp = resp +"<br> Resultado: "+ res1 +" Euros equivalen a "+ res2 +"USD.<br>"+msgTail;
        		
            	}else {
            		resp = resp +"<br> Error, debe especificar el tipo de conversion." +msgTail;
            	}
            }else {
            	resp = resp +"<br> Error, debe ingresar una cantidad." +msgTail;
            }
          }
        }else {
        	resp = resp + msgTail;
        }
    	response.getWriter().append(resp);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msgHead = "<html> <title>Server de Practica - Arquitectura y Servicios Distribuidos</title>\n<body><br>";
		String msgTail = "</body> </html>";
        String resp, aux1, aux2;
        float res1, res2 = 0;
    	resp = msgHead+"<H1><body><p style=\"color:blue\">Convertidor de monedas.</body></H2><hr><i><body><p style=\"color:red\"></body><br> "
        		+ "Escriba el valor que desea convertir:</i> <br>\n"
        		+ "<form action= \"Serv02\" name=\"calc\" method=\"post\">\n"
        		+ "	<h3>Cantidad: <input type=\"text\" name=\"cantidad\" size=\"20\"> </h3>\n"
        		+ "	Tipos de conversion:\n"
        		+ "	<select name=\"conv\" size=\"1\" align=\"left\" >\n"
        		+ "	<option selected=\"selected\" value=\"0\">--&gt; Indique el tipo de conversion</option>\n"
        		+ "	<option value=\"1\"> USD --> Euros </option>\n"
        		+ "	<option value=\"2\"> Euros --> USD </option>\n"
        		+ "	</select>\n"
        		+ "<input type=\"submit\" name=\"submit\" value=\"Convertir\" >\n"
        		+ "<input type=\"submit\" name=\"submit\" value=\"Recargar\" >\n</form>\n";
    	
        aux1 = request.getParameter("cantidad");
        aux2 = request.getParameter("conv");
        String aux3 = request.getParameter("submit");
        if (aux3.equals("Convertir")) {
          if (!aux1.equalsIgnoreCase("") && aux1!=null) {
        	res1 = Float.parseFloat(aux1);
        	if (aux2.equalsIgnoreCase("1")) {
        		//HACER LA OPERACION Y GUARDAR RESULTADO EN res2
        		res2 = (float) (res1 / 1.05);
        		resp = resp +"<br> Resultado: "+ res1 +" USD equivalen a "+ res2 +" Euros.<br>"+msgTail;
        	}else if (aux2.equalsIgnoreCase("2")) {
        		//HACER LA OPERACION Y GUARDAR RESULTADO EN res2
        		res2 = (float) (res1 * 1.05);
        		resp = resp +"<br> Resultado: "+ res1 +" Euros equivalen a "+ res2 +" USD.<br>"+msgTail;
        		
        	}else {
        		resp = resp +"<br> Error, debe especificar el tipo de conversion." +msgTail;
        	}
          }else {
        	resp = resp +"<br> Error, debe ingresar una cantidad." +msgTail;
          }
        } else 
        	resp = resp + msgTail;
       	response.getWriter().append(resp);
	}
}
//http://localhost:8084/WebApplication1/Serv02 