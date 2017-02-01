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
        $("#calendar").shieldCalendar({
            footer: {
                enabled: true,
                footerTemlpate: "{0:dd.MM.yy}"
            },
            min: new Date("2009/2/23"),
            max: new Date("2039/3/1"),
            value: new Date()
        });

        $("#${grafico1}").shieldChart({
            seriesPalette: ["#001AAD", "#FF6900", "#17BE0A"],
            exportOptions: {
                image: false,
                print: false
            },
            axisX: {
                categoricalValues: <g:applyCodec encodeAs="none">${eixoX1}</g:applyCodec>
            },
            axisY: {
                axisTickText: {
                    format: "{text:c}"
                },
                title: {
                    text: "Preço (R$)"
                }
            },
            tooltipSettings: {
                chartBound: true,
//                customPointText: function(point, chart) {
//                    return shield.format(
//                        '<span>Id: <b>{id}</b><br/>Valor:<b>R$ {valor}</b></span>',
//                        {
//                            id: point.x,
//                            valor: point.y,
//
//                        }
//                    );
//                }

            },
            primaryHeader: {
                text: <g:applyCodec encodeAs="none">${titulo1}</g:applyCodec>
            },
            dataSeries: [{
                seriesType: 'splinearea',
                applyAnimation: true,
                collectionAlias: 'Média',
                data: <g:applyCodec encodeAs="none">${yTAM1}</g:applyCodec>
            }, {
                seriesType: 'spline',

                applyAnimation: true,
                collectionAlias: 'Mínimo',
                data: <g:applyCodec encodeAs="none">${yTAM2}</g:applyCodec>
            }, {
                seriesType: 'spline',

                applyAnimation: true,
                collectionAlias: 'Máximo',
                data: <g:applyCodec encodeAs="none">${yTAM3}</g:applyCodec>
            }]
        });


        $("#${grafico2}").shieldChart({
            seriesPalette: ["#001AAD", "#FF6900", "#17BE0A"],
            exportOptions: {
                image: false,
                print: false
            },
            axisX: {
                categoricalValues: <g:applyCodec encodeAs="none">${eixoX2}</g:applyCodec>
            },
            axisY: {
                axisTickText: {
                    format: "{text:c}"
                },
                title: {
                    text: "Preço (R$)"
                }
            },
            tooltipSettings: {
                chartBound: true
            },
            primaryHeader: {
                text: <g:applyCodec encodeAs="none">${titulo2}</g:applyCodec>
            },
            dataSeries: [{
                seriesType: 'splinearea',
                applyAnimation: true,
                collectionAlias: 'Média',
                data: <g:applyCodec encodeAs="none">${yGOL1}</g:applyCodec>
            }, {
                seriesType: 'spline',

                applyAnimation: true,
                collectionAlias: 'Mínimo',
                data: <g:applyCodec encodeAs="none">${yGOL2}</g:applyCodec>
            }, {
                seriesType: 'spline',

                applyAnimation: true,
                collectionAlias: 'Máximo',
                data: <g:applyCodec encodeAs="none">${yTAM3}</g:applyCodec>
            }]
        });
    });
</script>

</body>
</html>