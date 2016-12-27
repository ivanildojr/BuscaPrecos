package buscaprecos

class AirportCodes {

    String continent
    String elevation_ft
    String gps_code
    String iata_code
    String ident
    String iso_country
    String iso_region
    String latitude_deg
    String local_code
    String longitude_deg
    String municipality
    String name
    String type_airport
    static constraints = {
        type_airport nullable: true
    }
}
