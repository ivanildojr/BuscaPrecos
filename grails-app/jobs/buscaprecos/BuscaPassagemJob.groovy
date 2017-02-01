package buscaprecos

import org.quartz.Job
import org.quartz.JobDataMap
import org.quartz.JobExecutionContext
import org.quartz.JobExecutionException

class BuscaPassagemJob implements Job{

    def buscaPrecosTAM /*Codigo Legado Java*/
    def buscaPrecosGOL /*Codigo Legado Java*/
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

        buscaTAM(dataLimiteSaida, dataIda, duracao, origem, destino, adultos, criancas)
        buscaGOL(dataLimiteSaida, dataIda, duracao, origem, destino, adultos, criancas)

        println "Job Name: ${jobKey} - Parametros:  ${origem}-${destino}: ${dataIda} - ${dataVolta} : Adultos/Crianças: ${adultos} / ${criancas}"
    }

    private void buscaGOL(dataLimiteSaida, dataIda, duracao,String origem, String destino, adultos, criancas) {
        int count = 0
        Date dataLimite = Date.parse("yyyy-MM-dd HH:mm:ss", dataLimiteSaida)
        Date dataInicio = Date.parse("yyyy-MM-dd HH:mm:ss", dataIda)
        while (dataInicio <= dataLimite && count <= 50) {

            String dataIdaFormatada = dataInicio.format("ddMMyyyy")
            String dataVoltaFormatada = dataInicio.plus(Integer.parseInt(duracao)).format("ddMMyyyy")

            def origemGol = null
            def destinoGol = null
            if(origem.equalsIgnoreCase("NAT"))
                origemGol = AirportCodes.findAllByIata_code(origem).get(0).municipality
            else
                origemGol = origem
            if(destino.equalsIgnoreCase("NAT"))
                destinoGol = AirportCodes.findAllByIata_code(destino).get(0).municipality
            else
                destinoGol = destino

            String voosIdaVolta = buscaPrecosGOL.busca(origemGol, destinoGol, dataIdaFormatada, dataVoltaFormatada, adultos, criancas)

            if (voosIdaVolta) {
                buscaPrecosParserService.precosIdaGOL(voosIdaVolta, origem, destino, dataIdaFormatada)
                buscaPrecosParserService.precosVoltaGOL(voosIdaVolta, origem, destino, dataVoltaFormatada)
            }

            dataInicio = dataInicio.plus(1)
            println "Executou :" + count + " vezes."
            count += 1
        }
    }


    private void buscaTAM(dataLimiteSaida, dataIda, duracao, origem, destino, adultos, criancas) {
        int count = 0
        Date dataLimite = Date.parse("yyyy-MM-dd HH:mm:ss", dataLimiteSaida)
        Date dataInicio = Date.parse("yyyy-MM-dd HH:mm:ss", dataIda)
        while (dataInicio <= dataLimite && count <= 50) {

            String dataIdaFormatada = dataInicio.format("yyyyMMdd0000")
            String dataVoltaFormatada = dataInicio.plus(Integer.parseInt(duracao)).format("yyyyMMdd0000")


            String voosIdaVolta = buscaPrecosTAM.busca(origem, destino, dataIdaFormatada, dataVoltaFormatada, adultos, criancas)
            if (voosIdaVolta) {
                buscaPrecosParserService.precosIdaTAM(voosIdaVolta, origem, destino, dataIdaFormatada)
                buscaPrecosParserService.precosVoltaTAM(voosIdaVolta, origem, destino, dataVoltaFormatada)
            }

            dataInicio = dataInicio.plus(1)
            println "Executou :" + count + " vezes."
            count += 1
        }
    }
}
