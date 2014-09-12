<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Daftar Peserta</title>
    </head>
    <body>
        <h1>Daftar Peserta</h1>
        
        <p>
            <a href="upload" class="btn btn-primary">Import Data Peserta</a>
            <a href="download" class="btn btn-success">Download Data Peserta</a>
            <a href="form" class="btn btn-info">Tambah Data Peserta</a>
        </p>
        
        <table class="table table-bordered table-hover">
            <thead>
                <tr>
                    <th>Kode</th>
                    <th>Nama</th>
                    <th>Email</th>
                    <th>Tanggal Bergabung</th>
                    <th>&nbsp;</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="p" items="${dataPeserta}">
                <tr>
                    <td>${p.kode}</td>
                    <td>${p.nama}</td>
                    <td>${p.email}</td>
                    <td>${p.tanggalBergabung}</td>
                    <td>
                        <a href="form?id=${p.id}" class="btn btn-warning">
                            <span class="glyphicon glyphicon-pencil"></span> edit
                        </a> 
                        <a href="hapus?id=${p.id}" class="btn btn-danger">
                            <span class="glyphicon glyphicon-trash"></span> hapus
                        </a> 
                        
                    </td>
                </tr>
                </c:forEach>
            </tbody>
        </table>

        
    </body>
</html>
