<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
    <title>Trust Farm</title>
    <style>
        @media (min-width: 768px) {
            .container-fluid {
                width: 550px;
            }
        }
    </style>
</head>
<body class="bg-dark">
<div class="container-fluid">
    <br/>
    <a href="javascript:history.back();" class="btn btn-warning">Back</a>
    <c:if test="${fn:contains(product.certification, 'Klaytn') == false}">
        &nbsp;
        <a href="javascript:alert('Certification contract added.');location.href='/certification/products/${product.id}/certify';" class="btn btn-warning">Certify</a>
    </c:if>
    <br/><br/>
    <table class="table table-dark">
        <tr>
            <th>Product</th>
            <td>${product.name}</td>
        </tr>
        <tr>
            <th>Price</th>
            <td>${product.price}</td>
        </tr>
        <tr>
            <th>Certification</th>
            <td>${product.certification}</td>
        </tr>
        <tr>
            <th>
                Video
            </th>
            <td>
                <video width="100%" autoplay>
                    <source src="http://landvibe.cafe24.com/img/${product.id}.mp4" type="video/mp4">
                </video>
            </td>
        </tr>
    </table>
</div>
</body>
</html>