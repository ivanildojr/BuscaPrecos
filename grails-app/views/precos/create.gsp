<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'precos.label', default: 'Precos')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
        <asset:javascript src="jquery-2.2.0.min.js"/>
        <asset:javascript src="jquery-ui.js"/>
        <asset:stylesheet src="jquery-ui.css"/>
    </head>
    <body>
        <a href="#create-precos" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="create-precos" class="content scaffold-create" role="main">
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.precos}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.precos}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form action="save">
                <fieldset class="form">
                    <div class="ui-widget">
                        <f:field property="origem" bean="precos"/>
                    </div>

                    <div class="ui-widget">
                        <f:field property="destino" bean="precos"/>
                    </div>
                    <f:all bean="precos" except="origem,destino"/>
                </fieldset>
                <fieldset class="buttons">
                    <g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
                </fieldset>
            </g:form>
        </div>


    <g:javascript>

        $(document).ready(function () {
            $( "#origem" ).autocomplete({
                    minLength: 3,
                    source: function( request, response ) {
                        $.ajax({
                        url:'${g.createLink(controller: 'agendaConsulta', action: 'buscaAeroportos')}',
                        dataType: 'json',
                        data: {codigo: $('#origem').val()}
                        ,
                        success: function (data) {
                            response(data);
                        },
                        error: function (request, status, error) {
                        console.log('Deu erro');
                        }
                        });
                    },
                    change: function( event, ui ) {
                        $("#origem").val(ui.item.value.substring(0,3));
                    }

            });

            $( "#destino" ).autocomplete({
                    minLength: 3,
                    source: function( request, response ) {
                        $.ajax({
                        url:'${g.createLink(controller: 'agendaConsulta', action: 'buscaAeroportos')}',
                        dataType: 'json',
                        data: {codigo: $('#destino').val()}
                        ,
                        success: function (data) {
                            response(data);
                        },
                        error: function (request, status, error) {
                        console.log('Deu erro');
                        }
                        });
                    },
                    change: function( event, ui ) {
                        $("#destino").val(ui.item.value.substring(0,3));
                    }

            });
        });




    </g:javascript>
    </body>
</html>
