<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Entri Data Peserta</title>
    </head>
    <body>
        <h1>Entri Data Peserta</h1>

        <c:if test="${errors != null}">
            Ada error : 
            <ul>
            <c:forEach var="err" items="${errors}">
                <li>Field ${err.key} : ${err.value}</li>
            </c:forEach>
            </ul>
        </c:if>
        
        
        <form class="form-horizontal" role="form" method="post">
            <div class="form-group">
                <label for="kode" class="col-sm-2 control-label">Kode</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="kode" name="kode" placeholder="Kode Peserta">
                </div>
            </div>
            <div class="form-group">
                <label for="nama" class="col-sm-2 control-label">Nama</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="nama" name="nama" placeholder="Nama Peserta">
                </div>
            </div>
            <div class="form-group">
                <label for="email" class="col-sm-2 control-label">Email</label>
                <div class="col-sm-10">
                    <input type="email" class="form-control" id="email" name="email" placeholder="Email Peserta">
                </div>
            </div>
            <div class="form-group">
                <label for="tanggalBergabung" class="col-sm-2 control-label">Tanggal Bergabung</label>
                <div class="col-sm-10">
                    <input type="date" class="form-control" id="tanggalBergabung" name="tanggalBergabung" placeholder="Tanggal Bergabung">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default">Simpan</button>
                </div>
            </div>
        </form>

    </body>
</html>
