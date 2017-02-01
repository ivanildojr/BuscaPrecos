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
        $("#dataViagem").shieldCalendar({
            footer: {
                enabled: true,
                footerTemlpate: "{0:dd.MM.yy}"
            },
            min: new Date("2009/2/23"),
            max: new Date("2039/3/1"),
            value: new Date()
        });

    });
</script>

</body>
</html>