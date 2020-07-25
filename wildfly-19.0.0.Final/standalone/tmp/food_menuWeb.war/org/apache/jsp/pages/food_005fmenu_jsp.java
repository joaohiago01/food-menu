/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: WildFly Full 19.0.0.Final (WildFly Core 11.0.0.Final) - 2.0.30.Final
 * Generated at: 2020-05-30 17:40:46 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Set;
import entity.Restaurant;
import entity.Menu;
import entity.Category;
import java.util.List;
import entity.Product;
import java.util.List;

public final class food_005fmenu_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("entity.Category");
    _jspx_imports_classes.add("entity.Product");
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("entity.Restaurant");
    _jspx_imports_classes.add("java.util.Set");
    _jspx_imports_classes.add("entity.Menu");
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JBWEB004248: JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=utf-8");
      response.addHeader("X-Powered-By", "JSP/2.3");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"utf-8\" />\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("\thref=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\" />\r\n");
      out.write("\r\n");
      out.write("<meta name=\"viewport\"\r\n");
      out.write("\tcontent=\"width=device-width, initial-scale=1, shrink-to-fit=no\" />\r\n");
      out.write("\r\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\"></script>\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js\"></script>\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<title>Food Menu</title>\r\n");
      out.write("\r\n");
      out.write("<link rel=\"sortcut icon\" href=\"../assets/favicon.ico\"\r\n");
      out.write("\ttype=\"image/x-icon\" />\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t\r\n");
      out.write("\t");

		Restaurant restaurant = (Restaurant) session.getAttribute("restaurant");
	if (restaurant == null) {
		response.sendRedirect("./index.jsp");
	} else {
		Menu menu = (Menu) session.getAttribute("menu");
		Category category = (Category) session.getAttribute("category");
	
      out.write("\r\n");
      out.write("\t<div class=\"card bg-danger mb-3\">\r\n");
      out.write("\t\t<div class=\"card-header\">\r\n");
      out.write("\t\t\t<ul class=\"nav justify-content-end\">\r\n");
      out.write("\t\t\t\t<li class=\"nav-item\"><a class=\"nav-link btn btn-danger btn-lg\"\r\n");
      out.write("\t\t\t\t\thref=\"user_register.jsp\">Cadastrar Restaurante</a></li>\r\n");
      out.write("\t\t\t\t<li class=\"nav-item\"><a class=\"nav-link btn btn-danger btn-lg\"\r\n");
      out.write("\t\t\t\t\thref=\"login.jsp\">Entrar</a></li>\r\n");
      out.write("\t\t\t\t<li class=\"nav-item\"><a class=\"nav-link btn btn-danger btn-lg\"\r\n");
      out.write("\t\t\t\t\thref=\"../RestaurantServlet?pageURL=index.jsp\">Voltar</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"card-body\">\r\n");
      out.write("\t\t<br />\r\n");
      out.write("\t\t<div class=\"card-body\">\r\n");
      out.write("\t\t\t<h1 class=\"card-title\" id=\"restaurant\">\r\n");
      out.write("\t\t\t\t");
      out.print(restaurant.getName());
      out.write("\r\n");
      out.write("\t\t\t</h1>\r\n");
      out.write("\t\t\t<br />\r\n");
      out.write("\t\t\t");

				if (restaurant.getCategory() != null) {
			
      out.write("\r\n");
      out.write("\t\t\t<label class=\"form-col-1 font-weight-bold\" id=\"category\">Especialidade:\r\n");
      out.write("\t\t\t\t");
      out.print(restaurant.getCategory().getName());
      out.write("</label> <br />\r\n");
      out.write("\t\t\t");

				}
			
      out.write("\r\n");
      out.write("\t\t\t<label class=\"card-text\" id=\"description\"> ");
      out.print(restaurant.getDescription());
      out.write("\r\n");
      out.write("\t\t\t</label> <br /> <label class=\"card-text\" id=\"category\"> ");

 	if (category != null)
 	category.getName();
 
      out.write("\r\n");
      out.write("\t\t\t</label> <br />\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"card-body\">\r\n");
      out.write("\t\t\t<div class=\"form-row\">\r\n");
      out.write("\t\t\t\t<label class=\"form-col-1 font-weight-bold\">Horário de\r\n");
      out.write("\t\t\t\t\tFuncionamento:</label> <label id=\"time_open\" class=\"form-col-1\"> ");
      out.print(restaurant.getTime_open());
      out.write("\r\n");
      out.write("\t\t\t\t</label> <label class=\"form-col-1\"></label> <label id=\"time_close\"\r\n");
      out.write("\t\t\t\t\tclass=\"form-col-1\"> ");
      out.print(restaurant.getTime_close());
      out.write("\r\n");
      out.write("\t\t\t\t</label>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div class=\"form-group col-md-15 font-weight-bold\">\r\n");
      out.write("\t\t\t\t<label for=\"inputDays\">Quais dias o restaurante funciona?</label>\r\n");
      out.write("\t\t\t\t<div class=\"custom-control custom-checkbox custom-control-inline\">\r\n");
      out.write("\t\t\t\t\t");

						if (restaurant.isMonday_open()) {
					
      out.write("\r\n");
      out.write("\t\t\t\t\t<input type=\"checkbox\" class=\"custom-control-input\"\r\n");
      out.write("\t\t\t\t\t\tid=\"customCheck1\" name=\"monday\" checked=\"checked\"\r\n");
      out.write("\t\t\t\t\t\tdisabled=\"disabled\" />\r\n");
      out.write("\t\t\t\t\t");

						}
					
      out.write("\r\n");
      out.write("\t\t\t\t\t<input type=\"checkbox\" class=\"custom-control-input\"\r\n");
      out.write("\t\t\t\t\t\tid=\"customCheck1\" name=\"monday\" disabled=\"disabled\" /> <label\r\n");
      out.write("\t\t\t\t\t\tclass=\"custom-control-label\" for=\"customCheck1\">Segunda-Feira</label>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"custom-control custom-checkbox custom-control-inline\">\r\n");
      out.write("\t\t\t\t\t");

						if (restaurant.isTuesday_open()) {
					
      out.write("\r\n");
      out.write("\t\t\t\t\t<input type=\"checkbox\" class=\"custom-control-input\"\r\n");
      out.write("\t\t\t\t\t\tid=\"customCheck2\" name=\"tuesday\" checked=\"checked\"\r\n");
      out.write("\t\t\t\t\t\tdisabled=\"disabled\" />\r\n");
      out.write("\t\t\t\t\t");

						}
					
      out.write("\r\n");
      out.write("\t\t\t\t\t<input type=\"checkbox\" class=\"custom-control-input\"\r\n");
      out.write("\t\t\t\t\t\tid=\"customCheck2\" name=\"tuesday\" disabled=\"disabled\" /> <label\r\n");
      out.write("\t\t\t\t\t\tclass=\"custom-control-label\" for=\"customCheck2\">Terça-Feira</label>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"custom-control custom-checkbox custom-control-inline\">\r\n");
      out.write("\t\t\t\t\t");

						if (restaurant.isWednesday_open()) {
					
      out.write("\r\n");
      out.write("\t\t\t\t\t<input type=\"checkbox\" class=\"custom-control-input\"\r\n");
      out.write("\t\t\t\t\t\tid=\"customCheck3\" name=\"wednesday\" checked=\"checked\"\r\n");
      out.write("\t\t\t\t\t\tdisabled=\"disabled\" />\r\n");
      out.write("\t\t\t\t\t");

						}
					
      out.write("\r\n");
      out.write("\t\t\t\t\t<input type=\"checkbox\" class=\"custom-control-input\"\r\n");
      out.write("\t\t\t\t\t\tid=\"customCheck3\" name=\"wednesday\" disabled=\"disabled\"> <label\r\n");
      out.write("\t\t\t\t\t\tclass=\"custom-control-label\" for=\"customCheck3\">Quarta-Feira</label>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"custom-control custom-checkbox custom-control-inline\">\r\n");
      out.write("\t\t\t\t\t");

						if (restaurant.isThursday_open()) {
					
      out.write("\r\n");
      out.write("\t\t\t\t\t<input type=\"checkbox\" class=\"custom-control-input\"\r\n");
      out.write("\t\t\t\t\t\tid=\"customCheck4\" name=\"thursday\" checked=\"checked\"\r\n");
      out.write("\t\t\t\t\t\tdisabled=\"disabled\" />\r\n");
      out.write("\t\t\t\t\t");

						}
					
      out.write("\r\n");
      out.write("\t\t\t\t\t<input type=\"checkbox\" class=\"custom-control-input\"\r\n");
      out.write("\t\t\t\t\t\tid=\"customCheck4\" name=\"thursday\" disabled=\"disabled\" /> <label\r\n");
      out.write("\t\t\t\t\t\tclass=\"custom-control-label\" for=\"customCheck4\">Quinta-Feira</label>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"custom-control custom-checkbox custom-control-inline\">\r\n");
      out.write("\t\t\t\t\t");

						if (restaurant.isFriday_open()) {
					
      out.write("\r\n");
      out.write("\t\t\t\t\t<input type=\"checkbox\" class=\"custom-control-input\"\r\n");
      out.write("\t\t\t\t\t\tid=\"customCheck5\" name=\"friday\" checked=\"checked\"\r\n");
      out.write("\t\t\t\t\t\tdisabled=\"disabled\" />\r\n");
      out.write("\t\t\t\t\t");

						}
					
      out.write("\r\n");
      out.write("\t\t\t\t\t<input type=\"checkbox\" class=\"custom-control-input\"\r\n");
      out.write("\t\t\t\t\t\tid=\"customCheck5\" name=\"friday\" disabled=\"disabled\" /> <label\r\n");
      out.write("\t\t\t\t\t\tclass=\"custom-control-label\" for=\"customCheck5\">Sexta-Feira</label>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"custom-control custom-checkbox custom-control-inline\">\r\n");
      out.write("\t\t\t\t\t");

						if (restaurant.isSaturday_open()) {
					
      out.write("\r\n");
      out.write("\t\t\t\t\t<input type=\"checkbox\" class=\"custom-control-input\"\r\n");
      out.write("\t\t\t\t\t\tid=\"customCheck6\" name=\"saturday\" checked=\"checked\"\r\n");
      out.write("\t\t\t\t\t\tdisabled=\"disabled\" />\r\n");
      out.write("\t\t\t\t\t");

						}
					
      out.write("\r\n");
      out.write("\t\t\t\t\t<input type=\"checkbox\" class=\"custom-control-input\"\r\n");
      out.write("\t\t\t\t\t\tid=\"customCheck6\" name=\"saturday\" disabled=\"disabled\" /> <label\r\n");
      out.write("\t\t\t\t\t\tclass=\"custom-control-label\" for=\"customCheck6\">Sabádo</label>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"custom-control custom-checkbox custom-control-inline\">\r\n");
      out.write("\t\t\t\t\t");

						if (restaurant.isSunday_open()) {
					
      out.write("\r\n");
      out.write("\t\t\t\t\t<input type=\"checkbox\" class=\"custom-control-input\"\r\n");
      out.write("\t\t\t\t\t\tid=\"customCheck7\" name=\"sunday\" checked=\"checked\"\r\n");
      out.write("\t\t\t\t\t\tdisabled=\"disabled\" />\r\n");
      out.write("\t\t\t\t\t");

						}
					
      out.write("\r\n");
      out.write("\t\t\t\t\t<input type=\"checkbox\" class=\"custom-control-input\"\r\n");
      out.write("\t\t\t\t\t\tid=\"customCheck7\" name=\"sunday\" disabled=\"disabled\" /> <label\r\n");
      out.write("\t\t\t\t\t\tclass=\"custom-control-label\" for=\"customCheck7\">Domingo</label>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div class=\"form-row\">\r\n");
      out.write("\t\t\t\t<label class=\"form-col-1 font-weight-bold\">Contato: </label> <label\r\n");
      out.write("\t\t\t\t\tclass=\"form-col-1\" id=\"phone\"> ");
      out.print(restaurant.getPhone());
      out.write("\r\n");
      out.write("\t\t\t\t</label>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"card-body\">\r\n");
      out.write("\t\t\t<h4 class=\"card-title font-weight-bold\">Localização</h4>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div class=\"form-row\">\r\n");
      out.write("\t\t\t\t<label class=\"form-col-1 font-weight-bold\">Cidade:</label> <label\r\n");
      out.write("\t\t\t\t\tclass=\"form-col-1\" id=\"city\"> ");
      out.print(restaurant.getCity());
      out.write("\r\n");
      out.write("\t\t\t\t</label> <label class=\"form-col-1 font-weight-bold\">Estado:</label> <label\r\n");
      out.write("\t\t\t\t\tclass=\"form-col-1\" id=\"state\"> ");
      out.print(restaurant.getState());
      out.write("\r\n");
      out.write("\t\t\t\t</label>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"form-row\">\r\n");
      out.write("\t\t\t\t<label class=\"form-col-1 font-weight-bold\">Endereço: </label> <label\r\n");
      out.write("\t\t\t\t\tclass=\"form-col-1\" id=\"address\"> ");
      out.print(restaurant.getAddress());
      out.write("\r\n");
      out.write("\t\t\t\t</label>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"form-row\">\r\n");
      out.write("\t\t\t\t<label class=\"form-col-1 font-weight-bold\">Bairro: </label> <label\r\n");
      out.write("\t\t\t\t\tclass=\"form-col-1\" id=\"disctrict\"> ");
      out.print(restaurant.getDistrict());
      out.write("\r\n");
      out.write("\t\t\t\t</label>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"form-row\">\r\n");
      out.write("\t\t\t\t<label class=\"form-col-1 font-weight-bold\">Complemento: </label> <label\r\n");
      out.write("\t\t\t\t\tclass=\"form-col-1\" id=\"addition\"> ");
      out.print(restaurant.getAddition());
      out.write("\r\n");
      out.write("\t\t\t\t</label>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"card-body form-group col-md-15 font-weight-bold\">\r\n");
      out.write("\t\t\t<label for=\"inputDelivery\">O restaurante possui serviço de\r\n");
      out.write("\t\t\t\tentrega?</label> <br />\r\n");
      out.write("\t\t\t<div class=\"custom-control custom-radio custom-control-inline\">\r\n");
      out.write("\t\t\t\t<input type=\"radio\" id=\"customRadioDeliveryYes\" disabled=\"disabled\"\r\n");
      out.write("\t\t\t\t\tname=\"customRadioDelivery\" class=\"custom-control-input\"\r\n");
      out.write("\t\t\t\t\t");
if (restaurant.isDelivery())
      out.write(" checked=\"checked\" /><label\r\n");
      out.write("\t\t\t\t\tclass=\"custom-control-label\" for=\"customRadioDeliveryYes\">Sim</label>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"custom-control custom-radio custom-control-inline\">\r\n");
      out.write("\t\t\t\t<input type=\"radio\" id=\"customRadioDeliveryNo\" disabled=\"disabled\"\r\n");
      out.write("\t\t\t\t\tname=\"customRadioDelivery\" class=\"custom-control-input\"\r\n");
      out.write("\t\t\t\t\t");
if (!restaurant.isDelivery())
      out.write(" checked=\"checked\" /><label\r\n");
      out.write("\t\t\t\t\tclass=\"custom-control-label\" for=\"customRadioDeliveryNo\">Não</label>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"card-body\">\r\n");
      out.write("\t\t\t<h4 class=\"card-title font-weight-bold\">Cardápio</h4>\r\n");
      out.write("\t\t\t<br />\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t");

					List<Product> listProducts = menu.getProducts();
				if (listProducts == null || listProducts.isEmpty()) {
				
      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"col-sm-6\">\r\n");
      out.write("\t\t\t\t\t<div class=\"card\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"card-body\">\r\n");
      out.write("\t\t\t\t\t\t\t<h5 class=\"card-title\">Nenhum produto encontrado</h5>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t");

					} else {
					for (Product product : listProducts) {
				
      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"col-sm-6\">\r\n");
      out.write("\t\t\t\t\t<div class=\"card\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"card-body\">\r\n");
      out.write("\t\t\t\t\t\t\t<h5 class=\"card-title\">\r\n");
      out.write("\t\t\t\t\t\t\t\t");
      out.print(product.getName());
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t</h5>\r\n");
      out.write("\t\t\t\t\t\t\t<p class=\"card-text\">\r\n");
      out.write("\t\t\t\t\t\t\t\t");
      out.print(product.getDescription());
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t<p class=\"card-text\">\r\n");
      out.write("\t\t\t\t\t\t\t\t");
      out.print("R$ " + product.getPrice());
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t");

					}
				}
				}
				
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}