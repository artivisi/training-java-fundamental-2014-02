<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Entri Data Peserta</title>
    </head>
    <body>
        <h1>Entri Data Peserta</h1>
        
        <form method="POST">
            
            <table border="1">
                <tbody>
                    <tr>
                        <td>Kode</td>
                        <td>
                            <input type="text" name="kode">
                        </td>
                    </tr>
                    <tr>
                        <td>Nama</td>
                        <td>
                            <input type="text" name="nama">
                        </td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td>
                            <input type="text" name="email">
                        </td>
                    </tr>
                    <tr>
                        <td>Tanggal Bergabung</td>
                        <td>
                            <input type="text" name="tanggalBergabung">
                        </td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td>
                            <input type="submit" value="Simpan">
                        </td>
                    </tr>
                </tbody>
            </table>

            
        </form>
        
    </body>
</html>
