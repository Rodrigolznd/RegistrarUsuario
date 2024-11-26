
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


// Declaramos el servlet y asignamos la URL "/UserServlet" que se usará para acceder a él
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {

    // El método doPost es llamado cuando el formulario es enviado con el método POST
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
        // 1. Obtener los parámetros del formulario HTML, enviados como parte de la solicitud POST
        String name = request.getParameter("name");  // Obtiene el valor del campo "name"
        String email = request.getParameter("email");  // Obtiene el valor del campo "email"

        // 2. Establecer los valores obtenidos como atributos de la solicitud
        // Estos atributos estarán disponibles para ser usados en la JSP
        request.setAttribute("name", name);  // Establece el valor de "name" como atributo
        request.setAttribute("email", email);  // Establece el valor de "email" como atributo

        // 3. Usar un RequestDispatcher para redirigir la solicitud a la página JSP
        // En este caso, redirige a "success.jsp"
        RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp"); 
        dispatcher.forward(request, response);  // Redirige la solicitud hacia la JSP y pasa los atributos
    }
}