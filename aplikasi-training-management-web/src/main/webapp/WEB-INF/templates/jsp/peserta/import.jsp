<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hasil Import Data</title>
    </head>
    <body>
        <h1>Hasil Import Data</h1>
        
        Jumlah data yang sukses import : ${hasilUpload.sukses.size()}
        <br>
        Data yang gagal import : ${hasilUpload.gagal.size()}
        
        <table border="1">
            <thead>
                <tr>
                    <th>Baris</th>
                    <th>Keterangan</th>
                    <th>Data</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="x" items="${hasilUpload.gagal}">
                <tr>
                    <td>${x.baris}</td>
                    <td>${x.keterangan}</td>
                    <td>${x.data}</td>
                </tr>
                </c:forEach>
            </tbody>
        </table>

        
    </body>
</html>
