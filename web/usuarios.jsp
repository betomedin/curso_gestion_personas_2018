<%@include file="template/header.jsp" %>
<%@include file="template/menu.jsp" %>
<div class="container">
    <div class="row">
        <div class="col s12">
            <h3>Lista de Usuarios</h3>
            <table>
                <thead>
                    <tr>
                        <th>Rut</th>
                        <th>Nombre</th>
                        <th>Perfil</th>
                        <th>Correo-E</th>
                        <th>Activo</th>
                        <th>Accion</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${applicationScope.lista}" var="p" >
                        <tr>
                            <td>${p.rut}</td>
                            <td>${p.nombre}</td>
                            <td>${p.perfil}</td>
                            <td>${p.mail}</td>
                            <td>${p.activo}</td>
                            <td>
                                <form method="post" action="control.do">
                                    <input type="hidden" name="rut" value="${p.rut}"/>
                                    <button class="circle btn-floating" name="accion" value="modificarForm">
                                        <i class="material-icons">edit</i>
                                    </button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<%@include file="template/footer.jsp" %>