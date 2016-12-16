<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="dataGridLayout" />
    <g:set var="entityName" value="${message(code: 'precos.label', default: 'Precos')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
<div id="conteudo">
    %{--Valores de Ida: ${raw(ida)}--}%
    %{--<br>--}%
    %{--Valores de Volta: ${raw(volta)}--}%
</div>

<div id="grid"></div>


</body>
</html>