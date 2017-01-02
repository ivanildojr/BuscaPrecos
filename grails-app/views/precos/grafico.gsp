<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="graphLayout" />
    <g:set var="entityName" value="${message(code: 'precos.label', default: 'Precos')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">
            <i class="fa fa-line-chart"></i>
                Evolução dos Preços
            <a class="pull-right glyphicon glyphicon-option-horizontal" href="#" style="text-decoration:none;"></a>
        </h3>
    </div>
    <div class="panel-body">
        <div id="IDA" style="width:100%; height:250px;" class="shield-chart"/>
    </div>
</div>
<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">
            <i class="fa fa-line-chart"></i>
            Evolução dos Preços
            <a class="pull-right glyphicon glyphicon-option-horizontal" href="#" style="text-decoration:none;"></a>
        </h3>
    </div>
    <div class="panel-body">
        <div id="VOLTA" style="width:100%; height:250px;" class="shield-chart"/>
    </div>
</div>



</body>
</html>