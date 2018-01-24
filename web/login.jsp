<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container ">
    <div class="row">
        <div class="col s6 center offset-l3">
            <h3>Login de Usuario</h3>
            <form class="" method="post" action="control.do">
                <label>
                    Usuario<br>
                    <input type="text" name="rut" value=""/>
                </label>
                <br>
                <label>
                    Password<br>
                    <input type="password" name="clave" value=""/>
                </label>
                <br><br>
                <label>
                    ${requestScope.msg}
                </label>
                <br><br>
                <label>
                    <button class="btn" name="accion" value="ingresar">Ingresar</button>
                </label>
                <label>
                    <button class="btn btn-flat" name="accion" value="formRegistro">Registro</button>
                </label>
<!--                <table>
                    <thead>
                        <tr>
                            <th>Rut</th>
                            <th>Nombre</th>
                            <th>Perfil</th>
                            <th>Clave</th>
                            <th>Activo</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${applicationScope.lista}" var="p" >
                            <tr>
                                <td>${p.rut}</td>
                                <td>${p.nombre}</td>
                                <td>${p.perfil}</td>
                                <td>${p.clave}</td>
                                <td>${p.activo}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>-->
            </form>    
        </div>
    </div>
</div>
