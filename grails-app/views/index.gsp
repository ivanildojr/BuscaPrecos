<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Busca Preços</title>

    <asset:link rel="icon" href="favicon.ico" type="image/x-ico" />
</head>
<body>
    <content tag="nav">
    </content>

    <div class="svg" role="presentation">
    </div>

    <div id="content" role="main">
        <section class="row colset-2-its">
            <div id="controllers" role="navigation">
                <h2>Controllers Disponíveis:</h2>
                <ul>
                    <g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">
                        <li class="controller">
                            <g:link controller="${c.logicalPropertyName}">${c.logicalPropertyName}</g:link>
                        </li>
                    </g:each>
                    <li class="controller">
                        <g:link controller="precos" action="buscaCotacoes">Busca Precos</g:link>
                    </li>
                    <li class="controller">
                        <g:link controller="precos" action="grafico" params="[iata_code:'YYZ',vencimento:'5']">Grafico Precos</g:link>
                    </li>
                    <li class="controller">
                        <g:link controller="precos" action="graficoDia" params="[iata_code:'YYZ',vencimento:'30',dataViagem:'2017-09-08']">Grafico Dia Precos</g:link>
                    </li>

                </ul>
            </div>
        </section>
    </div>

</body>
</html>
