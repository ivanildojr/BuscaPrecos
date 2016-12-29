<%@ page import="grails.converters.JSON" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'agendaConsulta.label', default: 'AgendaConsulta')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#list-agendaConsulta" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="list-agendaConsulta" class="content scaffold-list" role="main">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <table>
                <thead>
                    <tr>
                        <g:each in="${fields}" var="fl" status="i">
                            <th>${fl}</th>
                        </g:each>
                    </tr>
                </thead>
                <tbody>
                    <g:each in="${agendaConsultaList}" var="p" status="i">
                        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                            <g:each in="${p}" var="linha">
                                <td>
                                    <g:link controller="agendaConsulta" action="show" params="[id: p.id]">${p.origem}</g:link>
                                </td>
                                <td>${p.destino}</td>
                                <td>${p.dataIda}</td>
                                <td>${p.dataVolta}</td>
                                <td>${p.horaConsulta}</td>
                                <td>${p.adultos}</td>
                                <td>${p.criancas}</td>
                                <td>${p.duracao}</td>
                                <td>${p.dataLimiteSaida}</td>
                                <td>
                                    <g:link controller="agendaConsulta" action="schedule" params="[id: p.id, origem: p.origem, destino: p.destino, dataIda: p.dataIda,dataVolta:p.dataVolta,adultos:p.adultos,criancas:p.criancas,horaConsulta:p.horaConsulta,duracao:p.duracao,dataLimiteSaida:p.dataLimiteSaida]">Iniciar Job</g:link>
                                    <br>
                                    <g:link controller="agendaConsulta" action="unschedule" params="[id: p.id]">Remover Job</g:link>
                                </td>
                            </g:each>

                        </tr>
                    </g:each>
                </tbody>
            <div class="pagination">
                <g:paginate total="${agendaConsultaCount ?: 0}" />
            </div>
        </div>
    </body>
</html>