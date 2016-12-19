package buscaprecos

import org.quartz.Job
import org.quartz.JobDataMap
import org.quartz.JobExecutionContext
import org.quartz.JobExecutionException

class BuscaPassagemJob implements Job{

    def buscaPrecos /*Codigo Legado Java*/

    void execute(JobExecutionContext context) throws JobExecutionException{
        JobDataMap map = context.trigger.getJobDataMap()
        def jobKey = context.trigger.getJobKey().toString()
        def origem = map.get("origem")
        def destino  = map.get("destino")
        def dataIda = map.get("dataIda")
        def dataVolta = map.get("dataVolta")
        def adultos = map.get("adultos")
        def criancas = map.get("criancas")


        String voosIdaVolta = buscaPrecos.busca(origem,destino,"201709120000","201710100000",adultos,criancas)

//        println "Job Name: ${jobKey} - Parametros:  ${origem}-${destino}: ${dataIda} - ${dataVolta} : Adultos/Crianças: ${adultos} / ${criancas}"
    }
}
