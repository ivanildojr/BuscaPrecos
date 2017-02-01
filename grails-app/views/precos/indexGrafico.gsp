<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="graphCustomLayout" />
    <title>Customização dos Gráficos</title>
</head>
<body>
<div class="col-lg-12">
    <div class="well">
        <form class="form-horizontal">
            <fieldset>
                <legend>Configuração do Gráfico</legend>
                <div class="form-group">
                    <label for="iata_code" class="col-lg-2 control-label">Destino</label>
                    <div class="col-lg-10">
                        <input type="text" class="form-control" id="iata_code" placeholder="Código Destino - (YYZ, BSB, NAT)" maxlength="3">
                    </div>
                </div>
                <div class="form-group">
                    <label for="vencimento" class="col-lg-2 control-label">Vencimendo Pesquisa</label>
                    <div class="col-lg-10">
                        <input type="text" class="form-control" id="vencimento" placeholder="Informar quantidade de dias">

                    </div>
                </div>
                <div class="form-group">
                    <label class="col-lg-2 control-label">Tipo de Gráfico</label>
                    <div class="col-lg-10">
                        <div class="radio">
                            <label>
                                <input type="radio" name="tipoGrafico" id="optionsRadios1" value="dia" checked="">
                                Gráfico evolução preços para determinado dia
                            </label>
                        </div>
                        <div class="radio">
                            <label>
                                <input type="radio" name="tipoGrafico" id="optionsRadios2" value="option2">
                                Gráfico de preços para diversos dias
                            </label>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-lg-2 control-label">Data da Viagem</label>
                    <div class="col-md-6">
                        <div class="container">
                            <div id="dataViagem" class="sui-calendar"></div>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-lg-10 col-lg-offset-2">
                        <button class="btn btn-default">Cancel</button>
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </div>
                </div>
            </fieldset>
        </form>
    </div>
</div>
</body>
</html>