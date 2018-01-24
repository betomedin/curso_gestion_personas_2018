<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="template/header.jsp" %>
<c:if test="${sessionScope.persona.perfil eq 'administrador'}">
    <%@include file="template/menu.jsp" %>
</c:if>
<div class="container">
    <div class="row">
        <div class="col s12">
            <h3>${(empty sessionScope.persona)?"Formulario de Registro":"Modificar Usuario"}</h3>
            <form method="post" action="control.do">
                <label>
                    Rut<br>
                    <input type="text" name="rut" value="${requestScope.persona.rut}"/>
                </label>
                <br>
                <label>
                    Nombre<br>
                    <input type="text" name="nombre"  value="${requestScope.persona.nombre}"/>
                </label>
                <br>
                <label>
                    Perfil<br>
                    <select class="select-label" name="perfil">
                        <option value="alumno" ${(requestScope.persona.perfil eq 'alumno')?'selected':''}>Alumno</option>
                        <option value="docente" ${(requestScope.persona.perfil eq 'docente')?'selected':''}>Docente</option>
                        <option value="administrador" ${(requestScope.persona.perfil eq 'administrador')?'selected':''}>Administrador</option>
                    </select>
                </label>
                <br>
                <label>
                    Correo<br>
                    <input type="email" name="correo"  value="${requestScope.persona.mail}"/>
                </label>
                <br>
                <label>
                    Password<br>
                    <input type="password" name="clave"  value="${requestScope.persona.clave}"/>
                </label>
                <br>
                <c:if test="${sessionScope.persona.perfil eq 'Administrador'}">
                    Activo<br>
                    <select class="select-label" name="activo">
                        <option ${(requestScope.persona.activo)?'selected':''}>Si</option>
                        <option ${(requestScope.persona.activo)?'':'selected'}>No</option>                        
                    </select>
                </c:if>
                <br><br>
                <label>
                    <button class="btn" name="accion" value="${(empty sessionScope.persona)?"registrar":"modificar"}">${(empty sessionScope.persona)?"Registrar":"Modificar"}</button>
                    <c:if test="${empty sessionScope.persona.perfil}">
                    <a class="btn btn-flat"  >Volver</a>
                    </c:if>
                </label>
            </form>
        </div>
    </div>
</div>

<%@include file="template/footer.jsp" %>