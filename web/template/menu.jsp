<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="">
    <div class="nav-wrapper container">
        <!--<a href="" class="brand-logo left">Sistema</a>-->
        <c:if test="${ sessionScope.persona.perfil eq 'administrador'}">
            <ul id="nav-mobile" class=" hide-on-med-and-down">
                <li><a href="index.jsp">Inicio</a></li>                                  
                <li><a href="usuarios.jsp">Usuarios</a></li>                                  
                <li><a href="config.jsp">Configurar</a></li>                                  
            </ul>
        </c:if>
        <ul id="nav-mobile" class="right hide-on-med-and-down">
            <li><b>Bienvenido ${sessionScope.persona.nombre}</b></li>
            <li><a href="cerrar.jsp"><i class="material-icons">power_settings_new</i></a></li>                 
        </ul>
    </div>

</nav>
            
<div id="modal_salir" class="modal">
    <div class="modal-content">
        <h4>Modal Header</h4>
        <p>A bunch of text</p>
    </div>
    <div class="modal-footer">
        <a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat">Agree</a>
    </div>
</div>