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
        
        <table border="1">
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
                        <a href="form?id=${p.id}">edit</a> | 
                        <a href="hapus?id=${p.id}">hapus</a> 
                        
                    </td>
                </tr>
                </c:forEach>
            </tbody>
        </table>

        
    </body>
</html>
