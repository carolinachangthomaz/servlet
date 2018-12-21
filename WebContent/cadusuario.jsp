<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:useBean id="beanLogin" class="br.com.carolina.bean.Usuario"></jsp:useBean>
    <jsp:setProperty property="*" name="beanLogin"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form name="formcadusu" method="get" action="cadusuario.jsp">
					 
					    <table width="207" border="1" align="center">
    <tr>
      <td colspan="2"><div align="center"><span class="style1">Cadastro de Usuarios</span></div></td>
    </tr>
    <tr>
      <td width="90">Usu&aacute;rio</td>
      <td width="101"><label>
        <div align="center">
          <input name="usuario" type="text" id="usuario" size="10" />
          </div>
      </label></td>
    </tr>
    <tr>
      <td>Senha</td>
      <td><label>
        <div align="center">
          <input name="senha" type="password" id="senha" size="10" />
          </div>
      </label></td>
    </tr>
	 <tr>
      <td>Nivel de Acesso</td>
      <td><label>
        <div align="center">
          <input name="nivelAcesso" type="text" id="senha" size="10" />
          </div>
      </label></td>
    </tr>
    <tr>
      <td><label>
        <div align="center">
          <input type="reset" name="limpar" id="limpar" value="Limpar" />
          </div>
      </label></td>
      <td><label>
        <div align="center">
          <input type="submit" name="gravar" id="gravar" value="Gravar" />
          </div>
      </label></td>
    </tr>
  </table>
 </form> 
 <%
    if(request.getParameter("gravar") != null){
    	beanLogin.gravarLogin();
    }
 %>
 <jsp:getProperty property="situacao" name="beanLogin"/>
</body>
</html>