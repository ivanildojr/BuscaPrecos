<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>    <g:layoutTitle default="Grails"/></title>
    <g:layoutHead/>
    <asset:stylesheet src="bootstrap.css" />

    <asset:stylesheet src="font-awesome.css" />

    <asset:stylesheet src="all.min.css" />

    <asset:stylesheet src="theme.css" />
    <asset:stylesheet src="dashboard.css" />
</head>
<body>
<g:layoutBody/>

<asset:javascript src="tema.js"/>
<script type="text/javascript" src="http://www.shieldui.com/shared/components/latest/js/shieldui-all.min.js"></script>
<script type="text/javascript">
    jQuery(function ($) {
        $("#grid").shieldGrid({
            dataSource: {
                data: <g:applyCodec encodeAs="none">${gridData}</g:applyCodec>
            },
            sorting:{
                multiple: true
            },
            paging: {
                pageSize: 17,
                pageLinksCount: 10
            },
            selection:{
                type: "row",
                multiple: true,
                toggle: false
            },
            columns: [
                { field: "id", width: "70px", title: "ID" },
                { field: "empresa", width: "100px", title: "Empresa" },
                { field: "preco", title:"Preço", width: "100px" , format: function(value){return "R$ " + value;}},
                { field: "tipo", title:"IDA / VOLTA", width: "100px" },
                { field: "data", title: "Data da Viagem"  , format: function(value){return value.substring(8,10)+"/"+value.substring(5,7)+"/"+value.substring(0,4);}},
                { field: "dataConsulta", title: "Data da Consulta" , format: function(value){return value.substring(8,10)+"/"+value.substring(5,7)+"/"+value.substring(0,4)+" "+value.substring(11,19);}},
                { field: "origem", title:"Origem", width: "270px" },
                { field: "destino", title:"Destino", width: "270px" }

            ]
        });
    });
</script>

</body>
</html>