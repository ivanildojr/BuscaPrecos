package buscaprecos

import org.quartz.Job
import org.quartz.JobDataMap
import org.quartz.JobExecutionContext
import org.quartz.JobExecutionException

class BuscaPassagemJob implements Job{

    def buscaPrecos /*Codigo Legado Java*/
    def buscaPrecosParserService /*Regras de Negocio*/

    void execute(JobExecutionContext context) throws JobExecutionException {
        JobDataMap map = context.trigger.getJobDataMap()
        def jobKey = context.trigger.getJobKey().toString()
        def origem = map.get("origem")
        def destino = map.get("destino")
        def dataIda = map.get("dataIda")
        def dataVolta = map.get("dataVolta")
        def adultos = map.get("adultos")
        def criancas = map.get("criancas")
        def duracao = map.get("duracao")
        def dataLimiteSaida = map.get("dataLimiteSaida")

//        String dataIdaFormatada = Date.parse("yyyy-MM-dd HH:mm:ss", dataIda).format("yyyyMMdd0000")
//        String dataVoltaFormatada = Date.parse("yyyy-MM-dd HH:mm:ss", dataVolta).format("yyyyMMdd0000")
//
//
//        String voosIdaVolta = buscaPrecos.busca(origem, destino, dataIdaFormatada, dataVoltaFormatada, adultos, criancas)
//        if (voosIdaVolta) {
//            buscaPrecosParserService.precosIda(voosIdaVolta, origem, destino, dataIdaFormatada)
//            buscaPrecosParserService.precosVolta(voosIdaVolta, origem, destino, dataVoltaFormatada)
//        }
        int count =0
        Date dataLimite = Date.parse("yyyy-MM-dd HH:mm:ss", dataLimiteSaida)
        Date dataInicio = Date.parse("yyyy-MM-dd HH:mm:ss", dataIda)
        while(dataInicio <= dataLimite && count <= 50){

            String dataIdaFormatada = dataInicio.format("yyyyMMdd0000")
            String dataVoltaFormatada = dataInicio.plus(Integer.parseInt(duracao)).format("yyyyMMdd0000")

//            println count + " dataLimiteSaida: " + dataLimiteSaida + ' - ' + " dataInicio: " + dataInicio + " dataIdaFormatada: " + dataIdaFormatada + " - " + " dataVoltaFormatada: " + dataVoltaFormatada


            String voosIdaVolta = buscaPrecos.busca(origem, destino, dataIdaFormatada, dataVoltaFormatada, adultos, criancas)
            if (voosIdaVolta) {
                buscaPrecosParserService.precosIda(voosIdaVolta, origem, destino, dataIdaFormatada)
                buscaPrecosParserService.precosVolta(voosIdaVolta, origem, destino, dataVoltaFormatada)
            }

            dataInicio = dataInicio.plus(1)
            count+=1
        }

        println "Job Name: ${jobKey} - Parametros:  ${origem}-${destino}: ${dataIda} - ${dataVolta} : Adultos/Crianças: ${adultos} / ${criancas}"
    }
}
